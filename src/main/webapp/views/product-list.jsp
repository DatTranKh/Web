<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<div class="row">
    <c:forEach items="${productList}" var="p">
        <div class="col-md-4">
            <!-- Link tới trang chi tiết -->
            <a href="${pageContext.request.contextPath}/product/detail?id=${p.productId}">
                <img src="${pageContext.request.contextPath}/image?fname=${p.images}" style="width: 100%; height: 200px;">
                <h4>${p.productName}</h4>
            </a>
            <p>Giá: ${p.price}</p>
        </div>
    </c:forEach>
</div>

<!-- Nút chuyển trang -->
<div class="pagination">
    <c:forEach begin="1" end="${endPage}" var="i">
        <a href="${pageContext.request.contextPath}/product?page=${i}" 
           style="${currentPage == i ? 'font-weight:bold; color:red;' : ''}">[ ${i} ]</a>
    </c:forEach>
</div>