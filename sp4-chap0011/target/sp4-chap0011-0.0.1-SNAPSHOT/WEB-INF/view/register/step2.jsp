<%--
  Created by IntelliJ IDEA.
  User: nekisse
  Date: 2017. 11. 22.
  Time: PM 4:01
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>

<%--        스프링 MVC가 제공하는 커스텀 태그 추가     --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
    <h2>회원 정보 입력</h2>
    <form:form action="step3" commandName="registerRequest">
    <p>
        <label>이메일: <br>
        <form:input path="email"/>
        </label>
    </p>
    <p>
        <label>이름:<br>
            <form:input path="name"/>
        </label>
    </p>
    <p>
        <label>비밀번호:<br>
            <form:password path="password"/>
        </label>
    </p>
    <p>
        <label>비밀번호 확인:<br>
            <form:password path="confirmPassword"/>
        </label>
    </p>
    <input type="submit" value="가입 완료">
</form:form>

</body>
</html>
