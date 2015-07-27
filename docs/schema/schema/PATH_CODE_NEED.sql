--------------------------------------------------------
--  DDL for Table PATH_CODE_NEED
--------------------------------------------------------

  CREATE TABLE "PATH_CODE_NEED" 
   (	"CODE_KEY" NUMBER(*,0), 
	"STATUS" CHAR(1), 
	"DESCRIPTION" VARCHAR2(100), 
	"UPDATE_TIMESTAMP" TIMESTAMP (6), 
	"MIGRATION_FLAG" CHAR(2)
   ) ;
