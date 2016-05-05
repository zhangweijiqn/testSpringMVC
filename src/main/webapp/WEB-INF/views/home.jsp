<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhangweijian
  Date: 2015/8/12
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
  <title>Home</title>
</head>
<body>
<h1><c:out value="${message}"/></h1>
<h2>Again!</h2>
<%--统计访问量，结合getHitsCount.jsp文件，查看刷新时统计量是否增加--%>
<%
  Integer hitsCount =
          (Integer)application.getAttribute("hitCounter");
  if( hitsCount ==null || hitsCount == 0 ){
       /* 第一次访问 */
    out.println("Welcome to my website!");
    hitsCount = 1;
  }else{
       /* 返回访问值 */
    out.println("Welcome back to my website!");
    hitsCount += 1;
  }
  application.setAttribute("hitCounter", hitsCount);
%>
<p>Total number of visits: <%= hitsCount%></p>
</body>
</html>

