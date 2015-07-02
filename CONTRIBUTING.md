Contributing to OpenHMIS
=================================================================
The OpenHMIS project is a group effort: thank you for considering helping out!

Step 1: Join the Community
-------------------
If you want to contribute, we welcome you to participate in the [OpenHMIS community](http://openhmis.pcni.org/).  There are three core points of access:

* [The Google Group](http://openhmis.pcni.org/developers/discussion-group) is a forum is for any HMIS topic: administrative, policy/governance, and software development.
* [Developer Meetings](http://openhmis.pcni.org/developers/developer-meetings) are held on a regular basis, and are generally coordinated via the Google Group.
* [Github Issues](https://github.com/PCNI/OpenHMIS/issues) are used to keep track of bugs, feature requests, and suggested improvements.


Step 2: Review the Issues
-------------------
Our [list of Issues](https://github.com/PCNI/OpenHMIS/issues) should have a current list of identified issues with OpenHMIS.  New contributors should start by looking at the [easy pickings](https://github.com/PCNI/OpenHMIS/labels/easy%20pickings) list.

The labels with actionable tasks:

* [Easy pickings](https://github.com/PCNI/OpenHMIS/labels/easy%20pickings) - issues that have been identified as good tasks for new contributors who may not know the code base.
* [Core](https://github.com/PCNI/OpenHMIS/labels/core) - issues that represent core functionality to OpenHMIS, these might involve multiple contributors and may be broken into smaller tasks.  Definitely reach out to the group before pursuing a core issue.
* [Enhancement](https://github.com/PCNI/OpenHMIS/labels/enhancement) - these issues are more significant than easy pickings, but less vital than core.  Communicate with the group before taking on an enhancement to coordinate implementation details.
* [Help Wanted](https://github.com/PCNI/OpenHMIS/labels/help%20wanted) - Someone started on an issue but realized they could use another set of hands or eyes.  Feel free to request that this tag get added to an issue you're working on if you want assistance!

No matter the type of issue, if you have identified something you wish to make progress on, please be sure to comment on the issue and post to the google group.


Some other recommendations:

* Do not be afraid to ask questions of any kind.  We are all here to help!
* If you have an issue which is not listed already, create an issue for it and start a discussion thread in the Google Group.



Step 3: Understand our Branching / Contribution Policies
-------------------
Generally our branching structure can be understood by reading (A Successful Git Branching Model)[http://nvie.com/posts/a-successful-git-branching-model/].  Here is a quick summary of the important points:

* We use tags (e.g. 0.2.0) to represent release builds.
* We use release branches (e.g. 0.2.1) to make progress on new builds.

	Tag and release branch names use (Semantic Versioning)[http://semver.org/]

* We use feature branches (e.g. feature-oauth) to develop new functionality or behaviors for the API which will go into a release.

	Feature branches are of the form "feature-FEATURE_NAME"

* We use hotfix branches (e.g. hotfix-migration) for urgent changes which need to be made outside of a standard release cycle.

	Hotfix branches are of the form "hotfix_HOTFIX_NAME"


To make a feature contribution, fork repository and create a new feature branch from the latest release branch.  Once you feel the code is ready for integration, issue a [pull request](https://help.github.com/articles/using-pull-requests/) in which you describe the changes along with [references to any issues you resolved](https://github.com/blog/1506-closing-issues-via-pull-requests).

Some Best Practices:

* Commit early and often.  Having one giant commit makes it difficult to understand the evolution of a patch.
* Describe your commits with good comments.  Comments like "changed index.html" aren't helpful.  Comments like "updated the page title" are.
* Don't be upset if your Pull Request requires an iteration.
* (Eventually...) Write tests for your feature (currently we aren't set up for unit tests, but this will change.)


Step 4: Understand the Code Base
-------------------

This repository generally uses the [Standard Directory Layout](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html) and additional modifications can be found in the [README.md](README.md). 

At a high level this project uses:

* [Java](https://java.com)
* [Maven](https://maven.apache.org) for building and dependency management.
* [Tomcat](http://tomcat.apache.org/) for serving the API.
* [MySQL](https://www.mysql.com/) for storing the data.

Moving slightly lower, the project uses:

* [Jersey](https://jersey.java.net) for API route mapping.
* [FlywayDB](flywaydb.org) for schema migrations.



Step 5: Set up a Local Development Environment:
-------------------
Please view [INSTALL.md](INSTALL.md) for information on how to set up a development environment.

If you get stuck at any point in the installation process, create a Github Issue and email the Google Group and someone will help you get unstuck!
