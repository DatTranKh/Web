<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<head>
    <title>Đăng ký tài khoản</title>
</head>
<body>
    <div style="max-width: 400px; margin: 40px auto; padding: 25px; border: 1px solid #ddd; border-radius: 8px; box-shadow: 0 2px 5px rgba(0,0,0,0.1);">
        <h2 style="text-align: center; color: #333; margin-bottom: 20px;">ĐĂNG KÝ TÀI KHOẢN</h2>

        <!-- Hiển thị thông báo lỗi nếu có -->
        <c:if test="${not empty error}">
            <div style="color: #d9534f; background-color: #f2dede; padding: 10px; border-radius: 4px; margin-bottom: 15px; font-size: 14px;">
                ${error}
            </div>
        </c:if>

        <form action="${pageContext.request.contextPath}/register" method="post">
            <div style="margin-bottom: 15px;">
                <label style="display: block; margin-bottom: 5px; font-weight: bold; color: #555;">Email:</label>
                <input type="email" name="email" required placeholder="Nhập địa chỉ email của bạn..." 
                       style="width: 100%; padding: 10px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 4px;">
            </div>

            <div style="margin-bottom: 20px;">
                <label style="display: block; margin-bottom: 5px; font-weight: bold; color: #555;">Mật khẩu:</label>
                <input type="password" name="password" required placeholder="Nhập mật khẩu..." 
                       style="width: 100%; padding: 10px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 4px;">
            </div>

            <button type="submit" 
                    style="width: 100%; padding: 12px; background-color: #007bff; border: none; color: white; font-size: 16px; font-weight: bold; border-radius: 4px; cursor: pointer;">
                Đăng Ký & Nhận OTP
            </button>
        </form>

        <div style="text-align: center; margin-top: 15px; font-size: 14px;">
            Đã có tài khoản? 
            <a href="${pageContext.request.contextPath}/login" style="color: #007bff; text-decoration: none;">Đăng nhập ngay</a>
        </div>
    </div>
</body>