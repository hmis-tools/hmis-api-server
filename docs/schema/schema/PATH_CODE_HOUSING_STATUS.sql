--------------------------------------------------------
--  DDL for Table PATH_CODE_HOUSING_STATUS
--------------------------------------------------------

  CREATE TABLE "PATH_CODE_HOUSING_STATUS" 
   (	"CODE_KEY" NUMBER(*,0), 
	"CODE_NAME" VARCHAR2(100), 
	"DESCRIPTION" VARCHAR2(250), 
	"STATUS" CHAR(1), 
	"UPDATE_TIMESTAMP" TIMESTAMP (6), 
	"MIGRATION_FLAG" CHAR(2), 
	"SORT_ORDER" NUMBER
   ) ;
