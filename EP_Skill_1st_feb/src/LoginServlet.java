

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email=request.getParameter("email");//are Strings
		String password=request.getParameter("password");
		
		LoginBean sb=new LoginBean();
		
		sb.setEmail(email);
		sb.setPassword("password");
		
		DAO dao = new DAO();
		try
		{
				Connection con = DBUtil.DBConnection();		
				PreparedStatement ps = con.prepareStatement("select email,password from registrationbean where email = ? and password = ?");
				ps.setString(1,email);
	            ps.setString(2,password);
	            ResultSet rs = ps.executeQuery();
	            String dbemail,dbpassword;
				
				if(rs.next()) 
				{
					dbemail = rs.getString("email");
					dbpassword = rs.getString("password");
					
				
					if (email.equals(dbemail) && password.equals(dbpassword)) 
					{
						RequestDispatcher rd = request.getRequestDispatcher("feedbackform.html");
						rd.include(request,response);

						PrintWriter pw=response.getWriter();//from servelts  to client
						pw.print("YOU'VE ENTERED YOUR EMAIL AS : " + email + " AND PASSWORD AS : " + password);
						pw.print("\n");
					}
				}
				else 
				{
					PrintWriter pw=response.getWriter();
					pw.write("Invalid Credentials! Please Try Again!\n");				
				}
				con.close();
			
		}
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//sb have details of client
	}

}
