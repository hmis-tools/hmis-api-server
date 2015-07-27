--------------------------------------------------------
--  DDL for Table PATH_CODE_NON_CASH_BENEFIT
--------------------------------------------------------

  CREATE TABLE "PATH_CODE_NON_CASH_BENEFIT" 
   (	"CODE_KEY" NUMBER(*,0), 
	"STATUS" CHAR(1), 
	"DESCRIPTION" VARCHAR2(100), 
	"SHORT_DESCRIPTION" VARCHAR2(50), 
	"UPDATE_TIMESTAMP" TIMESTAMP (6), 
	"MIGRATION_FLAG" CHAR(2)
   ) ;
