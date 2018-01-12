<%-- 
    Document   : login
    Created on : 4/07/2017, 12:38:40 PM
    Author     : ejmorales
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Plataforma Web</title>
    <link rel="icon" type="image/x-icon" href="img/CGC_32x32.png">
    <link type="text/css" rel="stylesheet" href="<c:url value="bootstrap/css/bootstrap.min.css" />"></link>
    <link type="text/css" rel="stylesheet" href="<c:url value="css/style.css" />"></link>
  </head>
  <body>  
        <div class="container">
            <div class="row vertical-offset-100">
                    <div class="col-md-4 col-md-offset-4">
                        <div class="panel panel-default">
                            <div class="panel-heading">                                
                                <div class="row-fluid user-row">
                                    <img src="<c:url value="img/logo_cgc.png"/>" class="img-responsive" alt="Conxole Admin"/>
                                </div>
                            </div>
                            <div class="panel-body">
                                <form accept-charset="UTF-8" role="form" class="form-signin" method="POST" action="j_security_check">
                                    <fieldset>
                                        <label class="panel-login">
                                            <div class="login_result"></div>
                                        </label>
                                         <% if (request.getParameter("error")  != null){
                                                out.println("<spam class='text-center' style='color:red'>Credenciales invalidos</spam>");
                                            }
                                         %>
                                        <input class="form-control" placeholder="Usuario" name="j_username" id="username" type="text">
                                        <input class="form-control" placeholder="Contraseña" name="j_password" id="password" type="password">
                                        <br></br>
                                        <input class="btn btn-lg btn-info btn-block" type="submit" id="login" value="Conectar »">
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
  </body>
</html>
