<%--
  Created by IntelliJ IDEA.
  User: Mihscko
  Date: 22.03.2018
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Klient</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">
</head>
</head>
<body>

<div class="wrapper">
    <div class="header">

        <div class="nav">
            <td>
                <jsp:include page="menu.jsp"/>
            </td>
        </div>
    </div>

<form:form modelAttribute="criteria"
           action="buyers/search" method="post">
    <table>
        <tr>
            <form:label path="firstName">Imię: </form:label>
            <form:input path="firstName"></form:input><br/>
        </tr>
        <tr>
            <form:label path="lastName">Nazwisko: </form:label>
            <form:input path="lastName"></form:input><br/>
        </tr>
        <tr>
            <form:label path="companyName">Nazwa firmy: </form:label>
            <form:input path="companyName"></form:input><br/>
        </tr>
        <tr>
            <form:label path="taxNumber">NIP: </form:label>
            <form:input path="taxNumber"></form:input><br/>
        </tr>
        <tr>
            <form:label path="city">Miasto: </form:label>
            <form:input path="city"></form:input><br/>
        </tr>
        <tfoot>

        <tr>
            <td colspan="2"><input type="submit" value="Filtruj"></td>
        </tr>
        </tfoot>
    </table>
</form:form>

Klienci:<br/>

    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            text-align: left;
            padding: 8px;
            border: 1px solid #ddd;

        }

        tr:nth-child(even){background-color: #f5f5f5}

        th {
            background-color: #4CAF50;
            color: white;
        }
        a:link, a:visited {
            background-color: #4CAF50;
            color: white;
            padding: 14px 25px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            border-radius: 4px;
        }


        a:hover, a:active {
            background-color: #5db761;
        }
        input[type=text], select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type=submit] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

    </style>
<table>
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
            <td><a href="${pageContext.servletContext.contextPath}/buyer/${buyer.id}">Przejdz</a></td>
            <td>
                <form action="buyer/delete" method="post">
                    <input type="submit" name="deleteBuyer" value="Usuń"/>
                    <input type="hidden" name="buyerId" value="${buyer.id}"/>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="${pageContext.servletContext.contextPath}/buyer/add">Dodaj klienta</a>

</div>
</body>
</html>
