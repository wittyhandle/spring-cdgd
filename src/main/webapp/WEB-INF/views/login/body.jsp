<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="login-container">
    <div class="login-fields">
        <div class="login-banner">
            <img src="<c:url value="/images/logo.png" />" style="width: 74px;height: 37px" alt="CDGD Login" />
        </div>
        <form class="form-horizontal login" action="<c:url value="j_spring_security_check" />" method="post">
            <div class="control-group">
                <label class="control-label" for="inputUsername">Username</label>
                <div class="controls">
                    <input type="text" id="inputUsername" name="j_username" placeholder="Username">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="inputPassword">Password</label>
                <div class="controls">
                    <input type="password" id="inputPassword" name="j_password" placeholder="Password">
                </div>
            </div>
            <div class="control-group">
                <div class="controls">
                    <button type="submit" class="btn">Sign in</button>
                </div>
            </div>
        </form>
    </div>

    <c:if test="${param.error == 'true'}">
        <div class="alert alert-error container">
            Incorrect login credentials.
        </div>
    </c:if>

</div>