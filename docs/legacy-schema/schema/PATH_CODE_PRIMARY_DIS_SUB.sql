--------------------------------------------------------
--  DDL for Table PATH_CODE_PRIMARY_DIS_SUB
--------------------------------------------------------

  CREATE TABLE "PATH_CODE_PRIMARY_DIS_SUB" 
   (	"CODE_KEY" NUMBER, 
	"TEXT" VARCHAR2(200), 
	"ORDER_NUMBER" NUMBER, 
	"STATUS" CHAR(1), 
	"DESCRIPTION" VARCHAR2(200), 
	"PRIMARY_KEY" NUMBER(*,0), 
	"UPDATE_TIMESTAMP" TIMESTAMP (6), 
	"MIGRATION_FLAG" CHAR(2)
   ) ;
