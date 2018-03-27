<%--
  Created by IntelliJ IDEA.
  User: Mihscko
  Date: 22.03.2018
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Klient</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet"/>
</head>
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
                <th>Imię</th>
                <th>Nazwisko</th>
                <th>Nazwa firmy</th>
                <th>NIP</th>
                <th>Ulica</th>
                <th>Numer</th>
                <th>Miasto</th>
                <th>Poczta</th>
                <th>Szczegóły</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${buyers}" var="buyer">
                <tr>
                    <td>${buyer.firstName}</td>
                    <td>${buyer.lastName}</td>
                    <td>${buyer.companyName}</td>
                    <td>${buyer.taxNumber}</td>
                    <td>${buyer.street}</td>
                    <td>${buyer.streetNumber}</td>
                    <td>${buyer.postcode}</td>
                    <td>${buyer.city}</td>
                    <td><a href="${pageContext.servletContext.contextPath}/buyer/${buyer.id}">Przejdz</a></td>
                    <td>
                        <form action="buyer/delete" method="post">
                            <input type="submit" name="deleteBuyer" value="Usuń"/>
                            <input type="hidden" name="buyerId" value="${buyer.id}"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
    <div id="main2">
        <form:form modelAttribute="criteria"
                   action="buyers/search" method="post">
            <table class="table table-striped">
                <tr>
                    <td><form:label path="firstName">Imię: </form:label></td>
                    <td><form:input path="firstName"></form:input></td>
                </tr>
                <tr>
                    <td><form:label path="lastName">Nazwisko: </form:label></td>
                    <td><form:input path="lastName"></form:input><br/></td>
                </tr>
                <tr>
                    <td><form:label path="companyName">Nazwa firmy: </form:label></td>
                    <td><form:input path="companyName"></form:input></td>
                </tr>
                <tr>
                    <td><form:label path="taxNumber">NIP: </form:label></td>
                    <td><form:input path="taxNumber"></form:input></td>
                </tr>
                <tr>
                    <td><form:label path="city">Miasto: </form:label></td>
                    <td><form:input path="city"></form:input></td>
                </tr>
                <tfoot>

                <tr>
                    <td colspan="2"><input class="btn btn-default" type="submit" value="Filtruj"></td>
                </tr>
                <tr>
                    <td colspan="2"><a class="btn btn-success" href="${pageContext.servletContext.contextPath}/buyer/add">Dodaj nowego klienta</a></td>
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
