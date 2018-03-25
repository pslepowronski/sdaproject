<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.servletContext.contextPath}/resources/css/invoiceFormat.css" rel="stylesheet"></head>
<title>Invoice details</title>
</head>
<body>
<form:form modelAttribute="fullInvoiceAfterEdit" action="editFullInvoice" method="post">
<div id="contener">
    <div id="title">
        ${invoice.invoiceNumber} <form:input path="invoiceNumber" value="${invoice.invoiceNumber}"></form:input>
    </div>
    <div id="dates">
        Data sprzedazy: ${invoice.sellByDate} <form:input path="sellByDate" value="${invoice.sellByDate}"></form:input><br>
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
        ${invoice.user.login}
    </div>
</div>
</form:form>

<a href="${pageContext.servletContext.contextPath}/invoice/${invoice.id}/costEdit">Edytuj</a>
<a href="${pageContext.servletContext.contextPath}/invoice/${invoice.id}/print">Drukuj</a>
</body>
</html>