
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
                                    <table>
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Usuario</th>
                                        <th>Correo</th>
                                        <th>Contraseña</th>
                                        <th>Cargo</th>
                                        <th>Paginas</th>
                                        <th>Genero</th>                                
                                    </tr>
                                </thead>
                                <c:forEach items="${lista}" var="ver">
                                    <tr>
                                        <td>${ver.idUsuario}</td>
                                        <td>${ver.usuario}</td>
                                        <td>${ver.contra}</td>
                                        <td>${ver.cargo}</td>
                                    </tr>
                                </c:forEach>
                            </table>
    </body>
</html>
