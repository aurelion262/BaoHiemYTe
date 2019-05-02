/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlet;

import Model.Account;
import Model.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
@WebServlet(name="login", urlPatterns={"/login"})
public class login extends HttpServlet {

    public static String convertByteToHex1(byte[] data)
    {
        BigInteger number = new BigInteger(1, data);
        String hashtext = number.toString(16);
        while (hashtext.length() < 32)
        {
            hashtext = "0" + hashtext;
        }
        return hashtext;
    }
    
    //Trả về mã MD5 tương ứng với tham số là chuỗi input
    public static String getMD5(String input)
    {
        try
        {
          MessageDigest md = MessageDigest.getInstance("MD5");
          byte[] messageDigest = md.digest(input.getBytes());
          return convertByteToHex1(messageDigest);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    } 

    //Thực hiện kiểm tra thông tin đăng nhập xem có ứng với tài khoản nào trong db không
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");     
        HttpSession session = request.getSession();
        if(session.getAttribute("account")!=null)
        {
              response.sendRedirect("index.jsp");
//            response.sendRedirect(request.getHeader("Referer"));
        }
        else
        {
            DAO dao = new DAO();
            String username = (String)request.getParameter("username");
            String password = (String)request.getParameter("password");
            //mã hóa pass
            String passwordMD5 = getMD5(password);
            
            //tìm kiếm trong db, nếu thấy trả lại account tương ứng, nếu không trả lại null
            Account a = dao.getAccount(username, passwordMD5);
            
            //nếu tìm thấy
            if(a!=null)
            {
                //Thêm vào session một attribute tên "account", với giá trị của attribute là Account a vừa lấy được từ db
                session.setAttribute("account", a);
                //điều hướng về trang chủ
                response.sendRedirect("index.jsp");
//                RequestDispatcher dpc = request.getRequestDispatcher("index");
//                dpc.forward(request, response);
            }       
            //nếu không tìm thấy
            else
            {
//                request.setAttribute("message","Nhập sai tên tài khoản/mật khẩu. Vui lòng nhập lại !");
                //Điều hướng trờ lại trang login
                RequestDispatcher dpc = request.getRequestDispatcher("login.jsp");
                dpc.forward(request, response);
            }
            dao.close();
        }
    }
}
