# wedding: A Wedding Website back-end
Back-end for a Wedding Website app with RSVP and Registry

See the front-end project here: https://github.com/mdb255/wedding-ui

## Pre-requisites
* [MySQL]
* [Eclipse EE] with [Hibernate tools]
* [Maven]
* [Tomcat] (7+)

## Quick Start
#### Data
* Create a new schema _weddingdb_ in the local MySQL instance
* Import the project into Eclipse as an existing Maven project
* Update _/wedding-domain/src/main/resources/db/migration/V1_5__Seed_Registry_Item.sql_ with custom Registry Item data
* Update the pom.xml and hibernate.cfg.xml in this project with appropriate DB connection config
* Create a Maven run configuration from the _wedding-domain_ project with goal _compile flyway:migrate_
* Run this build to create the required tables and seed initial data

#### Web application
* In Eclipse choose _New > Other > Server_ and add a Tomcat Server
* Include both the wedding-ws and wedding-ws-test applications
* In the Servers view, double-click the _localhost_ server to edit, and change the HTTP port to 8080
* Run the Tomcat server and browse to http://localhost:8090/#/registry?category=transportation to test the Registry

## Misc
##### Disclaimers:
* Has not been reviewed for security issues and should not be used for sensitive data

[MySQL]: https://www.mysql.com/
[Eclipse EE]: http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/keplersr2
[Tomcat]: http://tomcat.apache.org/
[Hibernate tools]: http://hibernate.org/tools/
[FlyWayDB]: http://flywaydb.org/
[Maven]: https://maven.apache.org/
[Spring framework]: http://projects.spring.io/spring-framework/
