<%--
  Created by IntelliJ IDEA.
  User: Ni
  Date: 4/4/2020
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
<h1>${course.courseName} from ${course.department} department registration successful for ${stu.firstName.toUpperCase()}&nbsp${stu.lastName.toUpperCase()}</h1>
<a href="logout">log out</a>
</body>
</html>
