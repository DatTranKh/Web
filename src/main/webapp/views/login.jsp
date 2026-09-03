<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<form action="${pageContext.request.contextPath}/login" method="post">
    <h2>Đăng Nhập Vào Hệ Thống</h2>
    
    <c:if test="${alert != null}">
        <h3 class="alert alert-danger">${alert}</h3>
    </c:if>
    
    <section>
        <label class="input login-input">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                <input type="text" placeholder="Tài khoản" name="username" class="form-control" required>
            </div>
        </label>
    </section>
    
    <section>
        <label class="input login-input">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                <input type="password" placeholder="Mật khẩu" name="password" class="form-control" required>
            </div>
        </label>
    </section>
    
    <section>
        <div class="checkbox">
            <label>
                <input type="checkbox" name="remember"> Nhớ tôi
            </label>
        </div>
    </section>
    
    <button type="submit" class="btn btn-primary">Đăng nhập</button>
    
    <p>Nếu bạn chưa có tài khoản trên hệ thống, thì hãy <a href="${pageContext.request.contextPath}/register">Đăng ký</a></p>
</form>