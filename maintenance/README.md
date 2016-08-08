# Manage backups

See `hmis-backup.tmpl` for a description of how to set up backups.  To
use a backup that you've created, do the following:

    $ sudo service tomcat7 stop

    $ mysql -u __YOUR_USERNAME__ -p
      Password: __YOUR_PASSWORD__

    mysql> use openhmis

    # WARNING: This will drop all the tables in your database and cause you to
    # lose all your existing data!

    mysql> source YOUR_BACKUP_FILE.sql
    
    mysql> exit

    $ sudo service tomcat7 start
    $ cd /path/to/hmis-api-server
    $ mvn tomcat7:redeploy

