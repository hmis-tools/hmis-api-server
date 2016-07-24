-- MySQL dump 10.13  Distrib 5.7.10, for osx10.9 (x86_64)
--
-- Host: localhost    Database: openhmis
-- ------------------------------------------------------
-- Server version	5.7.10

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `PATH_CLIENT`
--

DROP TABLE IF EXISTS `PATH_CLIENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PATH_CLIENT` (
  `CLIENT_KEY` int(11) NOT NULL AUTO_INCREMENT,
  `IDENTIFICATION` varchar(20) DEFAULT NULL,
  `ID_TYPE` int(11) DEFAULT NULL,
  `LAST_NAME` varchar(100) DEFAULT NULL,
  `FIRST_NAME` varchar(100) DEFAULT NULL,
  `MIDDLE_NAME` varchar(100) DEFAULT NULL,
  `DATE_OF_BIRTH` date DEFAULT NULL,
  `GENDER_KEY` int(11) DEFAULT NULL,
  `ETHNICITY_KEY` int(11) DEFAULT '0',
  `MARITAL_STATUS_KEY` int(11) DEFAULT NULL,
  `AMBULATORY_KEY` int(11) DEFAULT NULL,
  `CLIENT_NOTES` text,
  `CREATE_DATE` date DEFAULT NULL,
  `CREATE_USER_KEY` int(11) DEFAULT NULL,
  `HOMELESS` char(1) DEFAULT NULL,
  `REGION_KEY` int(11) DEFAULT NULL,
  `SUFFIX` varchar(10) DEFAULT NULL,
  `ANONYMOUS` char(1) DEFAULT 'N',
  `UPDATE_DATE` date DEFAULT NULL,
  `UPDATE_USER_KEY` int(11) DEFAULT NULL,
  `DISABLING_CONDITION` int(11) DEFAULT '8',
  `PREVIOUS_FIRST_NAME` varchar(50) DEFAULT NULL,
  `PREVIOUS_MIDDLE_NAME` varchar(50) DEFAULT NULL,
  `PREVIOUS_LAST_NAME` varchar(50) DEFAULT NULL,
  `PREVIOUS_SUFFIX` varchar(50) DEFAULT NULL,
  `HOURS_WORKED_LAST_WEEK` int(11) DEFAULT '0',
  `LOOKING_FOR_WORK` int(11) DEFAULT '0',
  `VETERAN` int(11) DEFAULT '8',
  `HEALTH_STATUS_KEY` int(11) DEFAULT NULL,
  `PREGNANCY_STATUS` int(11) DEFAULT '0',
  `PREGNANCY_DUE_DATE` date DEFAULT NULL,
  `TRANSGENDER_TYPE` int(11) DEFAULT NULL,
  `PRIMARY_LANGUAGE_KEY` int(11) DEFAULT NULL,
  `SECONDARY_LANGUAGE_KEY` int(11) DEFAULT NULL,
  `INTERPRETER_NEEDED` char(1) DEFAULT NULL,
  `PRIMARY_LANGUAGE` int(11) DEFAULT NULL,
  `SECONDARY_LANGUAGE` int(11) DEFAULT NULL,
  `PICTURE` blob,
  `PICTURE_NAME` varchar(75) DEFAULT NULL,
  `PICTURE_UP_USER` int(11) DEFAULT NULL,
  `PICTURE_UP_DT` date DEFAULT NULL,
  `PICTURE_DEL_USER` int(11) DEFAULT NULL,
  `PICTURE_DEL_DT` date DEFAULT NULL,
  `PICTURE_TYPE` varchar(5) DEFAULT NULL,
  `RACE_KEY` int(11) DEFAULT NULL,
  `HOMELESS_STATUS_KEY` int(11) DEFAULT NULL,
  `DOB_TYPE` int(11) DEFAULT NULL,
  `INCOME_QUESTION` int(11) DEFAULT NULL,
  `INCOME_DATE` date DEFAULT NULL,
  `NON_CASH_QUESTION` int(11) DEFAULT NULL,
  `NON_CASH_DATE` date DEFAULT NULL,
  `IS_EMPLOYED` int(11) DEFAULT NULL,
  `TENURE` int(11) DEFAULT NULL,
  `VOLUNTEER` char(1) DEFAULT NULL,
  `IS_BASIC` char(1) DEFAULT 'N',
  `UPDATE_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `MIGRATION_FLAG` char(2) DEFAULT NULL,
  `IS_COORD` char(1) DEFAULT NULL,
  `NAME_TYPE` int(11) DEFAULT NULL,
  `GENDER_DESC` varchar(60) DEFAULT NULL,
  `HEALTH_INS_QUESTION` int(11) DEFAULT NULL,
  `HEALTH_INS_DATE` date DEFAULT NULL,
  `OTHER_IDENTIFICATION` varchar(30) DEFAULT NULL,
  `OTHER_IDENTIFICATION_NUM` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`CLIENT_KEY`)
) ENGINE=InnoDB AUTO_INCREMENT=715847 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `PATH_CLIENT_PROGRAM`
--

DROP TABLE IF EXISTS `PATH_CLIENT_PROGRAM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PATH_CLIENT_PROGRAM` (
  `PROGRAM_KEY` int(11) NOT NULL AUTO_INCREMENT,
  `CLIENT_KEY` int(11) DEFAULT NULL,
  `ENTRY_DATE` date DEFAULT NULL,
  `ENTRY_CASH_GK` int(11) DEFAULT NULL,
  `ENTRY_NONCASH_GK` int(11) DEFAULT NULL,
  `EXIT_DATE` date DEFAULT NULL,
  `EXIT_CASH_GK` int(11) DEFAULT NULL,
  `EXIT_NONCASH_GK` int(11) DEFAULT NULL,
  `PROGRAM_NAME_KEY` int(11) DEFAULT NULL,
  `DESTINATION_KEY` int(11) DEFAULT NULL,
  `REASON_LEAVING_KEY` int(11) DEFAULT NULL,
  `CREATE_DATE` date DEFAULT NULL,
  `CREATE_USER_KEY` int(11) DEFAULT NULL,
  `UPDATE_DATE` date DEFAULT NULL,
  `UPDATE_USER_KEY` int(11) DEFAULT NULL,
  `STATUS` char(1) DEFAULT NULL,
  `TENURE_KEY` int(11) DEFAULT NULL,
  `SUBSIDY_KEY` int(11) DEFAULT NULL,
  `REC_ACTIVE` char(1) DEFAULT NULL,
  `SUBSIDY_OTHERS` varchar(50) DEFAULT NULL,
  `REASON_LEAVING_OTHERS` varchar(50) DEFAULT NULL,
  `DESTINATION_OTHERS` varchar(50) DEFAULT NULL,
  `HOUSING_STATUS_KEY` int(11) DEFAULT NULL,
  `COUNTYNAME` varchar(64) DEFAULT NULL,
  `ENGAGEMENT_DATE` date DEFAULT NULL,
  `BARCODE_PROFILE_KEY` int(11) DEFAULT NULL,
  `UPDATE_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `MIGRATION_FLAG` char(2) DEFAULT NULL,
  `ANNUAL_CASH_GK` int(11) DEFAULT NULL,
  `ANNUAL_NONCASH_GK` int(11) DEFAULT NULL,
  PRIMARY KEY (`PROGRAM_KEY`)
) ENGINE=InnoDB AUTO_INCREMENT=452918 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `PATH_CLIENT_RACE`
--

DROP TABLE IF EXISTS `PATH_CLIENT_RACE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PATH_CLIENT_RACE` (
  `PRIMARY_KEY` int(11) NOT NULL AUTO_INCREMENT,
  `CLIENT_KEY` int(11) DEFAULT NULL,
  `RACE_KEY` int(11) DEFAULT NULL,
  `UPDATE_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `MIGRATION_FLAG` char(2) DEFAULT NULL,
  PRIMARY KEY (`PRIMARY_KEY`)
) ENGINE=InnoDB AUTO_INCREMENT=837737 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `PATH_CLIENT_VETERAN_INFO`
--

DROP TABLE IF EXISTS `PATH_CLIENT_VETERAN_INFO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PATH_CLIENT_VETERAN_INFO` (
  `VETERAN_KEY` int(11) DEFAULT NULL,
  `CLIENT_KEY` int(11) NOT NULL AUTO_INCREMENT,
  `YR_ENTER_MILITARY` varchar(20) DEFAULT NULL,
  `YR_SEP_MILITARY` varchar(20) DEFAULT NULL,
  `MILITARY_BRANCH` int(11) DEFAULT NULL,
  `DISCHARGE_STATUS` int(11) DEFAULT NULL,
  `WORLD_WAR_II` int(11) DEFAULT NULL,
  `KOREAN_WAR` int(11) DEFAULT NULL,
  `VIETNAM_WAR` int(11) DEFAULT NULL,
  `PERSIAN_WAR` int(11) DEFAULT NULL,
  `AFGHANISTAN_WAR` int(11) DEFAULT NULL,
  `IRAQ_FREEDOM` int(11) DEFAULT NULL,
  `IRAQ_DAWN` int(11) DEFAULT NULL,
  `OTHER` int(11) DEFAULT NULL,
  `CREATE_USER_KEY` varchar(20) DEFAULT NULL,
  `UPDATE_USER_KEY` varchar(20) DEFAULT NULL,
  `CREATE_DATE` date DEFAULT NULL,
  `UPDATE_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `VERIFIED_DATE` date DEFAULT NULL,
  PRIMARY KEY (`CLIENT_KEY`)
) ENGINE=InnoDB AUTO_INCREMENT=715847 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TMP_CHRONIC_HEALTH_CONDITION`
--

DROP TABLE IF EXISTS `TMP_CHRONIC_HEALTH_CONDITION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TMP_CHRONIC_HEALTH_CONDITION` (
  `chronicHealthConditionId` int(11) NOT NULL AUTO_INCREMENT,
  `enrollmentId` int(11) DEFAULT NULL,
  `informationDate` date DEFAULT NULL,
  `response` int(11) DEFAULT NULL,
  `indefiniteAndImpairs` int(11) DEFAULT NULL,
  `documentationOnFile` int(11) DEFAULT NULL,
  `receivingServices` int(11) DEFAULT NULL,
  `dateCreated` date DEFAULT NULL,
  `dateUpdated` date DEFAULT NULL,
  PRIMARY KEY (`chronicHealthConditionId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TMP_CONTACT`
--

DROP TABLE IF EXISTS `TMP_CONTACT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TMP_CONTACT` (
  `contactId` int(11) NOT NULL AUTO_INCREMENT,
  `enrollmentId` int(11) DEFAULT NULL,
  `dateProvided` date DEFAULT NULL,
  `typeProvided` int(11) DEFAULT NULL,
  `dateCreated` date DEFAULT NULL,
  `dateUpdated` date DEFAULT NULL,
  PRIMARY KEY (`contactId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TMP_DEVELOPMENTAL_DISABILITY`
--

DROP TABLE IF EXISTS `TMP_DEVELOPMENTAL_DISABILITY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TMP_DEVELOPMENTAL_DISABILITY` (
  `developmentalDisabilityId` int(11) NOT NULL AUTO_INCREMENT,
  `enrollmentId` int(11) DEFAULT NULL,
  `informationDate` date DEFAULT NULL,
  `response` int(11) DEFAULT NULL,
  `indefiniteAndImpairs` int(11) DEFAULT NULL,
  `documentationOnFile` int(11) DEFAULT NULL,
  `receivingServices` int(11) DEFAULT NULL,
  `dateCreated` date DEFAULT NULL,
  `dateUpdated` date DEFAULT NULL,
  PRIMARY KEY (`developmentalDisabilityId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TMP_DOMESTIC_ABUSE`
--

DROP TABLE IF EXISTS `TMP_DOMESTIC_ABUSE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TMP_DOMESTIC_ABUSE` (
  `domesticAbuseId` int(11) NOT NULL AUTO_INCREMENT,
  `enrollmentId` int(11) DEFAULT NULL,
  `informationDate` date DEFAULT NULL,
  `domesticViolenceVictim` int(11) DEFAULT NULL,
  `whenOccurred` int(11) DEFAULT NULL,
  `dateCreated` date DEFAULT NULL,
  `dateUpdated` date DEFAULT NULL,
  PRIMARY KEY (`domesticAbuseId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TMP_ENROLLMENT`
--

DROP TABLE IF EXISTS `TMP_ENROLLMENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TMP_ENROLLMENT` (
  `enrollmentId` int(11) NOT NULL AUTO_INCREMENT,
  `personalId` int(11) DEFAULT NULL,
  `projectExit` int(11) DEFAULT NULL,
  `disablingCondition` int(11) DEFAULT NULL,
  `residencePrior` int(11) DEFAULT NULL,
  `otherResidence` varchar(255) DEFAULT NULL,
  `residencePriorLengthOfStay` int(11) DEFAULT NULL,
  `entryDate` date DEFAULT NULL,
  `householdId` int(11) DEFAULT NULL,
  `relationshipToHoH` int(11) DEFAULT NULL,
  `clientLocationInformationDate` date DEFAULT NULL,
  `cocCode` varchar(255) DEFAULT NULL,
  `continuouslyHomelessOneYear` int(11) DEFAULT NULL,
  `timesHomelessInPastThreeYears` int(11) DEFAULT NULL,
  `monthsHomelessPastThreeYears` int(11) DEFAULT NULL,
  `monthsHomelessThisTime` int(11) DEFAULT NULL,
  `statusDocumentedCode` int(11) DEFAULT NULL,
  `housingStatus` int(11) DEFAULT NULL,
  `dateOfEngagement` date DEFAULT NULL,
  `residentialMoveInDate` date DEFAULT NULL,
  `inPermanentHousing` int(11) DEFAULT NULL,
  `permanentHousingMoveDate` date DEFAULT NULL,
  `dateOfPathStatus` date DEFAULT NULL,
  `clientEnrolledInPath` int(11) DEFAULT NULL,
  `reasonNotEnrolled` int(11) DEFAULT NULL,
  `dateOfBcpStatus` date DEFAULT NULL,
  `fysbYouth` int(11) DEFAULT NULL,
  `reasonNoServices` int(11) DEFAULT NULL,
  `sexualOrientation` int(11) DEFAULT NULL,
  `lastGradeCompleted` int(11) DEFAULT NULL,
  `schoolStatus` int(11) DEFAULT NULL,
  `employedInformationDate` date DEFAULT NULL,
  `employed` int(11) DEFAULT NULL,
  `employmentType` int(11) DEFAULT NULL,
  `notEmployedReason` int(11) DEFAULT NULL,
  `generalHealthStatus` int(11) DEFAULT NULL,
  `dentalHealthStatus` int(11) DEFAULT NULL,
  `mentalHealthStatus` int(11) DEFAULT NULL,
  `pregnancyStatusCode` int(11) DEFAULT NULL,
  `pregnancyDueDate` date DEFAULT NULL,
  `formerlyChildWelfare` int(11) DEFAULT NULL,
  `childWelfareYears` int(11) DEFAULT NULL,
  `childWelfareMonths` int(11) DEFAULT NULL,
  `formerWardJuvenileJustice` int(11) DEFAULT NULL,
  `juvenileJusticeYears` int(11) DEFAULT NULL,
  `juvenileJusticeMonths` int(11) DEFAULT NULL,
  `householdDynamics` int(11) DEFAULT NULL,
  `sexualOrientationGenderIdYouth` int(11) DEFAULT NULL,
  `sexualOrientationGenderIdFam` int(11) DEFAULT NULL,
  `housingIssuesYouth` int(11) DEFAULT NULL,
  `housingIssuesFam` int(11) DEFAULT NULL,
  `schoolEducationalIssuesYouth` int(11) DEFAULT NULL,
  `schoolEducationalIssuesFam` int(11) DEFAULT NULL,
  `unemploymentYouth` int(11) DEFAULT NULL,
  `unemploymentFam` int(11) DEFAULT NULL,
  `mentalHealthIssuesYouth` int(11) DEFAULT NULL,
  `mentalHealthIssuesFam` int(11) DEFAULT NULL,
  `healthIssuesYouth` int(11) DEFAULT NULL,
  `healthIssuesFam` int(11) DEFAULT NULL,
  `physicalDisabilityYouth` int(11) DEFAULT NULL,
  `physicalDisabilityFam` int(11) DEFAULT NULL,
  `mentalDisabilityYouth` int(11) DEFAULT NULL,
  `mentalDisabilityFam` int(11) DEFAULT NULL,
  `abuseAndNeglectYouth` int(11) DEFAULT NULL,
  `abuseAndNeglectFam` int(11) DEFAULT NULL,
  `alcoholDrugAbuseYouth` int(11) DEFAULT NULL,
  `alcoholDrugAbuseFam` int(11) DEFAULT NULL,
  `insufficientIncome` int(11) DEFAULT NULL,
  `activeMilitaryParent` int(11) DEFAULT NULL,
  `incarceratedParent` int(11) DEFAULT NULL,
  `incarceratedParentStatus` int(11) DEFAULT NULL,
  `referralSource` int(11) DEFAULT NULL,
  `countOUtreachReferralApproaches` int(11) DEFAULT NULL,
  `exchangeForSexPastThreeMonths` int(11) DEFAULT NULL,
  `countOfExchangeForSex` int(11) DEFAULT NULL,
  `askedOrForcedToExchangeForSex` int(11) DEFAULT NULL,
  `worstHousingSituation` int(11) DEFAULT NULL,
  `percentAmi` int(11) DEFAULT NULL,
  `lastPermanentStreet` varchar(255) DEFAULT NULL,
  `lastPermanentCity` varchar(255) DEFAULT NULL,
  `lastPermanentState` varchar(255) DEFAULT NULL,
  `lastPermanentZip` varchar(255) DEFAULT NULL,
  `addressDataQuality` int(11) DEFAULT NULL,
  `dateCreated` date DEFAULT NULL,
  `dateUpdated` date DEFAULT NULL,
  PRIMARY KEY (`enrollmentId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TMP_EXIT`
--

DROP TABLE IF EXISTS `TMP_EXIT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TMP_EXIT` (
  `exitId` int(11) NOT NULL AUTO_INCREMENT,
  `enrollmentId` int(11) DEFAULT NULL,
  `projectExitDate` date DEFAULT NULL,
  `destinationTypeCode` int(11) DEFAULT NULL,
  `otherDestination` varchar(255) DEFAULT NULL,
  `assessmentDisposition` int(11) DEFAULT NULL,
  `otherDisposition` varchar(255) DEFAULT NULL,
  `housingAssessment` int(11) DEFAULT NULL,
  `subsidyInformation` int(11) DEFAULT NULL,
  `connectionWithSoar` int(11) DEFAULT NULL,
  `employedInformationDate` date DEFAULT NULL,
  `employed` int(11) DEFAULT NULL,
  `employmentType` int(11) DEFAULT NULL,
  `notEmployedReason` int(11) DEFAULT NULL,
  `generalHealthStatus` int(11) DEFAULT NULL,
  `dentalHealthStatus` int(11) DEFAULT NULL,
  `mentalHealthStatus` int(11) DEFAULT NULL,
  `writtenAftercarePlan` int(11) DEFAULT NULL,
  `assistanceMainstreamBenefits` int(11) DEFAULT NULL,
  `permanentHousingPlacement` int(11) DEFAULT NULL,
  `temporaryShelterPlacement` int(11) DEFAULT NULL,
  `exitCounciling` int(11) DEFAULT NULL,
  `furtherFollowupServices` int(11) DEFAULT NULL,
  `scheduledFollowupContacts` int(11) DEFAULT NULL,
  `resourcePackage` int(11) DEFAULT NULL,
  `otherAftercarePlanOrAction` int(11) DEFAULT NULL,
  `projectCompletionStatus` int(11) DEFAULT NULL,
  `earlyExitReason` int(11) DEFAULT NULL,
  `earlyExpulsionReason` int(11) DEFAULT NULL,
  `familyReunificationCode` int(11) DEFAULT NULL,
  `dateCreated` date DEFAULT NULL,
  `dateUpdated` date DEFAULT NULL,
  PRIMARY KEY (`exitId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TMP_FINANCIAL_ASSISTANCE`
--

DROP TABLE IF EXISTS `TMP_FINANCIAL_ASSISTANCE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TMP_FINANCIAL_ASSISTANCE` (
  `financialAssistanceId` int(11) NOT NULL AUTO_INCREMENT,
  `enrollmentId` int(11) DEFAULT NULL,
  `dateProvided` date DEFAULT NULL,
  `hopwaTypeProvided` int(11) DEFAULT NULL,
  `hopwaFaaAmount` int(11) DEFAULT NULL,
  `ssvfTypeProvided` int(11) DEFAULT NULL,
  `ssvfFaaAmount` int(11) DEFAULT NULL,
  `dateCreated` date DEFAULT NULL,
  `dateUpdated` date DEFAULT NULL,
  PRIMARY KEY (`financialAssistanceId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TMP_HEALTH_INSURANCE`
--

DROP TABLE IF EXISTS `TMP_HEALTH_INSURANCE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TMP_HEALTH_INSURANCE` (
  `healthInsuranceId` int(11) NOT NULL AUTO_INCREMENT,
  `enrollmentId` int(11) DEFAULT NULL,
  `informationDate` date DEFAULT NULL,
  `insuranceFromAnySource` int(11) DEFAULT NULL,
  `medicaid` int(11) DEFAULT NULL,
  `noMedicaidReason` int(11) DEFAULT NULL,
  `medicare` int(11) DEFAULT NULL,
  `noMedicareReason` int(11) DEFAULT NULL,
  `schip` int(11) DEFAULT NULL,
  `noSchipReason` int(11) DEFAULT NULL,
  `vaMedicalServices` int(11) DEFAULT NULL,
  `noVaMedReason` int(11) DEFAULT NULL,
  `employerProvided` int(11) DEFAULT NULL,
  `noEmployerProvidedReason` int(11) DEFAULT NULL,
  `cobra` int(11) DEFAULT NULL,
  `noCobraReason` int(11) DEFAULT NULL,
  `Pay` int(11) DEFAULT NULL,
  `noPayReason` int(11) DEFAULT NULL,
  `stateHealthIns` int(11) DEFAULT NULL,
  `noStateHealthInsReason` int(11) DEFAULT NULL,
  `dateCreated` date DEFAULT NULL,
  `dateUpdated` date DEFAULT NULL,
  PRIMARY KEY (`healthInsuranceId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TMP_HIV_AIDS_STATUS`
--

DROP TABLE IF EXISTS `TMP_HIV_AIDS_STATUS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TMP_HIV_AIDS_STATUS` (
  `hivAidsStatusId` int(11) NOT NULL AUTO_INCREMENT,
  `enrollmentId` int(11) DEFAULT NULL,
  `informationDate` date DEFAULT NULL,
  `response` int(11) DEFAULT NULL,
  `indefiniteAndImpairs` int(11) DEFAULT NULL,
  `documentationOnFile` int(11) DEFAULT NULL,
  `receivingServices` int(11) DEFAULT NULL,
  `dateCreated` date DEFAULT NULL,
  `dateUpdated` date DEFAULT NULL,
  PRIMARY KEY (`hivAidsStatusId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TMP_INCOME_SOURCE`
--

DROP TABLE IF EXISTS `TMP_INCOME_SOURCE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TMP_INCOME_SOURCE` (
  `incomeSourceId` int(11) NOT NULL AUTO_INCREMENT,
  `enrollmentId` int(11) DEFAULT NULL,
  `informationDate` date DEFAULT NULL,
  `incomeFromAnySourceCode` int(11) DEFAULT NULL,
  `totalMonthlyIncome` int(11) DEFAULT NULL,
  `earned` int(11) DEFAULT NULL,
  `earnedAmount` int(11) DEFAULT NULL,
  `unemployment` int(11) DEFAULT NULL,
  `unemploymentAmount` int(11) DEFAULT NULL,
  `ssi` int(11) DEFAULT NULL,
  `ssiAmount` int(11) DEFAULT NULL,
  `ssdi` int(11) DEFAULT NULL,
  `ssdiAmount` int(11) DEFAULT NULL,
  `vaDisabilityService` int(11) DEFAULT NULL,
  `vaDisabilityServiceAmount` int(11) DEFAULT NULL,
  `vaDisabilityNonService` int(11) DEFAULT NULL,
  `vaDisabilityNonServiceAmount` int(11) DEFAULT NULL,
  `Disability` int(11) DEFAULT NULL,
  `DisabilityAmount` int(11) DEFAULT NULL,
  `workerscomp` int(11) DEFAULT NULL,
  `workersCompAmount` int(11) DEFAULT NULL,
  `tanf` int(11) DEFAULT NULL,
  `tanfAmount` int(11) DEFAULT NULL,
  `ga` int(11) DEFAULT NULL,
  `gaAmount` int(11) DEFAULT NULL,
  `socSecRetirement` int(11) DEFAULT NULL,
  `socSecRetirementAmount` int(11) DEFAULT NULL,
  `pension` int(11) DEFAULT NULL,
  `pensionAmount` int(11) DEFAULT NULL,
  `childSupport` int(11) DEFAULT NULL,
  `childSupportAmount` int(11) DEFAULT NULL,
  `alimony` int(11) DEFAULT NULL,
  `alimonyAmount` int(11) DEFAULT NULL,
  `otherIncomeSource` int(11) DEFAULT NULL,
  `otherIncomeAmount` int(11) DEFAULT NULL,
  `dateCreated` date DEFAULT NULL,
  `dateUpdated` date DEFAULT NULL,
  PRIMARY KEY (`incomeSourceId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TMP_MEDICAL_ASSISTANCE`
--

DROP TABLE IF EXISTS `TMP_MEDICAL_ASSISTANCE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TMP_MEDICAL_ASSISTANCE` (
  `medicalAssistanceId` int(11) NOT NULL AUTO_INCREMENT,
  `enrollmentId` int(11) DEFAULT NULL,
  `informationDate` date DEFAULT NULL,
  `hivAidsAssistance` int(11) DEFAULT NULL,
  `noHivAidsAssistanceReason` int(11) DEFAULT NULL,
  `adap` int(11) DEFAULT NULL,
  `noAdapReason` int(11) DEFAULT NULL,
  `dateCreated` date DEFAULT NULL,
  `dateUpdated` date DEFAULT NULL,
  PRIMARY KEY (`medicalAssistanceId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TMP_MENTAL_HEALTH_PROBLEM`
--

DROP TABLE IF EXISTS `TMP_MENTAL_HEALTH_PROBLEM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TMP_MENTAL_HEALTH_PROBLEM` (
  `mentalHealthProblemId` int(11) NOT NULL AUTO_INCREMENT,
  `enrollmentId` int(11) DEFAULT NULL,
  `informationDate` date DEFAULT NULL,
  `response` int(11) DEFAULT NULL,
  `indefiniteAndImpairs` int(11) DEFAULT NULL,
  `documentationOnFile` int(11) DEFAULT NULL,
  `receivingServices` int(11) DEFAULT NULL,
  `pathHowConfirmed` int(11) DEFAULT NULL,
  `pathSmiInformation` int(11) DEFAULT NULL,
  `dateCreated` date DEFAULT NULL,
  `dateUpdated` date DEFAULT NULL,
  PRIMARY KEY (`mentalHealthProblemId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TMP_NON_CASH_BENEFIT`
--

DROP TABLE IF EXISTS `TMP_NON_CASH_BENEFIT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TMP_NON_CASH_BENEFIT` (
  `nonCashBenefitId` int(11) NOT NULL AUTO_INCREMENT,
  `enrollmentId` int(11) DEFAULT NULL,
  `informationDate` date DEFAULT NULL,
  `benefitsFromAnySource` int(11) DEFAULT NULL,
  `snap` int(11) DEFAULT NULL,
  `wic` int(11) DEFAULT NULL,
  `tanfChildCare` int(11) DEFAULT NULL,
  `tanfTransportation` int(11) DEFAULT NULL,
  `otherTanf` int(11) DEFAULT NULL,
  `rentalAssistanceOngoing` int(11) DEFAULT NULL,
  `otherBenefitsSource` int(11) DEFAULT NULL,
  `rentalAssistanceTemp` int(11) DEFAULT NULL,
  `otherBenefitsSourceIdentify` varchar(255) DEFAULT NULL,
  `dateCreated` date DEFAULT NULL,
  `dateUpdated` date DEFAULT NULL,
  PRIMARY KEY (`nonCashBenefitId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TMP_ORGANIZATION`
--

DROP TABLE IF EXISTS `TMP_ORGANIZATION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TMP_ORGANIZATION` (
  `organizationId` int(11) NOT NULL AUTO_INCREMENT,
  `organizationName` varchar(255) DEFAULT NULL,
  `dateCreated` date DEFAULT NULL,
  `dateUpdated` date DEFAULT NULL,
  PRIMARY KEY (`organizationId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TMP_PHYSICAL_DISABILITY`
--

DROP TABLE IF EXISTS `TMP_PHYSICAL_DISABILITY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TMP_PHYSICAL_DISABILITY` (
  `physicalDisabilityId` int(11) NOT NULL AUTO_INCREMENT,
  `enrollmentId` int(11) DEFAULT NULL,
  `informationDate` date DEFAULT NULL,
  `response` int(11) DEFAULT NULL,
  `indefiniteAndImpairs` int(11) DEFAULT NULL,
  `documentationOnFile` int(11) DEFAULT NULL,
  `receivingServices` int(11) DEFAULT NULL,
  `dateCreated` date DEFAULT NULL,
  `dateUpdated` date DEFAULT NULL,
  PRIMARY KEY (`physicalDisabilityId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TMP_PROJECT`
--

DROP TABLE IF EXISTS `TMP_PROJECT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TMP_PROJECT` (
  `projectId` int(11) NOT NULL AUTO_INCREMENT,
  `projectName` varchar(255) DEFAULT NULL,
  `continuumProject` int(11) DEFAULT NULL,
  `projectType` int(11) DEFAULT NULL,
  `residentialAffiliation` int(11) DEFAULT NULL,
  `resProjectId` int(11) DEFAULT NULL,
  `trackingMethod` int(11) DEFAULT NULL,
  `targetPopulation` int(11) DEFAULT NULL,
  `dateCreated` date DEFAULT NULL,
  `dateUpdated` date DEFAULT NULL,
  PRIMARY KEY (`projectId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TMP_PROJECT_CONTINUUM`
--

DROP TABLE IF EXISTS `TMP_PROJECT_CONTINUUM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TMP_PROJECT_CONTINUUM` (
  `project_coc_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) DEFAULT NULL,
  `coc_code` varchar(255) DEFAULT NULL,
  `date_created` date DEFAULT NULL,
  `date_updated` date DEFAULT NULL,
  PRIMARY KEY (`project_coc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TMP_PROJECT_FUNDER`
--

DROP TABLE IF EXISTS `TMP_PROJECT_FUNDER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TMP_PROJECT_FUNDER` (
  `funderId` int(11) NOT NULL AUTO_INCREMENT,
  `projectId` int(11) DEFAULT NULL,
  `funder` int(11) DEFAULT NULL,
  `grantId` varchar(255) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `dateCreated` date DEFAULT NULL,
  `dateUpdated` date DEFAULT NULL,
  PRIMARY KEY (`funderId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TMP_PROJECT_INVENTORY`
--

DROP TABLE IF EXISTS `TMP_PROJECT_INVENTORY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TMP_PROJECT_INVENTORY` (
  `inventoryId` int(11) NOT NULL AUTO_INCREMENT,
  `projectCoCId` int(11) DEFAULT NULL,
  `informationDate` date DEFAULT NULL,
  `householdType` int(11) DEFAULT NULL,
  `bedType` int(11) DEFAULT NULL,
  `availability` int(11) DEFAULT NULL,
  `unitInventory` int(11) DEFAULT NULL,
  `bedInventory` int(11) DEFAULT NULL,
  `chBedInventory` int(11) DEFAULT NULL,
  `vetBedInventory` int(11) DEFAULT NULL,
  `youthBedInventory` int(11) DEFAULT NULL,
  `youthAgeGroup` int(11) DEFAULT NULL,
  `inventoryStartDate` date DEFAULT NULL,
  `inventoryEndDate` date DEFAULT NULL,
  `participatingBeds` int(11) DEFAULT NULL,
  `dateCreated` date DEFAULT NULL,
  `dateUpdated` date DEFAULT NULL,
  PRIMARY KEY (`inventoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TMP_PROJECT_SITE`
--

DROP TABLE IF EXISTS `TMP_PROJECT_SITE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TMP_PROJECT_SITE` (
  `siteId` int(11) NOT NULL AUTO_INCREMENT,
  `projectCoCId` int(11) DEFAULT NULL,
  `principalSite` int(11) DEFAULT NULL,
  `geocode` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  `dateCreated` date DEFAULT NULL,
  `dateUpdated` date DEFAULT NULL,
  PRIMARY KEY (`siteId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TMP_REFERRAL`
--

DROP TABLE IF EXISTS `TMP_REFERRAL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TMP_REFERRAL` (
  `referralId` int(11) NOT NULL AUTO_INCREMENT,
  `enrollmentId` int(11) DEFAULT NULL,
  `referralDate` date DEFAULT NULL,
  `pathTypeProvided` int(11) DEFAULT NULL,
  `referralOutcome` int(11) DEFAULT NULL,
  `rhyTypeProvided` int(11) DEFAULT NULL,
  `dateCreated` date DEFAULT NULL,
  `dateUpdated` date DEFAULT NULL,
  PRIMARY KEY (`referralId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TMP_SERVICE`
--

DROP TABLE IF EXISTS `TMP_SERVICE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TMP_SERVICE` (
  `serviceId` int(11) NOT NULL AUTO_INCREMENT,
  `enrollmentId` int(11) DEFAULT NULL,
  `dateProvided` date DEFAULT NULL,
  `pathTypeProvided` int(11) DEFAULT NULL,
  `rhyTypeProvided` int(11) DEFAULT NULL,
  `hopwaTypeProvided` int(11) DEFAULT NULL,
  `ssvfTypeProvided` int(11) DEFAULT NULL,
  `ssvfVaSubTypeProvided` int(11) DEFAULT NULL,
  `ssvfCoordinatingSubTypeProvided` int(11) DEFAULT NULL,
  `ssvfDirectSubTypeProvided` int(11) DEFAULT NULL,
  `ssvfOtherService` varchar(255) DEFAULT NULL,
  `dateCreated` date DEFAULT NULL,
  `dateUpdated` date DEFAULT NULL,
  PRIMARY KEY (`serviceId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TMP_SUBSTANCE_ABUSE`
--

DROP TABLE IF EXISTS `TMP_SUBSTANCE_ABUSE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TMP_SUBSTANCE_ABUSE` (
  `substanceAbuseId` int(11) NOT NULL AUTO_INCREMENT,
  `enrollmentId` int(11) DEFAULT NULL,
  `informationDate` date DEFAULT NULL,
  `response` int(11) DEFAULT NULL,
  `indefiniteAndImpairs` int(11) DEFAULT NULL,
  `documentationOnFile` int(11) DEFAULT NULL,
  `receivingServices` int(11) DEFAULT NULL,
  `pathHowConfirmed` int(11) DEFAULT NULL,
  `dateCreated` date DEFAULT NULL,
  `dateUpdated` date DEFAULT NULL,
  PRIMARY KEY (`substanceAbuseId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TMP_USER`
--

DROP TABLE IF EXISTS `TMP_USER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TMP_USER` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `externalID` varchar(255) DEFAULT NULL,
  `canRead` int(11) DEFAULT NULL,
  `canWrite` int(11) DEFAULT NULL,
  `canAdmin` int(11) DEFAULT NULL,
  `dateCreated` date DEFAULT NULL,
  `dateUpdated` date DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `externalID` (`externalID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `schema_version`
--

DROP TABLE IF EXISTS `schema_version`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schema_version` (
  `version_rank` int(11) NOT NULL,
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) NOT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`version`),
  KEY `schema_version_vr_idx` (`version_rank`),
  KEY `schema_version_ir_idx` (`installed_rank`),
  KEY `schema_version_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-24 15:23:22
