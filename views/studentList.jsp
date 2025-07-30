<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Danh sách sinh viên</title>
</head>
<body>

<h2>Danh sách sinh viên</h2>

<!-- Thông báo -->
<c:if test="${not empty message}">
  <p style="color:red;">${message}</p>
</c:if>

<!-- Nút thêm mới -->
<p><a href="/students/create">➕ Thêm sinh viên</a></p>

<!-- Bảng dữ liệu -->
<table border="1" cellpadding="10">
  <tr>
    <th>ID</th>
    <th>Tên</th>
    <th>Email</th>
    <th>Điểm</th>
    <th>Đang học</th>
    <th>Hành động</th>
  </tr>
  <c:forEach items="${students}" var="student">
    <tr>
      <td>${student.id}</td>
      <td>${student.studentName}</td>
      <td>${student.email}</td>
      <td>${student.ageMark}</td>
      <td>
        <c:choose>
          <c:when test="${student.isStudying}">✔️</c:when>
          <c:otherwise>❌</c:otherwise>
        </c:choose>
      </td>
      <td>
        <a href="/students/edit/${student.id}">✏️ Sửa</a> |
        <a href="/students/delete/${student.id}"
           onclick="return confirm('Bạn có chắc chắn muốn xóa?');">🗑️ Xóa</a>
      </td>
    </tr>
  </c:forEach>
</table>

</body>
</html>
