<%-- 
    Document   : config
    Created on : May 2, 2019, 5:57:37 PM
    Author     : ADMIN
--%>

<%@page import="Model.Config_BaseSalary"%>
<%@page import="Model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thiết lập cấu hình</title>
    </head>
    <body>
        <%
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            Account sessionAccount = (Account)session.getAttribute("account");
            Config_BaseSalary lastConfigBaseSalary = (Config_BaseSalary)request.getAttribute("lastConfigBaseSalary");            
        %>        
        <%            
            if(sessionAccount == null)
            {
                response.sendRedirect("login.jsp");
            }
            else if(sessionAccount.getRole()!=1)
            {
                response.sendRedirect("index.jsp");
            }
        %>
        <h1>Cấu hình lương cơ bản</h1>
        <form method="POST" action="updateConfig?configType=basesalary" onsubmit="return registerInputCheck()"> 
            <div>
                Ngày bắt đầu :
                <input type="text" name="start_date" placeholder="YYYY-MM-DD"
                    <% if (lastConfigBaseSalary!=null) { %>value="<%=lastConfigBaseSalary.getStart_date()%>" <%}%>>
            </div>
            <div>
                Lương cơ bản :
                <input type="text" name="base_salary" placeholder=""
                    <% if (lastConfigBaseSalary!=null) { %>value="<%=lastConfigBaseSalary.getBase_salary()%>" <%}%>>
                (VND)
            </div>            
            <div>
                Cập nhật lần cuối lúc : <% if (lastConfigBaseSalary!=null) { %> <%= lastConfigBaseSalary.getUpdated_at() %> <% } %>
            </div>        
            
        <h1>Cấu hình hộ gia đình</h1>
        <table>
            <tr>
                <th>Thành viên 1</th>
                <th>Thành viên 2</th>
                <th>Thành viên 3</th>
                <th>Thành viên 4</th>
            </tr>
            <tr>
                
            </tr>
        </table>
            <input type="submit" value="Cập nhật" ></input>
        </form>
    </body>
</html>
