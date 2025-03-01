<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Maintenance Form</h1>
    <form th:action="@{/baotri/save}" th:object="${baotri}" method="post">
        <label for="PTDThietBiID">Device ID:</label>
        <input type="number" th:field="*{PTDThietBiID}" id="PTDThietBiID" required><br>

        <label for="PTDNgayBaoTri">Maintenance Date:</label>
        <input type="date" th:field="*{PTDNgayBaoTri}" id="PTDNgayBaoTri" required><br>

        <label for="PTDMoTaBaoTri">Description:</label>
        <textarea th:field="*{PTDMoTaBaoTri}" id="PTDMoTaBaoTri"></textarea><br>

        <label for="PTDChiPhi">Cost:</label>
        <input type="number" step="0.01" th:field="*{PTDChiPhi}" id="PTDChiPhi"><br>

        <label for="PTDNguoiThucHien">Performed By:</label>
        <input type="text" th:field="*{PTDNguoiThucHien}" id="PTDNguoiThucHien"><br>

        <button type="submit">Save</button>
    </form>

</body>
</html>