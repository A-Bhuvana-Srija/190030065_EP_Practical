import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentInsert")
public class StudentInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public StudentInsert() {
    }	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("regno"));//are Strings
		String sname=request.getParameter("name");
		StudentBean sb=new StudentBean();
		sb.setId(id);
		sb.setName(sname);
		PrintWriter pw=response.getWriter();//from servelts  to client
		pw.print(id+" "+sname);
		StudentDAO dao = new StudentDAO();
		try {
			int i=dao.StudentInsert(sb);
			System.out.println(i);
			if(i>0) {
				RequestDispatcher rd=request.getRequestDispatcher("StudentDisplay"); 
				request.setAttribute("studentbean",sb);
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("error.html");
				rd.include(request, response);
			}
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//sb have details of client
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


}
