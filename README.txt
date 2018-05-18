HelloWorld: a program (.jar) that prints hello world to the console.
HelloRose: a web app (.war) that prints hello rose in a browser.
ForumApi: a web app (.war) that takes multiple kinds of calls and contains multiple classes.
DatabaseApi: a web app(.war) that fetches MySQL data.

To run tomcat server:
	$catalina start
	$localhost:8080/
	$catalina stop

To run mysql server:
	$mysql.server start
	$mysql.server stop

To run a maven web app:
	$mvn package to create .war
	Change .war to ROOT.war to access web app at localhost:8080, if don't change, then access at localhost:8080/[.war filename]
	$cp .war to /usr/local/Cellar/tomcat/9.0.8/libexec/webapps/
	$catalina start
	visit localhost:8080/[optional .war filename]
	$catalina stop

The .jar and .war files are located in the target folder. Dependencies are from Xiaomi's internal Maven repository and some may not openly available.