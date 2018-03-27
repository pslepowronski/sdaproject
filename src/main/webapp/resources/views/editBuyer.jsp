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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>

<body>
<div id="contener">
    <div id="nav">
        <jsp:include page="nawigacja.jsp"/>
    </div>
    <div id="main">
        <table class="table table-hover">
            <thead>
            <tr>
                <td colspan="2">Uzupelnij dane nowego klienta</td>
            </tr>
            </thead>
            <tbody>
            <form:form modelAttribute="newBuyer" method="post">
            <form:input type="hidden" path="id"/>
            <tr>
                <td><form:label path="firstName">Imię:</form:label></td>
                <td><form:input path="firstName"/></td>
            </tr>
            <tr>
                <td><form:label path="lastName">Nazwisko:</form:label></td>
                <td><form:input path="lastName"/></td>
            </tr>
            <tr>
                <td><form:label path="companyName">Nazwa firmy::</form:label></td>
                <td><form:input path="companyName"/></td>
            </tr>
            <tr>
                <td><form:label path="taxNumber">NIP:</form:label></td>
                <td><form:input path="taxNumber"/></td>
            </tr>
            <tr>
                <td><form:label path="street">Ulica:</form:label></td>
                <td><form:input path="street"/></td>
            </tr>
            <tr>
                <td><form:label path="streetNumber">Numer ulicy:</form:label></td>
                <td><form:input path="streetNumber"/></td>
            </tr>
            <tr>
                <td><form:label path="postcode">Kod Pocztowy:</form:label></td>
                <td><form:input path="postcode"/></td>
            </tr>
            <tr>
                <td><form:label path="city">Miasto:</form:label></td>
                <td><form:input path="city"/></td>
            </tr>
            </tbody>
            <tfoot>
            <tr>
                <td colspan="2"><input class="btn btn-success" type="submit" name="apply" value="Zatwierdź"/></td>
            </tr>
            </tfoot>
</form:form>
        </table>
    </div>
    <div id="footer">
        &copy; 2018
    </div>
</div>
</body>
</html>
