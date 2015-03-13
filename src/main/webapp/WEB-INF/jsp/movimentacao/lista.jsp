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
    <li class="active">Movimentações</li>
</ol>

<div class="page-header">
    <h1>Movimentações <small>Cadastro de gastos</small></h1>
    <a href="movimentacao/novo" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-file"></span> Novo</a>
</div>

<div class="bs-component">
    <table class="table table-striped table-hover ">
        <thead>
            <tr>
                <th>#</th>
                <th>Descrição</th>
                <th>Tipo</th>
                <th>Valor</th>
                <th>Quitado</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${areaList}" var="area">
            <tr>
                <td>${movimentacao.data}</td>
                <td>${movimentacao.descricao}</td>
                <td>${movimentacao.tipoEntrada}</td>
                <td>${movimentacao.valor}</td>
                <td>${movimentacao.quitado}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table> 
</div>

<%@ include file="/footer.jsp" %> 
