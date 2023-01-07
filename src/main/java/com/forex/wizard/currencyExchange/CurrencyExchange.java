package com.forex.wizard.currencyExchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.forex.wizard.currencyExchange.helper.ForexExchange;
import com.forex.wizard.helper.ReturnedInputStream;


@Component
public class CurrencyExchange {
	
		
		public String getEntryPoint(String fromCurrency,String toCurrency ) throws IOException {
			
			String url="https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=%s&to_currency=%s&apikey=%s";

	        //API key to fetch the details of any pair
	        String api="3JVTGPKKHMLH1V7J";
	      
	        url = String.format(url, fromCurrency, toCurrency, api);

	            
        	URLConnection connection = new URL(url).openConnection();
        	
        	//Get Response  
        	InputStream is = connection.getInputStream();
        	
        	//to convert InputStream object into string
        	String result = new BufferedReader(new InputStreamReader(is))
        		    .lines().parallel().collect(Collectors.joining("\n"));
        	
//        	System.out.println(result);
        	
        	//formating the result string


    		result=result.substring(41, result.length()-1);
    		result=result.replace("1. From_Currency Code","fromCurrencyCode");
    		result=result.replace("2. From_Currency Name","fromCurrencyName");
    		result=result.replace("3. To_Currency Code","toCurrencyCode");
    		result=result.replace("4. To_Currency Name","toCurrencyName");
    		result=result.replace("5. Exchange Rate","exchangeRate");
    		result=result.replace("6. Last Refreshed","LastRefreshed");
    		result=result.replace("7. Time Zone","timeZone");
    		result=result.replace("8. Bid Price","bidPrice");
    		result=result.replace("9. Ask Price","askPrice");
    		
    		
    		ObjectMapper mapper = new ObjectMapper();
            try {
            	ForexExchange forexExchange = mapper.readValue(result, ForexExchange.class);
                System.out.println(forexExchange.getTimeZone());
                System.out.println(forexExchange.getAskPrice());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
		}
		
		public String pipCount(String pips) {
			
			return null;
		}
}
