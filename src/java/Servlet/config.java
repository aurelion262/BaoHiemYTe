/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlet;

import Model.Account;
import Model.Config_BaseSalary;
import Model.Config_rate_families;
import Model.Config_rate_objects;
import Model.DAO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name="config", urlPatterns={"/config"})
public class config extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Account sessionAccount = (Account)session.getAttribute("account");       
        
        if(sessionAccount==null)
        {
            response.sendRedirect("index.jsp");
        }
        else if(sessionAccount.getRole()!=1)
        {
            response.sendRedirect("index.jsp");
        }
        else
        {
            DAO dao = new DAO();
            Config_BaseSalary lastConfigBaseSalary = dao.getLastConfig_BaseSalary();
            Config_rate_families lastConfig_rate_families = dao.getLastConfig_rate_families();
            Config_rate_objects lastConfig_rate_objects = dao.getLastConfig_rate_objects();
            request.setAttribute("lastConfigBaseSalary", lastConfigBaseSalary);
            request.setAttribute("lastConfig_rate_families", lastConfig_rate_families);
            request.setAttribute("lastConfig_rate_objects", lastConfig_rate_objects);
            RequestDispatcher dpc = request.getRequestDispatcher("config.jsp");
            dpc.forward(request, response);
            dao.close();
        }
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    }
}
