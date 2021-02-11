import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAO 
{
	
	public int registerInsert(RegistrationBean rb) throws ClassNotFoundException , SQLException 
	{
		Connection con = DBUtil.DBConnection();
		//prepared-Statements
		PreparedStatement ps = con.prepareStatement("insert into registrationbean values(?,?,?,?)");
		ps.setInt(1,rb.getId());
		ps.setString(2,rb.getName());
		ps.setString(3,rb.getEmail());
		ps.setString(4,rb.getPassword());
		int a=ps.executeUpdate();
		con.close();
		return a;
	}
	
	public int Feedback(FeedbackBean fb) throws ClassNotFoundException,SQLException
	{
		Connection con = DBUtil.DBConnection();
		String sql="insert into feedbackbean values(?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,fb.getQ1());
		ps.setString(2,fb.getQ2());
		ps.setString(3,fb.getQ3());
		ps.setString(4,fb.getQ4());
		ps.setString(5,fb.getQ5());
		ps.setString(6,fb.getRemarks());
		int i=ps.executeUpdate();
		return i;
		
	}
}