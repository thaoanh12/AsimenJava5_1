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
        <a href="/san-pham/hien-thi">sản phẩm  </a>/
        <a href="/mau-sac/hien-thi">màu sắc  </a>/
        <a href="/nsx-hien-thi">nsx </a>/
        <a href="/dongsp/hien-thi">dòng sản phẩm  </a>/
        <a href="/chi-tiet-san-pham/hien-thi">chi tiết sản phẩm  </a>
    </p>
    <br>
    <h2>NSX </h2>
    <br>
    <form method="post" action="/nsx-add">
        <p>id : <input type="text" value="${nsxs.id}" name="id" readonly></p>
        <p> mã : <input type="text" value="${nsxs.ma}" name="ma"></p>
        <p style="color: red">${thongBao}</p>
        <p> tên : <input type="text" value="${nsxs.ten}" name="ten"></p>
        <p style="color: red">${thongBao}</p>
        <button>Add</button>
        <button formaction="/nsx-update">update</button>
    </form>
    <button><a href="/nsx-hien-thi">hiển thị </a></button>
    <br>
    <table>
        <tr>
            <td>id</td>
            <td>mã</td>
            <td>Tên</td>
            <td>Action</td>
        </tr>
        <c:forEach var="nsx" items="${nsx.content}">
            <tr>
                <td>${nsx.id}</td>
                <td>${nsx.ma}</td>
                <td>${nsx.ten}</td>
                <td>
                    <button><a href="/nsx-remover/${nsx.id}">delete</a></button>
                    <button><a href="/nsx-detail/${nsx.id}">detail</a></button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="/nsx-hien-thi?p=0">Fist</a></li>
            <li class="page-item"><a class="page-link" href="/nsx-hien-thi?p=${nsx.number - 1}">Back</a></li>
            <li class="page-item"><a class="page-link" href="/nsx-hien-thi?p=${nsx.number + 1}">Next</a></li>
            <li class="page-item"><a class="page-link" href="/nsx-hien-thi?p=${nsx.totalPages - 1}">Last</a></li>
        </ul>
    </nav>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>