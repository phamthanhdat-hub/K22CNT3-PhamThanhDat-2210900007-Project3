<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>He Thong Quan Ly Trang Thiet Bi</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            margin: 0;
        }
        .sidebar {
            width: 250px;
            background: #2c3e50;
            color: white;
            height: 100vh;
            padding: 20px;
            box-shadow: 2px 0px 5px rgba(0, 0, 0, 0.2);
        }
        .sidebar h2 {
            text-align: center;
        }
        .sidebar ul {
            list-style: none;
            padding: 0;
        }
        .sidebar ul li {
            padding: 10px;
            border-bottom: 1px solid #34495e;
        }
        .sidebar ul li a {
            color: white;
            text-decoration: none;
            display: block;
        }
        .sidebar ul li a:hover {
            background: #1abc9c;
        }
        .content {
            flex-grow: 1;
            padding: 20px;
        }
    </style>
</head>
<body>
    <div class="sidebar">
        <h2>Quan Ly Trang Thiet Bi</h2>
   <ul>
    <li><a href="PTDBaoTri_list">Bao Tri</a></li>
    <li><a href="PTDLichSuDung_list">Lich Su Dung</a></li>
    <li><a href="PTDNguoiDung_list">Nguoi Dung</a></li>
    <li><a href="PTDTrangTB_list">Trang TB</a></li>
    <li><a href="PTDQuanTri_list">Quan Tri</a></li>
    
</ul>


    </div>

    <div class="content">
        <h1>Chào mừng bạn đến với quản lý trang thiết bị </h1>
        <p>Vui lòng chọn một danh mục từ  menu ben trái để thao tác.</p>
    </div>

</body>
</html>