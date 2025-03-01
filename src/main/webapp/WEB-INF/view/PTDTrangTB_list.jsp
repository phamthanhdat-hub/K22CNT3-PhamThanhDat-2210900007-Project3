<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>List of Admin Accounts</h1>
    <a href="/quantri/add">Add New Admin Account</a>
    <table border="1">
        <thead>
            <tr>
                <th>Username</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="adminAccount" items="${adminAccounts}">
                <tr>
                    <td>${adminAccount.ptDTaikhoan}</td>
                    <td>${adminAccount.ptDTrangthai == 1 ? 'Active' : 'Inactive'}</td>
                    <td>
                        <a href="/quantri/edit/${adminAccount.ptDTaikhoan}">Edit</a> |
                        <a href="/quantri/delete/${adminAccount.ptDTaikhoan}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>