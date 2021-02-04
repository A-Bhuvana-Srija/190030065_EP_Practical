import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterServlet() 
    {
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("id"));
		int year = Integer.parseInt(request.getParameter("year"));
		int sec = Integer.parseInt(request.getParameter("section"));
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		RegistrationBean rb = new RegistrationBean();
		rb.setName(name);
		rb.setId(id);
		rb.setYear(year);
		rb.setSection(sec);
		rb.setEmail(email);
		rb.setPassword(password);
		
		DAO dao = new DAO();
		try 
		{
			int i = dao.registerInsert(rb);
			if(i>0) 
			{
				PrintWriter pw = response.getWriter();
				pw.print(id + "  "+ name);
			}
			else {
				PrintWriter pw = response.getWriter();
				pw.print("");
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
