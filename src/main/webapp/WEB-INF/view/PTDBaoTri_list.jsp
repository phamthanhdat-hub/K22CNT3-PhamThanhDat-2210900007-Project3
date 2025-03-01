<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Maintenance Records</h1>
    <a href="/baotri/add">Add New Maintenance</a>
    <table>
        <thead>
            <tr>
                <th>Device ID</th>
                <th>Maintenance Date</th>
                <th>Description</th>
                <th>Cost</th>
                <th>Performed By</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <tr th:each="baotri : ${baotris}">
                <td th:text="${baotri.PTDThietBiID}"></td>
                <td th:text="${baotri.PTDNgayBaoTri}"></td>
                <td th:text="${baotri.PTDMoTaBaoTri}"></td>
                <td th:text="${baotri.PTDChiPhi}"></td>
                <td th:text="${baotri.PTDNguoiThucHien}"></td>
                <td>
                    <a th:href="@{/baotri/edit/{id}(id=${baotri.PTDThietBiID})}">Edit</a>
                    <a th:href="@{/baotri/delete/{id}(id=${baotri.PTDThietBiID})}">Delete</a>
                </td>
            </tr>
        </tbody>
    </table>

</body>
</html>