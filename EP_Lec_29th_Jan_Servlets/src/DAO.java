import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAO 
{
	
	public int registerInsert(RegistrationBean rb) throws ClassNotFoundException , SQLException 
	{
		Connection con = DBUtil.DBConnection();
		//prepared-Statements
		PreparedStatement ps = con.prepareStatement("insert into registrationbean values(?,?,?,?,?,?)");
		ps.setInt(1,rb.getId());
		ps.setString(2,rb.getName());
		ps.setString(3,rb.getEmail());
		ps.setString(4,rb.getPassword());
		ps.setInt(5,rb.getSection());
		ps.setInt(6,rb.getYear());
		int a=ps.executeUpdate();
		con.close();
		return a;
	}

}