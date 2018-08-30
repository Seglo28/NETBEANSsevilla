<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento de Departamentos</title>
    </head>
    <body>
        <html:form action="/mantenimientoDepartamentos">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Codigo Departamento:</td>
                        <td><html:text property="codigoDepartamento" size="5" maxlength="2"></html:text>
                    </tr>
                     <tr>
                        <td>Nombre Departamento:</td>
                        <td><html:text property="nombreDepartamento" size="50" maxlength="25"></html:text>
                    </tr>
                    <tr colspan="2">
                    <bean:write name="ActionFormDepartamentos" property="error" filter="false"/>
                    </tr>
                </tbody>
            </table>
                    <html:submit property="action" value="Nuevo"/>
                    <html:submit property="action" value="Agregar"/>
                    <html:submit property="action" value="Consultar"/>
                    <html:submit property="action" value="Eliminar"/>
        </html:form>
        <html:link page="/index.jsp">Index</html:link>
    </body>
</html>
