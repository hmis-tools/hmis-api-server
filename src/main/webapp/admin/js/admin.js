$(function() {

	// Hide admin interface
	$('#adminInterface').hide();

	// We don't want the login button to appear until google's code is initialized
	$('#login').hide();

	// Activate login
	$("#login").click(function() {
		if(auth2)
			auth2.grantOfflineAccess({'redirect_uri': 'postmessage'}).then(signInCallback);
		else
			$("body").html("There was a problem setting up Google OAuth.");

	});

	// Activate add user
	$("#addUser").click(function() {
		renderInput();
	})
})

// Called by google once it is ready for auth
function start() {

	// Initialize google oauth
	gapi.load('auth2', function() {
		var clientId = $.get("../api/v3/authenticate/google/client_key", function(data) {
			auth2 = gapi.auth2.init({
				client_id: data,
			});

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
			var idToken = data["id_token"];
			renderAdmin(idToken);

		});
	} else {
		// There was an error.
		$("body").html("There was a problem logging in, please refresh and try again.");
	}
}

// Called after authentication is complete
function renderAdmin(idToken) {
	$('#adminInterface').show();
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
			{ title: "Read" },
			{ title: "Write" },
			{ title: "Admin" }, 
			{ title: "" }
		];
		var rows = [];

		for(var x in users) {
			var user = users[x];
			var row = [
				user.externalId,
				user.canRead,
				user.canWrite,
				user.canAdmin,
				"<div id='edit" + user.id + "' class='edit-user'>Edit</div><div id='delete" + user.id + "' class='delete-user'>Delete</div>"
			]

			rows.push(row);
		}

		// Render the table
		$("#dataTable").dataTable({
			data: rows,
			columns: columns
		});

		// Enable the edit buttons
		$(".edit-user").click(function() {
			renderInput();
		});
	});
}

function renderInput(user) {
	$("#editForm").modal();
}
