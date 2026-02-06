package com.project.RealTicker.service;

import org.springframework.core.ParameterizedTypeReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.RealTicker.model.StockAnalysis;

@Service
public class StockService 
{
private final String Api_url="https://router.huggingface.co/hf-inference/models/google/flan-t5-base";
;
;
private final String Api_token=System.getenv("HF_TOKEN");

public StockAnalysis stockanalyze(String historyData)
{
	RestTemplate resttemp=new RestTemplate();
	HttpHeaders head=new HttpHeaders();
	
	head.setBearerAuth(Api_token);
	head.setContentType(MediaType.APPLICATION_JSON);
	
	Map<String,String> body=new HashMap<>();
	body.put("inputs",
			"You are a financial analysis AI.\n" +
			        "Analyze this 6 month stock price data and respond EXACTLY in this format:\n" +
			        "Trend: <Upward/Downward/Sideways>\n" +
			        "Risk: <Low/Medium/High>\n" +
			        "Suggestion: <Invest/Watch/Avoid>\n\n" +
			        "Stock Prices: " + historyData +
			        "\nDo not add explanations. Only give the three lines."
		);

	HttpEntity<Map<String,String>> request =new HttpEntity<Map<String,String>>(body,head);
	ResponseEntity<List<Map<String,Object>>> response=resttemp.exchange(Api_url, HttpMethod.POST,request,new ParameterizedTypeReference<List<Map<String,Object>>>(){});
	
    
	
    String ai = response.getBody().get(0).toString().toLowerCase();

 // ---- Extract values from AI text ----
 String trend = ai.contains("upward") ? "Upward" :
                ai.contains("downward") ? "Downward" : "Sideways";

 String risk = ai.contains("low") ? "Low" :
               ai.contains("high") ? "High" : "Medium";

 String action = ai.contains("avoid") ? "Avoid" :
                 ai.contains("watch") ? "Watch" : "Invest";

 return new StockAnalysis(
	        trend,
	        risk,
	        action,
	        "This is AI-generated analysis and not financial advice."
	);
 
	
}
}
