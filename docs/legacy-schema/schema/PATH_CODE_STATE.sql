--------------------------------------------------------
--  DDL for Table PATH_CODE_STATE
--------------------------------------------------------

  CREATE TABLE "PATH_CODE_STATE" 
   (	"STATE_KEY" NUMBER(*,0), 
	"STATE_CODE" VARCHAR2(5), 
	"STATE_NAME" VARCHAR2(50), 
	"UPDATE_TIMESTAMP" TIMESTAMP (6), 
	"MIGRATION_FLAG" CHAR(2)
   ) ;
