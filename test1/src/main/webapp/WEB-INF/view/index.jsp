<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: nekisse
  Date: 30/12/2018
  Time: 4:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>환율계산</title>
</head>
<body>
<h1>환율계산</h1>
<h3>송금국가: <form:select path="remittanceCountry"/> </h3>
<h3>환율: <input type="text" value="<%--${}--%>"/> </h3>
</body>
</html>
