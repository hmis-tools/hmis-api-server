$(function() {
    $('#signinButton').click(function() {
        console.log("DEBUG: test");
        auth2.grantOfflineAccess({'redirect_uri': 'postmessage'}).then(signInCallback);
    });
});

function start() {
    gapi.load('auth2', function() {
        // TBD: get this from the properties file?  Shouldn't be hardcoded here.
        id = '512268687331-6t93vg67gvr12lc6uqaf55e82ic52dnj.apps.googleusercontent.com';
        auth2 = gapi.auth2.init({
            client_id: id
        });
    });
};

function buildResponse(result) {
    result = JSON.parse(result);
    var id_token = result["id_token"];
    $("#result").append("Your id token is: ");
    var token = $("<span id=\"token\"/>");
    token.append(id_token);
    $("#result").append("<hr>");
    $("#result").append(token);
    $("#result").append("<hr>");
    $("#result").append("<br> (Pass this as the value of the Authorization header with your requests to the API.)");
};

function signInCallback(authResult) {
  console.log("Doing the sign in callback");
  if (authResult['code']) {

     $.ajax({
          type: 'POST',
          url: 'http://localhost:8080/openhmis/api/v3/authenticate/google',
          contentType: 'application/octet-stream; charset=utf-8',
          processData: false,
          data: authResult['code'],
          success: function(result) {
              console.log("Success!");
              buildResponse(result);
          },
          error: function(error) {
              $("#result").html("An error occurred: " + error.responseText);
          }
          });
      } else {
          $("#result").html("Sorry, there was an error generating your id token.");
      }
};


