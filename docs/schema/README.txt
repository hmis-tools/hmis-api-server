This directory contains unzipped PCR_Test_SchemaAndData_v1.2.zip from
https://drive.google.com/file/d/0B6jU7mYT7ztJWkJCTktyemVHUU0/view, as
posted by Steve Conners on 20 July 2015.  That entire message is
reproduced below, because it contains some information about the
differences between this v1.2 and previous versions of the schema.

    From: Steve Conners
    Subject: Re: [HMIS-Discuss] API and Schema Status
    To: Dan Schultz
    Cc: Karl Fogel, Cecilia Donnelly, Dave Totten, OpenHMIS Discuss
    Date: Mon, 20 Jul 2015 08:17:13 -0500
    Message-ID: \
      <CAJaH7nUVG_Sy9b+p788WKKjfHke4KfmAxDpSyfwh37GWyMnqSQ@mail.gmail.com>
    
    I have added to (and altered and removed from) the existing test data
    set. The new test data can be found here:

      COMPASS OpenHMIS Schema v1.2 [links to
      https://drive.google.com/file/d/0B6jU7mYT7ztJWkJCTktyemVHUU0/view]

    This is intended as a semi-permanent link and should be accessible
    for 6-12 months, longer if necessary.
    
    The changes were added tables (to support the API features noted by
    Dan) and added test data (to include a veteran). A handful of
    unnecessary tables were removed.
                     added the following data tables
                        PATH_CLIENT_STATUS
                        PATH_CLIENT_VETERAN
                        PATH_CLIENT_VETERAN_INFO
                        PATH_CLIENT_VETERAN_NEW
                        PATH_CODE_HUD_PROGRAM
                     added the following code tables
                        PATH_CODE_HEALTH_STATUS
                        PATH_CODE_MILITARY_BRANCH
                        PATH_CODE_MILITARY_ERA
                        PATH_CODE_PROGRAM_TYPE
                        PATH_CODE_PRIMARY_DISABILITY
                        PATH_CODE_PRIMARY_DIS_SUB
                        PATH_CODE_RESIDENCE_TYPE
                        PATH_STATUS
                        PATH_STATUS_CURRENT
                      updated test data for the following tables to
    include a veteran
                        PATH_AGENCY
                        PATH_HOUSEHOLD
                        PATH_HOUSEHOLD_CLIENT
                        PATH_CLIENT
                        PATH_CLIENT_AGENCY
                        PATH_CLIENT_CHRONIC_HOMELESS
                        PATH_CLIENT_CONTACT_NEED
                        PATH_CLIENT_PROGRAM
                        PATH_CLIENT_RACE
                        PATH_CLIENT_SPECIAL_NEEDS
                        PATH_CLIENT_HEALTH_INSURANCE
                        PATH_CLIENT_INCOME_CASH
                        PATH_CLIENT_INCOME_NONCASH
                      removed the following unnecessary tables
                        PATH_CODE_PROGRAM_HOPWA
                        PATH_CODE_PROGRAM_HOPWA_EXIT
                        PATH_CODE_PROGRAM_PATH_EXIT
                        PATH_CODE_PROGRAM_RELATIONSHIP
                        PATH_CODE_PROGRAM_RHSAP
                        PATH_CODE_PROGRAM_RHY
                        PATH_CODE_PROGRAM_RHY_EXIT
                        PATH_CODE_PROGRAM_RHY_YOUTH
    
    Here are the references to the COMPASE OpenHMIS Schema tables for the
    OpenHMIS Only objects and codes. Please let me know if you encounter
    any additional missing information.
    
    
        Objects
        Below is an overview of the objects I see based on the schema
        files I have access to today:
       
        HMIS ONLY
            Client Disabilities
    
    This should be in PATH_CLIENT.
    
            Client Household
    
    PATH_HOUSEHOLD added in v1.1.
    
            Client Noncash Benefits
    
    PATH_CLIENT_INCOME_NONCASH added in v1.1. 
    
            Client Status
    
    PATH_CLIENT_STATUS added in v1.2. 
    
            Client Theatre
            Client Veteran Info
    
    PATH_CLIENT_VETERAN, PATH_CLIENT_VETERAN_INFO, and 
    PATH_CLIENT_VETERAN_NEW added in v1.2. 
    
            Project
    
    PATH_CODE_HUD_PROGRAM added in v1.2. 
    
            Project Participation
    
    This should be in PROGRAM_ENROLLMENT 
    
            Service Event
    
    This should be in PATH_CLIENT_CONTACT NEED. 
    
            User Info
            User Permission
    
    This will require a little more work to provide test data -- some
    users exist as real users in our test system.
     
    
       
        Codes
        Below are a list of the codes referenced by various objects:
       
        HMIS ONLY
            Health Status
    
     PATH_CODE_HEALTH_STATUS added in v1.2. 
    
            Military Branch
    
     PATH_CODE_HEALTH_STATUS added in v1.2.  
    
            Military Discharge
    
     PATH_CODE_HEALTH_STATUS added in v1.2.  
    
            Project Type
    
     PATH_CODE_HEALTH_STATUS added in v1.2.  
    
            Residence
    
     PATH_CODE_RESIDENCE_TYPEadded in v1.2.  
    
    
    Additionally,
    PATH_STATUS and PATH_STATUS_CURRENT added in v1.2 for
    PATH_CLIENT_STATUS homelessness status lookups.
    PATH_CODE_PROGRAM_TYPE added in v1.2 for PATH_CODE_HUD_PROGRAM
    program type lookups.
    PATH_CODE_PRIMARY_DISABILITY and PATH_CODE_PRIMARY_DIS_SUB added in
    v1.2 for PATH_CLIENT disability lookups.

--------------------------------------------------------------------------

The only changes are the renaming of _README.txt to README.txt (this
file), the addition of this note, and an adjustment to the text below
to say "data_codes" instead of "codes" to match the subdirectory name
actually present in the original zip file.

--------------------------------------------------------------------------
Original _README.txt follows:
--------------------------------------------------------------------------

PCR_Test_Schema_And_Archive.zip v1.2
2015-07-20 sjc - added tables, test data, and added a veteran v1.2
                 added the following data tables
                    PATH_CLIENT_STATUS
                    PATH_CLIENT_VETERAN
                    PATH_CLIENT_VETERAN_INFO
                    PATH_CLIENT_VETERAN_NEW
                    PATH_CODE_HUD_PROGRAM
                 added the following code tables
                    PATH_CODE_HEALTH_STATUS
                    PATH_CODE_MILITARY_BRANCH
                    PATH_CODE_MILITARY_ERA
                    PATH_CODE_PROGRAM_TYPE
                    PATH_CODE_PRIMARY_DISABILITY
                    PATH_CODE_PRIMARY_DIS_SUB
                    PATH_CODE_RESIDENCE_TYPE
                    PATH_STATUS
                    PATH_STATUS_CURRENT
                  updated test data for the following tables to include a veteran
                    PATH_AGENCY
                    PATH_HOUSEHOLD
                    PATH_HOUSEHOLD_CLIENT
                    PATH_CLIENT
                    PATH_CLIENT_AGENCY
                    PATH_CLIENT_CHRONIC_HOMELESS
                    PATH_CLIENT_CONTACT_NEED
                    PATH_CLIENT_PROGRAM
                    PATH_CLIENT_RACE
                    PATH_CLIENT_SPECIAL_NEEDS
                    PATH_CLIENT_HEALTH_INSURANCE
                    PATH_CLIENT_INCOME_CASH
                    PATH_CLIENT_INCOME_NONCASH
                  removed the following unnecessary tables
                    PATH_CODE_PROGRAM_HOPWA
                    PATH_CODE_PROGRAM_HOPWA_EXIT
                    PATH_CODE_PROGRAM_PATH_EXIT
                    PATH_CODE_PROGRAM_RELATIONSHIP
                    PATH_CODE_PROGRAM_RHSAP
                    PATH_CODE_PROGRAM_RHY
                    PATH_CODE_PROGRAM_RHY_EXIT
                    PATH_CODE_PROGRAM_RHY_YOUTH
2015-07-17 sjc - added path_client_income_cash and path_client_income_noncash v1.1
2015-07-14 sjc - created v1.0


This archive contains the schema and test data for use with an OpenHMIS API implementation.

There are three folders, each containing SQL files. The folders are:

 schema:      ddl scripts to create tables 

 data_codes:  population scripts for lookup tables

 data:        population scripts for data tables
              (households 209778,340873,342956 were used to seed the database)


This is NOT production data. While the Agencies included here are actual agencies, the clients are test users. Email addresses were find/replaced with my email.
