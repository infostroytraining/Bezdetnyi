<%--
  Created by IntelliJ IDEA.
  User: Artem
  Date: 11.12.2015
  Time: 1:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <link rel="stylesheet" href="css/register.css" type="text/css">
    <title></title>
  </head>
  <body>
    <form id="register-form" action="/register" method="post" enctype="multipart/form-data">
      <div id="input-text-box">
        <input type="text" name="firstName" placeholder="Имя" value="${user.firstName}">
        <input type="text" name="lastName" placeholder="Фамилия" value="${user.lastName}">
        <input type="text" name="email" placeholder="Email" value="${user.email}">
        <input type="password" name="password" placeholder="Пароль" value="${user.password}">
        <input type="password" name="passwordConfirmation" placeholder="Подтверждение пароля">
      </div>
      <div id="photo-box">
        <div id="input-photo-box">
          <input type="file" name="photo">
        </div>
      </div>
      <input type="submit">
    </form>
  </body>
</html>