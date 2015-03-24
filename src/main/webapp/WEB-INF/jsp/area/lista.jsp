<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header.jsp" %> 

<style>
    .btn{
        font-family: Arial;
    }
</style>
<ol class="breadcrumb">
    <li><a href="<c:url context="/finances" value="/"/>">Home</a></li>
    <li class="active">Áreas</li>
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
                <th>Descrição</th>
                <th style="width:16px;">-</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${areaList}" var="area">
            <tr>
                <td>${area.id}</td>
                <td>${area.descricao}</td>
                <td>
                    <a href="<c:url context="/finances" value="/area/${area.id}"/>"><span class="glyphicon glyphicon-pencil"></a>
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table> 
</div>

<%@ include file="/footer.jsp" %> 
