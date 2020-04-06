<%--
  Created by IntelliJ IDEA.
  User: Ni
  Date: 4/2/2020
  Time: 1:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<body>
<h1 id="banner">Student Login</h1>
<form name="f" action="loginProcess"
      method="POST">
    <table align="center">
        <tr>
            <td>Email:</td>
            <td><input type='text' name='email' /></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password'></td>
        </tr>
        <tr>
            <td colspan="2">&nbsp;</td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="submit">&nbsp;<input name="reset" type="reset" value="reset"></td>
        </tr>
        <tr>
            <td colspan='2'><a href="register">Haven't registered?</a></td>
        </tr>
        <tr>
            <td colspan='2'><span style="color:red">${message}</span></td>
        </tr>
    </table>
</form>
</body>
</html>
