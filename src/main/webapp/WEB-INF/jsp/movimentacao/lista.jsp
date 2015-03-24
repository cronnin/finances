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
    <li class="active">Movimentações</li>
</ol>

<div class="page-header">
    <h1>Movimentações <small>Cadastro de gastos</small></h1>
    <a href="<c:url context="/finances" value="/movimentacao/novo"/>" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-file"></span> Novo</a>
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
            <c:forEach items="${movimentacaoList}" var="movimentacao">
            <tr>
                <td>${movimentacao.dataFormatada}</td>
                <td>${movimentacao.descricao}</td>
                <td>${movimentacao.tipoEntrada}</td>
                <td>${movimentacao.valor}</td>
                <td>${movimentacao.quitado}</td>
                <td>
                    <a href="<c:url value="/movimentacao/${movimentacao.id}"/>"><span class="glyphicon glyphicon-pencil"></a>
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table> 
</div>

<%@ include file="/footer.jsp" %> 
