<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">
    <div class="span12">
        <div class="leaderboard">
            <span class="pull-left">
                <h1>New Work</h1>
            </span>
        </div>
        <div class="row-fluid">
            <form:form class="form-horizontal span5" commandName="project" action="new">
                <div class="control-group">
                    <label class="control-label" for="name">Name</label>
                    <div class="controls">
                        <form:input class="input-xlarge" type="text" path="name" id="name" placeholder="Name"/>
                        <form:errors path="name" />
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="description">Description</label>
                    <div class="controls">
                        <form:textarea class="input-xlarge" path="description" id="description" rows="3"/>
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