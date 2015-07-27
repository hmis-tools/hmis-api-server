--------------------------------------------------------
--  DDL for Table PATH_CODE_PRIMARY_DISABILITY
--------------------------------------------------------

  CREATE TABLE "PATH_CODE_PRIMARY_DISABILITY" 
   (	"CODE_KEY" NUMBER(*,0), 
	"STATUS" CHAR(1), 
	"DESCRIPTION" VARCHAR2(100), 
	"TEXT" VARCHAR2(200), 
	"ORDER_NUMBER" NUMBER, 
	"UPDATE_TIMESTAMP" TIMESTAMP (6), 
	"MIGRATION_FLAG" CHAR(2)
   ) ;
