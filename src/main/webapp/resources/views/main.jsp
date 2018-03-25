<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ANIA
  Date: 2018-03-19
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet"/>
</head>
<style>
    #main2{
        text-align-all: center;
    }
    #nav{
        text-align-all: justify;
        text
    }
</style>
<body>
<div id="contener">
    <div id="nav">
        <h2>FU*KTURA - jasna strona ksiegowosci</h2>
    </div>
    <div id="main">
        <table>
        <thead>
        <tr>
            <td colspan="2">Zaloguj, aby przejsc dalej</td>
        </tr>
        </thead>
        <tr>
            <td>Uzytkownik</td>
            <td><input type="text" name="userid" value="login"></td>
        </tr>
        <tr>
            <td>Haslo</td>
            <td><input type="password" name="passwd" value="haslo"></td>
        </tr>
        <tr>
            <td colspan="2"><input class="btn btn-success" type="submit" value="Zaloguj"></td>
        </tr>
        </table>
    </div>

    <div id="main2">

        <h3>BLACK FRIDAY</h3><br/>
        <h4>Pelna wersja oprogramowania Fu*ktura</h4><br/>
        <h4>-30%</h4>
        <button class="btn btn-danger btn-xl">KUP TERAZ</button>
    </div>

    <div id="footer">
        &copy; 2018
    </div>
</div>
</body>
</html>
