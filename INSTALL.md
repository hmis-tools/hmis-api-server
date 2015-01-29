_TBD: real installation documentation still needs to be written._
=================================================================
 
Crucial Notes:
-------------------

* The demo-client branch (as of 2015-01-16) is the one running on the
  test server at http://108.59.80.159:8080/HMISClient/ (check that for
  comparison purposes)
* The master branch (as of 2015-01-16) has proprietary dependencies,
  so the demo-client branch is the only one that can be reproduced.
* Sample data will be located in: /sample-data/create_openhmis_tables.sql.
  It's in progress right now.

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
            hibernate.connection.username=root
            hibernate.connection.password=welcome123
            hibernate.connection.pool_size=1
            hibernate.show_sql=true
            hibernate.connection.autocommit=true
            javax.persistence.validation.mode=none

2. Save the property file in some directory location, for example `D:\Temp`.

3. Locate your Tomcat folder and find the conf directory.

4. Add the following line in the `<Context></Context>`

            <Environment name="config" value="D:\Temp\"
            type="java.lang.String" override="false"/>

  The value of the environment variable config is the location of the hibernate.property file.




More detailed information for Debian users:
--------------------------------------------------------------------
Here are some helpful steps for getting tomcat7 started with a webapp.
I'm running Debian jessie (testing). 

* Run `apt-get install tomcat7`
* The server.xml file is now located in `/etc/tomcat7`
* The default webapps dir is located in `/var/lib/tomcat7`
* The logs are located in: `/var/log/tomcat7/catalina.out`
* As of 2015-01-14 or so, the Debian tomcat7 installation didn't
  create these links, so you should make them:  
       `cd /usr/share/tomcat7  
       sudo ln -s /var/lib/tomcat7/common/ common  
       sudo ln -s /var/lib/tomcat7/server/ server  
       sudo ln -s /var/lib/tomcat7/shared/ shared  
       sudo ln -s /var/lib/tomcat7/conf/ conf  
       sudo ln -s /var/lib/tomcat7/logs/ logs  
       sudo mkdir /usr/share/tomcat7/temp`  
* Look at localhost:8080 in your browser.  You should see the default Tomcat start
  page!  
* Edit `/etc/tomcat7/server.xml` to point to the directory of the
 OpenHMIS tree by changing the default `appBase="webapps"` to the
  directory where you've checked out this repository.  
   ` <Host name="localhost"  appBase="webapps"
    unpackWARs="true" autoDeploy="true">`
* To change the server.xml file:  
    `cp /etc/tomcat7/server.xml ~/new/dir/server.xml  
    # keep the original file in case you want it back  
    sudo mv /etc/tomcat7/server.xml /etc/tomcat7/old-server.xml  
    # edit new/dir/server.xml as in the previous bullet  
    sudo cp new/dir/server.xml /etc/tomcat7/server.xml  
    sudo /etc/init.d/tomcat7 restart`
* If you have problems, try checking the logs with:  
    `sudo less /var/log/tomcat7/catalina.out`
* Create the database for tomcat to connect to:  
    `// if you already have mysql set up  
    $ mysql -u root -p  
    (enter your password)  
    $ mysql> source 'sample-data/create_openhmis_tables.sql'  
    // to create an openhmis-specific user:  
    $ mysql> CREATE USER 'new_user'@'localhost' IDENTIFIED BY
     'password';  
    $ mysql> GRANT ALL PRIVILEGES ON openhmis.* TO
     'new_user'@'localhost';  
    // you can now log in as new_user to make sure you can see the  
    // openhmis database and tables, if desired`

* Edit the mysql connection information in
    WebRoot/META-INF/context.xml  
    `username="new_user"  
    password="password"  
    (for your local machine, or whatever ip address is correct)  
    url="jdbc:mysql://127.0.0.1:3306/openhmis?autoReconnect=true"`
