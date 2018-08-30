   <%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </head>
    <body style="background-image: url('img/lago.jpg'); background-repeat: no-repeat; background-size: cover;">
        <div class="container" style="margin-top: 20px">

            <html:form action="/ActionLogin">
                <bean:write name="ActionFormLogin" property="error" filter="false" />
                <div class="card text-black bg-light mb3">
                    <div class="card-header">
                        Inicio de Sesion
                    </div>
                    <div class="card-body">
         
                        <table border="0">

                            <tbody style="margin: 5px;">
                                <tr>
                                    <td>Usuario</td>
                                    <td style="padding: 10px;"><html:text property="username" size="25" maxlength="50" /></td>
                                </tr>
                                <tr>
                                    <td>Contraseña</td>
                                    <td style="padding: 10px;"><html:text property="password" size="25" maxlength="50" /></td>
                                </tr>
                            </tbody>
                        </table>

                    </div>
                    <div class="card-footer">
                        <html:submit property="accion" value="Loguear" />
                    </div>
                </div>
            </html:form>
        </div>
    </body>
</html>
