<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ANIA
  Date: 2018-03-27
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Invoice step 2 - Products</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet"/>
</head>
<body>

<div id="contener">
    <div id="nav">
        <h3>Wybierz produkty</h3>
    </div>
    <div id="main">
        <form:form modelAttribute="shortInvoice" action="addProductsToInvoice" method="post">
        <table class="table table hover table-condensed">
            <thead>
            <tr>
                <td>Id</td>
                <td>Nazwa</td>
                <td>Cena</td>
                <td>Dostepna ilosc</td>
                <td>Podaj ilosc sztuk do faktury</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${allProducts}" var="product" varStatus="iterator">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.quantity}</td>
                    <td>
                        <input type="text" size="3" name="quantity[${iterator.index}]" value="0">
                        <input type="hidden" name="productId[${iterator.index}]" value="${product.id}">
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <input class="btn btn-success btn-sm" type="submit" value="Dodaj produkty do faktury">
            <input type="hidden" name="buyerId" value="${buyer.id}">
        </form:form>
    </div>

    <div id="main2">
    <table class="table table hover table-condensed">
        <thead>
        <tr>
            <td colspan="2">Dane nabywcy</td>
        </tr>
        </thead>
        <tr>
            <td>Data: </td>
            <td>${date}</td>
        </tr>
        <tr>
            <td>Imię : </td>
            <td>${buyer.firstName}</td>
        </tr>
        <tr>
            <td>Nazwisko : </td>
            <td>${buyer.lastName}</td>
        </tr>
        <tr>
            <td>Nazwa firmy : </td>
            <td>${buyer.companyName}</td>
        </tr>
        <tr>
            <td>NIP : </td>
            <td>${buyer.taxNumber}</td>
        </tr>
        <tr>
            <td>Ulica : </td>
            <td>${buyer.street}</td>
        </tr>
        <tr>
            <td>Numer : </td>
            <td>${buyer.streetNumber}</td>
        </tr>
        <tr>
            <td>Kod pocztowy : </td>
            <td>${buyer.postcode}</td>
        </tr>
        <tr><td>Miasto : </td>
            <td>${buyer.city}</td>
        </tr>
    </table>
    </div>
    <div id="footer">
        &copy; 2018
    </div>


</div>

</body>
</html>
