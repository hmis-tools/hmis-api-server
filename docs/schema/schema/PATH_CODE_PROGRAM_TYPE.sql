--------------------------------------------------------
--  DDL for Table PATH_CODE_PROGRAM_TYPE
--------------------------------------------------------

  CREATE TABLE "PATH_CODE_PROGRAM_TYPE" 
   (	"CODE_KEY" NUMBER, 
	"STATUS" VARCHAR2(100), 
	"DESCRIPTION" VARCHAR2(100), 
	"RESIDENTIAL" CHAR(2), 
	"SHORT_DESCRIPTION" VARCHAR2(20), 
	"UPDATE_TIMESTAMP" TIMESTAMP (6), 
	"MIGRATION_FLAG" CHAR(2), 
	"IS_HUD_PROGRAM" CHAR(2) DEFAULT NULL
   ) ;
