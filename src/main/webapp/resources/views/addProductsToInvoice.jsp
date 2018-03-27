<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <form action="products/complement" method="post">
        <table class="table table hover">
            <thead>
            <tr>
                <td>Id</td>
                <td>Nazwa</td>
                <td>Cena</td>
                <td>Dostepna ilosc</td>
                <td>Dodaj do faktury</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${allProducts}" var="product">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.quantity}</td>
                    <td>
                            <input type="text" name="productQuantitySell" value="0">
                            <input type="hidden" name="productId" value="${product.id}">
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <input class="btn btn-success btn-sm" type="submit" value="Dodaj do faktury">
        </form>
    </div>

    <div id="main2">
    <table>
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
