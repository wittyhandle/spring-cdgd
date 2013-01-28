<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Carl DeTorres Graphic Design</title>
        <tilesx:useAttribute name="addBootstrap" />
        <c:if test="${addBootstrap == 'true'}">
            <link href="<c:url value="/bootstrap/css/bootstrap.css" />" rel="stylesheet" type="text/css" />
            <link href="<c:url value="/bootstrap/css/bootstrap-responsive.css" />" rel="stylesheet" type="text/css" />
        </c:if>
        <link href="<c:url value="/css/styles.css" />" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <tiles:insertAttribute name="body" ignore="true" />
    </body>

</html>