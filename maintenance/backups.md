# Recommended system for backing up data for this HMIS API server

* Save the `backup-hmis.tmpl` script as `backup-hmis`, adjust it in
  the obvious ways, and run as a cron job on your server.  It will
  package a MySQL dump of the database into a .tar.gz file.
  
  As written, the script removes any backups older than two weeks old,
  so at any given time there are only fourteen or so files in your
  backups directory.
  
* In a cron job that runs later, run a separate script -- let's assume
  you called it `fetch-hmis-backup` -- from a separate server to scp
  today's backup from your backup dir to some other dir in that
  off-site server.

To do this manually, run the `backup-hmis` script from your HMIS
server, and then from your offsite server run `fetch-hmis-backup`.
