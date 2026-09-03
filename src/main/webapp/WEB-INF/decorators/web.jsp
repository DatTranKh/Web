<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><sitemesh:write property="title"/></title>
    <sitemesh:write property="head"/>
</head>
<body>
    <div>
        <%@ include file="/commons/web/header.jsp"%>
    </div>
    
    <!-- Phần nội dung động của từng trang sẽ được đẩy vào đây -->
    <div class="container">
        <sitemesh:write property="body"/>
    </div>
    
    <div>
        <%@ include file="/commons/web/footer.jsp"%>
    </div>
</body>
</html>