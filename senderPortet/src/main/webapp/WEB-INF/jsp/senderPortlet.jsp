<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Sender Portlet 2</h1>

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
  <option value="-1">Select </option>
  <option value="red"    <c:if test='${color eq "red"}'>    selected</c:if>>Red</option>
  <option value="green"  <c:if test='${color eq "green"}'>  selected</c:if> >Green</option>
  <option value="yellow" <c:if test='${color eq "yellow"}'> selected</c:if>>Yellow</option>
  <option value="black"  <c:if test='${color eq "black"}'>  selected</c:if>>Black</option>
</select>
<!-- 	User Name: <input type="text" name="color"> -->
	<input type="submit">  
</form>
