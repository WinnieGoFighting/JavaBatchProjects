<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Book List</title>
    </head>
    <body>
        <table boarder = "1" width = "500" align = "center">
            <tr>
                <th>Book_Id</th>
                <th>Book_Title</th>
                <th>Book_Author</th>
                <th>PublishedDate</th>
            </tr>
        <c:forEach items="${bookList}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.publishedDateFormat}</td>
            </tr>
        </c:forEach>
        </table>
    </body>
</html>