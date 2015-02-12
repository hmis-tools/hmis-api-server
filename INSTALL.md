_TBD: real installation documentation still needs to be written._
=================================================================

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
