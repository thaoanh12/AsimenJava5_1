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
    <h2>chi tiết sản phẩm </h2>
    <br>
    <form method="post" action="/chi-tiet-san-pham/add" style="display: flex">
        <div style="float: left">
            <p>id : <input type="text" value="${ctsps.id}" name="id" readonly></p>
            <p> năm bán hàng: <input type="text" value="${ctsps.namBh}" name="namBh"></p>
            <p> số lượng tồn : <input type="text" value="${ctsps.soLuongTon}" name="soLuongTon"></p>
            <p> giá nhập  : <input type="text" value="${ctsps.giaNhap}" name="giaNhap"></p>
            <p style="color: red">${thongBao}</p>
            <p> giá bán  : <input type="text" value="${ctsps.giaBan}" name="giaBan"></p>
            <p style="color: red">${thongBao}</p>
            <p> mô tả  : <input type="text" value="${ctsps.moTa}" name="moTa"></p>
            <p style="color: red">${thongBao}</p>
        </div>

        <div style="float: left ; margin-left: 30px">
            <p>sản phẩm :
                <select name="idSp">
                    <c:forEach var="sp" items="${sp}">
                        <option value="${sp.id}" ${ctsps.idSp.id == sp.id ? "selected" : ""}>${sp.ten}</option>
                    </c:forEach>
                </select>
            </p>
            <p>dòng sản phẩm  :
                <select name="idDsp">
                    <c:forEach var="dsp" items="${dsp}">
                        <option value="${dsp.id}" ${ctsps.idDongSp.id == dsp.id ? "selected" : ""}>${dsp.ten}</option>
                    </c:forEach>
                </select>
            </p>
            <p>màu sắc :
                <select name="idMauSac">
                    <c:forEach var="ms" items="${ms}">
                        <option value="${ms.id}" ${ctsps.idMauSac.id == ms.id ? "selected" : ""}>${ms.ten}</option>
                    </c:forEach>
                </select>
            </p>
            <p>NSX :
                <select name="idNsx">
                    <c:forEach var="nsx" items="${nsx}">
                        <option value="${nsx.id}" ${ctsps.idNsx.id == nsx.id ? "selected" : ""}>${nsx.ten}</option>
                    </c:forEach>
                </select>
            </p>
            <button style="height: 30px">Add</button>
            <button formaction="/chi-tiet-san-pham/update" style="height: 30px">update</button>
        </div>


    </form>
    <button><a href="/chi-tiet-san-pham/hien-thi">hiển thị</a></button>
    <br>
    <table>
        <tr>
            <td>id</td>
            <td>tên sản phẩm </td>
            <td>NSX</td>
            <td>màu sắc</td>
            <td>dòng sản phẩm </td>
            <td>năm bán hàng</td>
            <td>mô tả</td>
            <td>số lượng tồn</td>
            <td>giá nhập</td>
            <td>giá bán </td>
            <td>Action</td>
        </tr>
        <c:forEach var="ctsp" items="${ctsp.content}">
            <tr>
                <td>${ctsp.id}</td>
                <td>${ctsp.idSp.ten}</td>
                <td> ${ctsp.idNsx.ten}</td>
                <td>${ctsp.idMauSac.ten}</td>
                <td>${ctsp.idDongSp.ten}</td>
                <td>${ctsp.namBh}</td>
                <td>${ctsp.moTa}</td>
                <td>${ctsp.soLuongTon}</td>
                <td>${ctsp.giaNhap}</td>
                <td>${ctsp.giaBan}</td>
                <td>
                    <button><a href="/chi-tiet-san-pham/remover/${ctsp.id}">delete</a></button>
                    <button><a href="/chi-tiet-san-pham/detail/${ctsp.id}">detail</a></button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="/chi-tiet-san-pham/hien-thi?p=0">Fist</a></li>
            <li class="page-item"><a class="page-link" href="/chi-tiet-san-pham/hien-thi?p=${ctsp.number - 1}">Back</a></li>
            <li class="page-item"><a class="page-link" href="/chi-tiet-san-pham/hien-thi?p=${ctsp.number + 1}">Next</a></li>
            <li class="page-item"><a class="page-link" href="/chi-tiet-san-pham/hien-thi?p=${ctsp.totalPages - 1}">Last</a></li>
        </ul>
    </nav>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>