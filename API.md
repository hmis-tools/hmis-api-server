OpenHMIS API
============

The OpenHMIS API is a web-based API for collecting data and generating
reports about sources and users of social services.  Its underlying
data schema is based on the [2014 HUD HMIS Data
Standards](http://www.hudhdx.info/VendorResources.aspx) (see
especially the [Logical Model UML
diagram](http://www.hudhdx.info/Resources/Vendors/4_0/HMIS_Logical_Model.pdf))
from the [U.S. Department of Housing and Urban
Development](http://hud.gov/).

The latest version of the OpenHMIS API is version 3 ("v3") and is currently under development:

* [OpenHMIS API v3 documentation](https://docs.google.com/document/d/15-7OoU0fRtdq9IUuATA9AQfZsuDnkq03X9ORbs94udE/edit?pli=1).

Although this API is still in development, there is an
incomplete/unstable version of it (both server and demo client)
[running here](http://108.59.80.159:8080/HMISClient/).

Historical background:
----------------------

There have been two earlier versions of the OpenHMIS API, both of them
based on the HUD 2010 data standards.  Neither should be used as a
basis for new development now, since they are based on HUD 2010
instead of on HUD 2014, but we list them here for reference:

* [OpenHMIS API v1](https://drive.google.com/viewerng/viewer?a=v&pid=sites&srcid=cGNuaS5vcmd8b3BlbmhtaXN8Z3g6NGVmMWE3NzQ5OWRlOTA0Mw).  This API is implemented by [github.com/PCNI/OpenHMIS](https://github.com/PCNI/OpenHMIS), and is the API currently used by the [Homeless Helper](https://github.com/PCNI/homeless-helper) application.

* [OpenHMIS API v2](https://code.google.com/p/openciss/wiki/openCISS_API_v2).  No clients use this version and no known servers implement it.
