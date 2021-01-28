package com.ep.Display;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ep.Bean.ItemBean;
import com.ep.Connection.DBUtil;

public class TotalCostDisplay 
{
	public void TotalCostDisplay(ItemBean item) throws ClassNotFoundException, SQLException
	{
		Connection con1 = DBUtil.DBConnection();
		
		//PREPAREDSTATEMENTS
		// the mysql display statement
	      String query = " select sum(ItemCost) from ItemBean";
		
	    // create the mysql display preparedstatement
	      PreparedStatement stmt = con1.prepareStatement(query);	      
	      
	    // execute the preparedstatement
	      ResultSet rs = stmt.executeQuery();
	      
	      while(rs.next())
	      {
	    	  System.out.println("The Total Cost Is : " + rs.getDouble(1) + " ");
	      }
	     
		con1.close();
	}

}
