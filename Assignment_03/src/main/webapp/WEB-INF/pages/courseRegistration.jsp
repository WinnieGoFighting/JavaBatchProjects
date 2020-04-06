<%--
  Created by IntelliJ IDEA.
  User: Ni
  Date: 4/2/2020
  Time: 2:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<body>
<h1 id="banner">Welcome, ${stu.firstName.toUpperCase()}&nbsp${stu.lastName.toUpperCase()}</h1>
<form name="f" action="registerCourseProcess"
      method="POST">
    <table align="center">
        <tr>
            <td>Course Name:</td>
            <td><input type='text' name='courseName' /></td>
        </tr>
        <tr>
            <td>Department:</td>
            <td><input type='text' name='department' /></td>
        </tr>
        <tr>
            <td colspan="2">&nbsp;</td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="submit">&nbsp;<input name="reset" type="reset" value="reset"></td>
        </tr>
    </table>
</form>
</body>
</html>
