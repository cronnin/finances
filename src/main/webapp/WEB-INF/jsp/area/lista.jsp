<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header.jsp" %> 

<style>
    .btn{
        font-family: Arial;
    }
</style>
<ol class="breadcrumb">
    <li><a href="./">Home</a></li>
    <li class="active">Area</li>
</ol>

<div class="page-header">
    <h1>Areas <small>Cadastro das areas de gastos</small></h1>
    <a href="area/novo" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-file"></span> Novo</a>
</div>

<div class="bs-component">
    <table class="table table-striped table-hover ">
        <thead>
            <tr>
                <th>#</th>
                <th>Column heading</th>
                <th>Column heading</th>
                <th>Column heading</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>1</td>
                <td>Column content</td>
                <td>Column content</td>
                <td>Column content</td>
            </tr>
        </tbody>
    </table> 
</div>

<%@ include file="/footer.jsp" %> 
