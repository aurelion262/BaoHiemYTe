<%-- 
    Document   : xemdanhsach
    Created on : Apr 25, 2019, 7:12:36 PM
    Author     : ADMIN
--%>

<%@page import="Model.Transaction"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh sách đóng bảo hiểm y tế</title>
    </head>
    <body>
        Loại danh sách :
        <select onchange="javascript:location.href = this.value;" onfocus="this.selectedIndex = -1">
            <option value="xemdanhsach?type=transaction">Danh sách giao dịch</option> 
            <option value="xemdanhsach?type=customer">Danh sách khách hàng</option>                       
        </select> 
        <%
            String type = request.getParameter("type");
            if(type==null) type="transaction";
            if(type==null || type.equals("transaction"))
            {
        %>
            <br>Tiêu chí tìm kiếm :
            <form method="POST" action="xemdanhsach?type=<%=type%>&searchMode=true">
                <select name="key">
                    <option value="customer_id">ID Khách hàng</option>                       
                </select>
                <input type="text" id="value" name="value">
                <input type="submit" value="Tìm">
            </form>
            <table border="black">
                <tr>
                    <th>ID</th>
                    <th>Mã khách hàng</th>
                    <th>Số tiền thanh toán</th>
                    <th>Số tiền hỗ trợ</th>
                </tr>
                <%
                    for(Transaction t : (ArrayList<Transaction>)request.getAttribute("transactionList"))
                    {
                %>
                    <tr>
                        <td><%= t.getId() %></td>
                        <td><%= t.getCustomer_id() %></td>
                        <td><%= t.getPaid() %></td>
                        <td><%= t.getPaid() %></td>
                    </tr>
                <%
                    }
                %>
            </table>
        <%
            }
            else
            {
        %>
            <br>Tiêu chí tìm kiếm :
            <form method="POST" action="xemdanhsach?type=<%=type%>&searchMode=true">
                <select name="key">
                    <option value="id">ID Khách hàng</option>     
                    <option value="code_BHXH">Mã BHXH</option> 
                    <option value="name">Tên khách hàng</option> 
                    <option value="addr">Địa chỉ</option>
                </select>
                <input type="text" id="value" name="value">
                <input type="submit" value="Tìm">
            </form>
            <table border="black">
                <tr>
                    <th>ID</th>
                    <th>Họ tên</th>
                    <th>Ngày sinh</th>
                    <th>Giới tính</th>
                    <th>Địa chỉ</th>
                    <th>Mã BHYT</th>
                    <th>SĐT</th>
                    <th>Số CMND/Hộ chiếu/Thẻ căn cước</th>
                    <th>Mã số hộ gia đình</th>
                </tr>
                <%
                    for(Customer c : ((ArrayList<Customer>)request.getAttribute("customerList")))
                    {
                %>
                    <tr>
                        <td><%= c.getId() %></td>
                        <td><%= c.getName() %></td>
                        <td><%= c.getBirthday() %></td>
                        <td><%= c.getGender() %></td>
                        <td><%= c.getAddr() %></td>
                        <td><%= c.getCode_BHXH() %></td>
                        <td><%= c.getPhone() %></td>
                        <td><%= c.getCard_id() %></td>
                        <td><%= c.getFamilies_id() %></td>
                    </tr>
                <%
                    }
                %>
            </table>
        <%
            }
        %>
    </body>
</html>
