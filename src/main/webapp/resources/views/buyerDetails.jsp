<%--
  Created by IntelliJ IDEA.
  User: Mihscko
  Date: 24.03.2018
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Invoice App</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet"></head>
<body>

Imię : ${buyer.firstName} <br>
Nazwisko : ${buyer.lastName} <br>
Nazwa firmy : ${buyer.companyName} <br>
NIP : ${buyer.taxNumber} <br>
Ulica : ${buyer.street} <br>
Numer : ${buyer.streetNumber}<br>
Kod pocztowy : ${buyer.postcode} <br>
Miasto : ${buyer.city} <br>
</body>
</html>

