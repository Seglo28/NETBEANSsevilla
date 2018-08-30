<%-- 
    Document   : confirmacionEliminarDepartamento
    Created on : 08-17-2018, 01:28:29 PM
    Author     : Admin124
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Departamento</title>
    </head>
     <body>
        <h1>Felicitaciones</h1>
        <h2>Eldepartamento ha sido eliminado satisfactoriamente.</h2>
        <p>Codigo departamento: <bean:write name="ActionFormDepartamentos" property="codigoDepartamento"/></p>
        <p>Nombre departamento: <bean:write name="ActionFormDepartamentos" property="nombreDepartamento"/></p>
        <html:link page="/mantenimientoDepartamentos.jsp">Regresar</html:link>/>
        <html:link page="/index.jsp">Index</html:link>/>
    </body>
</html>
