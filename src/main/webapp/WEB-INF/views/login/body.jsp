<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="login-container">

    <div class="login-banner">
        <img src="<c:url value="/images/logo.png" context="/" />" style="width: 74px;height: 37px" alt="CDGD Login" />
    </div>
    <form class="form-horizontal login">
        <div class="control-group">
            <label class="control-label" for="inputUsername">Username</label>
            <div class="controls">
                <input type="text" id="inputUsername" placeholder="Username">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="inputPassword">Password</label>
            <div class="controls">
                <input type="password" id="inputPassword" placeholder="Password">
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <button type="submit" class="btn">Sign in</button>
            </div>
        </div>
    </form>
</div>