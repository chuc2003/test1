<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>index</title>
</head>
<body>
<a href="/san-pham/create">thêm mới</a>
    <table>
        <thead>
            <tr>
                <th>Mã</th>
                <th>Tên</th>
                <th>Trạng thái</th>
                <th colspan="2">Thao tác</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listSP}" var="sp">
                <tr>
                    <td>${sp.ma}</td>
                    <td>${sp.ten}</td>
                    <td>${sp.trangThai}</td>
                    <td><a href="/san-pham/edit/${sp.ma}">update</a></td>
                    <td><a href="/san-pham/delete/${sp.ma}">delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>