<%-- 
    Document   : makeReport
    Created on : May 8, 2019, 5:23:44 PM
    Author     : ADMIN
--%>

<%@page import="Model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="BHYT.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Xuất báo cáo</title>
    </head>
    <body>
        <%
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        if(session.getAttribute("account")==null) response.sendRedirect("index.jsp");
//        else if(((Account)session.getAttribute("account")).getRole()!=1) response.sendRedirect("index.jsp");
    %>   
    <a href="index.jsp"><< Quay lại trang chủ</a>
        <div class="style_center">
            <h1>Xuất báo cáo</h1>
        </div>
        <form action="makeReport" method="GET">
            <div class="style_center">Nhập thời điểm bắt đầu : <input type="date" name="begin_date"></div>
            <div class="style_center">Nhập thời điểm kết thúc : <input type="date" name="end_date"></div>
            <div class="style_center"><input type="submit" value="Tải báo cáo"></div>
        </form>        
    </body>
</html>
