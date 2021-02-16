import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/update") 
public class update extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int id=Integer.parseInt(request.getParameter("regno"));
		String sname=request.getParameter("name"); 
		Bean b=new Bean();
		b.setRegno(id);
		b.setName(sname);
		PrintWriter pw=response.getWriter();
		PrintWriter out = response.getWriter();
		DAO dao = new DAO();
		try 
		{
			int i=dao.Studentupdation(b);
			if(i>0) 
			{
				out.println("<html><head><style>\r\n"
				   		+ "html {\r\n"
				   		+ "	height: 100%;\r\n"
				   		+ "}\r\n"
				   		+ "\r\n"
				   		+ "body {\r\n"
				   		+ "	margin: 0;\r\n"
				   		+ "}\r\n"
				   		+ "\r\n"
				   		+ ".bg {\r\n"
				   		+ "	animation: slide 3s ease-in-out infinite alternate;\r\n"
				   		+ "	background-image: linear-gradient(-60deg, #6c3 50%, #09f 50%);\r\n"
				   		+ "	bottom: 0;\r\n"
				   		+ "	left: -50%;\r\n"
				   		+ "	opacity: .5;\r\n"
				   		+ "	position: fixed;\r\n"
				   		+ "	right: -50%;\r\n"
				   		+ "	top: 0;\r\n"
				   		+ "	z-index: -1;\r\n"
				   		+ "}\r\n"
				   		+ "\r\n"
				   		+ ".bg2 {\r\n"
				   		+ "	animation-direction: alternate-reverse;\r\n"
				   		+ "	animation-duration: 4s;\r\n"
				   		+ "}\r\n"
				   		+ "\r\n"
				   		+ ".bg3 {\r\n"
				   		+ "	animation-duration: 5s;\r\n"
				   		+ "}\r\n"
				   		+ "\r\n"
				   		+ ".content {\r\n"
				   		+ "	background-color: rgba(255, 255, 255, .8);\r\n"
				   		+ "	border-radius: .25em;\r\n"
				   		+ "	box-shadow: 0 0 .25em rgba(0, 0, 0, .25);\r\n"
				   		+ "	box-sizing: border-box;\r\n"
				   		+ "	left: 50%;\r\n"
				   		+ "	padding: 10vmin;\r\n"
				   		+ "	position: fixed;\r\n"
				   		+ "	text-align: center;\r\n"
				   		+ "	top: 50%;\r\n"
				   		+ "	transform: translate(-50%, -50%);\r\n"
				   		+ "}\r\n"
				   		+ "\r\n"
				   		+ "h1 {\r\n"
				   		+ "	font-family: monospace;\r\n"
				   		+ "}\r\n"
				   		+ "\r\n"
				   		+ "@keyframes slide \r\n"
				   		+ "{ \r\n"
				   		+ "0% \r\n"
				   		+ "{\r\n"
				   		+ "	transform: translateX(-25%);\r\n"
				   		+ "}\r\n"
				   		+ "100%\r\n"
				   		+ "{\r\n"
				   		+ "transform:translateX(25%);\r\n"
				   		+ "}\r\n"
				   		+ "}\r\n"
				   		+ ".button \r\n"
				   		+ "{\r\n"
				   		+ "	border-radius: 4px;\r\n"
				   		+ "	background-color: blue;\r\n"
				   		+ "	border: none;\r\n"
				   		+ "	color: white;\r\n"
				   		+ "	text-align: center;\r\n"
				   		+ "	font-size: 28px;\r\n"
				   		+ "	padding: 20px;\r\n"
				   		+ "	width: 200px;\r\n"
				   		+ "	transition: all 0.5s;\r\n"
				   		+ "	cursor: pointer;\r\n"
				   		+ "	margin: 5px;\r\n"
				   		+ "}\r\n"
				   		+ "\r\n"
				   		+ ".button span {\r\n"
				   		+ "	cursor: pointer;\r\n"
				   		+ "	display: inline-block;\r\n"
				   		+ "	position: relative;\r\n"
				   		+ "	transition: 0.5s;\r\n"
				   		+ "}\r\n"
				   		+ "\r\n"
				   		+ ".button span:after {\r\n"
				   		+ "	content: '\\00bb';\r\n"
				   		+ "	position: absolute;\r\n"
				   		+ "	opacity: 0;\r\n"
				   		+ "	top: 0;\r\n"
				   		+ "	right: -20px;\r\n"
				   		+ "	transition: 0.5s;\r\n"
				   		+ "}\r\n"
				   		+ "\r\n"
				   		+ ".button:hover span {\r\n"
				   		+ "	padding-right: 25px;\r\n"
				   		+ "}\r\n"
				   		+ "\r\n"
				   		+ ".button:hover span:after {\r\n"
				   		+ "	opacity: 1;\r\n"
				   		+ "	right: 0;\r\n"
				   		+ "}\r\n"
				   		+ "\r\n"
				   		+ "h2 {\r\n"
				   		+ "	font-size: 50px;\r\n"
				   		+ "	color: blue;\r\n"
				   		+ "}\r\n"
				   		+ "\r\n"
				   		+ "p {\r\n"
				   		+ "	font-size: 24px;\r\n"
				   		+ "	font-family: \"Times New Roman\", Times, serif;\r\n"
				   		+ "}\r\n"
				   		+ "\r\n"
				   		+ "box1 {\r\n"
				   		+ "	background-color: linear-gradient(yellow, white);\r\n"
				   		+ "}\r\n"
				   		+ "</style></head>");
			   out.println("<body>");
			   out.println("<div class=\"bg\"></div>\r\n"
			   		+ "	<div class=\"bg bg2\"></div>\r\n"
			   		+ "	<div class=\"bg bg3\"></div>\r\n"
			   		+ "	<h2 align=\"center\" style='color: Blue'>Display Page</h2>\r\n"
			   		+ "	<div class=\"box1\">");
				pw.print("<center> <p>Record is Updated successfully!</p> </center>");  
				pw.print("<center> <a href='view'><input type = 'submit' value = 'TAP HERE TO VIEW THE UPDATED DETAILS'></a> </center>");
			}
			else 
			{
				pw.print("<p>Oops! Record is Not Updated!</p>");  	
			}
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
