--------------------------------------------------------
--  DDL for Table PATH_CLIENT_VETERAN_NEW
--------------------------------------------------------

  CREATE TABLE "PATH_CLIENT_VETERAN_NEW" 
   (	"VETERAN_KEY" NUMBER, 
	"CLIENT_KEY" NUMBER, 
	"MILITARY_ERA_KEY" NUMBER, 
	"ERA_MONTH" NUMBER, 
	"WARZONE_KEY" NUMBER, 
	"WARZONE_MONTH" NUMBER, 
	"RECEIVED_FIRE" CHAR(2), 
	"MILITARY_BRANCH_KEY" NUMBER, 
	"DISCHARGE_STATUS_KEY" NUMBER, 
	"SERVED_WARZONE" NUMBER, 
	"UPDATE_TIMESTAMP" TIMESTAMP (6), 
	"MIGRATION_FLAG" CHAR(2)
   ) ;
