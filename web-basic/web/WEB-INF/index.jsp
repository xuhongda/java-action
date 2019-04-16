<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/16
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%
    // 在四个域中存放数据，进行获取
    //pageContext.setAttribute("key", "pageContext-value");
    Object hello = request.getAttribute("hello");
    String contextPath = request.getContextPath();
    pageContext.setAttribute("contextPath", contextPath);
    System.out.println(hello);
    session.setAttribute("key", "session-value");
    application.setAttribute("key", "application-value");
%>
${hello}
${requestScope.hello}
${pageScope.contextPath}
</body>
</html>
