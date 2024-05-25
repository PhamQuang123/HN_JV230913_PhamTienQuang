<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 08/05/2024
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới</title>
</head>
<body>
<form action="/add" method="post" enctype="multipart/form-data">
  <div>
    <label>Name</label>
    <input type="text" name="studentName">
  </div>
  <div>
    <label>Birth Day</label>
  <input type="date" name="birthday">
  </div>
  <div>
    <label>Phone</label>
    <input type="text" name="phoneNumber">
  </div>
  <div>
    <div>
      <label>Address</label>
      <input type="text" name="address">
    </div>
  </div>
  <div>
    <label>ImgUrl</label>
    <input type="file" name="imgUrl">
  </div>
  <div>
    <label>Gender</label>
    <input type="radio" name="gender" value="true"><label>Nam</label>
    <input type="radio" name="gender" value="false"><label>Nữ</label>
  </div>
  <button type="submit">Add</button>
</form>
</body>
</html>
