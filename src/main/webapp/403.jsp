<%-- 
    Document   : 403
    Created on : 11/07/2017, 10:51:02 AM
    Author     : ejmorales
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Login failed</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/bootstrap/css/bootstrap.min.css" />"></link>
  </head>
  <body style="background-color: #ccc">
      <div class="container-fluid">
          <div style="background-color: #204d74;height:10px;"></div>
          <div class="text-center" style="margin:10% auto;">
              <h1>403</h1>
              <h3>Acceso Denegado</h3>
              <p>Su usuario es valido, pero no tiene los permisos suficientes para
                 visualizar esta pagina</p>
          </div>
      </div>  
  </body>
</html>