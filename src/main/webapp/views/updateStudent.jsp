<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 09/05/2024
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form action="/update" method="post" enctype="multipart/form-data">
    <div>
        <label>ID</label>
        <input type="text" name="studentId" readonly value="${student.studentId}">
    </div>
    <div>
        <label>Name</label>
        <input type="text" name="studentName" value="${student.studentName}">
    </div>
    <div>
        <label>Birth Day</label>
        <input type="text" name="birthday" value="${student.birthday}">
    </div>
    <div>
        <label>Phone</label>
        <input type="text" name="phoneNumber" value="${student.phoneNumber}">
    </div>
    <div>
        <div>
            <label>Address</label>
            <input type="text" name="address" value="${student.address}">
        </div>
    </div>
    <div>
        <label>ImgUrl</label>
        <input type="file" name="imgUrl" value="${student.imgUrl}">
        <img src="/upload/${student.imgUrl}" width="100" height="100" style="object-fit: cover"/>
    </div>
    <div>
        <label>Gender</label>
        <input type="radio" name="gender" value="true" ${student.gender?"checked":""}><label>Nam</label>
        <input type="radio" name="gender" value="false" ${!student.gender?"checked":""}><label>Nữ</label>
    </div>
    <button type="submit">update</button>
</form>
</body>
</html>
