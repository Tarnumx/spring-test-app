<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Регистрация пользователя</title>
</head>
<body>
<form:form id="formRegister" modelAttribute="user" method="post" action="registeruser">
    <form:errors path="login"/>
    Логин
    <form:input path="login"/>
    Пароль
    <form:errors path="password"/>
    <form:textarea path="password"/>
    Подтверждение пароля
    <form:textarea path="password1"/>
    <button type="submit">Зарегистрироваться</button>
</form:form>
<a href="list">Отмена</a>

</body>
</html>
