<%@page pageEncoding="UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>add</title>
</head>
<body>
<h2>Thêm kích thước</h2>
<form action="/hoa-don-ct/store" method="post">
    <div>
        <lable>Mã hóa đơn chi tiết</lable>
        <input type="text" name="maHDCT">
    </div>
    <div>
        <lable>id hóa đơn</lable>
        <input type="text" name="idHoaDon">
    </div>
    <div>
        <lable>id sản phẩm chi tiết</lable>
        <input type="text" name="idSPCT">
    </div>
    <div>
        <lable>Số lượng</lable>
        <input type="text" name="soLuong">
    </div>
    <div>
        <lable>Đơn giá</lable>
        <input type="text" name="donGia">
    </div>

    <div>
        <lable>Trạng thái</lable>
        <input type="radio" id="tt-hd" name="trangThai" value="1">
        <lable id="tt-hd">Đang hoạt động</lable>
        <input type="radio" id="tt-nhd" name="trangThai" value="0">
        <lable id="tt-nhd">Ngừng hoạt động</lable>
    </div>
    <div>
    <button>thêm</button>
    </div>
</form>
</body>
</html>