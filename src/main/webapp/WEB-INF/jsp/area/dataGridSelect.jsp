<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header.jsp" %>
<table class="table table-bordered table-hover table-striped">
    <thead>
        <tr>
            <td>Id.</td>
            <td>Descrição</td>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${areaList}" var="area">
            <tr onclick="selectItem(${area})">
                <td>${area.id}</td>
                <td>${area.descricao}</td>
            </tr>
        </c:forEach>
        <nav>
            <ul class="pagination pagination-sm">
                <li>
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <c:forEach begin="1" end="${quantidade}" step="1" var="numero">
                    <li><a href="#">${numero}</a></li>
                </c:forEach>
                <li>
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>
    </tbody>
</table>