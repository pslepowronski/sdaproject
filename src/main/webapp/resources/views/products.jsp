<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet"/>
    <title>ProductsPage</title>
</head>
<body>
<div id="contener">
    <div id="nav">
        <jsp:include page="nawigacja.jsp"/>
    </div>
    <div id="main">
        <table class="table table-hover table-condensed">
            <thead>
            <tr>
                <td>Id</td>
                <td>Nazwa</td>
                <td>Cena</td>
                <td>Ilosc</td>
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
                        <form action="products/complement" method="post">
                            <input type="text" size="4" name="productQuantity" value="0">
                            <input class="btn btn-success btn-sm" type="submit" value="Uzupelnij">
                            <input type="hidden" name="productId" value="${product.id}">
                        </form>
                    </td>
                    <td>
                        <form action="products/delete" method="post">
                            <input class="btn btn-danger btn-sm" type="submit" name="deleteProduct" value="Usun"/>
                            <input type="hidden" name="productId" value="${product.id}"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>


    </div>
    <div id="main2">

        <form:form modelAttribute="productCriteria" action="products/search" method="post">
            <table class="table table-striped">
                <tr>
                    <td><form:label path="name">Nazwa produktu: </form:label></td>
                    <td><form:input path="name"></form:input></td>
                </tr>
                <tr>
                    <td><form:label path="priceFrom">Cena od: </form:label></td>
                    <td><form:input path="priceFrom"></form:input></td>
                </tr>
                <tr>
                    <td><form:label path="priceTo">Cena do: </form:label></td>
                    <td><form:input path="priceTo"></form:input></td>
                </tr>
                <tr>
                    <td><form:label path="quantityFrom">Ilosc od: </form:label></td>
                    <td><form:input path="quantityFrom"></form:input></td>
                </tr>
                <tr>
                    <td><form:label path="quantityTo">Ilosc do: </form:label></td>
                    <td><form:input path="quantityTo"></form:input></td>
                </tr>
                <tfoot>
                <tr>
                    <td colspan="2"><input class="btn btn-default" type="submit" value="Filtruj"></td>
                </tr>
                <tr>
                    <td colspan="2"><a class="btn btn-success" href="${pageContext.servletContext.contextPath}/products/add">Dodaj nowy produkt</a></td>
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
