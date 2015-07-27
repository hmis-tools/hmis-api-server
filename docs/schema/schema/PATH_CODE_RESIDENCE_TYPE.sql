--------------------------------------------------------
--  DDL for Table PATH_CODE_RESIDENCE_TYPE
--------------------------------------------------------

  CREATE TABLE "PATH_CODE_RESIDENCE_TYPE" 
   (	"CODE_KEY" NUMBER(*,0), 
	"STATUS" CHAR(1), 
	"DESCRIPTION" VARCHAR2(200), 
	"SHORT_DESCRIPTION" VARCHAR2(50), 
	"UPDATE_TIMESTAMP" TIMESTAMP (6), 
	"MIGRATION_FLAG" CHAR(2), 
	"SORT_ORDER" NUMBER
   ) ;
