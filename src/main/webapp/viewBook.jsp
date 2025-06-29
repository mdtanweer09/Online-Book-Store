<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Store - View Books</title>
    <style>
        body {
            font-family: Arial;
            background-color: #f9f9f9;
        }
        table {
            width: 80%;
            margin: 30px auto;
            border-collapse: collapse;
        }
        th, td {
            padding: 12px;
            border: 1px solid #ddd;
        }
        th {
            background-color: #eee;
        }
        .msg {
            text-align: center;
            color: green;
            font-weight: bold;
        }
    </style>
</head>
<body>

<div align="center">
    <h1>Book Management</h1>
    <h2>
        <a href="index.jsp">Add New Book</a>
    </h2>

    <c:if test="${not empty msg}">
        <div class="msg">${msg}</div>
    </c:if>

    <table>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
        <c:forEach var="book" items="${listBook}">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.price}</td>
                <td>
                    <a href="book?action=edit&id=${book.id}">Edit</a> |
                    <a href="book?action=delete&id=${book.id}" onclick="return confirm('Are you sure?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
