<%--
  Created by IntelliJ IDEA.
  User: dmitry
  Date: 5/3/19
  Time: 1:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (session.getAttribute("name") == null)
        response.sendRedirect("login");
%>

<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <jsp:include page="WEB-INF/views/header.jsp"/>
    <h1>Welcome, <%=session.getAttribute("name")%></h1>
    <jsp:include page="WEB-INF/views/footer.jsp"/>
</body>
</html>
