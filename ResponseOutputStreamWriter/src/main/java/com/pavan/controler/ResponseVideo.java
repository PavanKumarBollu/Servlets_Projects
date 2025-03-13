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


@WebServlet("/rvideo")
public class ResponseVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("video/mp4");
		
		
		File file = new File("D:\\FullStack_Development\\5_Code__Projects\\2_BackEnd\\4_Servlets\\ResponseOutputStreamWriter\\v.mp4");
		FileInputStream fis = new FileInputStream(file);
		
		byte[] b = new byte[(int) file.length()];
		fis.read(b);
		
		
		
		
		ServletOutputStream out = response.getOutputStream();
		
//		out.println("<html><head><title>Video Loading</title></head>");
//		out.println("<body<h1>Video Will be Loaded Below..</h1>");
//		out.println("<div style='height:500px; width:200px;'>");
		out.write(b);
//		out.println("</div></body></html>");
		
		
		out.flush();
		
		out.close();
		
		fis.close();
		
	}

}
