<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: ANIA
  Date: 2018-03-26
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Invoice step 1 - Buyer</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet"/>
</head>
<body>
<div id="contener">
    <div id="nav">
        <h3>Wybierz nabywce</h3>
    </div>
    <div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Imię</th>
                <th>Nazwisko</th>
                <th>Nazwa firmy</th>
                <th>NIP</th>
                <th>Ulica</th>
                <th>Numer</th>
                <th>Miasto</th>
                <th>Poczta</th>
                <th>Szczegóły</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${buyers}" var="buyer">
                <tr>
                    <td>${buyer.firstName}</td>
                    <td>${buyer.lastName}</td>
                    <td>${buyer.companyName}</td>
                    <td>${buyer.taxNumber}</td>
                    <td>${buyer.street}</td>
                    <td>${buyer.streetNumber}</td>
                    <td>${buyer.postcode}</td>
                    <td>${buyer.city}</td>
                    <td>
                        <a class="btn btn-success" href="${pageContext.servletContext.contextPath}/addBuyerToInvoice/${buyer.id}">Dodaj do faktury</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>

</body>
</html>
