<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>book search</title>
  </head>
  <body>
    <p>Search the book by title: </p>
    <form action="${pageContext.request.contextPath}/bookServlet" method = "post">
      <input type="text" name = "title"> <br/><br/>
      <input type="submit" value = "search"><br></br>
      <div><%=request.getAttribute("errorMsg")==null?"":request.getAttribute("errorMsg")%></div>
    </form>
  </body>
</html>