package hcmute.edu.vn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import hcmute.edu.vn.entity.User;
import hcmute.edu.vn.service.UserService;
import hcmute.edu.vn.service.impl.UserServiceImpl;
import hcmute.edu.vn.util.Constant;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/logout")
public class LogoutController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (Constant.COOKIE_REMEMBER.equals(cookie.getName())) {
                    cookie.setMaxAge(0); 
                    cookie.setPath("/"); 
                    resp.addCookie(cookie);
                    break;
                }
            }
        }
        
        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
