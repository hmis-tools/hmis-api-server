OpenHMIS
========

The OpenHMIS project is an [open source](LICENSE.md),
[standards-based](docs/API.md) HMIS (Homeless Management Information
System).

OpenHMIS is set of open standards for storing and exchanging HMIS data
securely; it is also a collection of open source online services, web,
and mobile applications that use those standards to communicate.
OpenHMIS applications collect [HUD](http://hud.gov/)-required data and
generate all HUD-mandated reports, and support data exchange, data
warehousing and more advanced reporting/data mining through the API.
See [OpenHMIS.org](http://openhmis.org/) for more information.

This repository contains the OpenHMIS API specification, and a server
implementing that API.

For more about the API, please see [API.md](docs/API.md).

For more about the server code, please see [INSTALL.md](INSTALL.md).


Directory Structure
-------------------
This repository generally uses the [Standard Directory Layout](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html).  Additional files and directories are described here:

* [docs](docs) which contains custom documentation and less structured notes.


Instructions for Contributing
-------------------
If you are interested in contributing to this repository, please review our [Contributors Guide](CONTRIBUTING.md) which explains policies, guidelines, and general advice.


Authentication
-------------------
This API uses [Google Sign-in](https://developers.google.com/identity/) for authentication.  To build an application powered by this API, your application must the Google Sign-in [server side flow](https://developers.google.com/identity/sign-in/web/server-side-flow).
