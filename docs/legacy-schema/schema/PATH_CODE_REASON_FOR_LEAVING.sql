--------------------------------------------------------
--  DDL for Table PATH_CODE_REASON_FOR_LEAVING
--------------------------------------------------------

  CREATE TABLE "PATH_CODE_REASON_FOR_LEAVING" 
   (	"CODE_KEY" NUMBER(38,0), 
	"STATUS" CHAR(1), 
	"DESCRIPTION" VARCHAR2(100), 
	"UPDATE_TIMESTAMP" TIMESTAMP (6), 
	"MIGRATION_FLAG" CHAR(2)
   ) ;
