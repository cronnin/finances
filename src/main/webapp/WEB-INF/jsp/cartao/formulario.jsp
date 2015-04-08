<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header.jsp" %>
<style>
    .btn{
        font-family: Arial;
    }
</style>

<ol class="breadcrumb">
    <li><a href="/finances">Home</a></li>
    <li><a href="<c:url value="/cartao"/>">Cartões</a></li>
    <li class="active">Formulário</li>
</ol>

<div class="page-header">
    <h1>Cartão <small>Cadastro dos cartão de crédito</small></h1>
</div>

<div class="well bs-component">
    <c:if test="${cartao eq null}">
        <form class="form-horizontal" id="formulario" action="<c:url value="/cartao"/>" method="POST">
        </c:if>
        <c:if test="${cartao.id > 0}">
            <form class="form-horizontal" id="formulario" action="<c:url value="/cartao/${cartao.id}"/>" method="POST">
            </c:if>
            <fieldset>
                <legend>Cartão</legend>

                <c:forEach var="error" items="${errors}">
                    <div class="alert alert-warning" role="alert">${error.category} - ${error.message}</div>
                </c:forEach>
                <input type="hidden" value="${cartao.id}" name="cartao.id" />
                <div class="form-group">
                    <label for="descricao" class="col-lg-2 control-label">Descrição</label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control" id="descricao" value="${cartao.descricao}" name="cartao.descricao" placeholder="Descrição do cartão"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="bandeira" class="col-lg-2 control-label">Bandeira</label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control" id="bandeira" value="${cartao.bandeira}" name="cartao.bandeira" placeholder="Bandeira do cartão"/>
                    </div>
                </div>
                    <div class="form-group">
                    <label for="dia" class="col-lg-2 control-label">Vencimento</label>
                    <div class="col-lg-10">
                        <input type="number" class="form-control" id="dia" value="${movimentacao.dia}" required name="movimentacao.dia" placeholder="Vencimento do cartão"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-2">
                        <button type="reset" class="btn btn-default">Limpar</button>
                        <c:if test="${cartao eq null}">
                            <button type="submit" class="btn btn-primary">Salvar</button>
                        </c:if>
                        <c:if test="${cartao.id > 0}">
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
