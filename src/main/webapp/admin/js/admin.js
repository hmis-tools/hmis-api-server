$(function() {


	// Activate login
	$("#login").click(function() {
		if(auth2)
			auth2.grantOfflineAccess({'redirect_uri': 'postmessage'}).then(signInCallback);
		else
			$("body").html("There was a problem setting up Google OAuth.");

	});


})


// Called by google
function start() {
	// Initialize google oauth
	gapi.load('auth2', function() {
		var clientId = $.get("../api/v3/authenticate/google/client_key", function(data) {
			auth2 = gapi.auth2.init({
				client_id: data,
			});
		})
	});
}

// Called by google
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

function renderAdmin(idToken) {
		$.ajax({
			"type": "GET",
			"url": "../api/v3/users",
			beforeSend: function (request) {
                request.setRequestHeader("Authorization", idToken);
            },
			"dataType": "json"
		}).success(function(data) {
			console.log(data);
		});
}
