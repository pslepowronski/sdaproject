<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="label" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ANIA
  Date: 2018-03-25
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet"/>
    <title>Add product</title>
</head>
<body>
<div id="contener">
    <div id="nav">
        <jsp:include page="nawigacja.jsp"/>
    </div>
    <div id="main">
        <form:form modelAttribute="newProduct" action="add" method="post">
            <form:input type="hidden" path="id"/><br>
        <table class="table table-hover">
            <thead>
            <tr>
                <td colspan="2">Dodaj nowy produkt</td>
            </tr>
            </thead>
            <tr>
                <td><from:label path="name">Nazwa produktu: </from:label></td>
                <td><from:input path="name"></from:input></td>
            </tr>
            <tr>
                <td><from:label path="price">Cena: </from:label></td>
                <td><form:input path="price"></form:input></td>
            </tr>
            <tr>
                <td><form:label path="quantity">Ilosc sztuk: </form:label></td>
                <td><form:input path="quantity"></form:input></td>
            </tr>
            <tr>
                <td colspan="2"><input class="btn btn-success" type="submit" name="dodajProdukt" value="Dodaj nowy produkt"></td>
            </tr>
        </table>
        </form:form>
    </div>

    </div>
    <div id="footer">
        &copy; 2018
    </div>
</div>

</body>
</html>
