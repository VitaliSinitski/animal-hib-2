<%--
  Created by IntelliJ IDEA.
  User: Алиса
  Date: 11.02.2023
  Time: 3:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>
    <style>
        table {
            font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif, serif;
            font-size: 14px;
            border-collapse: collapse;
            text-align: center;
            margin: auto;
        }

        th, td:first-child {
            background: #AFCDE7;
            color: black;
            padding: 10px 20px;
        }

        th, td {
            border-style: solid;
            border-width: 0 1px 1px 0;
            border-color: black;
        }

        td {
            background: #D8E6F3;
        }
    </style>
</head>
<body>
<h2>Измените данные</h2>
<form method="post" action="${pageContext.request.contextPath}/controller">
    <input type="hidden" name="command" value="update">

    <input type="hidden" name="id" id="id" value="${requestScope.id}">

    <label for="name">Имя:
        <input type="text" name="name" id="name" placeholder="Введите новое имя" value="${requestScope.animalDto.name}">
    </label><br>
    <label for="weight">Вес:
        <input type="text" name="weight" id="weight" placeholder="Введите новый вес"
               value="${requestScope.animalDto.weight}">
    </label><br>
    <button type="submit">Подтвердить</button>
</form>

<form class="addForm" method="get" action="${pageContext.request.contextPath}/controller">
    <input type="hidden" name="command" value="read">
    <button type="submit">Общий список</button>
</form>

<form class="addForm" action="${pageContext.request.contextPath}/">
    <input type="hidden">
    <button type="submit">Home</button>
</form>
<c:if test="${not empty requestScope.errors}">
    <div style="color: red">
        <c:forEach var="error" items="${requestScope.errors}">
            <span>${error.message}</span><br>
        </c:forEach>
    </div>
</c:if>
</body>
</html>
