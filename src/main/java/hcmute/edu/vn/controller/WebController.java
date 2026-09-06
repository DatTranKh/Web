package hcmute.edu.vn.controller;

import hcmute.edu.vn.dao.impl.ProductDaoImpl;
import hcmute.edu.vn.entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/home", "/product", "/product/detail"})
public class WebController extends HttpServlet {
    private ProductDaoImpl productDao = new ProductDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        if (path.equals("/home")) {
            // Lấy 10 sản phẩm mới nhất
            List<Product> top10 = productDao.getTop10Newest();
            req.setAttribute("topProducts", top10);
            req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
            
        } else if (path.equals("/product")) {
            // Phân trang 6 sp/trang
            int page = 1;
            int pageSize = 6;
            if (req.getParameter("page") != null) {
                page = Integer.parseInt(req.getParameter("page"));
            }
            
            int totalProducts = productDao.getTotalProducts();
            int endPage = totalProducts / pageSize;
            if (totalProducts % pageSize != 0) endPage++;

            List<Product> list = productDao.getProductsByPage(page, pageSize);
            req.setAttribute("productList", list);
            req.setAttribute("endPage", endPage);
            req.setAttribute("currentPage", page);
            
            req.getRequestDispatcher("/views/product-list.jsp").forward(req, resp);
            
        } else if (path.equals("/product/detail")) {
            // Chi tiết sản phẩm
            int id = Integer.parseInt(req.getParameter("id"));
            Product product = productDao.findById(id);
            req.setAttribute("product", product);
            req.getRequestDispatcher("/views/product-detail.jsp").forward(req, resp);
        }
    }
}