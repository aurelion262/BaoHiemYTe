/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlet;

import Model.Account;
import Model.Customer;
import Model.DAO;
import Model.Transaction;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name="xemdanhsach", urlPatterns={"/xemdanhsach"})
public class xemdanhsach extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doPost(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        //type : loại tìm kiếm. Nếu lúc search chọn khách hàng thì type là "customer", chọn giao dịch thì là "transaction"
        String type = request.getParameter("type");
        //searchMode : true hoặc false. True nếu trang này được điều hướng tới sau khi người dùng bấm nút tìm kiếm
        String searchMode = request.getParameter("searchMode");
        //key : tên của trường (cột) muốn tìm theo
        String key = request.getParameter("key");
        //value : giá trị của key(trường/cột) muốn tìm kiếm
        String value = request.getParameter("value");
        
        Account sessionAccount = (Account)session.getAttribute("account");       
        
        if(sessionAccount==null)
        {
            response.sendRedirect("index.jsp");
//            response.sendRedirect(request.getHeader("Referer"));
        }
        else
        {
            DAO dao = new DAO();
            if(type == null)
            {
                if(searchMode==null)
                {
                    ArrayList<Transaction> transactionList = dao.getAllTransaction();            
                    request.setAttribute("transactionList", transactionList);
                }
                else
                {
                    ArrayList<Transaction> transactionList = dao.getTransactionByString(key, value);
                    request.setAttribute("transactionList", transactionList);
                }
            }
            else
            {
                if(type.equals("transaction"))
                {
                    if(searchMode==null)
                    {
                        ArrayList<Transaction> transactionList = dao.getAllTransaction();            
                        request.setAttribute("transactionList", transactionList);
                    }
                    else
                    {
                        ArrayList<Transaction> transactionList = dao.getTransactionByString(key, value);
                        request.setAttribute("transactionList", transactionList);
                    }
                }
                else
                {
                    if(searchMode==null)
                    {
                        ArrayList<Customer> customerList = dao.getAllCustomer();            
                        request.setAttribute("customerList", customerList);    
                    }
                    else
                    {
                        ArrayList<Customer> customerList = dao.getCustomerByString(key, value);
                        request.setAttribute("customerList", customerList);
                    }
                }
            }
            RequestDispatcher dpc = request.getRequestDispatcher("xemdanhsach.jsp");
            dpc.forward(request, response);
            dao.close();
        }
    }
}
