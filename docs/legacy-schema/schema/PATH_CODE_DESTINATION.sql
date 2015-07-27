--------------------------------------------------------
--  DDL for Table PATH_CODE_DESTINATION
--------------------------------------------------------

  CREATE TABLE "PATH_CODE_DESTINATION" 
   (	"CODE_KEY" NUMBER(38,0), 
	"STATUS" CHAR(1) DEFAULT 'A', 
	"DESCRIPTION" VARCHAR2(200), 
	"UPDATE_TIMESTAMP" TIMESTAMP (6), 
	"MIGRATION_FLAG" CHAR(2)
   ) ;
