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

3. To initialize and update the schema, run the following command in the top-levle directory (the one containing the `pom.xml` file):

    ```shell
        $> mvn clean compile flyway:migrate
    ```

4. Create the `dev.properties` file.


    ```shell
        $> cp src/main/resources/dev.properties.example src/main/resources/dev.properties
    ```
    Open the new file and enter the database username and password that you created in steps 1 and 2.  You'll add more entries to this file once you have information for Google authentication (see "Set up OAuth authentication" below).

Import sample data (or real data, if you have some):
---------------------------------------------------

```shell
        mysql -u openhmis_user -p openhmis < src/main/resources/db/data/DATA.sql
```

Set up OAuth authentication:
----------------------------
This API uses [Google Sign-in](https://developers.google.com/identity/) OAuth-style authentication.  To build an application powered by this API, your application must use the Google Sign-in [server side flow](https://developers.google.com/identity/sign-in/web/server-side-flow).

1. Begin the [Google sign-in tutorial](https://developers.google.com/identity/sign-in/web/server-side-flow).  Create a client ID and a client secret and store them in a local `dev.properties` file, then restart your app.

   ```shell
        $> emacs src/main/resources/dev.properties
        $> mvn tomcat7:redeploy
   ```

2. Continue the tutorial.  Use the code provided there to generate an authorization code and a token.  If you are setting this up locally for development purposes, use `http://localhost:8080` for the authorized Javascript origin and the authorized redirect URI.

3. `POST` to `http://localhost:8080/openhmis/api/v3/authenticate/google` in part 6 of [the Google tutorial](https://developers.google.com/identity/sign-in/web/server-side-flow), passing the generated authentication code as the raw POST value, as explained there.

4. Extract the `id_token` component from the JSON object returned in part 7 of the tutorial.  If instead you receive an error like `Token Fail: 401 Unauthorized`, check that your origin and redirect URIs are correct, that your `client_id` and `client_secret` are in `dev.properties`, and that you've run `mvn tomcat7:redeploy` whenever any of these values change.

5. For all API calls that require authentication include the HTTP header `Authorization` with the value of the `id_token` you collected in step 3.  To test these calls with specific headers, try the [Postman](https://www.getpostman.com/) app.

You can test that you are passing your `id_token` correctly by using the `api/v3/healthcheck/authentication` endpoint


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
