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
    <li><a href="<c:url value="/area"/>">Áreas</a></li>
    <li class="active">Formulário</li>
</ol>

<div class="page-header">
    <h1>Areas <small>Cadastro das areas de gastos</small></h1>
</div>

<div class="well bs-component">
    <c:if test="${area eq null}">
        <form class="form-horizontal" id="formulario" action="<c:url value="/area"/>" method="POST">
    </c:if>
    <c:if test="${area.id > 0}">
        <form class="form-horizontal" id="formulario" action="<c:url value="/area/${area.id}"/>" method="POST">
    </c:if>
            <fieldset>
                <legend>Área</legend>

                <c:forEach var="error" items="${errors}">
                    <div class="alert alert-warning" role="alert">${error.category} - ${error.message}</div>
                </c:forEach>
                <input type="hidden" value="${area.id}" name="area.id" />
                <div class="form-group">
                    <label for="inputEmail" class="col-lg-2 control-label">Descrição</label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control" value="${area.descricao}" name="area.descricao" placeholder="Descrição da área"/>
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
