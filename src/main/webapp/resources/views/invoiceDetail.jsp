<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ANIA
  Date: 2018-03-22
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.servletContext.contextPath}/resources/css/invoiceFormat.css" rel="stylesheet"></head>
<title>Invoice details</title>
</head>
<body>
<div id="contener">
    <div id="title">
        ${invoice.invoiceNumber}
    </div>
    <div id="dates">
        Data sprzedazy: ${invoice.sellByDate}<br>
        Data platnisci: ${invoice.paymentDate}
    </div>
    <div id="buyer">
        Nabywca: ${invoice.buyer}
    </div>
    <div id="invoiceItems">
        <c:forEach items="${invoice.invoiceItems}" var="invoiceItem">
            ${invoiceItem.product},
            ${invoiceItem.quantity},
            ${invoiceItem.sum}<br>
        </c:forEach>
    </div>
    <div id="sumAndPay">
        ${invoice.invoiceSum}
        ${invoice.paymentType}
        ${invoice.user}
    </div>
</div>

<a href="${pageContext.servletContext.contextPath}/invoice/${invoice.id}/costEdit">Edytuj</a>
<a href="${pageContext.servletContext.contextPath}/invoice/${invoice.id}/print">Drukuj</a>
</body>
</html>
