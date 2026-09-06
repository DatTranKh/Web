<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<head>
    <title>Quên mật khẩu</title>
</head>
<body>
    <div style="max-width: 400px; margin: 40px auto; padding: 25px; border: 1px solid #ddd; border-radius: 8px; box-shadow: 0 2px 5px rgba(0,0,0,0.1);">
        <h2 style="text-align: center; color: #333; margin-bottom: 10px;">QUÊN MẬT KHẨU</h2>
        <p style="text-align: center; color: #666; font-size: 14px; margin-bottom: 20px;">
            Nhập email tài khoản của bạn để nhận mã OTP thiết lập lại mật khẩu.
        </p>

        <!-- Thông báo kết quả -->
        <c:if test="${not empty error}">
            <div style="color: #d9534f; background-color: #f2dede; padding: 10px; border-radius: 4px; margin-bottom: 15px; font-size: 14px;">
                ${error}
            </div>
        </c:if>
        <c:if test="${not empty message}">
            <div style="color: #3c763d; background-color: #dff0d8; padding: 10px; border-radius: 4px; margin-bottom: 15px; font-size: 14px;">
                ${message}
            </div>
        </c:if>

        <form action="${pageContext.request.contextPath}/forgot-password" method="post">
            <div style="margin-bottom: 20px;">
                <label style="display: block; margin-bottom: 5px; font-weight: bold; color: #555;">Email tài khoản:</label>
                <input type="email" name="email" required placeholder="example@gmail.com" 
                       style="width: 100%; padding: 10px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 4px;">
            </div>

            <button type="submit" 
                    style="width: 100%; padding: 12px; background-color: #28a745; border: none; color: white; font-size: 16px; font-weight: bold; border-radius: 4px; cursor: pointer;">
                Gửi mã xác thực OTP
            </button>
        </form>

        <div style="display: flex; justify-content: space-between; margin-top: 15px; font-size: 14px;">
            <a href="${pageContext.request.contextPath}/login" style="color: #007bff; text-decoration: none;">Đăng nhập</a>
            <a href="${pageContext.request.contextPath}/register" style="color: #007bff; text-decoration: none;">Đăng ký mới</a>
        </div>
    </div>
</body>