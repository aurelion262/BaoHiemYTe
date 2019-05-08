/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlet;

import Model.DAO;
import Model.Transaction;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
@WebServlet(name="makeReport", urlPatterns={"/makeReport"})
public class makeReport extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try
        {
        DAO dao = new DAO();
        request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "attachment; filename=mtfk.pdf");
        String begin_date_string, end_date_string;
        begin_date_string = request.getParameter("begin_date");
        end_date_string = request.getParameter("end_date");
        Date begin_date, end_date;
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");        
        begin_date = new Date(df.parse(begin_date_string).getTime());
        end_date = new Date(df.parse(end_date_string).getTime());            
                  
        ArrayList<Transaction> transactionList = dao.getTransactionByRange("created_at", new Timestamp(begin_date.getTime()), new Timestamp(end_date.getTime()));
        long transactionCount = transactionList.size();
        BigInteger totalPaid = new BigInteger("0"), totalSupport = new BigInteger("0");
        for(Transaction t : transactionList)
        {
            totalPaid = totalPaid.add(new BigInteger(String.valueOf(t.getPaid())));
            totalSupport = totalSupport.add(new BigInteger(String.valueOf(t.getSupport())));
        }
                
        OutputStream os = response.getOutputStream();		
	Document document = new Document();        
            PdfWriter.getInstance(document, os);
            document.open();
            BaseFont bf = BaseFont.createFont("c:/windows/fonts/ARIAL.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

            Font font = new Font(bf,20f,Font.BOLD,BaseColor.BLACK);
            Font fontContent = new Font(bf,14f,Font.NORMAL,BaseColor.BLACK);
            Paragraph paragraph = new Paragraph();
            paragraph.add(new Phrase("BÁO CÁO GIAO DỊCH BẢO HIỂM Y TẾ",font)); 
            paragraph.setAlignment(Element.ALIGN_CENTER);
            paragraph.add(new Phrase(Chunk.NEWLINE));
            paragraph.add(new Phrase(Chunk.NEWLINE));
            paragraph.add(new Phrase(Chunk.NEWLINE));
            document.add(paragraph);
            Paragraph paragraph1 = new Paragraph();
            paragraph1.add(new Phrase("Khoảng thời gian : " + begin_date_string + " - " + end_date_string,fontContent));  
            paragraph1.add(new Phrase(Chunk.NEWLINE));
            paragraph1.add(new Phrase("Tổng số giao dịch : " + transactionCount,fontContent));
            paragraph1.add(new Phrase(Chunk.NEWLINE));
            paragraph1.add(new Phrase("Tổng số tiền thanh toán : " + totalPaid.toString() + " VNĐ",fontContent));
            paragraph1.add(new Phrase(Chunk.NEWLINE));
            paragraph1.add(new Phrase("Tổng số tiền hỗ trợ : " + totalSupport.toString() + " VNĐ",fontContent));          
            document.add(paragraph1);
            document.close();        
        dao.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }
}
