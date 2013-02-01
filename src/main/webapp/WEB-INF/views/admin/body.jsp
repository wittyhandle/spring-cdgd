<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
    <div class="span12">
        <div class="leaderboard">
            <span class="pull-left">
                <h1>Works</h1>
            </span>
            <a href="<c:url value="/admin/project/new" />" class="btn btn-success btn-mini pull-right new-asset"><i class="icon-white icon-plus"></i> New Work</a>
        </div>
        <div class="row-fluid">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Copy</th>
                        <th>Category</th>
                        <th>Client</th>
                    </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
        <hr />
    </div>
</div>