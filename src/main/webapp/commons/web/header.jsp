<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<header>
    <!-- Top bar chứa Đăng nhập / Đăng ký -->
    <div style="background-color: #333; color: #fff; padding: 5px 20px; text-align: right; font-size: 14px;">
        <c:choose>
            <c:when test="${not empty sessionScope.user}">
                <span>Xin chào, ${sessionScope.user.fullname}</span> | 
                <a href="${pageContext.request.contextPath}/profile" style="color: #fff; text-decoration: none;">Profile</a> | 
                <a href="${pageContext.request.contextPath}/logout" style="color: #fff; text-decoration: none;">Đăng xuất</a>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/login" style="color: #fff; text-decoration: none;">ĐĂNG NHẬP</a> | 
                <a href="${pageContext.request.contextPath}/register" style="color: #fff; text-decoration: none;">ĐĂNG KÝ</a>
            </c:otherwise>
        </c:choose>
        <span style="margin-left: 15px; cursor: pointer;">🔍</span>
    </div>

    <!-- Main Navigation -->
    <nav style="display: flex; align-items: center; justify-content: space-around; padding: 15px 20px; background-color: #fff; border-bottom: 2px solid #eee;">
        <div class="logo">
            <a href="${pageContext.request.contextPath}/" style="text-decoration: none;">
                <h2 style="color: #007bff; margin: 0; font-family: Arial, sans-serif;">IoTStar<span style="color: red;">*</span></h2>
            </a>
        </div>
        
        <ul style="list-style: none; display: flex; gap: 30px; margin: 0; padding: 0;">
            <li><a href="${pageContext.request.contextPath}/" style="text-decoration: none; color: #555; font-weight: bold;">TRANG CHỦ</a></li>
            <li><a href="${pageContext.request.contextPath}/categories" style="text-decoration: none; color: #555; font-weight: bold;">DANH MỤC</a></li>
            <li><a href="${pageContext.request.contextPath}/products" style="text-decoration: none; color: #555; font-weight: bold;">SẢN PHẨM</a></li>
        </ul>
    </nav>
</header>