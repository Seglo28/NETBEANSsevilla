<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:form action="/aqui" method="post">
    <h3>ACTUALIZAR</h3>
        Id
    <html:text property="idUsuario" value=""></html:text>
    Usuario
    <html:text property="usuario" value=""></html:text>
    Correo
    <html:text property="correo" value=""></html:text>
    Contraseña
    <html:text property="contra" value=""></html:text>
    Cargo
    <html:text property="cargo" value=""></html:text>
    <html:submit value="Actualizar" property="action"/>
    <html:submit value="Eliminar" property="action"/>
</html:form>