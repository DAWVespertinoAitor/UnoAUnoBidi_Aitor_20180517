<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contexto" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado</title>
        <link rel="stylesheet" type="text/css" href="${contexto}/CSS/estilos.css" />
    </head>
    <body>

        <div class="rellenarForm">
            <h2>Listado de Países</h2>




            <ul style="margin: 0 auto;">
                <c:forEach var="item" items="${listadoPaises}">

                    <hr style="width: 25%;">
                    <li>
                        <b>Nombre pais: | </b>
                        <c:out value="${item.nombrePais}"/>
                        <ul>
                            <li>
                                <b>Presidente | </b>
                                ${item.presidente.nombrePresidente}
                            </li>
                            
                        </ul>
                    </li>

                </c:forEach>
            </ul>
            <br />
            <p><a href="${contexto}/" class="enlace">Men&uacute; inicial</a></p>
        </div>


    </body>
</html>