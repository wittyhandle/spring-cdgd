<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="navbar navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container-fluid">
			<div class="nav-collapse">
				<ul class="nav">
					<li class="active"><a href="#">Works</a></li>
					<li><a href="#touts">Touts</a></li>
				</ul>
				<p class="navbar-text pull-right">${username}, <a href="<c:url value="/j_spring_security_logout" context="/carl" />">logout.</a></p>
			</div>
		</div>
	</div>
</div>