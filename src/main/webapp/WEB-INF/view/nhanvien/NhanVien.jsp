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
    <h2>nhân viên </h2>
    <form method="post" action="/nhan-vien/add" style="display: flex">
        <div style="float: left">
            <p>id : <input type="text" value="${nvs.id}" name="id" readonly></p>
            <p> mã : <input type="text" value="${nvs.ma}" name="ma"></p>
            <p> họ : <input type="text" value="${nvs.ho}" name="ho"></p>
            <p> tên : <input type="text" value="${nvs.ten}" name="ten"></p>
            <p> tên đệm : <input type="text" value="${nvs.tenDem}" name="tenDem"></p>
            <p> giới tính :
                <input type="radio" value="nam" ${nvs.gioiTinh == "nam" ? "checked" : ""} name="gioiTinh"> nam
                <input type="radio" value="nữ" ${nvs.gioiTinh == "nữ" ? "checked" : ""} name="gioiTinh"> nữ
            </p>
            <p> ngày sinh : <input type="text" value="${nvs.ngaysinh}" name="ngaySinh"></p>
        </div>

        <div style="float: left ; margin-left: 30px">
            <p> địa chỉ : <input type="text" value="${nvs.diaChi}" name="diaChi"></p>
            <p> SĐT : <input type="text" value="${nvs.sdt}" name="sdt"></p>
            <p> mật khẩu : <input type="password" value="${nvs.matKhau}" name="matKhau"></p>
            <p>chức vụ :
                <select name="chucVu">
                    <c:forEach var="cv" items="${cv}">
                        <option value="${cv.id}">${cv.ten}</option>
                    </c:forEach>
                </select>
            </p>
            <p>cửa hàng :
                <select name="cuaHang">
                    <c:forEach var="ch" items="${ch}">
                        <option value="${ch.id}">${ch.ten}</option>
                    </c:forEach>
                </select>
            </p>
            <p> trạng thái :
                <input type="radio" value="0" ${nvs.trangThai == 0 ? "checked" : ""} name="trangThai"> đang đi làm
                <input type="radio" value="1" ${nvs.trangThai == 1 ? "checked" : ""} name="trangThai"> nghỉ làm
            </p>
            <button style="height: 30px">Add</button>
            <button formaction="/nhan-vien/update" style="height: 30px">update</button>
        </div>


    </form>
    <button><a href="/nhan-vien/hien-thi">hiển thị</a></button>
    <br>
    <table>
        <tr>
            <td>id</td>
            <td>mã</td>
            <td>họ tên</td>
            <td>tên đệm</td>
            <td>giới tính</td>
            <td>ngày sinh</td>
            <td>địa chỉ</td>
            <td>SĐT</td>
            <td>chức vụ</td>
            <td>cửa hàng</td>
            <td>Action</td>
        </tr>
        <c:forEach var="nv" items="${nv.content}">
            <tr>
                <td>${nv.id}</td>
                <td>${nv.ma}</td>
                <td> ${nv.ho}${nv.ten}</td>
                <td>${nv.tenDem}</td>
                <td>${nv.gioiTinh}</td>
                <td>${nv.ngaysinh}</td>
                <td>${nv.diaChi}</td>
                <td>${nv.sdt}</td>
                <td>${nv.idCv.ten}</td>
                <td>${nv.idCh.ten}</td>
                <td>${nv.trangThai == 0 ? "đang làm" : "nghỉ làm"}</td>
                <td>
                    <button><a href="/nhan-vien/remover/${nv.id}">delete</a></button>
                    <button><a href="/nhan-vien/detail/${nv.id}">detail</a></button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="/nhan-vien/hien-thi?p=0">Fist</a></li>
            <li class="page-item"><a class="page-link" href="/nhan-vien/hien-thi?p=${nv.number - 1}">Back</a></li>
            <li class="page-item"><a class="page-link" href="/nhan-vien/hien-thi?p=${nv.number + 1}">Next</a></li>
            <li class="page-item"><a class="page-link" href="/nhan-vien/hien-thi?p=${nv.totalPages - 1}">Last</a></li>
        </ul>
    </nav>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>