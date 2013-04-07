1. use liferay 6.1 and mysql 5.6
2. update liferay 6.1 mysql connector 
3. use maven archtype liferay-portal-archtype
4. use maven for spring portlets (mvn package liferay:deploy)
5. the latest spring webmvc portlet version 3.2.2.RELEASE was giving java.lang.IncompatibleClassChangeError exception
	as per liferay/liferay-portal-src-6.1.1-ce-ga2/lib/versions.html change the version of spring-mvc-portlet to
	3.0.7.7 RELASE
6. IPC using spring events	
7. -Xdebug -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n