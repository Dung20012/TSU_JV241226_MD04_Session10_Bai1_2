<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${formTitle}</title>
</head>
<body>
<h2>${formTitle}</h2>

<form:form action="${action}" method="post" modelAttribute="student">
    <form:hidden path="id"/>

    <div>
        <label>Tên sinh viên:</label>
        <form:input path="studentName"/>
        <form:errors path="studentName"/>
    </div>

    <div>
        <label>Email:</label>
        <form:input path="email"/>
        <form:errors path="email"/>
    </div>

    <div>
        <label>Điểm:</label>
        <form:input path="ageMark" type="number" step="0.1"/>
        <form:errors path="ageMark"/>
    </div>

    <div>
        <label>Đang học?</label>
        <form:checkbox path="isStudying"/>
    </div>

    <button type="submit">Lưu</button>
    <a href="/students">Quay lại</a>
</form:form>
</body>
</html>
