import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FeedbackDisplay
 */
@WebServlet("/FeedbackDisplay")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		FeedbackBean fb=(FeedbackBean) request.getAttribute("feedbackbean");
		PrintWriter pw=response.getWriter();
		pw.println("STUDENT FEEDBACK DETAILS\n");
		pw.print("\n");
		pw.println("Language Skills : " + fb.getQ1());
		pw.print("\n");
		pw.println("Technical Skills : " + fb.getQ2());
		pw.print("\n");
		pw.println("Mentoring Skills : " + fb.getQ3());
		pw.print("\n");
		pw.println("Punctuality Skills : " + fb.getQ4());
		pw.print("\n");
		pw.println("Empathetic Skills : " + fb.getQ5());
		pw.print("\n");
		if(fb.getRemarks() == null || fb.getRemarks() == "")
		{
			pw.print("No Remarks!");
		}
		else
		{
			pw.println("Remarks : " + fb.getRemarks());
			pw.print("\n");
		}
	}

}