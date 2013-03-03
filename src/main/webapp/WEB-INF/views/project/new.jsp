<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container cdgd-admin">
    <div class="span12">
        <div class="leaderboard">
            <span class="pull-left">
                <h1>New Work</h1>
            </span>
        </div>
        <div class="row-fluid">
            <form:form class="form-horizontal span5" commandName="project" action="new" method="post">
                <div class="control-group">
                    <label class="control-label" for="name">Name</label>
                    <div class="controls pull-right">

                        <spring:bind path="project.name">
                            <form:input class="input-xlarge" type="text" path="name" id="name" placeholder="Name"/>
                            <c:if test="${status.error}">
                                <c:forEach items="${status.errorMessages}" var="error">
                                    <div class="alert alert-error">
                                        <a class="close" data-dismiss="alert">×</a>
                                        ${error}
                                    </div>
                                </c:forEach>
                            </c:if>
                        </spring:bind>
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label" for="description">Description</label>
                    <div class="controls pull-right">

                        <spring:bind path="project.description">
                            <form:textarea class="input-xlarge" path="description" id="description" rows="3"/>
                            <c:if test="${status.error}">
                                <c:forEach items="${status.errorMessages}" var="error">
                                    <div class="alert alert-error">
                                        <a class="close" data-dismiss="alert">×</a>
                                        ${error}
                                    </div>
                                </c:forEach>
                            </c:if>
                        </spring:bind>
                    </div>
                </div>
                <div class="form-actions">
                    <button type="submit" class="btn btn-primary">Save</button>
                    <button class="btn">Cancel</button>
                </div>
            </form:form>
        </div>
        <hr />
    </div>
</div>