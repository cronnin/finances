<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="form-group">
    <label for="descricao" class="col-lg-2 control-label">Descrição</label>
    <div class="col-lg-10">
        <input type="text" class="form-control" id="descricao" name="descricao" placeholder="Descrição da Cartão"/>
    </div>
</div>
<table class="table table-bordered table-hover table-striped">
    <thead>
        <tr>
            <td>Id.</td>
            <td>Descrição</td>
            <td>Bandeira</td>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${cartaoList}" var="cartao">
            <tr ondblclick='selectItem(${cartao})'>
                <td>${cartao.id}</td>
                <td>${cartao.descricao}</td>
                <td>${cartao.bandeira}</td>
            </tr>
        </c:forEach>    
    </tbody>
</table>
<nav style="width:100%; text-align: center;">
    <ul  class="pagination">
        <c:if test="${paginacao ne 1}">
        <li>
            <a href="javascript:buscaDadosArea(${numero-1},'${descricao}')" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        </c:if>
        <c:forEach begin="1" end="${paginas}" step="1" var="numero">
            <li <c:if test="${numero eq paginacao}">class="active"</c:if>><a href="javascript:buscaDadosArea(${numero},'${descricao}')">${numero}</a></li>
        </c:forEach>

        <c:if test="${paginacao < paginas}">
        <li>
            <a href="javascript:buscaDadosArea(${numero+1},'${descricao}')" aria-label="Next">
                <span aria-hidden="true">&raquo;</szpan>
            </a>
        </li>
        </c:if>
    </ul>
</nav>