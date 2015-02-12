<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header.jsp" %> 

<style>
    #menu{
        margin: 0px;
        padding: 0px;
    }
    #menu ul{
        padding-left: 0px;
        list-style: none;
    }
    #menu li{
        float: left;
        height: 85px;
        padding: 10px;
        text-align: center;
        cursor: pointer;
        background-color: #faf2cc;
        width: 12.5%;
        border: 1px solid #fff;
    }
    #menu span.glyphicon{
        margin-top: 5px;
        margin-bottom: 10px;
        font-size: 24px;       
    }
    #menu span.label{
        display: block;
        text-align: center;
        word-break: break-all;
        color: #333;
    }
</style>

<ol class="breadcrumb">
  <li class="active">Home</li>
</ol>

<div class="page-header">
  <h1>Example page header <small>Welcome to here</small></h1>
</div>
<div id="menu">
    <ul>
        <li>
            <a>
            <span class="glyphicon glyphicon-usd" aria-hidden="true"></span>
            <span class="label">Movimentações</span>
            </a>
        </li>
        <li>
            <a href="movimentacao/novo">
            <span class="glyphicon glyphicon-user"></span>
            <span class="label">Usuarios</span>
            </a>
        </li>
    </ul>
</div>

<script>
    $(function(){
        $("#menu li").mouseover(function(){
                $( this ).css("border","1px solid black");
        });
        $("#menu li").mouseout(function(){
                $( this ).css("border","1px solid white");
        });
    });
</script>
<%@ include file="/footer.jsp" %> 