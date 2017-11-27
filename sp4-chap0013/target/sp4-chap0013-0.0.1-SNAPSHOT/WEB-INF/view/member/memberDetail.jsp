<%--
  Created by IntelliJ IDEA.
  User: nekisse
  Date: 2017. 11. 27.
  Time: PM 5:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>회원 정보</title>
</head>
<body>
    <p>아이디: ${member.id}</p>
    <p>이메일: ${member.email}</p>
    <p>이름: ${member.name}</p>
    <p>가입일: <fmt:formatDate value="${member.registerDate}"
                            pattern="yyyy-MM-dd HH:mm"/> </p>
</body>
</html>
