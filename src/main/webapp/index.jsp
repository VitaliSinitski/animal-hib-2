<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
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
    <title>JSP - Hello World</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <td>
            <form class="addForm" method="get" action="${pageContext.request.contextPath}/controller">
                <input type="hidden" name="command" value="read">
                <button type="submit">Список</button>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form class="addForm" method="get" action="${pageContext.request.contextPath}/controller">
                <input type="hidden" name="command" value="create">
                <button type="submit">Добавить</button>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form class="addForm" method="get" action="${pageContext.request.contextPath}/controller">
                <input type="hidden" name="command" value="login">
                <button type="submit">Войти</button>
            </form>
        </td>
    </tr>
    </thead>
</table>
</body>
</html>