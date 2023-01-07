package com.forex.wizard.telegram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.forex.wizard.helper.ReturnedInputStream;

@Component
public class Telegram {

	//This method is to send the signal only (VIP channel)
	public int useTelegramForSignalMsg_VIP(String msg) throws MalformedURLException, IOException {
		String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";

        //Add Telegram token 
        String apiToken = "5906626805:AAHbT1QQGOsMo_UTrUEeb-l9XpI30JRYB9M";
      
        //Add chatId 
        String chatId = "-1001493861809";

        urlString = String.format(urlString, apiToken, chatId, msg);

            
        	URLConnection connection = new URL(urlString).openConnection();
        	
        	//Get Response  
        	InputStream is = connection.getInputStream();
        	
        	//to convert InputStream object into string
        	String result = new BufferedReader(new InputStreamReader(is))
        		    .lines().parallel().collect(Collectors.joining("\n"));
        	
        	System.out.println(result);
        	
        	ObjectMapper mapper = new ObjectMapper();
            try {
                ReturnedInputStream returnedInputStream = mapper.readValue(result, ReturnedInputStream.class);
                System.out.println(returnedInputStream.getResult().getMessage_id());
                return (int) returnedInputStream.getResult().getMessage_id();
            } catch (IOException e) {
                e.printStackTrace();
            }
			return 0;
	}
	
	//This method is to update the signal result (VIP channel)
	public void useTelegramForUpdateSignalResult_VIP(String msg,int msg_id) throws MalformedURLException, IOException {
		String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s&reply_to_message_id=%s";

        //Add Telegram token 
        String apiToken = "5906626805:AAHbT1QQGOsMo_UTrUEeb-l9XpI30JRYB9M";
      
        //Add chatId 
        String chatId = "-1001493861809";

        urlString = String.format(urlString, apiToken, chatId, msg, msg_id);

            
        	URLConnection connection = new URL(urlString).openConnection();
        	
        	//Get Response  
        	InputStream is = connection.getInputStream();
	}
	
	//This method is to delete the signal result (VIP channel)
	public void useTelegramForDeleteSignalMsg_VIP(int msg_id) throws MalformedURLException, IOException {
		String urlString = "https://api.telegram.org/bot%s/deleteMessage?chat_id=%s&message_id=%s";
		
		//Add Telegram token 
		String apiToken = "5906626805:AAHbT1QQGOsMo_UTrUEeb-l9XpI30JRYB9M";
		
		//Add chatId 
		String chatId = "-1001493861809";
		
		urlString = String.format(urlString, apiToken, chatId, msg_id);
		
		
		URLConnection connection = new URL(urlString).openConnection();
		
		//Get Response  
		InputStream is = connection.getInputStream();
	}

	
	
	
	
	
	//This method is to send the signal only (FREE channel)
	public int useTelegramForSignalMsg_FREE(String msg) throws MalformedURLException, IOException {
		String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";

        //Add Telegram token 
        String apiToken = "5906626805:AAHbT1QQGOsMo_UTrUEeb-l9XpI30JRYB9M";
      
        //Add chatId 
        String chatId = "-1001447897723";

        urlString = String.format(urlString, apiToken, chatId, msg);

            
        	URLConnection connection = new URL(urlString).openConnection();
        	
        	//Get Response  
        	InputStream is = connection.getInputStream();
        	
        	//to convert InputStream object into string
        	String result = new BufferedReader(new InputStreamReader(is))
        		    .lines().parallel().collect(Collectors.joining("\n"));
        	
        	System.out.println(result);
        	
        	ObjectMapper mapper = new ObjectMapper();
            try {
                ReturnedInputStream returnedInputStream = mapper.readValue(result, ReturnedInputStream.class);
                System.out.println(returnedInputStream.getResult().getMessage_id());
                return (int) returnedInputStream.getResult().getMessage_id();
            } catch (IOException e) {
                e.printStackTrace();
            }
			return 0;
		}

		//This method is to update the signal result (FREE channel)
		public void useTelegramForUpdateSignalResult_FREE(String msg,int msg_id) throws MalformedURLException, IOException {
			String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s&reply_to_message_id=%s";
	
	        //Add Telegram
	        String apiToken = "5906626805:AAHbT1QQGOsMo_UTrUEeb-l9XpI30JRYB9M";
	      
	        //Add chatId
	        String chatId = "-1001447897723";
	
	        urlString = String.format(urlString, apiToken, chatId, msg, msg_id);
	
	            
	        	URLConnection connection = new URL(urlString).openConnection();
	        	
	        	//Get Response  
	        	InputStream is = connection.getInputStream();
	        	System.out.println("update called");
		}
		
		//This method is to delete the signal result (FREE channel)
		public void useTelegramForDeleteSignalMsg_FREE(int msg_id) throws MalformedURLException, IOException {
			String urlString = "https://api.telegram.org/bot%s/deleteMessage?chat_id=%s&message_id=%s";
			
			//Add Telegram token 
			String apiToken = "5906626805:AAHbT1QQGOsMo_UTrUEeb-l9XpI30JRYB9M";
			
			//Add chatId 
			String chatId = "-1001447897723";
			
			urlString = String.format(urlString, apiToken, chatId, msg_id);
			
			
			URLConnection connection = new URL(urlString).openConnection();
			System.out.println("delete called");
			//Get Response  
			InputStream is = connection.getInputStream();
		}


}