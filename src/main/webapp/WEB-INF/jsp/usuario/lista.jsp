<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table class="table table-striped table-hover ">
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Login</th>
                    <th>-</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${lista}" var="usuario">
                <tr>
                    <td>${usuario.nome}</td>
                    <td>${usuario.login}</td>
                    <td>
                        <a href=""><span class="glyphicon glyphicon-pencil"></a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table> 
</body>
</html>
