<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:form action="/aqui" method="post">
    <h3>REGISTRO</h3>
    Usuario
    <html:text property="usuario" value=""></html:text>
    Correo
    <html:text property="correo" value=""></html:text>
    Contraseña
    <html:text property="contra" value=""></html:text>
    Cargo
    <html:text property="cargo" value=""></html:text>
    <html:submit value="submit"/>
</html:form>