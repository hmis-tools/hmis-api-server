Contributing to OpenHMIS
=================================================================
The OpenHMIS project is a group effort: thank you for considering helping out!

Step 1: Join the Community
-------------------
If you want to contribute, we welcome you to participate in the [OpenHMIS community](http://openhmis.pcni.org/).

**There are three points of access:**

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


**Other recommendations:**

* Do not be afraid to ask questions of any kind.  We are all here to help!
* Issue not listed? Create an issue for it and start a discussion on the Google Group.



Step 3: Understand our Branching / Contribution Policies
-------------------
Our branching structure is based on [A Successful Git Branching Model](http://nvie.com/posts/a-successful-git-branching-model/), with a few tweaks, the main difference being that we don't keep a `develop` branch.  Instead, we have release branches and feature branches, both of which are periodically merged into `master`.  Whether you should commit a given change to a feature branch or to the latest release branch depends on the nature of the change, as described below.

**The important points:**

* Use tags (e.g. `0.2.0`) to represent release builds.
* Use release branches (e.g. `0.2.1`) to make progress on new builds.  If a change is not part of development on a particular feature, and is not a bugfix, then just commit it to the latest release branch.

	Tag and release branch names use [Semantic Versioning](http://semver.org/)

* Use feature branches (e.g. `feature-oauth`) to develop new functionality or behaviors for the API which will go into a release.

	Feature branches are of the form `feature-FEATURE_NAME`.  If you don't see the feature branch you need, create it -- branches are cheap!

* Use bugfix branches (e.g. `bugfix-52-migration`) for bugfixes that that need to be made outside of the release cycle.

	Bugfix branches are of the form `bugfix-<TICKET_NUMBER>-<BUGFIX_NAME>`.  Usually there should be a ticket number associated with the bug; if there is not, just omit that portion of the branch name (but consider just filing a ticket instead, to keep a consistent process).

* Use the `master` branch for documentation updates and similar global, non-code-related changes.  But, of course, if a documentation update is specifically related to the work being done on a feature branch, then the doc changes should go on that branch together with the code changes.

To make a feature contribution, fork repository and create a new feature branch from the latest release branch.  Once you feel the code is ready for integration, issue a [pull request](https://help.github.com/articles/using-pull-requests/) in which you describe the changes along with [references to any issues you resolved](https://github.com/blog/1506-closing-issues-via-pull-requests).

**Best practices:**

* Do work in small, discrete chunks as much as possible, committing early and often.  It's okay to break one logical change up into several related, smaller changes.  Having one giant commit makes it difficult for someone to wrap their mind around the change.
* Describe your commits with [good commit messages](https://robots.thoughtbot.com/5-useful-tips-for-a-better-commit-message).  Messages like "`changed index.html`" aren't helpful; messages like "`updated the page title`" are.  If your commit is related to an issue, make sure to mention the issue number in the commit message, e.g., "`#8`".
* Don't be upset if your Pull Request requires several iterations before being accepted.  That's a normal part of the open source process, even for experienced developers.  The pull request model is designed around that feedback process.
* Changes to the schema should be done by creating new migrations, not by editing existing migrations.


Step 4: Understand the Code Base
-------------------

This repository generally uses the [Standard Directory Layout](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html) and additional modifications can be found in the [README.md](README.md). 

**Core technologies:**

* [Java](https://java.com)
* [Maven](https://maven.apache.org) for building and dependency management.
* [Tomcat](http://tomcat.apache.org/) for serving the API.
* [MySQL](https://www.mysql.com/) for storing the data.

**Other technologies:**

* [Jersey](https://jersey.java.net) for API route mapping.
* [FlywayDB](flywaydb.org) for schema migrations.



Step 5: Set up a Local Development Environment:
-------------------
Please view [INSTALL.md](INSTALL.md) for information on how to set up a development environment.

If you get stuck at any point in the installation process, create a Github Issue and email the Google Group and someone will help you get unstuck!
