<%-- 
    Document   : index
    Created on : Apr 25, 2019, 3:21:12 PM
    Author     : ADMIN
--%>

<%@page import="Model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang chủ</title>
    </head>
    <body>
        <%
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            Account sessionAccount = (Account)session.getAttribute("account");
        %>        
        <%
            if(sessionAccount!=null)
            {
        %>            
            <p>Hello <%= sessionAccount.getUsername() %><a href="logout">(Đăng xuất)</a></p>
            <br><a href="xemdanhsach">Theo dõi danh sách</a>
            <br><a href="">Xuất báo cáo</a>
            <br><a href="config">Cấu hình</a>
        <%
            }
            else
            {
        %>
        <div>
            <br><a href="login.jsp">Đăng nhập</a>
        </div>
        <%
            }
        %>
    </body>
</html>
