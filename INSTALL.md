_TBD: real installation documentation still needs to be written._
=================================================================
 
Crucial Notes:
-------------------

* The demo-client branch (as of 2015-01-16) is the one running on the
  test server at http://108.59.80.159:8080/HMISClient/ (check that for
  comparison purposes)
* The master branch (as of 2015-01-16) has proprietary dependencies,
  so the demo-client branch is the only one that can be reproduced.

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
