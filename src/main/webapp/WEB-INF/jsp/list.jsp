<%--
  Created by IntelliJ IDEA.
  User: Алиса
  Date: 11.02.2023
  Time: 2:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        li {
            display: inline;
            list-style-type: none;
            list-style-position: inside;
        }

        ul {
            display: inline;
            list-style-type: none;
        }
        nav {
            font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif, serif;
            text-align: center;
        }
        form {
            font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif, serif;
            text-align: center;
        }
        table {
            font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif, serif;
            font-size: 14px;
            border-collapse: collapse;
            text-align: center;
            margin: auto;
        }
        caption {
            background: #AFCDE7;
            color: black;
            padding: 10px 20px;
            font-size: 16px;
            border-style: solid;
            border-width: 0.25ex;
            border-color: black;
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
        .emptyList {
            font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif, serif;
            font-size: 14px;
            color: red;
        }
    </style>
</head>
    <body>
<%--    <%@include file="header.jsp"%>--%>
    <c:choose>
        <c:when test="${requestScope.animalList.size() > 0}">
            <table>
                <caption>Список</caption>
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">Weight</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="animal" items="${requestScope.animalList}">
                    <tr>
                        <th scope="row">${animal.id}</th>
                        <td>${animal.name}</td>
                        <td>${animal.weight}</td>
                        <td>
                            <form method="get" action="${pageContext.request.contextPath}/controller">
                                <input type="hidden" name="command" value="update">
                                <input type="hidden" name="id" value=${animal.id}>
                                <button type="submit">Edit</button>
                            </form>
                        </td>
                        <td>
                            <form method="post" action="${pageContext.request.contextPath}/controller">
                                <input type="hidden" name="command" value="delete">
                                <input type="hidden" name="id" value=${animal.id}>
                                <button type="submit">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="5">
                        <form class="addForm" action="${pageContext.request.contextPath}/">
                            <input type="hidden">
                            <button type="submit">На главную</button>
                        </form>
                    </td>
                </tr>
                <tr>
                    <td colspan="5">
                        <form class="addForm" method="get" action="${pageContext.request.contextPath}/controller">
                            <input type="hidden" name="command" value="create">
                            <button class="red" type="submit">Добавить</button>
                        </form>
                    </td>
                </tr>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <div class="emptyList">
                <h2>Список пуст!</h2>


                <form class="addForm" action="${pageContext.request.contextPath}/">
                    <input type="hidden">
                    <button type="submit">На главную</button>
                </form>
                <form class="addForm" method="get" action="${pageContext.request.contextPath}/controller">
                    <input type="hidden" name="command" value="create">
                    <button type="submit">Добавить</button>
                </form>
            </div>
        </c:otherwise>
    </c:choose>

<nav aria-label="Navigation for animals">
    <ul>
        <c:if test="${requestScope.currentPage != 1}">
            <li>
                <form method="get" action="${pageContext.request.contextPath}/controller">
                    <input type="hidden" name="command" value="read">
                    <input type="hidden" name="recordsPerPage" value="${recordsPerPage}">
                    <input type="hidden" name="currentPage" value="${currentPage-1}">
                    <button type="submit">Previous</button>
                </form>
<%--                <a class="page-link" href="ReadCountries?recordsPerPage=${recordsPerPage}&currentPage=${currentPage-1}">Previous</a>--%>
            </li>
        </c:if>

        <c:forEach begin="1" end="${numberOfPages}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    <li>
                        <a>
                            ${i} <span>(current)</span>
                    </a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li>
                        <form method="get" action="${pageContext.request.contextPath}/controller">
                            <input type="hidden" name="command" value="read">
                            <input type="hidden" name="recordsPerPage" value="${recordsPerPage}">
                            <input type="hidden" name="currentPage" value="${i}">
                            <button type="submit">${i}</button>
                        </form>
<%--                        <a href="ReadCountries?recordsPerPage=${recordsPerPage}&currentPage=${i}">${i}</a>--%>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${currentPage lt numberOfPages}">
            <li>
                <form method="get" action="${pageContext.request.contextPath}/controller">
                    <input type="hidden" name="command" value="read">
                    <input type="hidden" name="recordsPerPage" value="${recordsPerPage}">
                    <input type="hidden" name="currentPage" value="${currentPage+1}">
                    <button type="submit">Next</button>
                </form>

<%--                <a href="ReadCountries?recordsPerPage=${recordsPerPage}&currentPage=${currentPage+1}">Next</a>--%>
            </li>
        </c:if>
    </ul>
</nav>

<form method="get" action="${pageContext.request.contextPath}/controller">
    <input type="hidden" name="command" value="read">
    <input type="hidden" name="currentPage" value="1">

    <div>
        <label for="records">Select records per page:</label>
        <select id="records" name="recordsPerPage">
            <option value="5">5</option>
            <option value="10" selected>10</option>
            <option value="15">15</option>
        </select>

    </div>
    <button type="submit">Submit</button>
</form>
    </body>
</html>
