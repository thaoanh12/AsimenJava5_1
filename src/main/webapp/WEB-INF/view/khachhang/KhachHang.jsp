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
    <br>
    <h2>khách hàng</h2>
    <br>
    <form method="post" action="/khach-hang/add" style="display: flex">
        <div style="float: left">
            <p>id : <input type="text" value="${khs.id}" name="id" readonly></p>
            <p> mã : <input type="text" value="${khs.ma}" name="ma"></p>
            <p style="color: red">${thongBao}</p>
            <p> họ : <input type="text" value="${khs.ho}" name="ho"></p>
            <p style="color: red">${thongBao}</p>
            <p> tên : <input type="text" value="${khs.ten}" name="ten"></p>
            <p style="color: red">${thongBao}</p>
            <p> tên đệm : <input type="text" value="${khs.tenDem}" name="tenDem"></p>
            <p style="color: red">${thongBao}</p>
            <p> ngày sinh : <input type="date" value="${khs.ngaySinh}" name="ngaySinh"></p>
            <p style="color: red">${thongBao}</p>
        </div>

        <div style="float: left ; margin-left: 30px">
            <p> địa chỉ : <input type="text" value="${khs.diaChi}" name="diaChi"></p>
            <p style="color: red">${thongBao}</p>
            <p> SĐT : <input type="text" value="${khs.sdt}" name="sdt"></p>
            <p style="color: red">${thongBao}</p>
            <p> thành phố : <input type="text" value="${khs.thanhPho}" name="thanhPho"></p>
            <p style="color: red">${thongBao}</p>
            <p> quốc gia : <input type="text" value="${khs.quocGia}" name="quocGia"></p>
            <p style="color: red">${thongBao}</p>
            <p> mật khẩu : <input type="password" value="${khs.matKhau}" name="matKhau"></p>
            <p style="color: red">${thongBao}</p>
            <button style="height: 30px">Add</button>
            <button formaction="/khach-hang/update" style="height: 30px">update</button>
        </div>


    </form>
    <button><a href="/khach-hang/hien-thi">hiển thị</a></button>
    <br>
    <table>
        <tr>
            <td>id</td>
            <td>mã</td>
            <td>họ tên</td>
            <td>tên đệm</td>
            <td>ngày sinh</td>
            <td>địa chỉ</td>
            <td>SĐT</td>
            <td>thành phố</td>
            <td>quốc gia </td>
            <td>Action</td>
        </tr>
        <c:forEach var="kh" items="${kh.content}">
            <tr>
                <td>${kh.id}</td>
                <td>${kh.ma}</td>
                <td> ${kh.ho}${kh.ten}</td>
                <td>${kh.tenDem}</td>
                <td>${kh.ngaySinh}</td>
                <td>${kh.diaChi}</td>
                <td>${kh.sdt}</td>
                <td>${kh.thanhPho}</td>
                <td>${kh.quocGia}</td>
                <td>
                    <button><a href="/khach-hang/remover/${kh.id}">delete</a></button>
                    <button><a href="/khach-hang/detail/${kh.id}">detail</a></button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="/khach-hang/hien-thi?p=0">Fist</a></li>
            <li class="page-item"><a class="page-link" href="/khach-hang/hien-thi?p=${kh.number - 1}">Back</a></li>
            <li class="page-item"><a class="page-link" href="/khach-hang/hien-thi?p=${kh.number + 1}">Next</a></li>
            <li class="page-item"><a class="page-link" href="/khach-hang/hien-thi?p=${kh.totalPages - 1}">Last</a></li>
        </ul>
    </nav>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>