package com.project.RealTicker.model;

public class StockModel 
{
	private String ticker;
	private String company;
	private double price;
	private double change;
	private long volume;
	

    //Constructor	
	public StockModel(String ticker,String company,double price,double change,long volume)
	{
		this.ticker=ticker;
		this.company=company;
		this.price=price;
		this.change=change;
		this.volume=volume;
	}
    //Getters
	public String getTicker()
	{
		return ticker;
	}
	public String getCompany()
	{
		return company;
	}
	public double getPrice()
	{
		return price;
	}
    public double getChange()
    {
	return change;
    }
    public long getVolume()
	{
		return volume;
	}
  
}







