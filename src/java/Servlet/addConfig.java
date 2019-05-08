/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlet;

import Model.Account;
import Model.Config_BaseSalary;
import Model.Config_rate_families;
import Model.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
@WebServlet(name="addConfig", urlPatterns={"/addConfig"})
public class addConfig extends HttpServlet {
    
    public String getDateTime()
    {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
            String timeStamp = getDateTime();
            
            Config_BaseSalary config_baseSalary = new Config_BaseSalary();
            config_baseSalary.setBase_salary((Long.parseLong(request.getParameter("base_salary"))/1000)*1000);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            try
            {
            Date BS_start_date = new Date(df.parse(request.getParameter("BS_start_date")).getTime());
            config_baseSalary.setStart_date(BS_start_date);  
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
                      
            config_baseSalary.setUpdated_at(Timestamp.valueOf(LocalDateTime.now()));
            dao.addConfig_BaseSalary(config_baseSalary);
            
            Config_rate_families config_rate_families = new Config_rate_families();
            config_rate_families.setMember1(Double.parseDouble(request.getParameter("member1"))/100);
            config_rate_families.setMember2(Double.parseDouble(request.getParameter("member2"))/100);
            config_rate_families.setMember3(Double.parseDouble(request.getParameter("member3"))/100);
            config_rate_families.setMember4(Double.parseDouble(request.getParameter("member4"))/100);
            config_rate_families.setMember5(Double.parseDouble(request.getParameter("member5"))/100);
            
            try{
                Date RF_start_date = new Date(df.parse(request.getParameter("RF_start_date")).getTime());
                config_rate_families.setStart_date(RF_start_date);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
            config_rate_families.setUpdated_at(Timestamp.valueOf(LocalDateTime.now()));
            dao.addConfig_rate_families(config_rate_families);
            
            dao.close();
            
            response.sendRedirect("config");
        }
    }
}
