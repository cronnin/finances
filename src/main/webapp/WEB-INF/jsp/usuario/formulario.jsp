<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="/header.jsp" %>
<style>
    .btn{
        font-family: Arial;
    }
</style>

<ol class="breadcrumb">
    <li><a href="<c:url context="/finances" value="/"/>">Home</a></li>
    <li><a href="<c:url context="/finances" value="/movimentacao"/>">Movimentações</a></li>
    <li class="active">Formulário</li>
</ol>

<div class="page-header">
    <h1>Movimentação <small>Cadastro de gasto</small></h1>
</div>

<div class="well bs-component">
    <c:if test="${movimentacao eq null}">
        <form class="form-horizontal" id="formulario" action="<c:url context="/finances" value="/movimentacao"/>" method="POST">
        </c:if>
        <c:if test="${movimentacao.id > 0}">
            <form class="form-horizontal" id="formulario" action="<c:url context="/finances" value="/movimentacao/${movimentacao.id}"/>" method="POST">
            </c:if>
            <fieldset>
                <legend>Formulário</legend>

                <c:forEach var="error" items="${errors}">
                    <div class="alert alert-warning" role="alert">${error.category} - ${error.message}</div>
                </c:forEach>

                <input type="hidden" value="${movimentacao.id}" name="movimentacao.id" />

                <div class="form-group">
                    <label for="descricao" class="col-lg-2 control-label">Descrição</label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control" id="descricao" value="${movimentacao.descricao}" required name="movimentacao.descricao" placeholder="Descrição da Movimentação"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="area" class="col-lg-2 control-label">Área</label>
                    <div class="col-lg-9">
                        <input type="hidden" id="areaId" name="movimentacao.area.id" value="${movimentacao.area.id}" />
                        <input type="text" class="form-control" id="areaDesc" name="movimentacao.area.descricao" readonly required value="${movimentacao.area.descricao}" />
                        
                        <div class="modal fade" id="myModal"  hidden>
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title">Selecionar área</h4>
                                    </div>
                                    <div class="modal-body" id="bodyModalSelectArea">

                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                        <button type="button" class="btn btn-primary">Selecionar</button>
                                    </div>
                                </div><!-- /.modal-content -->
                            </div><!-- /.modal-dialog -->
                        </div><!-- /.modal -->
                        <script>
                            function buscaDadosArea(paginacao, filtro) {
                                $.ajax({
                                    type: "GET",
                                    url: "<c:url context="/finances" value="/buscaarea"/>/" + paginacao + "/" + (filtro == '' ? null : filtro)
                                }).done(function (msg) {
                                    $("#bodyModalSelectArea").html(msg);
                                }).fail(function (jqXHR, textStatus) {
                                    alert("Request failed: " + textStatus);
                                });
                            }
                            function selectItem(obj) {
                                $("#areaId").val(obj.id);
                                $("#areaDesc").val(obj.descricao);
                                $('#myModal').modal('hide');
                            }
                            buscaDadosArea(1, null);
                        </script>
                    </div>
                                <div class="col-lg-1"><a href="#" data-toggle="modal" data-target="#myModal"><img align="absmiddle" src="<c:url context="/finances" value="/imagens/lupa.png"/>" /></a></div>
                </div>

                <div class="form-group">
                    <label for="tipoEntrada" class="col-lg-2 control-label">Tipo de Movimentação</label>
                    <div class="col-lg-10">
                        <select  class="form-control" id="tipoEntrada" required name="movimentacao.tipoEntrada" placeholder="Tipo de Movimentação">
                            <c:forEach var="tipo" items="${tipos}">
                                <option value="${tipo}" <c:if test="${tipo.id eq movimentacao.tipoEntrada.id}">selected</c:if>>${tipo.descricao}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label for="valor" class="col-lg-2 control-label">Valor</label>
                    <div class="col-lg-10">
                        <input type="number" class="form-control" id="valor" value="${movimentacao.valor}" required name="movimentacao.valor" placeholder="Valor da Movimentação"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="dataMov" class="col-lg-2 control-label">Data</label>
                    <div class="col-lg-7">
                        <input type="text" class="form-control" size="30" id="dataMov" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${movimentacao.data}" />" required name="movimentacao.data" placeholder="Data da Movimentação"/>
                    </div>
                    <div class="col-lg-3">
                        <input type="text" class="form-control" id="spinner" name="spinner" value="08:30 PM">    
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-2">
                        <button type="reset" class="btn btn-default">Limpar</button>
                        <c:if test="${movimentacao eq null}">
                            <button type="submit" class="btn btn-primary">Salvar</button>
                        </c:if>
                        <c:if test="${movimentacao.id > 0}">
                            <input type="hidden" name="_method" value="PUT" />
                            <button class="btn btn-primary">Salvar</button>
                            <button onclick="_method.value = 'DELETE';" class="btn btn-primary">Remover</button>
                        </c:if>
                    </div>
                </div>
            </fieldset>
        </form>
</div>
<script>
    $(function () {
        $("#dataMov").datepicker({
            showOtherMonths: true,
            selectOtherMonths: true,
            dateFormat: "dd/mm/yy",
            monthNames: ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"],
            dayNames: ["Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"],
            dayNamesMin: ["Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab"],
            dayNamesShort: ["Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab"],
            monthNamesShort: ["Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez"]
        });
    });
    $("#spinner").timespinner();
</script>
<%@ include file="/footer.jsp" %> 
