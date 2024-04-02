<%@page pageEncoding="UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form action="/hoa-don/store" method="post">
    <div>
        <lable>Mã hóa đơn</lable>
        <input type="text" name="maHoaDon">
    </div>
    <div>
        <lable>ID nhân viên</lable>
        <input type="text" name="idNhanVien">
    </div>
    <div>
        <lable>ID khách hàng</lable>
        <input type="text" name="idKhachHang">
    </div>
    <div>
        <lable>Ngày mua hàng</lable>
        <input type="date" name="ngayMuaHang">
    </div>
    <div>
        <lable>Trạng thái</lable>
        <input type="radio" id="tt-hd" name="trangThai" value="1">
        <lable id="tt-hd">Đang hoạt động</lable>
        <input type="radio" id="tt-nhd" name="trangThai" value="0">
        <lable id="tt-nhd">Ngừng hoạt động</lable>
    </div>
    <div>
        <button>Thêm</button>
    </div>
</form>
</body>
</html>