
<%--
  Created by IntelliJ IDEA.
  User: m1762
  Date: 2020/4/11
  Time: 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${list}" var="account">
    ${account.name}
</c:forEach>
</body>
</html>
