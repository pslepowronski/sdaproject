<%--
  Created by IntelliJ IDEA.
  User: ANIA
  Date: 2018-03-25
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>nawigacja</title>
</head>
<body>
<table class="table">
    <tr>
        <td><a class="btn btn-success" href="${pageContext.servletContext.contextPath}/invoice">Faktury</a></td>
        <td><a class="btn btn-success" href="${pageContext.servletContext.contextPath}/buyers">Kupcy</a></td>
        <td><a class="btn btn-success" href="${pageContext.servletContext.contextPath}/products">Produkty</a></td>
        <td><a class="btn btn-success" target="_blank" href="${pageContext.servletContext.contextPath}/calculator">Kalkulator</a></td>
        <td><a class="btn btn-success" href="${pageContext.servletContext.contextPath}/calendar">Kalendarz platnosci</a></td>
        <td><a class="btn btn-warning" href="${pageContext.servletContext.contextPath}/main">Wyloguj</a></td>
    </tr>
</table>



</body>
</html>
