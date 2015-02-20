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
    <li><a href="<c:url value="/area"/>">Area</a></li>
    <li class="active">Novo</li>
</ol>

<div class="page-header">
    <h1>Areas <small>Cadastro das areas de gastos</small></h1>
    <a href="#" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-file"></span> Novo</a>
    <a href="#" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-floppy-disk"></span> Salvar</a>
</div>

<%@ include file="/footer.jsp" %> 
