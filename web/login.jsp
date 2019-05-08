<%-- 
    Document   : login
    Created on : Apr 23, 2019, 10:31:24 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="BHYT.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng nhập</title>
    </head>
    <body>
    <%
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        if(session.getAttribute("account")==null)
        {
    %>    
        <div class="style_center">
            <form method="POST" action="login">
                <div class="style_center">Tài khoản</div>
                <input class="style_center" type="text" name="username" placeholder="Tài khoản" autofocus="true">
                <div class="style_center">Mật khẩu</div>
                <input class="style_center" type="password" name="password" placeholder="Mật khẩu">
                <div></div>
                <input class="style_center" type="submit" value="Đăng nhập"></input>
            </form>
            <div class="style_center">
                <%if(request.getAttribute("message")!=null) out.print(request.getAttribute("message"));%>
            </div>
        </div>        
    <%
        }
        else
        {
            response.sendRedirect("index.jsp");
        }
    %>
    </body>
</html>
