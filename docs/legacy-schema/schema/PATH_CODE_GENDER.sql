--------------------------------------------------------
--  DDL for Table PATH_CODE_GENDER
--------------------------------------------------------

  CREATE TABLE "PATH_CODE_GENDER" 
   (	"CODE_KEY" NUMBER(*,0), 
	"STATUS" CHAR(1), 
	"GENDER" VARCHAR2(100), 
	"UPDATE_TIMESTAMP" TIMESTAMP (6), 
	"MIGRATION_FLAG" CHAR(2), 
	"SORT_ORDER" NUMBER
   ) ;
