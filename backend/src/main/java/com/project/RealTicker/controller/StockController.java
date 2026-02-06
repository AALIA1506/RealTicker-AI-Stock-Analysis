package com.project.RealTicker.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.RealTicker.model.StockModel;
import com.project.RealTicker.service.StockService;
import com.project.RealTicker.model.StockAnalysis;
import com.project.RealTicker.model.StockHistory;

import java.util.*;

@RestController
@RequestMapping("/api/stocks")
@CrossOrigin(origins= "http://localhost:3000")

public class StockController 
{
	@Autowired
	private StockService aiModel;
//GET/api/stocks/top10
@GetMapping("/top10")

public List<StockModel> getTop10Stocks()
{
	List<StockModel> stocks=new ArrayList<StockModel>();
	
	stocks.add(new StockModel("AAPL", "Apple", 185.4, 1.2, 78000000));
	stocks.add(new StockModel("MSFT", "Microsoft", 412.3, 0.8, 45000000));
	stocks.add(new StockModel("GOOGL", "Alphabet", 138.2, -0.5, 32000000));
	stocks.add(new StockModel("AMZN", "Amazon", 145.6, 0.3, 29000000));
	stocks.add(new StockModel("TSLA", "Tesla", 220.1, -1.1, 38000000));
	stocks.add(new StockModel("META", "Meta", 310.7, 0.9, 21000000));
	stocks.add(new StockModel("NFLX", "Netflix", 420.3, 1.5, 15000000));
	stocks.add(new StockModel("NVDA", "Nvidia", 600.8, 2.2, 50000000));
	stocks.add(new StockModel("INTC", "Intel", 35.4, -0.8, 18000000));
	stocks.add(new StockModel("AMD", "AMD", 120.6, 1.1, 26000000));

	return stocks;
	
}

//GET/api/stocks/{ticker}/history 
@GetMapping("/{ticker}/history")
public List<StockHistory> getStockhistory(@PathVariable String ticker)
{
	List<StockHistory> history=new ArrayList<StockHistory>();
	
	if(ticker.equalsIgnoreCase("AAPL"))
	{
	history.add(new StockHistory("2023-04-01", 160));
	history.add(new StockHistory("2023-05-01", 165));
	history.add(new StockHistory("2023-06-01", 168));
	history.add(new StockHistory("2023-07-01", 172));
	history.add(new StockHistory("2023-08-01", 170));
	history.add(new StockHistory("2023-09-01", 175));
	history.add(new StockHistory("2023-10-01", 180));
	history.add(new StockHistory("2023-11-01", 182));
	history.add(new StockHistory("2023-12-01", 185));
	history.add(new StockHistory("2024-01-01", 188));
	}

	else if(ticker.equalsIgnoreCase("MSFT"))
	{
	history.add(new StockHistory("2023-04-01", 420));
	history.add(new StockHistory("2023-05-01", 415));
	history.add(new StockHistory("2023-06-01", 410));
	history.add(new StockHistory("2023-07-01", 405));
	history.add(new StockHistory("2023-08-01", 400));
	history.add(new StockHistory("2023-09-01", 395));
	history.add(new StockHistory("2023-10-01", 390));
	history.add(new StockHistory("2023-11-01", 385));
	history.add(new StockHistory("2023-12-01", 380));
	history.add(new StockHistory("2024-01-01", 375));
	}

	else if(ticker.equalsIgnoreCase("GOOGL"))
	{
	history.add(new StockHistory("2023-04-01", 120));
	history.add(new StockHistory("2023-05-01", 122));
	history.add(new StockHistory("2023-06-01", 121));
	history.add(new StockHistory("2023-07-01", 123));
	history.add(new StockHistory("2023-08-01", 125));
	history.add(new StockHistory("2023-09-01", 126));
	history.add(new StockHistory("2023-10-01", 127));
	history.add(new StockHistory("2023-11-01", 129));
	history.add(new StockHistory("2023-12-01", 130));
	history.add(new StockHistory("2024-01-01", 132));
	}

	else if(ticker.equalsIgnoreCase("AMZN"))
	{
	history.add(new StockHistory("2023-04-01", 140));
	history.add(new StockHistory("2023-05-01", 150));
	history.add(new StockHistory("2023-06-01", 135));
	history.add(new StockHistory("2023-07-01", 155));
	history.add(new StockHistory("2023-08-01", 145));
	history.add(new StockHistory("2023-09-01", 160));
	history.add(new StockHistory("2023-10-01", 150));
	history.add(new StockHistory("2023-11-01", 165));
	history.add(new StockHistory("2023-12-01", 155));
	history.add(new StockHistory("2024-01-01", 170));
	}


	else if(ticker.equalsIgnoreCase("TSLA"))
	{
	history.add(new StockHistory("2023-04-01", 200));
	history.add(new StockHistory("2023-05-01", 230));
	history.add(new StockHistory("2023-06-01", 210));
	history.add(new StockHistory("2023-07-01", 240));
	history.add(new StockHistory("2023-08-01", 220));
	history.add(new StockHistory("2023-09-01", 250));
	history.add(new StockHistory("2023-10-01", 230));
	history.add(new StockHistory("2023-11-01", 260));
	history.add(new StockHistory("2023-12-01", 240));
	history.add(new StockHistory("2024-01-01", 270));
	}
	
	else if(ticker.equalsIgnoreCase("META"))
	{
	history.add(new StockHistory("2023-04-01", 300));
	history.add(new StockHistory("2023-05-01", 295));
	history.add(new StockHistory("2023-06-01", 290));
	history.add(new StockHistory("2023-07-01", 292));
	history.add(new StockHistory("2023-08-01", 298));
	history.add(new StockHistory("2023-09-01", 305));
	history.add(new StockHistory("2023-10-01", 310));
	history.add(new StockHistory("2023-11-01", 315));
	history.add(new StockHistory("2023-12-01", 318));
	history.add(new StockHistory("2024-01-01", 320));
	}

	else if(ticker.equalsIgnoreCase("NFLX"))
	{
	history.add(new StockHistory("2023-04-01", 410));
	history.add(new StockHistory("2023-05-01", 412));
	history.add(new StockHistory("2023-06-01", 415));
	history.add(new StockHistory("2023-07-01", 418));
	history.add(new StockHistory("2023-08-01", 420));
	history.add(new StockHistory("2023-09-01", 422));
	history.add(new StockHistory("2023-10-01", 425));
	history.add(new StockHistory("2023-11-01", 427));
	history.add(new StockHistory("2023-12-01", 430));
	history.add(new StockHistory("2024-01-01", 432));
	}

	else if(ticker.equalsIgnoreCase("NVDA"))
	{
	history.add(new StockHistory("2023-04-01", 450));
	history.add(new StockHistory("2023-05-01", 470));
	history.add(new StockHistory("2023-06-01", 490));
	history.add(new StockHistory("2023-07-01", 510));
	history.add(new StockHistory("2023-08-01", 530));
	history.add(new StockHistory("2023-09-01", 550));
	history.add(new StockHistory("2023-10-01", 570));
	history.add(new StockHistory("2023-11-01", 590));
	history.add(new StockHistory("2023-12-01", 610));
	history.add(new StockHistory("2024-01-01", 630));
	}

	else if(ticker.equalsIgnoreCase("INTC"))
	{
	history.add(new StockHistory("2023-04-01", 40));
	history.add(new StockHistory("2023-05-01", 39));
	history.add(new StockHistory("2023-06-01", 38));
	history.add(new StockHistory("2023-07-01", 37));
	history.add(new StockHistory("2023-08-01", 36));
	history.add(new StockHistory("2023-09-01", 35));
	history.add(new StockHistory("2023-10-01", 34));
	history.add(new StockHistory("2023-11-01", 33));
	history.add(new StockHistory("2023-12-01", 32));
	history.add(new StockHistory("2024-01-01", 31));
	}

	else if(ticker.equalsIgnoreCase("AMD"))
	{
	history.add(new StockHistory("2023-04-01", 100));
	history.add(new StockHistory("2023-05-01", 102));
	history.add(new StockHistory("2023-06-01", 104));
	history.add(new StockHistory("2023-07-01", 106));
	history.add(new StockHistory("2023-08-01", 108));
	history.add(new StockHistory("2023-09-01", 110));
	history.add(new StockHistory("2023-10-01", 112));
	history.add(new StockHistory("2023-11-01", 114));
	history.add(new StockHistory("2023-12-01", 116));
	history.add(new StockHistory("2024-01-01", 118));
	}

	return history;
}

@PostMapping("/{ticker}/analyze")
public StockAnalysis stockanalyze(@PathVariable String ticker )
{
	List<StockHistory> hist=getStockhistory(ticker);//reusing the method
	
	StringBuilder sb=new StringBuilder();
	sb.append("6 month stock data:");
	
	for(StockHistory h:hist)
	{
		sb.append(h.getPrice()).append(",");
	}
	String historyData=sb.toString();
	
	return aiModel.stockanalyze(historyData);
	
}

}

