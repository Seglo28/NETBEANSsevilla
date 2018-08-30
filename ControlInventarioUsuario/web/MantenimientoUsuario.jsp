<%-- 
    Document   : MantenimientoUsuario
    Created on : 08-23-2018, 10:57:35 AM
    Author     : Admin126
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" >
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </head>
    <body style="background-image: url('img/lago.jpg'); background-repeat: no-repeat; background-size: cover;">
        <div class="container" style="margin-top: 20px">
              <div class="row">
                                <div class="col-12 text-center">
                                    <div class="alert alert-success" role="alert">
                                        <h4 class="alert-heading">Bienvenido</h4>

                                        <p class="mb-0"> Porfavor, ingrese los datos de usuario para acceder a la aplicacion web</p>
                                    </div>
                                </div>  
                            </div> 
            <div class="row">
            <div class="col-12">
           <html:form action="/mantenimiento">
            
            <table border="0" class="table-striped">
                <tbody style="margin: 5px;">
                    <tr  style="padding: 10px;">
                        <td>Correo:</td>     
                    </tr>
                    <tr  style="padding: 10px;">
                        <td><html:text property="correo" size="120" maxlength="25" value=""></html:text>
                    </tr>
                     <tr  style="padding: 10px;">
                        <td>Contraseña:</td>
                        
                    </tr>
                     <tr  style="padding: 10px;">
                      
                         <td><html:text property="contra" size="120" maxlength="25" value=""></html:text>
                    </tr>
                <br>
                    <tr colspan="2">
                    <bean:write name="UsurioActionForm" property="error" filter="false"/>
                    </tr><br>
                </tbody>
                
                    
            </table><br>
            <html:submit styleClass="btn btn-primary" property="accion" value="Ingresar" />
           
              
        </html:form>
        <html:link page="/index.jsp">Index</html:link>
        </div>
        </div>
        </div>
    </body>
</html>