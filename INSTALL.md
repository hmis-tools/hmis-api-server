## Installation Instructions


### Prerequisites
- JRE 7.x
- Git

### Base Instructions
- Install Maven (3.3.3) - NOTE: follow the README instructions in the Maven repository carefully
- Install Tomcat 7.x - https://wolfpaulus.com/jounal/mac/tomcat8/ (instructions are identical except for the version number we are using)
- Set up your local machine's Tomcat user and a Maven server  (1.1 and 1.2 from [http://www.mkyong.com/maven/how-to-deploy-maven-based-war-file-to-tomcat/])

### Customizing Eclipse
- Add Maven to Eclipse ([http://www.eclipse.org/m2e/])

### Running
from command line:
 - mvn tomcat7:deploy
 - mvn tomcat7:redeploy