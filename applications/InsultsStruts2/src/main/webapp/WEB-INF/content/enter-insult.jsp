<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Hello</title>
	<sb:head/>
</head>

<body>
	<div class="container">
	<h1>Enter an insult, dick</h1>
	<s:form action="enter-insult" theme="bootstrap" cssClass="form-horizontal" label="Insult inserter">
	  <s:textfield name="enteredInsult" label="Insult me!" tooltip="Enter your insult here"/>
	  <s:submit value="Enter" class="btn btn-primary" />
	</s:form>
  <div>
  	Current insults:
  	<ul class="list-group">
  	<s:iterator value="insults">
  		<li class="list-group-item"><s:property /></li>
  	</s:iterator>
    </ul>
  </div>
</div>
</body></html>
