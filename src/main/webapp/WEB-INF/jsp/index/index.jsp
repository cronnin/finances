<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header.jsp" %> 

<style>
    #menu{
        margin: 0px;
        padding: 0px;
    }
    #menu button{
        min-width: 100px;
        min-height: 100px;
        margin: 2px;
        color: #333333;
    }
</style>

<ol class="breadcrumb">
    <li class="active">Home</li>
</ol>

<div class="page-header">
    <h1>Finances <small>Controle financeiro</small></h1>
</div>
<div id="menu" class="btn-group" role="group">
    <form method="GET">
        <button class="btn btn-default" formaction="movimentacao">
            <span class="glyphicon glyphicon-usd" aria-hidden="true"></span>
            <span>Movimentações</span>
        </button>
        <button class="btn btn-default" formaction="area">
            <span class="glyphicon glyphicon-user"></span>
            <span>Áreas</span>
        </button>
        <button class="btn btn-default" formaction="cartao">
            <span class="glyphicon glyphicon-user"></span>
            <span>Cartões</span>
        </button>
    </form>
</div>

<script>
    $(function () {
        $("#menu li").mouseover(function () {
            $(this).css("border", "1px solid black");
        });
        $("#menu li").mouseout(function () {
            $(this).css("border", "1px solid white");
        });
    });
</script>
<%@ include file="/footer.jsp" %> 