Installing OpenHMIS
=================================================================
 
General Notes:
-------------------
* This code base is expected to be built using Maven, and deployed to Tomcat.
* We are using MySQL as a data store.
* Although several core developers are using Eclipse, this is not a requirement to contribute.


To create a local build:
-------------------
The instructions below explain how to set up a development environment capable of running the API endpoints.  This section assumes you have already used git to download a local copy of the code base.

_In order for those endpoints to function correctly, you must also create a local copy of the schema._

1. Install [Maven (3.x)](https://maven.apache.org/download.cgi).

2. Install [Tomcat 7.x](https://tomcat.apache.org/download-70.cgi). Note that there may be a more recent version of Tomcat, but as of (6-22-2015) Maven plugins do not appear to exist beyond Tomcat 7.

3. Install [MySQL 5.x](http://dev.mysql.com/downloads/mysql/).

4. Create a Tomcat admin by editing `%TOMCAT7_PATH%/conf/tomcat-users.xml`.

	```XML
		<tomcat-users>
			<role rolename="manager-gui"/>
			<role rolename="manager-script"/>
			<user username="admin" password="password" roles="manager-gui,manager-script" />
		</tomcat-users>
	```


5. Update Maven's settings by editing `%MAVEN_PATH%/conf/settings.xml` so that Maven will be able to use the Tomcat user in step 3.

	* The `username` and `password` must match those set in step 3.
	* The ID must be `TomcatServer`.
	
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


To create the schema:
---------------------
Database migrations are performed using [Flyway](http://flywaydb.org/).

1. Create a local `config/flyway.properties` file with your database connection information

	```shell
	  $> cp src/config/flyway.properties.example src/config/flyway.properties
	  $> vi src/config/flyway.properties
	```


2. To initialize and update the schema, run the following command in the `pom.xml` directory

	```shell
	  $> mvn clean compile flyway:migrate
	```

3. Configure the code base to work with your schema by creating and populating the `src/main/resources/hibernate.cfg.xml` file.

	```shell
	  $> cp src/main/resources/hibernate.cfg.xml.example src/main/resources/hibernate.cfg.xml
	  $> vi src/main/resources/hibernate.cfg.xml
	```

To run the web service:
---------------------

1. Ensure that Tomcat is running (generally you can do this by going to http://localhost:8080)

2. Using a Command Line Interface, navigate to the root directory of this code base.  It should be the one containing `pom.xml`

3. Deploy using Maven:

	```shell
		$> mvn tomcat7:deploy
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

4. If your web service is properly configured, [http://localhost:8080/openhmis/services/healthcheck](http://localhost:8080/openhmis/services/healthcheck) should display "Your service is working." 

5. If the schema is properly set up, [http://localhost:8080/openhmis/services/clients/client/75864/user/password](http://localhost:8080/openhmis/services/clients/client/30486/user/password) should yield a valid XML object.

6. As you make changes, to redeploy updates to the service:

	```shell
		$> mvn tomcat7:redeploy
	```
