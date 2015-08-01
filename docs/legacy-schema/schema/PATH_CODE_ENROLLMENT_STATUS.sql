--------------------------------------------------------
--  DDL for Table PATH_CODE_ENROLLMENT_STATUS
--------------------------------------------------------

  CREATE TABLE "PATH_CODE_ENROLLMENT_STATUS" 
   (	"CODE_KEY" NUMBER, 
	"STATUS" CHAR(1) DEFAULT 'A', 
	"DESCRIPTION" VARCHAR2(100), 
	"MIGRATION_FLAG" CHAR(2)
   ) ;
