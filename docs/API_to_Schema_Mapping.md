This document details the mapping of OpenHMIS API objects to the database schema.

Schema: COMPASS OpenHMIS Schema (subset of COMPASS ROSE schema required for API implementation)

### /clients

Client objects are a 1:1 map to PATH_CLIENT. There are no deleted client records. The values of the race characteristics derive from evaluating the presence of records in the PATH_CLIENT_RACE table for the client.

API Field            | Data source                               | Code Table
---------------------|-------------------------------------------|------------
PersonalID           | CLIENT_KEY                                |
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
Gender               | GENDER_KEY                                | PATH_CODE_GENDER (!female lookup value does not match standard)
OtherGender          | GENDER_DESC                               |
VeteranStatus        | VETERAN                                   | PATH_CODE_VETERAN
YearEnteredService   | PATH_CLIENT_VETERAN_INFO.YR_ENTER_MILITARY |
YearSeparated        | PATH_CLIENT_VETERAN_INFO.YR_SEP_MILITARY  |
WorldWarII           | PATH_CLIENT_VETERAN_INFO.WORLD_WAR_II     | PATH_CODE_YESNO
KoreanWar            | PATH_CLIENT_VETERAN_INFO.KOREAN_WAR       | PATH_CODE_YESNO
VietnamWar           | PATH_CLIENT_VETERAN_INFO.VIETNAM_WAR      | PATH_CODE_YESNO
DesertStorm          | PATH_CLIENT_VETERAN_INFO.PERSIAN          | PATH_CODE_YESNO
AfghanistanOEF       | PATH_CLIENT_VETERAN_INFO.AFGHANISTAN_WAR  | PATH_CODE_YESNO
IraqOIF              | PATH_CLIENT_VETERAN_INFO.IRAQ_FREEDOM     | PATH_CODE_YESNO
IraqOND              | PATH_CLIENT_VETERAN_INFO.IRAQ_DAWN        | PATH_CODE_YESNO
OtherTheater         | PATH_CLIENT_VETERAN_INFO.OTHER            | PATH_CODE_YESNO
MilitaryBranch       | PATH_CLIENT_VETERAN.MILITARY_BRANCH_KEY   | PATH_CODE_MILITARY_BRANCH
DischargeStatus      | PATH_CLIENT_VETERAN.DISCHARGE_STATUS_KEY  | PATH_CODE_DISCHARGE_STATUS
DateCreated          | CREATE_DATE                               |
DateUpdated          | UPDATE_TIMESTAMP                          |
UserID               | CREATE_USER_KEY                           | PATH_USERS
DateDeleted          | (N/A)                                     |


### /enrollments

(?) Is there one enrolment per household? Or one enrolment per household-client? (??) are the verb enrollment and the noun enrolment _really_ spelled differentl?
Enrollments have a many:1 relationship with PATH_CLIENT_PROGRAM. (one PATH_CLIENT_PROGRAM row must be joined with PATH_HOUSEHOLD_CLIENT to create on row per client in the household at the time)
Elements in the Data Source field are fields from PATH_CLIENT_PROGRAM, unless stated otherwise. Enrollments are attached to a single member of a household and extend to the rest of the household. The other clients can be found by extracting the full set of client keys from PATH_HOUSEHOLD_CLIENT based on the enrolling member's HOUSEHOLD_KEY. This mapping is denoted in the Data Source field by (PATH_HOUSEHOLD_CLIENT.CLIENT_KEY) -> table.field to indicate that the household member's client key should be used as the constraint to lookup the table.field value.

API Field                                                 | Data source                              | Code Table
----------------------------------------------------------|------------------------------------------|------------
(?) ClientEnrollmentID                                    | PROGRAM_KEY                              |
ClientId                                                  | PATH_HOUSEHOLD_CLIENT.CLIENT_KEY         |
(?) ProjectID                                             | PROGRAM_NAME_KEY                         |
DisablingConditionCode                                    | (PATH_HOUSEHOLD_CLIENT.CLIENT_KEY) -> PATH_CLIENT.DISABLING_CONDITION |
TypeOfResidenceCode                                       | (PATH_HOUSEHOLD_CLIENT.CLIENT_KEY) -> PATH_CLIENT_CHRONIC_HOMELESS.max(ENTRY_DATE) -> PATH_CLIENT_CHRONIC_HOMELESS.PRIOR_NIGHTS_RESIDENCE | PATH_CODE_RESIDENCE_TYPE
OtherResidence                                            | (PATH_HOUSEHOLD_CLIENT.CLIENT_KEY) -> PATH_CLIENT_CHRONIC_HOMELESS.max(ENTRY_DATE) -> PATH_CLIENT_CHRONIC_HOMELESS.PRIOR_RESIDENCE_OTHER | 
LengthOfStayInPreviousPlaceCode                           | (PATH_HOUSEHOLD_CLIENT.CLIENT_KEY) -> PATH_CLIENT_CHRONIC_HOMELESS.max(ENTRY_DATE) -> PATH_CLIENT_CHRONIC_HOMELESS.PRIOR_NIGHTS_RESIDENCE | PATH_CODE_LENGTH_OF_STAY
ProjectEntryDate                                          | ENTRY_DATE                               |
ProjectExitDate                                           | EXIT_DATE                                |
DestinationTypeCode                                       | DESTINATION_KEY                          | PATH_CODE_DESTINATION (where STATUS=A)
OtherDestination                                          | DESTINATION_OTHERS                       |
HouseholdId                                               | PATH_HOUSEHOLD_CLIENT.HOUSEHOLD_KEY (at program_entry) |
RelationshipToHeadOfHouseholdCode                         | PATH_HOUSEHOLD_CLIENT.RELATIONSHIP       |
ClientLocationInformationDate                             |                                          |
ClientLocationCoCCode                                     |                                          |
ContinuouslyHomelessForOneYearCode                        |                                          |
NumberOfTimesHomelessInPastThreeYearsCode                 |                                          |
NumberOfMonthsHomelessInPastThreeYearsCode                |                                          |
NumberOfMonthsContinuouslyHomelessImmediatelyPriorToEntry |                                          |
StatusDocumentedCode                                      |                                          |
HomelessnessStatusCode                                    |                                          |
EngagementDate                                            |                                          |
ResidentialMoveInDate                                     |                                          |
PermanentHousingCode                                      |                                          |
PermanentHousingMoveDate                                  |                                          |
HousingAssessmentDispositionCode                          |                                          |
HousingAssessmentDispositionOther                         |                                          |
HousingAssessmentAtExitCode                               |                                          |
HousingAssessmentAtExitMaintainedSubsidyCode              |                                          |
HousingAssessmentAtExitMovedSubsidyCode                   |                                          |
PathStatusDate                                            |                                          |
PathEnrollmentCode                                        |                                          |
PathNoEnrollmentReasonCode                                |                                          |
ConnectionWithSoarCode                                    |                                          |
RhyBcpStatusDate                                          |                                          |
FysbYouthEnrollmentCode                                   |                                          |
FysbYouthNoEnrollmentReasonCode                           |                                          |
SexualOrientationCode                                     |                                          |
LastGradeCompletedCode                                    |                                          |
SchoolStatusCode                                          |                                          |
EmploymentEntryInformationDate                            |                                          |
EmploymentEntryStatusCode                                 |                                          |
EmploymentEntryTypeCode                                   |                                          |
EmploymentEntryUnemployedReasonCode                       |                                          |
EmploymentExitInformationDate                             |                                          |
EmploymentExitStatusCode                                  |                                          |
EmploymentExitTypeCode                                    |                                          |
EmploymentExitUnemployedReasonCode                        |                                          |
GeneralHealthEntryStatusCode                              |                                          |
GeneralHealthExitStatusCode                               |                                          |
DentalHealthEntryStatusCode                               |                                          |
DentalHealthExitStatusCode                                |                                          |
MentalHealthEntryStatusCode                               |                                          |
MentalHealthExitStatusCode                                |                                          |
PregnancyStatusCode                                       |                                          |
PregnancyDueDate                                          |                                          |
FormerlyChildWelfareCode                                  |                                          |
FormerlyChildWelfareYearDurationCode                      |                                          |
FormerlyChildWelfareMonthDurationCode                     |                                          |
FormerlyJuvenileJusticeCode                               |                                          |
FormerlyJuvenileJusticeYearDurationCode                   |                                          |
FormerlyJuvenileJusticeMonthDurationCode                  |                                          |
HouseholdDynamicsCode                                     |                                          |
SexualOrientationYouthCode                                |                                          |
SexualOrientationFamilyCode                               |                                          |
HousingIssuesYouthCode                                    |                                          |
HousingIssuesFamilyCode                                   |                                          |
SchoolIssuesYouthCode                                     |                                          |
SchoolIssuesFamilyCode                                    |                                          |
UnemploymentYouthCode                                     |                                          |
UnemploymentFamilyCode                                    |                                          |
MentalHealthYouthCode                                     |                                          |
MentalHealthFamilyCode                                    |                                          |
HealthYouthCode                                           |                                          |
HealthFamilyCode                                          |                                          |
PhysicalDisabilityYouthCode                               |                                          |
PhysicalDisabilityFamilycode                              |                                          |
MentalDisabilityYouthCode                                 |                                          |
MentalDisabilityFamilyCode                                |                                          |
AbuseNeglectYouthCode                                     |                                          |
AbuseNeglectFamilyCode                                    |                                          |
AlcoholAbuseYouthCode                                     |                                          |
AlcoholAbuseFamilyCode                                    |                                          |
InsufficientIncomeFamilyCode                              |                                          |
ActiveMilitaryFamilyCode                                  |                                          |
IncarceratedParentOfYouthCode                             |                                          |
IncarceratedParentOfYouthDetailCode                       |                                          |
ReferralSourceCode                                        |                                          |
ReferralOutreachCount                                     |                                          |
SexualExploitationInPastThreeMonthsCode                   |                                          |
SexualExploitationInPastThreeMonthsAmountCode             |                                          |
SexualExplotationRequestCode                              |                                          |
AfterCarePlanAgreementCode                                |                                          |
AfterCareAdviceCode                                       |                                          |
AfterCarePlacementCode                                    |                                          |
AfterCareShelterCode                                      |                                          |
AfterCareFollowupServicesCode                             |                                          |
AfterCareFollowupMeetingCode                              |                                          |
AfterCareInformationPackageCode                           |                                          |
AfterCareOtherCode                                        |                                          |
RhyCompletionStatusCode                                   |                                          |
RhyEarlyExitReasonCode                                    |                                          |
RhyExpulsionReasonCode                                    |                                          |
FamilyReunificationCode                                   |                                          |
WorstHousingSituationCode                                 |                                          |
HouseholdIncomeAsPercentageOfAmiCode                      |                                          |
LastStreetAddress                                         |                                          |
LastCity                                                  |                                          |
LastState                                                 |                                          |
LastZip                                                   |                                          |
LastAddressQualityCode                                    |                                          |
(?) DateCreated                                           | CREATE_DATE                              |
(?) DateUpdated                                           | UPDATE_DATE                              |
(?) UserID                                                | CREATE_USER_KEY (if UPDATE_DATE is NULL) else UPDATE_USER_KEY  |
(?) DateDeleted                                           |                                          |

