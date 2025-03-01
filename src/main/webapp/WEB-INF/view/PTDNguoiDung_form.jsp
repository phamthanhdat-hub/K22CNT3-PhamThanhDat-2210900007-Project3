<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${user.id == 0 ? 'Add New User' : 'Edit User'}</h1>
    <form action="/nguoidung/save" method="post">
        <input type="hidden" name="id" value="${user.id}">
        <label>Name: </label><input type="text" name="ptDten" value="${user.ptDten}" required><br>
        <label>Email: </label><input type="email" name="ptDEmail" value="${user.ptDEmail}" required><br>
        <label>Role: </label><input type="text" name="ptDVaiTro" value="${user.ptDVaiTro}" required><br>
        <label>Password: </label><input type="password" name="ptDMatKhau" value="${user.ptDMatKhau}" required><br>
        <button type="submit">Save</button>
    </form>
    <br><a href="/nguoidung/list">Back to List</a>

</body>
</html>