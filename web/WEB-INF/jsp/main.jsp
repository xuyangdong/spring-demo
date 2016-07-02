<%--
  Created by IntelliJ IDEA.
  User: xyd
  Date: 16/7/2
  Time: 下午11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>myDemo</title>
</head>
<body>
  <p>用户名：${user.userName}</p>
  <p>用户上次登录的时间:${user.lastVisit}</p>
  <p>用户上次登录的IP:${user.lastIp}</p>
</body>
</html>
