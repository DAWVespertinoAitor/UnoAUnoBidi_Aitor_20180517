<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contexto" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar</title>
        <link rel="stylesheet" type="text/css" href="${contexto}/CSS/estilos.css" />
    </head>
    <body>

        <div class="columnasCentradas">
            <h2>Actualizaci&oacute;n de datos presidente</h2>
            <form method="post" action="conclusion?op=updatePresi">
                <table style="margin: 0 auto;">
                    <tr>
                        <th colspan="2">Datos del Presidente</th>
                    </tr>
                    <tr>
                        <td>Código</td>
                        <td><input type="text" name="id" value="${presidente.id}" readonly="readonly" /></td>
                    </tr>
                    <tr>
                        <td>Nombre del Presidente</td>
                        <td><input type="text" name="nombrePresidente" value="${presidente.nombrePresidente}" /></td>
                    </tr>
                    <tr>
                        <th colspan="2">Datos del país</th>
                    </tr>
                    <tr>
                        <td>Nombre del pais </td>
                        <td><input type="text" name="nombrePais" value="${presidente.pais.nombrePais}"/></td>
                    </tr>
                </table><br>
                <input type="submit" name="enviar" value="Enviar" class="boton"/><br><br>
            </form>
        </div>


    </body>
</html>