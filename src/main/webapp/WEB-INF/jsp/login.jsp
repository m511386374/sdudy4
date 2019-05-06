<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/5/6
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form METHOD="get" action="/user/login">
    用户名：<input type="text" name="name"/> <br/>
    密码  ：<input type="text" name= "pwd"/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
