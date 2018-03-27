<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Invoice details</title>
</head>
<body>
<%--<form:form modelAttribute="finalInvoice" action="finalInvoice" method="post">--%>
<div id="contener">
    <div id="title">
        Faktura numer <input type="text" name="invoiceName" value="0000">
    </div>
    <div id="dates">
        Data sprzedazy: ${date}
        Data platnisci:
        <select name="dataPlatnosci">
            <option>${date}</option>
            <option>${date.plusMonths(1)}</option>
            <option>${date.plusMonths(3)}</option>
        </select>
    </div>
    <div id="buyer">
            Nabywca:<br>
            ${buyer.firstName} ${buyer.lastName} ${buyer.companyName} <br>
            ul. ${buyer.street} ${buyer.streetNumber} <br>
            ${buyer.postcode} ${buyer.city} <br>
            NIP: ${buyer.taxNumber} <br>
    </div>
    <div id="invoiceItems">
        <c:forEach items="${invoiceItems}" var="invoiceItem" varStatus="iterator">
            ${iterator.index+1},
            ${invoiceItem.product.name},
            ${invoiceItem.product.price},
            ${invoiceItem.quantity},
            ${invoiceItem.sum}<br>
        </c:forEach>
    </div>
    <div id="sumAndPay">
        <select name="typPlatnosci">
            <option>gotowka</option>
            <option>przelew</option>
            <option>karta platnicza</option>
            <option>kredyt kupiecki 1M</option>
            <option>kredyt kupiecki 3M</option>
        </select>


    </div>
</div>
<%--</form:form>--%>
<a class="btn btn-primary" href="${pageContext.servletContext.contextPath}/invoice/${invoice.id}/invoiceEdit">Edytuj</a>
<a class="btn btn-success" href="${pageContext.servletContext.contextPath}/invoice/${invoice.id}/print">Drukuj</a>

</body>
</html>
