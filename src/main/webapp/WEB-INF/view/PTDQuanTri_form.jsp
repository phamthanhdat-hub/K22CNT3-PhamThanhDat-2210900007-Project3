<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${adminAccount.ptDTaikhoan == null ? 'Add New Admin Account' : 'Edit Admin Account'}</h1>
    <form action="/quantri/save" method="post">
        <input type="hidden" name="ptDTaikhoan" value="${adminAccount.ptDTaikhoan}">
        <label>Username: </label><input type="text" name="ptDTaikhoan" value="${adminAccount.ptDTaikhoan}" required><br>
        <label>Status: </label>
        <select name="ptDTrangthai">
            <option value="1" ${adminAccount.ptDTrangthai == 1 ? 'selected' : ''}>Active</option>
            <option value="0" ${adminAccount.ptDTrangthai == 0 ? 'selected' : ''}>Inactive</option>
        </select><br>
        <button type="submit">Save</button>
    </form>
    <br><a href="/quantri/list">Back to List</a>

</body>
</html>