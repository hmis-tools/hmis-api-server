--------------------------------------------------------
--  DDL for Table PATH_CODE_WAR_ZONE
--------------------------------------------------------

  CREATE TABLE "PATH_CODE_WAR_ZONE" 
   (	"CODE_KEY" NUMBER, 
	"STATUS" CHAR(1) DEFAULT 'A', 
	"DESCRIPTION" VARCHAR2(100), 
	"UPDATE_TIMESTAMP" TIMESTAMP (6), 
	"MIGRATION_FLAG" CHAR(2)
   ) ;
