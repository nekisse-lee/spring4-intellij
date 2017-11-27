<%--
  Created by IntelliJ IDEA.
  User: nekisse
  Date: 2017. 11. 26.
  Time: PM 4:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title><spring:message code="change.pwd.title"/> </title>
</head>
<body>
<form:form>
    <p>
        <label><spring:message code="currentPassword"/>
            <form:password path="currentPassword"/>
            <form:errors path="currentPassword"/>
        </label>
    </p>
    <p>
        <label><spring:message code="newPassword"/>
            <form:password path="newPassword"/>
            <form:errors path="newPassword"/>
        </label>
    </p>
    <input type="submit" value="<spring:message code="change.btn"/> ">
</form:form>

</body>
</html>
