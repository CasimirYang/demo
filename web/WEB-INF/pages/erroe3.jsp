<%--
  Created by IntelliJ IDEA.
  User: yjh
  Date: 16/10/15
  Time: 下午11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title 500 error3 page</title>
</head>
<body>
<h1>Title 500 error page..</h1>
<h1>${greeting}</h1>
<h2>${SessionScope.greeting}</h2>
<h2>${RequestScope.greeting}</h2>
<h3>${Session.greeting}</h3>
<h3><%request.getSession().getAttribute("greeting");%></h3>
</body>
</html>
