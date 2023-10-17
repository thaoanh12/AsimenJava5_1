<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Document</title>
    <style>
        table, tr, td {
            border: solid 1px black;
        }
    </style>
</head>
<body>
<div style="margin-left: 20px ; margin-top: 10px">
    <ul class="nav justify-content-center">
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="/nhan-vien/hien-thi">NhanVien</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/san-pham/hien-thi">SanPhẩm</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/khach-hang/hien-thi">Khách Hàng </a>
        </li>
    </ul>
    <p>
        <a href="/nhan-vien/hien-thi">nhân viên </a>/
        <a href="/cua-hang/hien-thi">cửa hàng </a>/
        <a href="/chuc-vu/hien-thi">chức vụ </a>
    </p>
    <br>
    <h2>cửa hàng </h2>
    <br>
    <form method="post" action="/cua-hang/add">
        <p>id : <input type="text" value="${chs.id}" name="id" readonly></p>
        <p> mã : <input type="text" value="${chs.ma}" name="ma"></p>
        <p style="color: red">${thongBao}</p>
        <p> tên : <input type="text" value="${chs.ten}" name="ten"></p>
        <p style="color: red">${thongBao}</p>
        <p> địa chỉ : <input type="text" value="${chs.diaChi}" name="diaChi"></p>
        <p style="color: red">${thongBao}</p>
        <p> thành phố : <input type="text" value="${chs.thanhPho}" name="thanhPho"></p>
        <p style="color: red">${thongBao}</p>
        <p> quốc gia : <input type="text" value="${chs.quocGia}" name="quocGia"></p>
        <p style="color: red">${thongBao}</p>
        <button>Add</button>
        <button formaction="/cua-hang/update">update</button>
    </form>
    <button><a href="/cua-hang/hien-thi">hiển thị</a></button>
    <br>
    <table>
        <tr>
            <td>id</td>
            <td>mã</td>
            <td>Tên</td>
            <td>địa chỉ</td>
            <td>thành phố</td>
            <td>quốc gia</td>
            <td>Action</td>
        </tr>
        <c:forEach var="ch" items="${ch.content}">
            <tr>
                <td>${ch.id}</td>
                <td>${ch.ma}</td>
                <td>${ch.ten}</td>
                <td>${ch.diaChi}</td>
                <td>${ch.thanhPho}</td>
                <td>${ch.quocGia}</td>
                <td>
                    <button><a href="/cua-hang/remover/${ch.id}">delete</a></button>
                    <button><a href="/cua-hang/detail/${ch.id}">detail</a></button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="/cua-hang/hien-thi?p=0">Fist</a></li>
            <li class="page-item"><a class="page-link" href="/cua-hang/hien-thi?p=${ch.number - 1}">Back</a></li>
            <li class="page-item"><a class="page-link" href="/cua-hang/hien-thi?p=${ch.number + 1}">Next</a></li>
            <li class="page-item"><a class="page-link" href="/cua-hang/hien-thi?p=${ch.totalPages - 1}">Last</a></li>
        </ul>
    </nav>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>