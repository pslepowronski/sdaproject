<%--
  Created by IntelliJ IDEA.
  User: Mihscko
  Date: 23.03.2018
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Invoice App</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">
</head>

<body>

Dodaj/edytuj Klienta:
<form:form modelAttribute="newBuyer" method="post">
    <form:input type="hidden" path="id"/><br/>
    <form:label path="firstName">Imię:</form:label>
    <form:input path="firstName"/><br/>
    <form:label path="lastName">Nazwisko:</form:label>
    <form:input path="lastName"/><br/>
    <form:label path="companyName">Nazwa firmy::</form:label>
    <form:input path="companyName"/><br/>
    <form:label path="taxNumber">NIP:</form:label>
    <form:input path="taxNumber"/><br/>
    <form:label path="street">Ulica:</form:label>
    <form:input path="street"/><br/>
    <form:label path="streetNumber">Numer ulicy:</form:label>
    <form:input path="streetNumber"/><br/>
    <form:label path="postcode">Kod Pocztowy:</form:label>
    <form:input path="postcode"/><br/>
    <form:label path="city">Miasto:</form:label>
    <form:input path="city"/><br/>

    <input type="submit" name="apply" value="Zatwierdź"/>

</form:form>

</body>
</html>
