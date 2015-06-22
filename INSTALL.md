_TBD: real installation documentation still needs to be written._
=================================================================
 
General Notes:
-------------------
* This code base is expected to be built using Maven, and deployed to Tomcat.
* Although several core developers are using Eclipse, this is not a requirement to contribute.


To create a local development environment for the web service:
-------------------
The instructions below explain how to set up a development environment capable of running the API endpoints.  This section assumes you have already used git to download a local copy of the code base.

NOTE: As of this writing, in order for those endpoints to function correctly, you must also create a local copy of the schema.

1. Install (Maven (3.x))[https://maven.apache.org/download.cgi].

2. Install (Tomcat 7.x)[https://tomcat.apache.org/download-70.cgi]. Note that there may be a more recent version of Tomcat, but as of (6-22-2015) Maven plugins do not appear to exist beyond Tomcat 7.

3. Create a Tomcat admin by editing `%TOMCAT7_PATH%/conf/tomcat-users.xml`.

```XML
	<tomcat-users>
		<role rolename="manager-gui"/>
		<role rolename="manager-script"/>
		<user username="admin" password="password" roles="manager-gui,manager-script" />
	</tomcat-users>
```


4. Update Maven's settings by editing `%MAVEN_PATH%/conf/settings.xml` so that Maven will be able to use the Tomcat user in step 3.  The `username` and `password` must match those set in step 3. The ID must be `TomcatServer`.

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


Running the web service
---------------------

1. Ensure that Tomcat is running (generally you can do this by going to [http://localhost:8080])

2. Using a Command Line Interface, navigate to the root directory of this code base.  It should be the one containing `pom.xml`

3. Deploy using Maven:

```shell
	$> mvn tomcat7:deploy
```

This should yield a series of output, ending in a message similar to the example below

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

4. Navigate to [http://localhost:8080/openhmis/services/healthcheck] which should display "Your service is working." 

5. As you make changes, to redeploy updates to the service:

```shell
	$> mvn tomcat7:redeploy
```

To create the schema:
---------------------
* Sample data will be located in: Database/Sampledb.  It's in progress
  right now. 
* For now, use the 2014StandsOpenHMIS\_ERD.mwb file in /doc.  It will
  create an empty schema.
    * Convert the 2014StandardsOpenHMIS\_ERD.mwb file to a .sql file
        * I used the mwb2sql tool available at
          https://github.com/tomoemon/mwb2sql 
        * It requires MySQL Workbench to run  
          `$ sudo apt-get install mysql-workbench`  
          `$ mwb2sql path/to/2014StandardOpenHMIS_ERD.mwb your_filename.sql`  
    * Run the generated .sql file:  
    `$ mysql -u root -p`  
    (enter your password)  
    mysql> source 'doc/your\_filename.sql'  
    // to create an openhmis-specific user:  
    mysql> CREATE USER 'new\_user'@'localhost' IDENTIFIED BY
     'password';  
    mysql> GRANT ALL PRIVILEGES ON <database>.* TO
     'new\_user'@'localhost';  


Hibernate instructions:
-----------------------------
The instructions below are just for how to read the database
credentials from the property file.  These instructions should be
updated and subsumed into more complete installation documentation
eventually.

1. First create a `hibernate.properties` file.  I have the following values in my property file.

            hibernate.dialect=org.hibernate.dialect.MySQLDialect
            hibernate.connection.driver_class=com.mysql.jdbc.Driver
            hibernate.connection.url=jdbc:mysql://173.194.107.15:3306/OPENHMIS2
            hibernate.connection.username=<Database user name>
            hibernate.connection.password=<Database password>
            hibernate.connection.pool_size=1
            hibernate.show_sql=true
            hibernate.connection.autocommit=true
            javax.persistence.validation.mode=none

2. Save the property file in some directory location, for example `D:\Temp`.

3. Locate your Tomcat folder, find the conf directory and locate context.xml

4. Add the following line in the `<Context></Context>`

            <Environment name="config" value="D:\Temp\"
            type="java.lang.String" override="false"/>

  The value of the environment variable config is the location of the hibernate.property file.


Testing to see if it's working.
-------------------------------

You can get access to the API using either a Google account or SalesForce account.

To access using Google account you need your Google email ID and
service account email ID.  The service account email is
`50252473639-gsb3u5dvq6t1oj9hvhhi43f5125vtu2b@developer.gserviceaccount.com`.
(The service account email will be same for all users.)

A sample URL to get the client information using client key (e.g., 75864) is

    http://localhost:8080/OpenHMIS/services/clients/client/75864/ashaar.riaz@pnci.org/50252473639-gsb3u5dvq6t1oj9hvhhi43f5125vtu2b@developer.gserviceaccount.com

(TBD: need information about how to do this with a Salesforce account.)




More detailed information for Debian users:
--------------------------------------------------------------------
Here are some helpful steps for getting tomcat7 started with a webapp
while running Debian jessie (testing). 

* Run `apt-get install tomcat7`
* The server.xml file is now located in `/etc/tomcat7`
* The default webapps dir is located in `/var/lib/tomcat7`
* The logs are located in: `/var/log/tomcat7/catalina.out`
* As of 2015-01-14 or so, the Debian tomcat7 installation didn't
  create these links, so you should make them:  
       cd /usr/share/tomcat7  
       sudo ln -s /var/lib/tomcat7/common/ common  
       sudo ln -s /var/lib/tomcat7/server/ server  
       sudo ln -s /var/lib/tomcat7/shared/ shared  
       sudo ln -s /var/lib/tomcat7/conf/ conf  
       sudo ln -s /var/lib/tomcat7/logs/ logs  
       sudo mkdir /usr/share/tomcat7/temp  
* Edit `/etc/tomcat7/server.xml` to point to the directory of the
 OpenHMIS tree by changing the default `appBase="webapps"` to the
  directory where you've checked out this repository.  
   ` <Host name="localhost"  appBase="webapps"
    unpackWARs="true" autoDeploy="true">`
* Edit the mysql connection information in
    WebRoot/META-INF/context.xml  
    `username="new_user"  
    password="password"  
    // (for your local machine, or whatever ip address is correct)  
    url="jdbc:mysql://127.0.0.1:3306/openhmis?autoReconnect=true"`


## Installation Instructions


### Prerequisites
- JRE 7.x
- Git

### Base Instructions
- Install Maven (3.3.3) - NOTE: follow the README instructions in the Maven repository carefully
- Install Tomcat 7.x - https://wolfpaulus.com/jounal/mac/tomcat8/ (instructions are identical except for the version number we are using)
- Set up your local machine's Tomcat user and a Maven server  (1.1 and 1.2 from [http://www.mkyong.com/maven/how-to-deploy-maven-based-war-file-to-tomcat/])

### Customizing Eclipse
- Add Maven to Eclipse ([http://www.eclipse.org/m2e/])

### Running
from command line:
 - mvn tomcat7:deploy
 - mvn tomcat7:redeploy