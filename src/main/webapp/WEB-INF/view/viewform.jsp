<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h1>Employees List</h1>
<style>
        /* Basic body styling */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
        }

        /* Form container with background and shadow */
        .form-container {
            width: 50%;
            margin: 50px auto;
            padding: 20px;
            background-color: #ffffff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        /* Heading */
        h1 {
            text-align: center;
            color: #4CAF50;
            font-size: 2em;
            margin-bottom: 30px;
        }

        /* Table structure */
        table {
            width: 100%;
            margin-top: 20px;
        }

        td {
            padding: 10px;
            text-align: left;
        }

        /* Input fields with a light blue background */
        form:input {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ddd;
            border-radius: 4px;
            background-color: #f0f8ff;  /* Light blue background */
            box-sizing: border-box;
        }

        /* Specific colors for the fields */
        .id-field input {
            background-color: #e0f7fa;  /* Light cyan background for ID */
            border: 1px solid #00bcd4;  /* Cyan border */
        }

        .name-field input {
            background-color: #fff9c4;  /* Light yellow background for Name */
            border: 1px solid #ffeb3b;  /* Yellow border */
        }

        .mail-field input {
            background-color: #bbdefb;  /* Light blue background for Mail */
            border: 1px solid #2196f3;  /* Blue border */
        }

        .diemso-field input {
            background-color: #c8e6c9;  /* Light green background for DiemSo */
            border: 1px solid #4caf50;  /* Green border */
        }

        /* Submit button styling */
        .form-container input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 1.1em;
        }

        /* Hover effect for the submit button */
        .form-container input[type="submit"]:hover {
            background-color: #45a049;
        }

        /* Label colors */
        td:first-child {
            color: #333333;  /* Dark gray color for labels */
            font-weight: bold;
        }

        /* Styling for form sections */
        .form-container table {
            background-color: #fafafa;
            border-radius: 8px;
        }

        /* Add a border around the form container */
        .form-container {
            border: 2px solid #4CAF50;
        }

        /* Responsive design for smaller screens */
        @media screen and (max-width: 768px) {
            .form-container {
                width: 80%;
            }
        }

    </style>
<table border="2" width="70%" cellpadding="2">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Mail</th>
		<th>DiemSo</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<c:forEach var="user" items="${list}">
		<tr>
			<td>${user.id}</td>
			<td>${user.name}</td>
			<td>${user.mail}</td>
			<td>${user.diem}</td>
			<td><a href="edituser/${user.id}">Edit</a></td>
			<td><a href="deleteuser/${user.id}">Delete</a></td>
		</tr>
	</c:forEach>
</table>
<br />
<a href="saveform" class="add-link">Add new SinhVien</a>