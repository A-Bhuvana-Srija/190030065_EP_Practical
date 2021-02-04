import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentDAO {

	public int StudentInsert(StudentBean sb) throws ClassNotFoundException,SQLException{
		Connection con=DBUtil.DBConnection();
		String sql="insert into studentbean values(?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1,sb.getId());
		ps.setString(2,sb.getName());
		int i=ps.executeUpdate();
		return i;
	}

}