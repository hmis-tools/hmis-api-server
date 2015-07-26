This document details the mapping of OpenHMIS API objects to the database schema.

Schema: COMPASS OpenHMIS Schema (subset of COMPASS ROSE schema required for API implementation)

### /clients

Client objects are a 1:1 map to PATH_CLIENT. There are no deleted client records. The values of the race characteristics derive from evaluating the presence of records in the PATH_CLIENT_RACE table for the client.

API Field            | Data source                               | Code Table
---------------------|-------------------------------------------|------------
PersonalID           | (?) CLIENT_KEY                            |
FirstName            | FIRST_NAME                                |
MiddleName           | MIDDLE_NAME                               |
LastName             | LAST_NAME                                 |
NameSuffix           | SUFFIX                                    |
NameDataQuality      | NAME_TYPE                                 | PATH_CODE_NAME_TYPE
SSN                  | IDENTIFICATION (if ID_TYPE = 1)           | 
SSNDataQuality       | ID_TYPE (if ID_TYPE in (1,2,8,9) else ??) | PATH_CODE_ID_TYPE
DOB                  | DATE_OF_BIRTH (if DOB_TYPE = 1)           |   
DOBDataQuality       | DOB_TYPE                                  | PATH_CODE_DOB_TYPE
AmIndAKNative        | (if exists PATH_CLIENT_RACE.CODE_KEY = 7) | PATH_CODE_RACE
Asian                | (if exists PATH_CLIENT_RACE.CODE_KEY = 5) | PATH_CODE_RACE
BlackAfAmerican      | (if exists PATH_CLIENT_RACE.CODE_KEY = 6) | PATH_CODE_RACE
NativeHIOtherPacific | (if exists PATH_CLIENT_RACE.CODE_KEY = 9) | PATH_CODE_RACE
white                | (if exists PATH_CLIENT_RACE.CODE_KEY = 8) | PATH_CODE_RACE
raceNone             | (if not exists PATH_CLIENT_RACE.CODE_KEY) | PATH_CODE_RACE
Ethnicity            | ETHNICITY_KEY                             | PATH_CODE_ETHNICITY
Gender               | GENDER_KEY                                | PATH_CODE_GENDER
OtherGender          |                                           |
VeteranStatus        | VETERAN                                   | PATH_CODE_VETERAN
YearEnteredService   |                                           |
YearSeparated        |                                           |
WorldWarII           |                                           |
KoreanWar            |                                           |
VietnamWar           |                                           |
DesertStorm          |                                           |
AfghanistanOEF       |                                           |
IraqOIF              |                                           |
IraqOND              |                                           |
OtherTheater         |                                           |
MilitaryBranch       |                                           |
DischargeStatus      |                                           |
DateCreated          | CREATE_DATE                               |
DateUpdated          | UPDATE_TIMESTAMP                          |
UserID               | CREATE_USER_KEY                           | PATH_USERS
DateDeleted          |                                           |


### /enrollments

(?) Is there one enrolment per household? Or one enrolment per household-client? (??) are the verb enrollment and the noun enrolment _really_ spelled differentl?
Enrollments have a many:1 relationship with PATH_CLIENT_PROGRAM. (one PATH_CLIENT_PROGRAM row must be joined with PATH_HOUSEHOLD_CLIENT to create on row per client in the household at the time)

API Field                                                 | Data source                              | Code Table
----------------------------------------------------------|------------------------------------------|------------
(?) ClientEnrollmentID                                    | PROGRAM_KEY                              |
ClientId                                                  | PATH_HOUSEHOLD_CLIENT.CLIENT_KEY         |
(?) ProjectID                                             | PROGRAM_NAME_KEY                         |
DisablingConditionCode                                    |                                          |
TypeOfResidenceCode                                       |                                          |
otherResidence                                            |                                          |
lengthOfStayInPreviousPlaceCode                           |                                          |
projectEntryDate                                          | ENTRY_DATE                               |
projectExitDate                                           | EXIT_DATE                                |
destinationTypeCode                                       | DESTINATION_KEY                          | PATH_CODE_DESTINATION (where STATUS=A)
otherDestination                                          | DESTINATION_OTHERS                       |
householdId                                               | PATH_HOUSEHOLD_CLIENT.HOUSEHOLD_KEY (at program_entry) |
relationshipToHeadOfHouseholdCode                         | PATH_HOUSEHOLD_CLIENT.RELATIONSHIP       |
clientLocationInformationDate                             |                                          |
clientLocationCoCCode                                     |                                          |
continuouslyHomelessForOneYearCode                        |                                          |
numberOfTimesHomelessInPastThreeYearsCode                 |                                          |
numberOfMonthsHomelessInPastThreeYearsCode                |                                          |
numberOfMonthsContinuouslyHomelessImmediatelyPriorToEntry |                                          |
statusDocumentedCode                                      |                                          |
homelessnessStatusCode                                    |                                          |
engagementDate                                            |                                          |
residentialMoveInDate                                     |                                          |
permanentHousingCode                                      |                                          |
permanentHousingMoveDate                                  |                                          |
housingAssessmentDispositionCode                          |                                          |
housingAssessmentDispositionOther                         |                                          |
housingAssessmentAtExitCode                               |                                          |
housingAssessmentAtExitMaintainedSubsidyCode              |                                          |
housingAssessmentAtExitMovedSubsidyCode                   |                                          |
pathStatusDate                                            |                                          |
pathEnrollmentCode                                        |                                          |
pathNoEnrollmentReasonCode                                |                                          |
connectionWithSoarCode                                    |                                          |
rhyBcpStatusDate                                          |                                          |
fysbYouthEnrollmentCode                                   |                                          |
fysbYouthNoEnrollmentReasonCode                           |                                          |
sexualOrientationCode                                     |                                          |
lastGradeCompletedCode                                    |                                          |
schoolStatusCode                                          |                                          |
employmentEntryInformationDate                            |                                          |
employmentEntryStatusCode                                 |                                          |
employmentEntryTypeCode                                   |                                          |
employmentEntryUnemployedReasonCode                       |                                          |
employmentExitInformationDate                             |                                          |
employmentExitStatusCode                                  |                                          |
employmentExitTypeCode                                    |                                          |
employmentExitUnemployedReasonCode                        |                                          |
generalHealthEntryStatusCode                              |                                          |
generalHealthExitStatusCode                               |                                          |
dentalHealthEntryStatusCode                               |                                          |
dentalHealthExitStatusCode                                |                                          |
mentalHealthEntryStatusCode                               |                                          |
mentalHealthExitStatusCode                                |                                          |
pregnancyStatusCode                                       |                                          |
pregnancyDueDate                                          |                                          |
formerlyChildWelfareCode                                  |                                          |
formerlyChildWelfareYearDurationCode                      |                                          |
formerlyChildWelfareMonthDurationCode                     |                                          |
formerlyJuvenileJusticeCode                               |                                          |
formerlyJuvenileJusticeYearDurationCode                   |                                          |
formerlyJuvenileJusticeMonthDurationCode                  |                                          |
householdDynamicsCode                                     |                                          |
sexualOrientationYouthCode                                |                                          |
sexualOrientationFamilyCode                               |                                          |
housingIssuesYouthCode                                    |                                          |
housingIssuesFamilyCode                                   |                                          |
schoolIssuesYouthCode                                     |                                          |
schoolIssuesFamilyCode                                    |                                          |
unemploymentYouthCode                                     |                                          |
unemploymentFamilyCode                                    |                                          |
mentalHealthYouthCode                                     |                                          |
mentalHealthFamilyCode                                    |                                          |
healthYouthCode                                           |                                          |
healthFamilyCode                                          |                                          |
physicalDisabilityYouthCode                               |                                          |
physicalDisabilityFamilycode                              |                                          |
mentalDisabilityYouthCode                                 |                                          |
mentalDisabilityFamilyCode                                |                                          |
abuseNeglectYouthCode                                     |                                          |
abuseNeglectFamilyCode                                    |                                          |
alcoholAbuseYouthCode                                     |                                          |
alcoholAbuseFamilyCode                                    |                                          |
insufficientIncomeFamilyCode                              |                                          |
activeMilitaryFamilyCode                                  |                                          |
incarceratedParentOfYouthCode                             |                                          |
incarceratedParentOfYouthDetailCode                       |                                          |
referralSourceCode                                        |                                          |
referralOutreachCount                                     |                                          |
sexualExploitationInPastThreeMonthsCode                   |                                          |
sexualExploitationInPastThreeMonthsAmountCode             |                                          |
sexualExplotationRequestCode                              |                                          |
afterCarePlanAgreementCode                                |                                          |
afterCareAdviceCode                                       |                                          |
afterCarePlacementCode                                    |                                          |
afterCareShelterCode                                      |                                          |
afterCareFollowupServicesCode                             |                                          |
afterCareFollowupMeetingCode                              |                                          |
afterCareInformationPackageCode                           |                                          |
afterCareOtherCode                                        |                                          |
rhyCompletionStatusCode                                   |                                          |
rhyEarlyExitReasonCode                                    |                                          |
rhyExpulsionReasonCode                                    |                                          |
familyReunificationCode                                   |                                          |
worstHousingSituationCode                                 |                                          |
householdIncomeAsPercentageOfAmiCode                      |                                          |
lastStreetAddress                                         |                                          |
lastCity                                                  |                                          |
lastState                                                 |                                          |
lastZip                                                   |                                          |
lastAddressQualityCode                                    |                                          |
(?) DateCreated                                           | CREATE_DATE                              |
(?) DateUpdated                                           | UPDATE_DATE                              |
(?) UserID                                                | CREATE_USER_KEY (if UPDATE_DATE is NULL) else UPDATE_USER_KEY  |
(?) DateDeleted                                           |                                          |





