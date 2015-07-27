--------------------------------------------------------
--  DDL for Table PATH_HOUSEHOLD
--------------------------------------------------------

  CREATE TABLE "PATH_HOUSEHOLD" 
   (	"HOUSEHOLD_KEY" NUMBER, 
	"PHONE" VARCHAR2(50), 
	"FAX" VARCHAR2(50), 
	"PAGER" VARCHAR2(50), 
	"VOICE_MAIL" VARCHAR2(50), 
	"EMAIL" VARCHAR2(100), 
	"CREATE_DATE" DATE, 
	"CREATE_USER_KEY" NUMBER(9,0), 
	"UPDATE_DATE" DATE, 
	"UPDATE_USER_KEY" NUMBER(9,0), 
	"CLIENT_KEY_TEMP" NUMBER, 
	"MOBILE" VARCHAR2(50), 
	"UPDATE_TIMESTAMP" TIMESTAMP (6), 
	"MIGRATION_FLAG" CHAR(2)
   ) ;
