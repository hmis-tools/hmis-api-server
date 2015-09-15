OpenHMIS API
============

The OpenHMIS API is a web-based API for collecting data and generating
reports about sources and users of social services.  The latest
version of the API is version 3 and it is currently under development:

* [OpenHMIS API, v3](https://github.com/PCNI/OpenHMIS/blob/feature-compass_schema/docs/API.md)

Although the API is still in development, there is an
incomplete/unstable version of it (both server and demo client)
[running here](http://108.59.80.159:8080/HMISClient/).

For an example of the API in use, see the [Mobile Outreach App design
specification](https://github.com/PCNI/outreach-app/blob/master/doc/outreach-app-design.docx).

Our long-term goal is for the API to reflect the full data schema from
the 2014 data standards from the [U.S. Department of Housing and Urban
Development (HUD)](http://hud.gov/).  While the API is still fairly
minimal, this [schema based on the full HUD 2014 Data
Standards](doc/2014StandardOpenHMIS.png) gives an idea of what the API
will eventually support, and this [smaller
schema](doc/current-schema-diagram.jpg) gives an idea of what the API
supports so far.  (The latter diagram is not always kept in sync with
the database or API implementations, so it may be a bit out of date.)

For more information about the HUD 2014 standards, see:

* [HMIS Data Exchange Resources](http://www.hudhdx.info/VendorResources.aspx) (pay attention only to things with "2014" or later next to them)
* [2014 HMIS Logical Model UML diagram](http://www.hudhdx.info/Resources/Vendors/4_0/HMIS_Logical_Model.pdf)
* [HUD 2014 HMIS Data Dictionary](https://www.hudexchange.info/resource/3824/hmis-data-dictionary/)

Note that the OpenHMIS API is intended to compatibly cover the same
core API defined by the [HMIS API
project](http://htmlpreview.github.io/?https://github.com/hmis-api/api/blob/master/doc/hmis-api.html)
project.  This overlap is deliberate: interoperability is a primary
goal of OpenHMIS, and staying compatible with the HMIS API is how
OpenHMIS ensures interoperability with HMIS clients and servers from
many providers.

Historical background:
----------------------

There have been two earlier versions of the OpenHMIS API, both of them
based on the HUD 2010 data standards.  Neither should be used as a
basis for new development now, since they are based on HUD 2010
instead of on HUD 2014, but we list them here for reference:

* [OpenHMIS API v1](https://drive.google.com/viewerng/viewer?a=v&pid=sites&srcid=cGNuaS5vcmd8b3BlbmhtaXN8Z3g6NGVmMWE3NzQ5OWRlOTA0Mw).  This API is implemented by the [deprecated_v1_api branch](https://github.com/PCNI/OpenHMIS/tree/deprecated_v1_api), and is the API currently used by the [Homeless Helper](https://github.com/PCNI/homeless-helper) application.

* [OpenHMIS API v2](https://code.google.com/p/openciss/wiki/openCISS_API_v2).  No clients use this version and no known servers implement it.
