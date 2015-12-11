<%--
  Created by IntelliJ IDEA.
  User: Artem
  Date: 11.12.2015
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="css/register.css">
    <title></title>
  </head>
  <body>
  <table>
    <tr>
      <td>Id</td>
      <td>Имя</td>
      <td>Фамилия</td>
      <td>Email</td>
    </tr>
    <c:forEach var="user" items="${users}">
      <tr>
        <td>${user.id}</td>
        <td>${user.firstName}</td>
        <td>${user.lastName}</td>
        <td>${user.email}</td>
      </tr>
    </c:forEach>
  </table>
  </body>
</html>
