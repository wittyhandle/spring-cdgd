<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Carl DeTorres Graphic Design - Administration</title>

        <link href="<c:url value="/bootstrap/css/bootstrap.css" context="/" />" rel="stylesheet" type="text/css" />
        <link href="<c:url value="/bootstrap/css/bootstrap-layout.css" context="/" />" rel="stylesheet" type="text/css" />
        <link href="<c:url value="/css/admin.css" context="/" />" rel="stylesheet" type="text/css" />
    </head>

    <body>

        <tiles:insertAttribute name="body" ignore="true" />

    </body>

</html>