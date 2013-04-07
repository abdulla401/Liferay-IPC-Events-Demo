<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<h1>This is Default Render Jsp</h1>

<portlet:defineObjects/>

<portlet:renderURL var="defaultRenderURL">
	
</portlet:renderURL>

<a href="${defaultRenderURL}">Back</a>
<h1>This is Render 1 JSP</h1>