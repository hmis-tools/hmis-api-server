--------------------------------------------------------
--  DDL for Table PATH_CODE_DISCHARGE_STATUS
--------------------------------------------------------

  CREATE TABLE "PATH_CODE_DISCHARGE_STATUS" 
   (	"CODE_KEY" NUMBER, 
	"STATUS" CHAR(1) DEFAULT 'A', 
	"DESCRIPTION" VARCHAR2(100), 
	"UPDATE_TIMESTAMP" TIMESTAMP (6), 
	"MIGRATION_FLAG" CHAR(2)
   ) ;
