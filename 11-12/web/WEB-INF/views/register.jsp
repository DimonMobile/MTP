<%@ page import="db.UserDao" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: dmitry
  Date: 5/3/19
  Time: 1:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<jsp:include page="WEB-INF/views/header.jsp"/>
<%
    String name = request.getParameter("name");
    String password = request.getParameter("password");
    String errorString = null;
    if (name != null && password != null) {
        UserDao userDao = new UserDao();
        if (userDao.isExists(name)) {
            errorString = "This account already exists";
        } else {
            userDao.addUser(name, password);
        }
    }

%>
    <% if (errorString != null) {%>
    <font color="red"><%=errorString%></font>
    <%}%>
    <form method="POST" action="register">
        <label>Регистрация нового пользователя</label><br>
        <label>Введите имя: </label><input name="name" type="text"/><br>
        <label>Введите пароль: </label><input name="password" type="password"/><br>
        <input type="submit" value="Зарегистрировать">
    </form>
<jsp:include page="WEB-INF/views/footer.jsp"/>
</body>
</html>
