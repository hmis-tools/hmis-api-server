The Design of the "OpenHMIS API <-> Data Storage" Code Layers
=============================================================

Overview
--------

This server implements an OpenHMIS API layer on top of a database
layer based on the Pathways COMPASS/ROSE schema.  The API is based on
the HUD 2014 Logical Model and is not specific to any particular
schema, but the underlying data storage layer is allowed to be
vendor-specific and normally is so.  In other words, the data storage
layer is *not* necessarily fully determined by the HUD 2014 Logical
Model, although it must of course be able to support any data that
fits within that model.  In practice, we expect the data storage layer
to be arranged differently depending on the implementation.

This design document explains how those layers relate, starting from
the top (API) down to the bottom (database schema).  It is based on
Dan Schultz's post ["Re: A modest request about
terminology."](http://openhmis.pcni.org/developers/discussion-group?place=msg%2Fopenhmis-discuss%2F7NoHSbk2F28%2F2mRITwD4GQAJ)
of 5 August 2015 on the OpenHMIS Discuss mailing list.

Design Details
--------------

The following things are 100% vendor-neutral.  They should be able to
be reused by every vendor in the world who wants to have an
implementation of the API:

**1)** **Service objects: [src/main/java/org/openhmis/webservice](src/main/java/org/openhmis/webservice)**

        These define the endpoint structure (which currently closely
        matches the https://github.com/hmis-api/api spec as well).

**2)** **Data Transfer Objects (DTOs): [src/main/java/org/openhmis/dto](src/main/java/org/openhmis/dto)**

        These define the endpoint input/output object structures
        (e.g. field names and the JSON objects that are returned and
        taken in by the endpoints).

**3)** **Codes: [src/main/java/org/openhmis/code](src/main/java/org/openhmis/code)**

        These define the values of an object (e.g. "EmploymentType 2
        means part time").

Then there are then the following types of object where the
*architecture* is vendor-neutral -- these objects will all look very
similar between implementations, regardless of vendor -- but the
details of the implementation are inherently vendor-specific:

**4)** **Domain Objects: [src/main/java/org/openhmis/domain](src/main/java/org/openhmis/domain)**

        These are automatically generated objects, created by
        Hibernate tools in Eclipse.  They are explicitly defined to
        mirror a schema.

**5)** **Data Access Objects (DAOs): [src/main/java/org/openhmis/dao](src/main/java/org/openhmis/dao)**

        These are manually created objects (one object per domain
        object) which can usually be automatically or
        semi-automatically generated.  They just make it possible to
        query the database using the domain objects.

**6)** **Manager Objects: [src/main/java/org/openhmis/manager](src/main/java/org/openhmis/manager)**

        These are manually created objects (one object per DTO), and
        actually do the mapping logic between the vendor-specific
        schema and the vendor-neutral API implementation.

So, layer (6) is the only place where meaningful vendor logic exists.
Layers (4) and (5) are basically dumb objects that are (or might as
well be) automatically generated.
