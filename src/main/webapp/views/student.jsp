<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 07/05/2024
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách</title>
</head>
<body>
<a href="/add"><button>Add New</button></a>
<form action="/search">
    <label>Search by studentname</label>
    <input type="text" name="studentName"/>
    <input type="submit" value="search"/>
</form>
<table border="1">
    <thead>
    <th>ID</th>
    <th>Name</th>
    <th>Birth Day</th>
    <th>Phone</th>
    <th>Gender</th>
    <th>Address</th>
    <th>Image</th>
    <th colspan="2">Act</th>
    </thead>
    <tbody>
   <c:forEach items="${listStudent}" var="st">
       <tr>
           <td>${st.studentId}</td>
           <td>${st.studentName}</td>
           <td>${st.test()}</td>
           <td>${st.phoneNumber}</td>
           <td>${st.address}</td>
           <td>${st.gender?"Nam":"Nữ"}</td>
           <td><img src="/upload/${st.imgUrl}" alt="photo" width="100" height="100" style="object-fit: cover"></td>
           <td><a href="/edit?studentId=${st.studentId}">Edit</a></td>
           <td><a href="/delete?studentId=${st.studentId}">Delete</a></td>
       </tr>
   </c:forEach>
    </tbody>
</table>
</body>
</html>
