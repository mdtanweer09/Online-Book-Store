<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Store - Add/Edit Book</title>
    <style>
        body {
            font-family: Arial;
            background-color: #f0f0f0;
        }
        table {
            background-color: #fff;
            border: 1px solid #ccc;
            margin-top: 30px;
            padding: 20px;
        }
        .msg {
            color: green;
            font-weight: bold;
            text-align: center;
        }
    </style>
</head>
<body>

<div align="center">
    <h1>Book Management</h1>
    <h2>
        <a href="book">List All Books</a>
    </h2>

    <c:if test="${not empty msg}">
        <div class="msg">${msg}</div>
    </c:if>

    <form action="book" method="post">
        <table cellpadding="10">
            <caption>
                <h2>
                    <c:choose>
                        <c:when test="${not empty book}">
                            Edit Book
                        </c:when>
                        <c:otherwise>
                            Add New Book
                        </c:otherwise>
                    </c:choose>
                </h2>
            </caption>

            <c:if test="${not empty book}">
                <input type="hidden" name="id" value="${book.id}" />
            </c:if>

            <tr>
                <th>Title:</th>
                <td><input type="text" name="title" value="${book.title}" required /></td>
            </tr>
            <tr>
                <th>Author:</th>
                <td><input type="text" name="author" value="${book.author}" required /></td>
            </tr>
            <tr>
                <th>Price:</th>
                <td><input type="number" step="0.01" name="price" value="${book.price}" required /></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
