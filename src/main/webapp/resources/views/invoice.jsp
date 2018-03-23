<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ANIA
  Date: 2018-03-21
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet"/>
    <title>InvoicesPage</title>
</head>
<body>
<div id="contener">
    <div id="menu">

    </div>
    <div id="main">
        <table>
            <thead>
            <tr>
                <td>Numer faktury</td>
                <td>Data sprzedazy</td>
                <td>Data platnosci</td>
                <td>Zaplacono</td>
                <td>Płatnik</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${allInvoices}" var="invoice">
                <tr>
                    <td>${invoice.invoiceNumber}</td>
                    <td>${invoice.sellByDate}</td>
                    <td>${invoice.paymentType}</td>
                    <td>${invoice.paymentType}</td>
                    <td>${invoice.buyer}</td>
                    <td><a href="${pageContext.servletContext.contextPath}/invoice/${invoice.id}">Szczegóły</a></td>
                    <td>
                        <form action="invoice/delete" method="post">
                            <input type="submit" name="deleteInvoice" value="Usun"/>
                            <input type="hidden" name="invoiceId" value="${invoice.id}"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href="${pageContext.servletContext.contextPath}/invoice/add">Dodaj fakture</a>

    </div>
    <div id="main2">

        <form:form modelAttribute="criteria" action="search" method="post">
            <table>
                <tr>
                    <td><form:label path="invoiceNumber">Numer faktury: </form:label></td>
                    <td><form:input path="invoiceNumber"></form:input></td>
                </tr>
                <tr>
                    <td><form:label path="paymentDateFrom">Data platnosci od: </form:label></td>
                    <td><form:input path="paymentDateFrom"></form:input></td>
                </tr>
                <tr>
                    <td><form:label path="paymentDateto">Data platnosci do: </form:label></td>
                    <td><form:input path="paymentDateto"></form:input></td>
                </tr>
                <tr>
                    <td><form:label path="sellDatefrom">Data sprzedazy od: </form:label></td>
                    <td><form:input path="sellDatefrom"></form:input></td>
                </tr>
                <tr>
                    <td><form:label path="sellDateto">Data sprzedazy do: </form:label></td>
                    <td><form:input path="sellDateto"></form:input></td>
                </tr>
                <tfoot>
                <tr>
                    <td colspan="2"><input type="submit" value="filtruj"></td>
                </tr>
                </tfoot>
            </table>
        </form:form>

    </div>
    <div id="footer">
        &copy; 2018
    </div>


</div>

</body>
</html>
