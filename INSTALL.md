Installing OpenHMIS
=================================================================
 
General Notes:
-------------------
* This code base is expected to be built using Maven, and deployed to Tomcat.
* We are using MySQL as a data store.
* Although several core developers are using Eclipse, this is not a requirement to contribute.


Create a local build:
---------------------
The instructions below explain how to set up a development environment capable of running the API endpoints.  This section assumes you have already used git to download a local copy of the code base.

_In order for those endpoints to function correctly, you must also create a local copy of the schema._

1. Install JDK 1.7.x

   On Debian GNU/Linux 'testing' dist as of 2015-07-30, `sudo apt-get install openjdk-7-jre openjdk-7-jdk` should work.

2. Install [Maven (3.x)](https://maven.apache.org/download.cgi).

   On Debian GNU/Linux 'testing' dist as of 2015-07-30: `sudo apt-get install maven`.

3. Install [Tomcat 7.x](https://tomcat.apache.org/download-70.cgi). Note that there may be a more recent version of Tomcat, but as of 2015-06-22 Maven plugins do not appear to exist beyond Tomcat 7.

   On Debian GNU/Linux 'testing' dist as of 2015-07-30, some combination of `sudo apt-get install libtomcat7-java tomcat7 tomcat7-admin tomcat7-user tomcat7-common tomcat7-docs tomcat7-examples` should do the trick.  If you install the Tomcat server correctly, you can visit http://localhost:8080/ and see a message saying "It works" and giving details about Tomcat configuration paths, etc.

4. Install [MySQL 5.x](http://dev.mysql.com/downloads/mysql/).

   (Most Debian GNU/Linux systems already have the `mysql-server` and `mysql-client` packages installed.)

5. Create a Tomcat admin by editing `<TOMCAT7_PATH>/conf/tomcat-users.xml`.

    ```XML
        <tomcat-users>
                <role rolename="admin-gui"/>
                <role rolename="admin-script"/>
                <role rolename="manager-gui"/>
                <!-- We don't need 'manager-jmx' and 'manager-status' 
                     roles for this application, but feel free to
                     add them if you need them for other reasons. -->
                <role rolename="manager-script"/>
                <user username="admin" password="password" 
                      roles="admin-gui,admin-script,manager-gui,manager-script" />
        </tomcat-users>
    ```

   On Debian GNU/Linux, `TOMCAT7_PATH` above is usually `/var/lib/tomcat7`.  This path is also known as `CATALINA_BASE` in Tomcat-speak, and the corresponding `CATALINA_HOME` would be `/usr/share/tomcat7`.

6. Restart Tomcat

    ```Shell
        $> cd <CATALINA_HOME>   # (e.g., /usr/share/tomcat7)
        $> bin/shutdown.sh
        $> bin/startup.sh
    ```

   Or, on many Unix-like systems:

    ```Shell
        $> sudo service tomcat7 stop
        $> sudo service tomcat7 start
    ```

7. Update Maven's settings by editing `<MAVEN_PATH>/conf/settings.xml` so that Maven will be able to use the Tomcat user in step 3.

   On Debian GNU/Linux, `MAVEN_PATH` is `/usr/share/maven`.

   The `username` and `password` must match those set in step 3.  The ID must be `TomcatServer`.
        
    ```XML
        <settings ...>
                <servers>
                        <server>
                                <id>TomcatServer</id>
                                <username>admin</username>
                                <password>password</password>
                        </server>
                </servers>
        </settings>
    ```


Create the schema:
------------------
Database migrations are performed using [Flyway](http://flywaydb.org/).
_Note: you do not need to install anything for this to work.  Flyway is automatically loaded and used by Maven._

1. Using your tool of choice, create an empty MySQL schema, and create a user with access to it.

   The name of your schema is up to you; in this example we use
   `openhmis`.  The username and password are likewise up to you; here
   we use `openhmis_user` and `openhmis_password`.

    ```shell
        $> mysql -u root -p
        (...enter database admin password...)
        mysql> create database openhmis;
        mysql> create user openhmis_user@localhost identified by "openhmis_password";
        mysql> grant ALL on openhmis.* to openhmis_user@localhost identified by "openhmis_password";
    ```

2. Create a local `src/config/flyway.properties` file with your database connection information

    The schema name, username, and password entered in this file must match those created in step2 1

    ```shell
        $> cp src/config/flyway.properties.example src/config/flyway.properties
        $> vi src/config/flyway.properties
    ```

3. To initialize and update the schema, run the following command in the top-level directory (the one containing the `pom.xml` file):

    ```shell
        $> mvn clean compile flyway:migrate
    ```

4. Create the `dev.properties` file.


    ```shell
        $> cp src/main/resources/dev.properties.example src/main/resources/dev.properties
    ```
    Open the new file and enter the database username and password that you created in steps 1 and 2.  Note that the file has default values for client id and client key.  Many users can continue to use these, but see "Set up OAuth authentication" below for more details.

Import sample data (or real data, if you have some):
---------------------------------------------------

```shell
        mysql -u openhmis_user -p openhmis < src/main/resources/db/data/DATA.sql
```

Manage OAuth authentication:
----------------------------

#### For users making requests to an existing server:

Each request to the API needs to be accompanied by an Authorization
header which contains an id token.  You can find your id token by
navigating to `YOUR_SERVER_ROOT/openhmis/signup/`.  Click on "Sign in
with Google" and copy the very long string of numbers and letters that
shows up after you click the button and sign in.  That is your id token,
and you will use it in each request you send to the API.

Note that you will need to be an authorized user on the server for your
requests to work, even if you have the correct id token.

#### For developers setting up a local instance of the server:

You can use our default/test client ID and secret, pre-set in
`dev.properties.example`, instead of creating your own Google API
Console project.

1. Navigate to `localhost:8080/openhmis/signup/` and sign in there.
   You'll receive an id token as a response.
   
2. Set the value of the Authorization header to that id token for all
   requests you send to your local instance.  Note that id tokens will
   only work for authorization if you've added the corresponding email
   address to your users table, as explained in the next section,
   "Create your first admin user."


#### For developers setting up a production instance of the server:

This API uses [Google Sign-in](https://developers.google.com/identity/) OAuth-style authentication.  To build an application powered by this API, your application must use the Google Sign-in [server side flow](https://developers.google.com/identity/sign-in/web/server-side-flow).

1. Begin the [Google sign-in
tutorial](https://developers.google.com/identity/sign-in/web/server-side-flow).
Create a client ID and a client secret and edit `dev.properties` to use
those values instead of the default ones, then restart your app.

   ```shell
        $> emacs src/main/resources/dev.properties
        $> mvn tomcat7:redeploy
   ```

2. We've incorporated the tutorial steps into the `/openhmis/signup` endpoint.  After you've replaced the client ID and client secret, navigate to that page and click "Sign in with Google."  You'll get an id token back.  Note that you'll need to add admin user(s) as explained in the next section for this token to be effective.

3. For all API calls that require authentication include the HTTP header `Authorization` with the value of the `id_token` you collected in step 2.  To test these calls with specific headers, try the [Postman](https://www.getpostman.com/) app.


You can test that you are passing your `id_token` correctly by using the `api/v3/healthcheck/authentication` endpoint.  You can turn off authentication for local development by changing the "authEnabled" entry in the dev.properties file to false and running `mvn tomcat7:redeploy`.  Turn authentication back on at any time by changing authEnabled to true and running `mvn tomcat7:redeploy`.


Create your first admin user:
-----------------------------

If you are setting up the OpenHMIS server for the first time, you'll see
that you have a TMP_USER table in your database.  If you don't, then do
the following:

```
    $ mysql -u __YOUR_USER__ -p
    Enter password: __YOUR_PASSWORD__
    
    mysql> \. src/main/resources/db/migration/V028__CREATE_TMP_USER.sql
```

Then, create an admin user with all permissions:
```
    mysql> insert into TMP_USER (externalID, canRead, canWrite, canAdmin, dateCreated, dateUpdated) values ('__YOUR_GMAIL_EMAIL__', 1, 1, 1, NOW(), NOW());
```

Note that the `externalID` column expects some identification from
another external account.  We generally expect this API to be set up
with Google as the external authenticating party, in which case you
would use a Google email address for the `externalID`, but you could set
up OAuth with any other external auth, too.

Each request to the API should include an authorization header with an
id_token corresponding to an email address in this user table (see
"Manage OAuth authentication," above).


Run the web service:
--------------------

1. Ensure that Tomcat is running (generally you can do this by going to http://localhost:8080)

2. Using a Command Line Interface, navigate to the root directory of this code base.  It should be the one containing `pom.xml`

3. Deploy using Maven if this is the *first* time you've ever deployed this code:

    ```shell
        $> mvn tomcat7:deploy
    ```

   But if you have previously deployed this code with any tool, then you should instead _redeploy_ using Maven:

    ```shell
        $> mvn tomcat7:redeploy
    ```
        
   If successful, the output will end with a message similar to the example below:
        
    ```shell
        [INFO] tomcatManager status code:200, ReasonPhrase:OK
        [INFO] OK - Deployed application at context path /openhmis
        [INFO] ------------------------------------------------------------------------
        [INFO] BUILD SUCCESS
        [INFO] ------------------------------------------------------------------------
        [INFO] Total time: 4.488 s
        [INFO] Finished at: 2015-06-22T14:43:19-04:00
        [INFO] Final Memory: 20M/165M
        [INFO] ------------------------------------------------------------------------
    ```

4. If your web service is properly configured, [http://localhost:8080/openhmis/api/v3/healthcheck](http://localhost:8080/openhmis/api/v3/healthcheck) should display "Your service is working with version `<version>`."

5. If the authentication is working, then [http://localhost:8080/openhmis/api/v3/healthcheck/authentication](http://localhost:8080/openhmis/api/v3/healthcheck/authentication) should display "You have a valid authorization token."

6.  Once authentication works, if the schema is properly set up, [http://localhost:8080/openhmis/api/v3/clients](http://localhost:8080/openhmis/api/v3/clients) should yield a valid XML object.
