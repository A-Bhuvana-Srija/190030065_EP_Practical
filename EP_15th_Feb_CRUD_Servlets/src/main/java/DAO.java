import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.SQLException;
public class DAO 
{
	public int StudentInsert(Bean sb) throws ClassNotFoundException,SQLException
	{
		Connection con=DBUtil.DBconnection();
		String sql="insert into crud_servlet_student values(?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1,sb.getRegno());
		ps.setString(2,sb.getName());
		ps.setString(3,sb.getEmail());;
		int i=ps.executeUpdate();
		return i;
		
	}
	public  int Studentupdation(Bean b) throws ClassNotFoundException, SQLException
	{
		Connection con=DBUtil.DBconnection();		
		PreparedStatement stmt=con.prepareStatement("update crud_servlet_student set name=? where id=?");  
		stmt.setString(1,b.getName());
		stmt.setInt(2,b.getRegno());
		int u=stmt.executeUpdate();  
		return u;
	}
	public  int StudentDelete(int id) throws ClassNotFoundException, SQLException
	{
		Connection con=DBUtil.DBconnection();		
		PreparedStatement stmt=con.prepareStatement("delete from crud_servlet_student where id=?");  
		stmt.setInt(1,id);
		int u=stmt.executeUpdate();  
		con.close();
		return u;
	}
}
