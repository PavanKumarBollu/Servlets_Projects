package com.pavan.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/img")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("image/jpg");
		
		File file = new File("\"D:\\WallPapers\\Screenshot (1).png\"");
		FileInputStream fileInputStream = new FileInputStream(file);
		
		byte[] b = new byte[(int)file.length()];
		fileInputStream.read(b);
		
		ServletOutputStream outputStream = response.getOutputStream();
		outputStream.write(b);
		
		outputStream.flush();
		outputStream.close();
		fileInputStream.close();
	}

}
