This document details the mapping of OpenHMIS API objects to the database schema.

Schema: COMPASS OpenHMIS Schema (subset of COMPASS ROSE schema required for API implementation)

### /clients

Client objects are a 1:1 map to PATH_CLIENT. There are no deleted client records.

API Field       | type    | format, etc.                  | Data source                               | Code Table
----------------|---------|-------------------------------|-------------------------------------------|------------
PersonalID      | string  | minLength:32, maxLength:32    |                                           |
FirstName       | string  | maxLength:50                  | FIRST_NAME                                |
MiddleName      | string  | maxLength:50                  | MIDDLE_NAME                               |
LastName        | string  | maxLength:50                  | LAST_NAME                                 |
NameSuffix      | string  | maxLength:50                  | SUFFIX                                    |
NameDataQuality | integer |                               | NAME_TYPE                                 | PATH_CODE_NAME_TYPE
SSN             | string  | maxLength:9                   | IDENTIFICATION (if ID_TYPE = 1)           | 
SSNDataQuality  | integer |                               | ID_TYPE (if ID_TYPE in (1,2,8,9) else ??) | PATH_CODE_ID_TYPE
DOB             | string  | format:date-time              | DATE_OF_BIRTH (if DOB_TYPE = 1)           |   
DOBDataQuality  | integer |                               | DOB_TYPE                                  | PATH_CODE_DOB_TYPE
Race            | integer |                               | (1:many)PATH_CLIENT_RACE.RACE_KEY         | PATH_CODE_RACE
Ethnicity       | integer |                               | ETHNICITY_KEY                             | PATH_CODE_ETHNICITY
Gender          | integer |                               | GENDER_KEY                                | PATH_CODE_GENDER
OtherGender     | string  | maxLength:50                  |                                           |
VeteranStatus   | integer |                               | VETERAN                                   | PATH_CODE_VETERAN
DateCreated     | string  | format:date-time              | CREATE_DATE                               |
DateUpdated     | string  | format:date-time              | UPDATE_TIMESTAMP                          |
UserID          | string  | maxLength:32                  | CREATE_USER_KEY                           | PATH_USERS
DateDeleted     | string  | date-time                     |                                           |


### /enrollments

Enrollments have a many:1 relationship with PATH_CLIENT_PROGRAM. (one per PATH_CLIENT attached to HOUSEHOLD_KEY at enrollment time)

API Field                       | type    | format, etc.                       | Data source                               | Code Table
--------------------------------|---------|------------------------------------|-------------------------------------------|------------
ProjectEntryID                  | string  | minLength:32, maxLength:32         | PROGRAM_KEY                               |
PersonalID                      | string  | minLength:32, maxLength:32         | PATH_CLIENT.CLIENT_KEY                    |
ProjectID                       | string  | minLength:32, maxLength:32         | PROGRAM_KEY                               |
EntryDate                       | string  | format:date-time                   | ENTRY_DATE                                |
HouseholdID                     | string  | minLength:32, maxLength:32         | HOUSEHOLD_KEY                             | PATH_HOUSEHOLD
RelationshipToHoH               | integer |                                    | PATH_CLIENT.RELATIONSHIP                  | PATH_CODE_RELATIONSHIP
ResidencePrior                  | integer |                                    |                                           |
OtherResidencePrior             | string  | maxLength:50                       |                                           |
ResidencePriorLengthOfStay      | integer |                                    |                                           |
DisablingCondition              | integer |                                    |                                           |
ContinuouslyHomelessOneYear     | integer |                                    |                                           |
TimesHomelessPastThreeYears     | integer |                                    |                                           |
MonthsHomelessPastThreeYears    | integer |                                    |                                           |
MonthsHomelessThisTime          | string  | pattern:^[0-9]{1,3}$               |                                           |
StatusDocumented                | integer |                                    |                                           |
HousingStatus                   | integer |                                    |                                           |
DateOfEngagement                | string  | format:date-time                   |                                           |
InPermanentHousing              | integer |                                    |                                           |
ResidentialMoveInDate           | string  | format:date-time                   |                                           |
DateOfPATHStatus                | string  | format:date-time                   |                                           |
ClientEnrolledInPATH            | integer |                                    |                                           |
ReasonNotEnrolled               | integer |                                    |                                           |
WorstHousingSituation           | integer |                                    |                                           |
PercentAMI                      | integer |                                    |                                           |
LastPermanentStreet             | string  | maxLength:100                      |                                           |
LastPermanentCity               | string  | maxLength:50                       |                                           |
LastPermanentState              | string  | maxLength:2, pattern:^[a-zA-Z]{2}$ |                                           |
LastPermanentZIP                | string  | maxLength:5, pattern:^[0-9]{5}$    |                                           |
AddressDataQuality              | integer |                                    |                                           |
DateOfBCPStatus                 | string  | format:date-time                   |                                           |
FYSBYouth                       | integer |                                    |                                           |
ReasonNoServices                | integer |                                    |                                           |
SexualOrientation               | integer |                                    |                                           |
FormerWardChildWelfare          | integer |                                    |                                           |
ChildWelfareYears               | integer |                                    |                                           |
ChildWelfareMonths              | integer |                                    |                                           |
FormerWardJuvenileJustice       | integer |                                    |                                           |
JuvenileJusticeYears            | integer |                                    |                                           |
JuvenileJusticeMonths           | integer |                                    |                                           |
HouseholdDynamics               | integer |                                    |                                           |
SexualOrientationGenderIDYouth  | integer |                                    |                                           |
SexualOrientationGenderIDFam    | integer |                                    |                                           |
HousingIssuesYouth              | integer |                                    |                                           |
HousingIssuesFam                | integer |                                    |                                           |
SchoolEducationalIssuesYouth    | integer |                                    |                                           |
SchoolEducationalIssuesFam      | integer |                                    |                                           |
UnemploymentYouth               | integer |                                    |                                           |
UnemploymentFam                 | integer |                                    |                                           |
MentalHealthIssuesYouth         | integer |                                    |                                           |
MentalHealthIssuesFam           | integer |                                    |                                           |
HealthIssuesYouth               | integer |                                    |                                           |
HealthIssuesFam                 | integer |                                    |                                           |
PhysicalDisabilityYouth         | integer |                                    |                                           |
PhysicalDisabilityFam           | integer |                                    |                                           |
MentalDisabilityYouth           | integer |                                    |                                           |
MentalDisabilityFam             | integer |                                    |                                           |
AbuseAndNeglectYouth            | integer |                                    |                                           |
AbuseAndNeglectFam              | integer |                                    |                                           |
AlcoholDrugAbuseYouth           | integer |                                    |                                           |
AlcoholDrugAbuseFam             | integer |                                    |                                           |
InsufficientIncome              | integer |                                    |                                           |
ActiveMilitaryParent            | integer |                                    |                                           |
IncarceratedParent              | integer |                                    |                                           |
IncarceratedParentStatus        | integer |                                    |                                           |
ReferralSource                  | integer |                                    |                                           |
CountOutreachReferralApproaches | integer |                                    |                                           |
ExchangeForSexPastThreeMonths   | integer |                                    |                                           |
CountOfExchangeForSex           | integer |                                    |                                           |
AskedOrForcedToExchangeForSex   | integer |                                    |                                           |
DateCreated                     | string  | format:date-time                   | CREATE_DATE                               |
DateUpdated                     | string  | format:date-time                   | UPDATE_DATE                               |
UserID                          | string  | minLength:32, maxLength:32         | CREATE_USER_KEY (if UPDATE_DATE is NULL) else UPDATE_USER_KEY  |
DateDeleted                     | string  | format:date-time                   |                                           |


