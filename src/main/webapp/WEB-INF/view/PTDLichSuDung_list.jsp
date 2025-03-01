<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>List of Lich Su Dung</h1>
    <a href="/lichsudung/add">Add New</a>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>PTDThietBiID</th>
                <th>PTDNguoiDungID</th>
                <th>PTDNgaySuDung</th>
                <th>PTDMucDichSuDung</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <tr th:each="lichSuDung : ${lichSuDungs}">
                <td th:text="${lichSuDung.id}"></td>
                <td th:text="${lichSuDung.ptdThietBiID}"></td>
                <td th:text="${lichSuDung.ptdNguoiDungID}"></td>
                <td th:text="${lichSuDung.ptdNgaySuDung}"></td>
                <td th:text="${lichSuDung.ptdMucDichSuDung}"></td>
                <td>
                    <a th:href="@{/lichsudung/edit/{id}(id=${lichSuDung.id})}">Edit</a> |
                    <a th:href="@{/lichsudung/delete/{id}(id=${lichSuDung.id})}">Delete</a>
                </td>
            </tr>
        </tbody>
    </table>

</body>
</html>