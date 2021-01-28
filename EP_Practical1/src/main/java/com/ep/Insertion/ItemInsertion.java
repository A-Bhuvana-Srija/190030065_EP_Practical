package com.ep.Insertion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ep.Bean.ItemBean;
import com.ep.Connection.DBUtil;

public class ItemInsertion 
{
	public int ItemInsert(ItemBean item) throws ClassNotFoundException, SQLException
	{
		Connection con1 = DBUtil.DBConnection();
		
		//PREPAREDSTATEMENTS
		// the mysql insert statement
	      String query = " insert into ItemBean (ItemID, ItemName, ItemCost)" + " values (?, ?, ?)";
	      
	      // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = con1.prepareStatement(query);
	      
	      preparedStmt.setInt (1, item.getId());
	      preparedStmt.setString (2, item.getName());
	      preparedStmt.setDouble  (3, item.getCost());
	      
	      // execute the preparedstatement
	      int n = preparedStmt.executeUpdate();
	      
	      con1.close();
	     
		return n;
	}

}
