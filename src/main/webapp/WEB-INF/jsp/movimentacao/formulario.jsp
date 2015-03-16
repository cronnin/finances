<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header.jsp" %>
<style>
    .btn{
        font-family: Arial;
    }
</style>

<ol class="breadcrumb">
    <li><a href="<c:url context="/Finances" value="/"/>">Home</a></li>
    <li><a href="<c:url context="/Finances" value="/movimentacao"/>">Movimentações</a></li>
    <li class="active">Formulário</li>
</ol>

<div class="page-header">
    <h1>Movimentação <small>Cadastro de gasto</small></h1>
</div>

<div class="well bs-component">
    <c:if test="${area eq null}">
        <form class="form-horizontal" id="formulario" action="<c:url context="/Finances" value="/movimentacao"/>" method="POST">
    </c:if>
    <c:if test="${area.id > 0}">
        <form class="form-horizontal" id="formulario" action="<c:url context="/Finances" value="/movimentacao/${area.id}"/>" method="POST">
    </c:if>
            <fieldset>
                <legend>Formulário</legend>

                <c:forEach var="error" items="${errors}">
                    <div class="alert alert-warning" role="alert">${error.category} - ${error.message}</div>
                </c:forEach>
                    
                <input type="hidden" value="${area.id}" name="movimentacao.id" />
                
                <div class="form-group">
                    <label for="descricao" class="col-lg-2 control-label">Descrição</label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control" id="descricao" value="${movimentacao.descricao}" required name="movimentacao.descricao" placeholder="Descrição da Movimentação"/>
                    </div>
                </div>
                    
                <div class="form-group">
                    <label for="area" class="col-lg-2 control-label">Área</label>
                    <div class="col-lg-10">
                        <input type="hidden" name="movimentacao.area.id" value="${movimentacao.area.id}" />
                        <input type="text" id="area" name="movimentacao.area.descricao" value="${movimentacao.area.descricao}" />
                    </div>
                </div>
                    
                <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-2">
                        <button type="reset" class="btn btn-default">Limpar</button>
                        <!--                    <button type="button" onclick="_post($('#formulario'));" class="btn btn-primary">Submit</button>-->
                        <c:if test="${area eq null}">
                            <button type="submit" class="btn btn-primary">Salvar</button>
                        </c:if>
                        <c:if test="${area.id > 0}">
                            <input type="hidden" name="_method" value="PUT" />
                            <button class="btn btn-primary">Salvar</button>
                            <button onclick="_method.value = 'DELETE';" class="btn btn-primary">Remover</button>
                        </c:if>
                    </div>
                </div>
            </fieldset>
        </form>
</div>

<%@ include file="/footer.jsp" %> 
