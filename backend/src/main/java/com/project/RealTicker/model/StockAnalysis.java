package com.project.RealTicker.model;

public class StockAnalysis 
{
private String trend;
private String risk;
private String action;
private String disclaimer;

public StockAnalysis(String trend,String risk,String action,String disclaimer)
{
	this.trend=trend;
	this.risk=risk;
	this.action=action;
	this.disclaimer=disclaimer;
}
public String getTrend()
{
	return trend;
}
public String getRisk()
{
	return risk;
}
public String getAction()
{
	return action;
}
public String getDisclaimer()
{
	return disclaimer;
}


}
