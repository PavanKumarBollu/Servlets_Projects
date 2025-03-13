package com.pavan.controler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/oswt")
public class OutputStreamWriterTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("image/jpg");
		File file = new File("D:\\FullStack_Development\\5_Code__Projects\\2_BackEnd\\4_Servlets\\ResponseOutputStreamWriter\\pavan.jpg");
		FileInputStream fileInputStream = new FileInputStream(file);
		
		
		byte[] b = new byte[(int) file.length()];
		fileInputStream.read(b);
		
		ServletOutputStream out = response.getOutputStream();
//		out.println("<div style='height:500px; width:500px;'>");
		out.write(b);
//		out.println("</div");
	
		out.flush();
		out.close();
		fileInputStream.close();
		
	}

}
