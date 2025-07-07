# trek-project-test

This is a simple Java web application built with Maven, showing a trekking image on the home page. You can build and deploy it using Apache Tomcat.

## How to Build

```bash
mvn clean install
```

## Deploy WAR to Tomcat
Copy the generated `target/sample-trekking-site.war` into your Tomcat's `webapps/` directory.

## Upload to Nexus (Optional)
Use the Maven deploy plugin or your organization's CI/CD tool to push the WAR to Nexus.
