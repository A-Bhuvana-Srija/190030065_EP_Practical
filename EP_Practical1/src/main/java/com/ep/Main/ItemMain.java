package com.ep.Main;

import java.sql.SQLException;
import java.util.Scanner;

import com.ep.Bean.ItemBean;
import com.ep.Insertion.ItemInsertion;
import com.ep.Display.ItemDisplay;
import com.ep.Display.TotalCostDisplay;

public class ItemMain 
{
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		ItemBean ib = new ItemBean();
		ItemInsertion ii = new ItemInsertion();
		ItemDisplay id = new ItemDisplay();
		TotalCostDisplay tcd = new TotalCostDisplay();

		while(true)
		{
			int n;
			System.out.println("Enter Your Choice : ");
			System.out.println("1. Insert An Item's Data");
			System.out.println("2. Display All The Item Details");
			System.out.println("3. Calculate The Total Cost");
			
			n = sc.nextInt();
			
			switch(n)
			{
			case 1 : 
				int IDNum;
				String name;
				double cost;
				System.out.println("Enter Item's ID : ");
				IDNum = sc.nextInt();
				System.out.println("Enter Item's Name : ");
				name = sc.next();
				System.out.println("Enter Item's Cost : ");
				cost = sc.nextDouble();
				ib.setId(IDNum);
				ib.setName(name);
				ib.setCost(cost);
				
				int i = ii.ItemInsert(ib);
				
				if(i > 0)
				{
					System.out.println("Insertion Successful!");
				}
				else
				{
					System.out.println("Please Try Again!");
				}
				break;
			case 2 :
				id.StudentDisplay(ib);
				break;
				
			case 3 :
				tcd.TotalCostDisplay(ib);
				break;
			}
		}
	}
}
