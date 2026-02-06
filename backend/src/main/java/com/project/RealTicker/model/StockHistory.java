package com.project.RealTicker.model;

public class StockHistory 
{
private String date;
private double price;

//Constructor
public StockHistory(String date,double price)
{
	this.date=date;
	this.price=price;
}

//Getters
public String getDate()
{
	return date;
}
public double getPrice()
{
	return price;
}
}

