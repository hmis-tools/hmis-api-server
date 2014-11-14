OpenHMIS API
============

The OpenHMIS API is a web-based API for collecting data and generating
reports about sources and users of social services.  The latest
version of the API is version 3 and it is currently under development:

* [OpenHMIS API v3 documentation](https://docs.google.com/document/d/15-7OoU0fRtdq9IUuATA9AQfZsuDnkq03X9ORbs94udE/edit) (draft API specification based on the in-progress Outreach Mobile App).

Although this API is still in development, there is an
incomplete/unstable version of it (both server and demo client)
[running here](http://108.59.80.159:8080/HMISClient/).  The API is
still fairly minimal; this [schema diagram](doc/schema-diagram.jpg)
gives an idea of what is supported so far (note that the schema
diagram is not always kept in sync with the database or API
implementations, so it may be a bit out of date).

Our long-term goal is for the API's underlying data schema to be based
on the 2014 data standards from the [U.S. Department of Housing and
Urban Development (HUD)](http://hud.gov/).  For more information about
those standards, see:

* [HMIS Data Exchange Resources](http://www.hudhdx.info/VendorResources.aspx) (pay attention only to things with "2014" or later next to them)
* [2014 HMIS Logical Model UML diagram](http://www.hudhdx.info/Resources/Vendors/4_0/HMIS_Logical_Model.pdf)
* [HUD 2014 HMIS Data Dictionary](https://www.hudexchange.info/resource/3824/hmis-data-dictionary/)

Historical background:
----------------------

There have been two earlier versions of the OpenHMIS API, both of them
based on the HUD 2010 data standards.  Neither should be used as a
basis for new development now, since they are based on HUD 2010
instead of on HUD 2014, but we list them here for reference:

* [OpenHMIS API v1](https://drive.google.com/viewerng/viewer?a=v&pid=sites&srcid=cGNuaS5vcmd8b3BlbmhtaXN8Z3g6NGVmMWE3NzQ5OWRlOTA0Mw).  This API is implemented by the [deprecated_v1_api branch](https://github.com/PCNI/OpenHMIS/tree/deprecated_v1_api), and is the API currently used by the [Homeless Helper](https://github.com/PCNI/homeless-helper) application.

* [OpenHMIS API v2](https://code.google.com/p/openciss/wiki/openCISS_API_v2).  No clients use this version and no known servers implement it.
