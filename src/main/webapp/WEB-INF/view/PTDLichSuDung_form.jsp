<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Form for Lich Su Dung</h1>
    <form action="#" th:action="@{/lichsudung/save}" th:object="${lichSuDung}" method="post">
        <label for="ptdThietBiID">PTDThietBiID:</label>
        <input type="number" th:field="*{ptdThietBiID}" /><br>
        
        <label for="ptdNguoiDungID">PTDNguoiDungID:</label>
        <input type="number" th:field="*{ptdNguoiDungID}" /><br>

        <label for="ptdNgaySuDung">PTDNgaySuDung:</label>
        <input type="date" th:field="*{ptdNgaySuDung}" /><br>

        <label for="ptdMucDichSuDung">Muc Dich Su Dung:</label>
        <input type="text" th:field="*{ptdMucDichSuDung}" /><br>

        <button type="submit">Save</button>
    </form>

</body>
</html>