package com.ep.Display;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ep.Bean.ItemBean;
import com.ep.Connection.DBUtil;

public class ItemDisplay 
{
	public void StudentDisplay(ItemBean item) throws ClassNotFoundException, SQLException
	{
		Connection con1 = DBUtil.DBConnection();
		
		//PREPAREDSTATEMENTS
		// the mysql display statement
	      String query = " select * from ItemBean";
		
	    // create the mysql display preparedstatement
	      PreparedStatement stmt = con1.prepareStatement(query);	      
	      
	    // execute the preparedstatement
	      ResultSet rs = stmt.executeQuery();
	      
	      while(rs.next())
	      {
	    	  System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getDouble(3) + " ");
	      }
	     
		con1.close();
	}

}
