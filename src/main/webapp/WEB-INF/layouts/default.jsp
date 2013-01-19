<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Carl DeTorres Graphic Design</title>

        <link href="<c:url value="/css/styles.css" context="/" />" rel="stylesheet" type="text/css" />
    </head>

    <body>

        <section>
            hello default layout. with resources?
        </section>
        <tiles:insertAttribute name="body" ignore="true" />

    </body>

</html>