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
    <li class="active">Cartões</li>
</ol>

<div class="page-header">
    <h1>Cartões <small>Cadastro de cartões de crédito</small></h1>
    <a href="cartao/novo" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-file"></span> Novo</a>
</div>

<div class="bs-component">
    <table class="table table-striped table-hover ">
        <thead>
            <tr>
                <th>#</th>
                <th>Descrição</th>
                <th>Bandeira</th>
                <th>Vencimento</th>
                <th style="width:16px;">-</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${cartaoList}" var="cartao">
            <tr>
                <td>${cartao.id}</td>
                <td>${cartao.descricao}</td>
                <td>${cartao.bandeira}</td>
                <td>${cartao.dia}</td>
                <td>
                    <a href="<c:url context="/finances" value="/cartao/${cartao.id}"/>"><span class="glyphicon glyphicon-pencil"></a>
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table> 
</div>

<%@ include file="/footer.jsp" %> 
