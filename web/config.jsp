<%-- 
    Document   : config
    Created on : May 2, 2019, 5:57:37 PM
    Author     : ADMIN
--%>

<%@page import="Model.Config_rate_objects"%>
<%@page import="Model.Config_rate_families"%>
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
            Config_rate_families lastConfig_rate_families = (Config_rate_families)request.getAttribute("lastConfig_rate_families");
            Config_rate_objects lastConfig_rate_objects = (Config_rate_objects)request.getAttribute("lastConfig_rate_objects");
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
        <a href="index.jsp"><< Quay lại trang chủ</a>
        <h1>Cấu hình lương cơ bản</h1>
        <form method="POST" action="addConfig" onsubmit="return registerInputCheck()"> 
            <div>
                Ngày bắt đầu : 
                <input type="date" name="BS_start_date" placeholder="YYYY-MM-DD"
                    <% if (lastConfigBaseSalary!=null) { %>value="<%=lastConfigBaseSalary.getStart_date()%>" <%}%>
                    autofocus="true" style="margin-left: 4px">
            </div>
            <div>
                Lương cơ bản :
                <input type="number" name="base_salary" placeholder=""
                    <% if (lastConfigBaseSalary!=null) { %>value="<%=lastConfigBaseSalary.getBase_salary()%>" <%}%>>
                (VND)
            </div>            
            <div>
                Cập nhật lần cuối lúc : <% if (lastConfigBaseSalary!=null) { %> <%= lastConfigBaseSalary.getUpdated_at() %> <% } %>
            </div>        
            
        <h1>Cấu hình hộ gia đình</h1>
        <table border="black">
            <tr>
                <th>Thành viên 1</th>
                <th>Thành viên 2</th>
                <th>Thành viên 3</th>
                <th>Thành viên 4</th>
                <th>Thành viên 5</th>
            </tr>
            <tr>
                <td><input type="number" name="member1" placeholder=""
                    <% if (lastConfig_rate_families!=null) { %>value="<%= lastConfig_rate_families.getMember1()*100 %>" <%}%>>%</td>
                <td><input type="number" name="member2" placeholder=""
                    <% if (lastConfig_rate_families!=null) { %>value="<%= lastConfig_rate_families.getMember2()*100 %>" <%}%>>%</td>
                <td><input type="number" name="member3" placeholder=""
                    <% if (lastConfig_rate_families!=null) { %>value="<%= lastConfig_rate_families.getMember3()*100 %>" <%}%>>%</td>
                <td><input type="number" name="member4" placeholder=""
                    <% if (lastConfig_rate_families!=null) { %>value="<%= lastConfig_rate_families.getMember4()*100 %>" <%}%>>%</td>
                <td><input type="number" name="member5" placeholder=""
                    <% if (lastConfig_rate_families!=null) { %>value="<%= lastConfig_rate_families.getMember5()*100 %>" <%}%>>%</td>
            </tr>
        </table>
            <div>
                Ngày bắt đầu :
                <input type="text" name="RF_start_date" placeholder="YYYY-MM-DD"
                    <% if (lastConfig_rate_families!=null) { %>value="<%=lastConfig_rate_families.getStart_date()%>" <%}%>>
            </div>
            <div>
                Cập nhật lần cuối lúc : <% if (lastConfig_rate_families!=null) { %> <%= lastConfig_rate_families.getUpdated_at() %> <% } %>
            </div> 
            <input type="submit" value="Cập nhật" ></input>
        </form>
    </body>
</html>
