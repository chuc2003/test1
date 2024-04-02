<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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
<h3>Tìm kiếm</h3>
<form action="/hoa-don/search" method="get">
    <input type="text" name="maHoaDon" placeholder="Tìm theo maHoaDon">
    <input type="text" name="idNhanVien" placeholder="Tìm theo idNhanVien">
    <input type="text" name="idKhachHang" placeholder="Tìm theo idKhachHang">
    <button>tìm</button>
</form>
<form action="/hoa-don/search-date" method="get">
    <h3>Ngày</h3>
    <input type="date" name="ngayMuaHang">
    <button>Tìm</button>
</form>
<form action="/hoa-don/loc" method="get">
    <h3>Lọc</h3>
    <lable>Trạng thái</lable>
    <select name="trangThai" >
        <option value="1">Đang hoạt động</option>
        <option value="0">Ngừng hoạt động</option>
    </select>
    <button>Lọc</button>
</form>
<br>
<a href="/hoa-don/create">Thêm mới</a>
<table>
    <thead>
        <tr>
            <th>Mã hóa đơn</th>
            <th>ID nhân viên</th>
            <th>ID khách hàng</th>
            <th>Ngày mua hàng</th>
            <th>Trạng thái</th>
            <th colspan="2">Thao tác</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${listHD}" var="hd">
            <tr>
                <td>${hd.maHoaDon}</td>
                <td>${hd.idNhanVien}</td>
                <td>${hd.idKhachHang}</td>
                <td>${hd.ngayMuaHang}</td>
                <td>${hd.trangThai}</td>
                <td><a href="/hoa-don/edit/${hd.maHoaDon}">update</a></td>
                <td><a href="/hoa-don/delete/${hd.maHoaDon}">delete</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>