<%-- 
    Document   : ConfirmacionAccesoUsuario
    Created on : 08-23-2018, 11:18:24 AM
    Author     : Admin126
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar departamento</title>
    </head>
    <body>
        <h1>Entrado</h1>
        <h2>¿Desea Salir?.</h2>
        <html:form action="/mantenimiento">
            <html:submit styleClass="btn btn-primary" property="accion" value="Salir" />
        </html:form>
        
    </body>
</html>
