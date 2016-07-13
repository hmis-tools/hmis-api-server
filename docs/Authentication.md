Managing OAuth authentication in OpenHMIS
-----------------------------------------

# For users making requests to an existing server:

Note that you will need to be an authorized user on the server for your
requests to work, even if you have the correct id token.  An "authorized
user" is one that has been added to the admin list by a server
administrator, probably using the page at `/openhmis/admin`.  Your
username will be a Google email address.

Each request to the API needs to be accompanied by an Authorization
header which contains an id token.  You can find your id token by
navigating to `YOUR_SERVER_ROOT/openhmis/signup/`.  Click on "Sign in
with Google," and sign in with the Google email address that is on the
admin list for the server.  In response, you'll see a very long string
of numbers and letters.  That is your id token, and you will use it in
each request you send to the API.  You can test requests to the API with
the Postman app or curl.  In each request, set the value of the
Authorization header to that id token.

# For developers setting up a local instance of the server:

The process here is the same for users making requests to an existing
server (the previous section).  Even though you've set up a local
instance of the server, you can use our default/test client ID and
secret, pre-set in `dev.properties.example`, instead of creating your
own [Google API
Console](https://console.developers.google.com/projectselector/apis/library)
project to sign in to Google.  The default values will work as long as
you don't need to control the origin and redirect URIs -- i.e., as long
as you're not setting up a non-local server.  If you are, see the next
section.  For more information, see [the Google server-side flow
](https://developers.google.com/identity/sign-in/web/server-side-flow)

1. Navigate to `localhost:8080/openhmis/signup/` and sign in there
   using the google email you used as the `externalID` in your users
   table (above).  You'll receive an id token as a response.
   
2. Set the value of the Authorization header to that id token for all
   requests you send to your local instance.  Note that id tokens will
   only work for authorization if you've added the corresponding email
   address to your users table, as explained in the previous section,
   "Create your first admin user."

# For developers setting up a production instance of the server:

This API uses [Google Sign-in](https://developers.google.com/identity/) OAuth-style authentication.  To set up an instance of this server, use the Google Sign-in [server side flow](https://developers.google.com/identity/sign-in/web/server-side-flow).

1. Begin the [Google sign-in
tutorial](https://developers.google.com/identity/sign-in/web/server-side-flow).
Create a client ID and a client secret and edit `dev.properties` to use
those values instead of the default ones, then restart your app.

   ```shell
        $> emacs src/main/resources/dev.properties
        $> mvn tomcat7:redeploy
   ```

2. We've incorporated the tutorial steps into the `/openhmis/signup` endpoint.  After you've replaced the client ID and client secret, navigate to that page and click "Sign in with Google," using the Google email address that you added to your users table above.  You'll get an id token back.  

3. For all API calls that require authentication include the HTTP header `Authorization` with the value of the `id_token` you collected in step 2.  To test these calls with specific headers, try the [Postman](https://www.getpostman.com/) app.

You can test that you are passing your `id_token` correctly by using the `api/v3/healthcheck/authentication` endpoint.  You can turn off authentication for local development by changing the "authEnabled" entry in the dev.properties file to false and running `mvn tomcat7:redeploy`.  Turn authentication back on at any time by changing authEnabled to true and running `mvn tomcat7:redeploy`.
