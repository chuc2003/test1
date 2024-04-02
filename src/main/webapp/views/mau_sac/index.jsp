<%@page pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>view</title>
</head>
<body>
<a href="/mau-sac/create">thêm mới</a>
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
    <c:forEach items="${ listMS }" var="ms">
        <tr>
            <td>${ ms.ma }</td>
            <td>${ ms.ten }</td>
            <td>${ ms.trangThai }</td>
            <td>
                <a href="/mau-sac/edit/${ms.ma}">Update</a>
            </td>
            <td>
                <a href="/mau-sac/delete/${ms.ma}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>