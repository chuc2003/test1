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
    <title>index</title>
</head>
<body>
<a href="/nhan-vien/create">thêm mới</a>
    <table>
        <thead>
        <tr>
            <th>Mã</th>
            <th>Tên</th>
            <th>Tên đăng nhập</th>
            <th>Mật khẩu</th>
            <th>Trạng thái</th>
            <th colspan="2">Thao tác</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${listNV}" var="nv">
                <tr>
                    <td>${ nv.ma }</td>
                    <td>${ nv.ten }</td>
                    <td>${ nv.tenDangNhap }</td>
                    <td>${ nv.matKhau }</td>
                    <td>${ nv.trangThai }</td>
                    <td>
                        <a href="/nhan-vien/edit/${nv.ma}">update</a>
                    </td>
                    <td>
                        <a href="/nhan-vien/delete/${nv.ma}">delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>