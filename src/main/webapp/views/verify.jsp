<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form action="${pageContext.request.contextPath}/verify" method="post">
    <h3>Nhập mã OTP đã được gửi qua email</h3>
    <input type="text" name="otp" required placeholder="Nhập 6 số OTP">
    <button type="submit">Xác thực</button>
</form>