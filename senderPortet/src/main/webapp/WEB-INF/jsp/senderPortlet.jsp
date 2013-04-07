<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<h1>Sender Portlet</h1>

<portlet:defineObjects/>

<portlet:renderURL var="renderOneMethodURL">
	<portlet:param name="action" value="renderTwo"></portlet:param>
</portlet:renderURL>

<portlet:actionURL var="actionOneMethodURL">
<portlet:param name="action" value="actionOne"></portlet:param>
</portlet:actionURL>

<a href="${renderOneMethodURL}">Alternate render action</a>

<br />
<br />

<form action="${actionOneMethodURL}" method="post">
Color : <select name="color">
  <option value="red">Red</option>
  <option value="green">Green</option>
  <option value="yellow">Yellow</option>
  <option value="black">Black</option>
</select>
<!-- 	User Name: <input type="text" name="color"> -->
	<input type="submit">  
</form>
