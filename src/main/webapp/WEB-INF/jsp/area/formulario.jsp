<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header.jsp" %>
<style>
    .btn{
        font-family: Arial;
    }
</style>
<ol class="breadcrumb">
    <li><a href="/Finances">Home</a></li>
    <li><a href="<c:url value="/area"/>">Area</a></li>
    <li class="active">Novo</li>
</ol>

<div class="page-header">
    <h1>Areas <small>Cadastro das areas de gastos</small></h1>
    <a href="#" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-file"></span> Novo</a>
    <a href="#" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-floppy-disk"></span> Salvar</a>
</div>

<div class="well bs-component">
    <form class="form-horizontal" id="formulario" action="<c:url value="/area"/>" method="POST">
        <fieldset>
            <legend>Área</legend>
            <div class="form-group">
                <label for="inputEmail" class="col-lg-2 control-label">Descrição</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control" name="area.descricao" placeholder="Email">
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-10 col-lg-offset-2">
                    <button type="reset" class="btn btn-default">Cancel</button>
                    <button type="button" onclick="_post($('#formulario'));" class="btn btn-primary">Submit</button>
                </div>
            </div>
        </fieldset>
    </form>
</div>

<%@ include file="/footer.jsp" %> 
