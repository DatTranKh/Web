<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<head>
    <title>Cập nhật Profile</title>
</head>
<body>
    <h2>Thông tin cá nhân</h2>
    
    <c:if test="${param.success == 'true'}">
        <div style="color: green;">Cập nhật hồ sơ thành công!</div>
    </c:if>
    <c:if test="${param.error == 'true'}">
        <div style="color: red;">Có lỗi xảy ra, vui lòng thử lại.</div>
    </c:if>

    <!-- Lưu ý: Cần enctype="multipart/form-data" để upload file -->
    <form action="${pageContext.request.contextPath}/profile" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${user.id}">
        
        <div>
            <label>Họ và tên:</label>
            <input type="text" name="fullname" value="${user.fullname}" required>
        </div>
        
        <div>
            <label>Số điện thoại:</label>
            <input type="text" name="phone" value="${user.phone}">
        </div>
        
        <div>
            <label>Ảnh đại diện hiện tại:</label><br>
            <c:if test="${not empty user.images}">
                <!-- Cần một controller phụ (như DownloadImageController) để hiển thị ảnh từ ổ E -->
                <img src="${pageContext.request.contextPath}/image?fname=${user.images}" alt="Avatar" width="150">
            </c:if>
            <c:if test="${empty user.images}">
                <p>Chưa có ảnh đại diện</p>
            </c:if>
        </div>
        
        <div>
            <label>Chọn ảnh đại diện mới:</label>
            <!-- Name 'imageFile' phải khớp với request.getPart("imageFile") trong Controller -->
            <input type="file" name="imageFile" accept="image/*">
        </div>
        
        <button type="submit">Cập nhật thông tin</button>
    </form>
</body>