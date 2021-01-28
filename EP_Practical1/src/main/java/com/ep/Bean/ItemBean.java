package com.ep.Bean;

public class ItemBean 
{
	//members
		private String name;
		private double cost;
		private int id;
		
		//constructor
		public ItemBean()
		{
			this.id = id;
			this.name = name;
			this.cost = cost;
		}
		
		//getters and setters
		//for name
		public void setName(String name)
		{
			this.name = name;
		}
		public String getName()
		{
			return name;
		}
		
		//for id
		public void setId(int id)
		{
			this.id = id;
		}
		public int getId()
		{
			return id;
		}
		
		//for cost
		public void setCost(double cost)
		{
			this.cost = cost;
		}
		public double getCost()
		{
			return cost;
		}

}
