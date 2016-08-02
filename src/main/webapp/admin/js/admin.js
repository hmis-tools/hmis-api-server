$(function() {

	// Hide admin interface
	$('#adminInterface').hide();

	// We don't want the login button to appear until google's code is initialized
	$('#login').hide();

	// Activate login
	$("#login").click(function() {
		if(auth2) {
			$("#loader").show();
			auth2.grantOfflineAccess({'redirect_uri': 'postmessage'}).then(signInCallback);
		}
		else
			$("body").html("There was a problem setting up Google OAuth.");
	});

	$("#editForm").hide();

	// Activate add user
	$("#addUser").click(function() {
		renderInput();
	});

	// Activate save user
	$("#saveUser").click(function() {
		var internalId = $("#internalId").val();
		var externalId = $("#externalId").val();
		var organization = $("#organization").val();
		var coC = $("#coC").val();
		var canAdmin = $("#canAdmin").prop("checked")?1:0;
		var canRead = $("#canRead").prop("checked")?1:0;
		var canWrite = $("#canWrite").prop("checked")?1:0;

		var data = {
    		        externalId: externalId,
                        organization: organization,
                        coC: coC,
			canRead: canRead,
			canWrite: canWrite,
			canAdmin: canAdmin
		}

		saveUser(data, internalId);
	});

	// Activate delete user
	$("#deleteUser").click(function() {
		var internalId = $("#internalId").val();
		deleteUser(internalId);
	});
});

function saveUser(data, internalId) {
    // Does the internal ID exist?
    if(internalId) {
		$.ajax({
			"type": "PUT",
			"url": "../api/v3/users/" + internalId,
			"data": JSON.stringify(data),
			beforeSend: function (request) {
				request.setRequestHeader("Authorization", idToken);
			},
			"dataType": "json",
			"contentType": "application/json"
		}).success(function() {
		    reloadAdmin();
		})
	} else {
		$.ajax({
			"type": "POST",
			"url": "../api/v3/users",
			"data": JSON.stringify(data),
			beforeSend: function (request) {
				request.setRequestHeader("Authorization", idToken);
			},
			"dataType": "json",
			"contentType": "application/json"
		}).success(function() {
		    reloadAdmin();
		})
	}

	// Close the modal
	$.modal.close();
}

function deleteUser(internalId) {
	$.ajax({
		"type": "DELETE",
		"url": "../api/v3/users/" + internalId,
		beforeSend: function (request) {
			request.setRequestHeader("Authorization", idToken);
		},
		"dataType": "json",
		"contentType": "application/json"
	}).success(function() {
		reloadAdmin();
	});

	// Close the modal
	$.modal.close();
}

// The auth token
var idToken = null;

// Called by google once it is ready for auth
function start() {

	// Initialize google oauth
	gapi.load('auth2', function() {
		var clientId = $.get("../api/v3/authenticate/google/client_key", function(data) {
			auth2 = gapi.auth2.init({
				client_id: data,
			});

			// User isn't waiting any longer
			$("#loader").hide();

			// And now we can let the user log in
			$('#login').show();
		})
	});
}

// Called by google after an auth attempt
function signInCallback(authResult) {
	if (authResult['code']) {
		// Hide the sign-in button now that the user is authorized, for example:
		$('#login').hide();

		// Send the code to the server to get a token back
		$.ajax({
			"type": "POST",
			"url": "../api/v3/authenticate/google",
			"data": authResult['code'],
			"processData": false,
			"dataType": "json"
		}).success(function(data) {

			// Set the locally defined idToken
			// TODO: this is why we wish we used react.
			// This is very bad form (it's a global variable)
			idToken = data["id_token"];
			$("#loader").hide();
			renderAdmin();
		});
	} else {
		// There was an error.
		$("body").html("There was a problem logging in, please refresh and try again.");
	}
}

// Called after authentication is complete
function renderAdmin() {
	$('#adminInterface').show();
	reloadAdmin();
}

// Loads the latest user data and refreshes the view
function reloadAdmin() {
    $("#loader").show();
	$.ajax({
		"type": "GET",
		"url": "../api/v3/users",
	    beforeSend: function (request) {
                request.setRequestHeader("Authorization", idToken);
            },
		"dataType": "json"
	}).success(function(data) {
	    var users = data.data.items;
		var columns = [
			{ title: "Email" },
			{ title: "Organization" },
			{ title: "Continuum of Care" },
			{ title: "Read" },
			{ title: "Write" },
			{ title: "Admin" }, 
			{ title: "" }
		];
		var rows = [];

		for(var x in users) {
    		        var user = users[x];
                        if (user.canRead == 1) {
                                user.canReadDisplay = 'Yes';
                        }
                        else {
                                user.canReadDisplay = 'No';
                        }
                        if (user.canWrite == 1) {
                                user.canWriteDisplay = 'Yes';
                        }
                        else {
                                user.canWriteDisplay = 'No';
                        }
		        if (user.canAdmin == 1) {
                                user.canAdminDisplay = 'Yes';
                        }
                        else {
                                user.canAdminDisplay = 'No';
                        }
                        var row = [
                                user.externalId,
                                user.organization,
                                user.coC,
				user.canReadDisplay,
			        user.canWriteDisplay,
				user.canAdminDisplay,
				"<div id='edit" + x + "' class='edit-user'>Edit</div>"
			]

			rows.push(row);
		}

		// Hide the spinner
		$("#loader").hide();

		// Render the table
		var $dataTable = $("#dataTable");
		$dataTable.empty();
		$("<table>")
			.appendTo($dataTable)
			.dataTable({
				data: rows,
				columns: columns,
				bPaginate: false
			});

		// Enable the edit buttons
		$(".edit-user").click(function() {
			// Parse the user index from the ID
			var index = $(this).attr("id").substring(4);
			var user = users[index];
			renderInput(user);
		});
	});
}

function renderInput(user) {
	$("#editForm").modal();

	if(user) {
		$("#internalId").val(user.id)
		$("#externalId").val(user.externalId);
		$("#canAdmin").prop("checked", user.canAdmin);
		$("#canRead").prop("checked", user.canRead);
		$("#canWrite").prop("checked", user.canWrite);
                $("#organization").val(user.organization);
	        $("#coC").val(user.coC);
	        $("#deleteUser").show();
	} else {
		$("#internalId").val("")
		$("#externalId").val("");
		$("#canAdmin").prop("checked", false);
		$("#canRead").prop("checked", false);
		$("#canWrite").prop("checked", false);
		$("#organization").val("");
	        $("#coC").val("");
	        $("#deleteUser").hide();
	}
}
