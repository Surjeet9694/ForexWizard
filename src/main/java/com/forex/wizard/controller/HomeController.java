package com.forex.wizard.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.forex.wizard.Dao.DataDao;
import com.forex.wizard.Dao.PurchaseDao;
import com.forex.wizard.currencyExchange.CurrencyExchange;
import com.forex.wizard.entity.Data;
import com.forex.wizard.entity.Purchase;
import com.forex.wizard.telegram.Telegram;

@Controller
public class HomeController {

	@Autowired
	private PurchaseDao purchaseDao;
	
	@Autowired
	private DataDao dataDao;
	
	@Autowired
	private Telegram telegram;
	
	@Autowired
	private CurrencyExchange currencyExchange;

	
	/*
	 * API : /
	 * 
	 * Task : 1) This API is linked with "Wizard Forex" button on the navigation bar and "home" button on the navigation bar.
	 * 		  2) This API will open the home page.
	 * 		  3) It will fetch all the available data of the singals from the data table stored in the database.
	 *        4) If the data is not available in the database then it will open an page named : singleJspFileForAddingSignal......
	 *        5) In singleJsoFileForAdd..... file there is only one button which will redirect the control to the add signal page.
	 *        6) And if the data is available in the database then with the help of model object it will send to the report page.
	 *        
	 * Return : home.jsp
	 */
	@RequestMapping("/")
	public String home(Model model) throws MalformedURLException, IOException {
		List<Data> listOfAllTheSingalsData=this.dataDao.findAll();
		if (listOfAllTheSingalsData.size() <= 0) {
			return "singleJspFileForAddSingalOnlyIfNoDataIsAvailableInDataBase";
		} else {
			model.addAttribute("data",listOfAllTheSingalsData);
		}
		return "home";
	}
	
	
	

	/*
	 * API : /report
	 * 
	 * Task : 1) This API is linked with "Report" button on the navigation bar.
	 * 		  2) It will fetch all the available data of the singals from the data table stored in the database.
	 *        3) If the data is not available in the database then it will open an page named : singleJspFileForAddingSignal......
	 *        4) In singleJsoFileForAdd..... file there is only one button which will redirect the control to the add signal page.
	 *        5) And if the data is available in the database then with the help of model object it will send to the report page.
	 *        
	 * Return : report.jsp
	 */
	@RequestMapping("/report")
	public String report(Model model) {
		List<Data> listOfAllTheSingalsData=this.dataDao.findAll();
		if (listOfAllTheSingalsData.size() <= 0) {
			return "singleJspFileForAddSingalOnlyIfNoDataIsAvailableInDataBase";
		} else {
			model.addAttribute("data",listOfAllTheSingalsData);
		}
		return "report";
	}

	
	

	/*
	 * API : /reportForm
	 * 
	 * Task : 1) This API is linked with two button available on report.jsp page and singleJspFileForAddSignal..... page.
	 *        2) This API will open an web page from which we can send the signal and signal report.
	 *        
	 * Return : reportForm.jsp
	 */
	@RequestMapping("/reportForm")
	public String reportForm() {
		return "reportForm";
	}

	
	

	/*
	 * API : /report
	 * 
	 * Task : 1) This API is linked with a form action in the reportForm.jsp page.
	 * 		  2) It will convert the Pair entity to the uper case in case we enter the input in lower case.
	 * 		  3) It will automatically set the status to "Running" on the first time (On the reportForm there is no option to choose the status).
	 * 		  4) If the tokenNo entity is empty then this method will set the value of tokenNo = Not available.
	 * 		  5) This method will create an sample signal message in msg variable and then after checking the channel variable "useTelegramForSignalMsg()" method will
	 * 			 send the signal msg to the telegram channel and then "useTelegramForSignalMsg()" mehtod will return and msg_id of that signal msg which
	 *           we save in database so with the help of that msg_id we can update the result on the same signal.
	 *        6) At the end we save the data object to the database.
	 *        
	 * Return : A RedirectView with "/report" API
	 */
	@RequestMapping("/report-handle")
	public RedirectView reportHandle(@ModelAttribute Data data) throws MalformedURLException, IOException {
		System.out.println(data);
		data.setPair(data.getPair().toUpperCase());
		data.setStatus("Running");
		if(data.getTokenNo().equals(""))
			data.setTokenNo("Not Available");
		
		//Sending Signal through telegram
		
		//%F0%9F%92%B9 is used for the "green share-market emoji"
		// "%0D%0A" this we use to break the line in signal message
		String msg="Live Trading%F0%9F%92%B9"+"%0D%0A %0D%0A"          
				+ data.getPair()+" "+data.getSellBuy().toUpperCase()+"%0D%0A %0D%0A"
				+ "ENTRY : "+data.getEntryPoint()+"%0D%0A"
				+ "SL : "+data.getStopLoss()+"%0D%0A"
				+ "TP : "+data.getTakeProfit();
		
		//Checking the channel name to send the signal msg (vip, free or both)
		if(data.getChannel().equals("VIP"))
		{
			System.out.println("Vip");
			int msg_id=telegram.useTelegramForSignalMsg_VIP(msg);         //sending the signal in vip channel
			data.setMsgIdOfVipChannel(msg_id);                            //setting the "vip singal msg id" to the database returned from the telegram method
		}
		else if(data.getChannel().equals("FREE"))
		{
			System.out.println("Free");
			int msg_id=telegram.useTelegramForSignalMsg_FREE(msg);         //sending the signal in free channel
			data.setMsgIdOfFreeChannel(msg_id);                            //setting the "free singal msg id" to the database returned from the telegram method
		}
		else if(data.getChannel().equals("BOTH"))
		{
			System.out.println("Both");
			int msg_id_vip=telegram.useTelegramForSignalMsg_VIP(msg);      //sending the signal in vip channel
			data.setMsgIdOfVipChannel(msg_id_vip);						   //setting the "vip singal msg id" to the database returned from the telegram method
			
			int msg_id_free=telegram.useTelegramForSignalMsg_FREE(msg);    //sending the signal in free channel
			data.setMsgIdOfFreeChannel(msg_id_free);                       //setting the "free singal msg id" to the database returned from the telegram method
		}
		dataDao.save(data);                    //sending all data to the data base after setting the returned msg id 
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/report");
		return redirectView; 
	}

	
	
	
	
	/*
	 * API : /purchase
	 * 
	 * Task : 1) This API is linked with "Purchase" button on the navigation bar.
	 *        2) This API will open an web page from which we can add the subscribers details.
	 *        
	 * Return : purchase.jsp
	 */
	@RequestMapping("/purchase")
	public String purchase() {
		return "purchase";
	}

	
	
	
	
	/*
	 * API : /about
	 * 
	 * Task : 1) This API is linked with "About" button on the navigation bar.
	 *        2) This API will open about.jsp page.
	 *        
	 * Return : about.jsp
	 */
	@RequestMapping("/about")
	public String about() {
		return "about";
	}

	
	
	
	/*
	 * API : /subscribers/{periodOfMembership}
	 * 
	 * Task : 1) This API is linked with an dropdown menu on the navigation bar with periodOfMembership.
	 *        2) This API will fetch the data from the database according to the periodOfMembership.
	 *        3) We created a method with a custom query in DataDao which will return all the data of the subscriber according to the periodOfMembership.
	 *        4) If there is no data available in the database for the specific periodOfMembership then this method will opern an page "whenNoDataIsAvailable.jsp"
	 *        	 that will show an heading with no data available.
	 *        5) Else the model object will send the listOfAllTheSubscribers to the subscribers.jsp page according to the periodOfMembership.
	 *        
	 * Return : subscribers.jsp
	 */
	@RequestMapping("/subscribers/{periodOfMembership}")
	public String subscribers(@PathVariable("periodOfMembership") String periodOfMembership, Model model) {

		List<Purchase> listOfAllTheSubscribers = this.purchaseDao
				.getDetailsOfSubscribersAccordingToThePeriodOfMonth(periodOfMembership);
		if (listOfAllTheSubscribers.size() <= 0) {
			return "whenNoDataIsAvailable";
		} else {
			model.addAttribute("purchase", listOfAllTheSubscribers);
		}

		return "subscribers";
	}

	
	
	
	
	/*
	 * API : /login
	 * 
	 * Task : 1) This API is linked in the config class which will open the custom login page automatically when the website open.
	 *        2) This API will open login.jsp page.
	 *        
	 * Return : login.jsp
	 */
	@RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

	
	
	
	
	/*
	 * API : /handle-purchase
	 * 
	 * Task : 1) This API is linked with a form action available on purchase.jsp page.
	 *        2) There is an calss created in this project named Purchase with the help of @ModelAttribute all the details of a subscriber will get in
	 *           purchase object in this method.
	 *        3) If any value in the input tag is empty then this method will set the value of that variable = Not Available
	 *        4) At the end this method will sava the purchase object in the Purchase table stored in the database.
	 *        
	 * Return : purchase.jsp
	 */
	@RequestMapping("/handle-purchase")
	public String purchaseHandle(@ModelAttribute Purchase purchase) {
		
		purchase.setFirstName(purchase.getFirstName().substring(0, 1).toUpperCase()
				+ purchase.getFirstName().substring(1).toLowerCase());
		purchase.setLastName(purchase.getLastName().substring(0, 1).toUpperCase()
				+ purchase.getLastName().substring(1).toLowerCase());

		purchase.setEmail(purchase.getEmail().toLowerCase());		
		
		if(purchase.getFirstName().equals(""))
			purchase.setFirstName("Not Available");
		if(purchase.getLastName().equals(""))
			purchase.setLastName("Not Available");
		if(purchase.getEmail().equals(""))
			purchase.setEmail("Not Available");
		if(purchase.getNumber().equals(""))
			purchase.setNumber("Not Available");
		if(purchase.getCountry().equals(""))
			purchase.setCountry("Not Available");
		
		purchaseDao.save(purchase);
		return "purchase";
	}

	
	
	
	
	/*
	 * API : /update/{id}
	 * 
	 * Task : 1) This API is linked with a pen/edit icon on the report page.
	 *        2) If user click on that icon then the id of the clicked data will fetch by this method By the @PathVAriable long id.
	 *        3) With help of that id this method will fetch the data of a particular data followed by the fetched id.
	 *        4) And with the help of model object this method will send the data to the updateForm.jsp page.
	 *        
	 * Return : updateForm.jsp
	 */
	@RequestMapping("/update/{id}")
	public String update(@PathVariable("id") long id, Model model) {
		Data data=this.dataDao.getDataById(id);
		model.addAttribute("data",data);
		return "updateForm";
	}

	
	
	
	
	/*
	 * API : /update-handle
	 * 
	 * Task : 1) This API is linked with a form action in the updateForm.jsp page.
	 *        2) This method will get all the updated signal details in data object with the help of @ModelAttribute.
	 *        3) This method will overwrite the udpated signal details in the database.
	 *        4) It will check the status of the signal and sent the result/report with the help of an mehtod of telegram class named "getTheMsgOfSIgnalPairById()".
	 *        5) This method will create a message according to the status and then this message will send in the telegram channel.
	 *        
	 * Return : A RedirectView with "/report" API
	 */
	@RequestMapping("/update-handle")
	public RedirectView updateHandle(@ModelAttribute Data data) throws MalformedURLException, IOException {
		this.dataDao.save(data);
		
		//Checking the channel name to send the signal msg (vip, free or both)
		if(data.getChannel().equals("VIP"))
		{
			System.out.println("Vip");
			
			if(data.getStatus().equals("Running"))
			{
				//%2B is used to send "+" in the update result
				//%F0%9F%92%9A%F0%9F%92%9A%F0%9F%92%9A is used to send the "green heart" for three times
				String msg="Running "+data.getPips()+"%2B Pips%F0%9F%92%9A%F0%9F%92%9A%F0%9F%92%9A";    
				telegram.useTelegramForUpdateSignalResult_VIP(msg,this.dataDao.getTheVipMsgIdOfSignalPairById(data.getId()));
			}
			else if(data.getStatus().equals("Closed with"))
			{
				//%2B is used to send "+" in the update result
				//%F0%9F%92%9A%F0%9F%92%9A%F0%9F%92%9A is used to send the "green heart" for three times
				String msg="Closed with %2B"+data.getPips()+" Pips%F0%9F%92%9A%F0%9F%92%9A%F0%9F%92%9A";    
				telegram.useTelegramForUpdateSignalResult_VIP(msg,this.dataDao.getTheVipMsgIdOfSignalPairById(data.getId()));
			}
			else if(data.getStatus().equals("Hit tp"))
			{
				//%2B is used to send "+" in the update result
				//%F0%9F%92%9A%F0%9F%92%9A%F0%9F%92%9A is used to send the "green heart" for three times
				String msg="Hit target %2B"+data.getPips()+" Pips%F0%9F%92%9A%F0%9F%92%9A%F0%9F%92%9A";    
				telegram.useTelegramForUpdateSignalResult_VIP(msg,this.dataDao.getTheVipMsgIdOfSignalPairById(data.getId()));
			}
			else if(data.getStatus().equals("Hit sl"))
			{
				//%E2%9D%A4%EF%B8%8F is used to send the "red heart" for three times
				String msg="Hit sl -"+data.getPips()+" Pips%E2%9D%A4%EF%B8%8F";    
				telegram.useTelegramForUpdateSignalResult_VIP(msg,this.dataDao.getTheVipMsgIdOfSignalPairById(data.getId()));
			}
			else if(data.getStatus().equals("set sl to entry"))
			{
				//%2B is used to send "+" in the update result
				//%F0%9F%92%9A%F0%9F%92%9A%F0%9F%92%9A is used to send the "green heart" for three times
				String msg="Running "+data.getPips()+"%2B Pips%F0%9F%92%9A%F0%9F%92%9A%F0%9F%92%9A Set sl to entry";   
				telegram.useTelegramForUpdateSignalResult_VIP(msg,this.dataDao.getTheVipMsgIdOfSignalPairById(data.getId()));
			}
			else if(data.getStatus().equals("close half set sl to entry"))
			{
				//%2B is used to send "+" in the update result
				//%F0%9F%92%9A%F0%9F%92%9A%F0%9F%92%9A is used to send the "green heart" for three times
				String msg="Running "+data.getPips()+"%2B Pips%F0%9F%92%9A%F0%9F%92%9A%F0%9F%92%9A Close half and set sl to entry";    
				telegram.useTelegramForUpdateSignalResult_VIP(msg,this.dataDao.getTheVipMsgIdOfSignalPairById(data.getId()));
			}
			
		}
		else if(data.getChannel().equals("FREE"))
		{
			System.out.println("Free");
			
			if(data.getStatus().equals("Running"))
			{
				//%2B is used to send "+" in the update result
				//%F0%9F%92%9A%F0%9F%92%9A%F0%9F%92%9A is used to send the "green heart" for three times
				String msg="Running "+data.getPips()+"%2B Pips%F0%9F%92%9A%F0%9F%92%9A%F0%9F%92%9A";    
				telegram.useTelegramForUpdateSignalResult_FREE(msg,this.dataDao.getTheFreeMsgIdOfSignalPairById(data.getId()));
			}
			else if(data.getStatus().equals("Closed with"))
			{
				//%2B is used to send "+" in the update result
				//%F0%9F%92%9A%F0%9F%92%9A%F0%9F%92%9A is used to send the "green heart" for three times
				String msg="Closed with %2B"+data.getPips()+" Pips%F0%9F%92%9A%F0%9F%92%9A%F0%9F%92%9A";    
				telegram.useTelegramForUpdateSignalResult_FREE(msg,this.dataDao.getTheFreeMsgIdOfSignalPairById(data.getId()));
			}
			else if(data.getStatus().equals("Hit tp"))
			{
				//%2B is used to send "+" in the update result
				//%F0%9F%92%9A%F0%9F%92%9A%F0%9F%92%9A is used to send the "green heart" for three times
				String msg="Hit target %2B"+data.getPips()+" Pips%F0%9F%92%9A%F0%9F%92%9A%F0%9F%92%9A";    
				telegram.useTelegramForUpdateSignalResult_FREE(msg,this.dataDao.getTheFreeMsgIdOfSignalPairById(data.getId()));
			}
			else if(data.getStatus().equals("Hit sl"))
			{
				//%E2%9D%A4%EF%B8%8F is used to send the "red heart" for three times
				String msg="Hit sl -"+data.getPips()+" Pips%E2%9D%A4%EF%B8%8F";    
				telegram.useTelegramForUpdateSignalResult_FREE(msg,this.dataDao.getTheFreeMsgIdOfSignalPairById(data.getId()));
			}
			else if(data.getStatus().equals("set sl to entry"))
			{
				//%2B is used to send "+" in the update result
				//%F0%9F%92%9A%F0%9F%92%9A%F0%9F%92%9A is used to send the "green heart" for three times
				String msg="Running "+data.getPips()+"%2B Pips%F0%9F%92%9A%F0%9F%92%9A%F0%9F%92%9A Set sl to entry";   
				telegram.useTelegramForUpdateSignalResult_FREE(msg,this.dataDao.getTheFreeMsgIdOfSignalPairById(data.getId()));
			}
			else if(data.getStatus().equals("close half set sl to entry"))
			{
				//%2B is used to send "+" in the update result
				//%F0%9F%92%9A%F0%9F%92%9A%F0%9F%92%9A is used to send the "green heart" for three times
				String msg="Running "+data.getPips()+"%2B Pips%F0%9F%92%9A%F0%9F%92%9A%F0%9F%92%9A Close half and set sl to entry";    
				telegram.useTelegramForUpdateSignalResult_FREE(msg,this.dataDao.getTheFreeMsgIdOfSignalPairById(data.getId()));
			}
		}
		else if(data.getChannel().equals("BOTH"))
		{
			System.out.println("Both");
			
			//updating the msg of VIP channel and free channel
			if(data.getStatus().equals("Running"))
			{
				//%2B is used to send "+" in the update result
				//%F0%9F%92%9A%F0%9F%92%9A%F0%9F%92%9A is used to send the "green heart" for three times
				String msg="Running "+data.getPips()+"%2B Pips%F0%9F%92%9A%F0%9F%92%9A%F0%9F%92%9A";    
				telegram.useTelegramForUpdateSignalResult_VIP(msg,this.dataDao.getTheVipMsgIdOfSignalPairById(data.getId()));
				telegram.useTelegramForUpdateSignalResult_FREE(msg,this.dataDao.getTheFreeMsgIdOfSignalPairById(data.getId()));
			}
			else if(data.getStatus().equals("Closed with"))
			{
				//%2B is used to send "+" in the update result
				//%F0%9F%92%9A%F0%9F%92%9A%F0%9F%92%9A is used to send the "green heart" for three times
				String msg="Closed with %2B"+data.getPips()+" Pips%F0%9F%92%9A%F0%9F%92%9A%F0%9F%92%9A";    
				telegram.useTelegramForUpdateSignalResult_VIP(msg,this.dataDao.getTheVipMsgIdOfSignalPairById(data.getId()));
				telegram.useTelegramForUpdateSignalResult_FREE(msg,this.dataDao.getTheFreeMsgIdOfSignalPairById(data.getId()));
			}
			else if(data.getStatus().equals("Hit tp"))
			{
				//%2B is used to send "+" in the update result
				//%F0%9F%92%9A%F0%9F%92%9A%F0%9F%92%9A is used to send the "green heart" for three times
				String msg="Hit target %2B"+data.getPips()+" Pips%F0%9F%92%9A%F0%9F%92%9A%F0%9F%92%9A";    
				telegram.useTelegramForUpdateSignalResult_VIP(msg,this.dataDao.getTheVipMsgIdOfSignalPairById(data.getId()));
				telegram.useTelegramForUpdateSignalResult_FREE(msg,this.dataDao.getTheFreeMsgIdOfSignalPairById(data.getId()));
			}
			else if(data.getStatus().equals("Hit sl"))
			{
				//%E2%9D%A4%EF%B8%8F is used to send the "red heart" for three times
				String msg="Hit sl -"+data.getPips()+" Pips%E2%9D%A4%EF%B8%8F";    
				telegram.useTelegramForUpdateSignalResult_VIP(msg,this.dataDao.getTheVipMsgIdOfSignalPairById(data.getId()));
				telegram.useTelegramForUpdateSignalResult_FREE(msg,this.dataDao.getTheFreeMsgIdOfSignalPairById(data.getId()));
			}
			else if(data.getStatus().equals("set sl to entry"))
			{
				//%2B is used to send "+" in the update result
				//%F0%9F%92%9A%F0%9F%92%9A%F0%9F%92%9A is used to send the "green heart" for three times
				String msg="Running "+data.getPips()+"%2B Pips%F0%9F%92%9A%F0%9F%92%9A%F0%9F%92%9A Set sl to entry";   
				telegram.useTelegramForUpdateSignalResult_VIP(msg,this.dataDao.getTheVipMsgIdOfSignalPairById(data.getId()));
				telegram.useTelegramForUpdateSignalResult_FREE(msg,this.dataDao.getTheFreeMsgIdOfSignalPairById(data.getId()));
			}
			else if(data.getStatus().equals("close half set sl to entry"))
			{
				//%2B is used to send "+" in the update result
				//%F0%9F%92%9A%F0%9F%92%9A%F0%9F%92%9A is used to send the "green heart" for three times
				String msg="Running "+data.getPips()+"%2B Pips%F0%9F%92%9A%F0%9F%92%9A%F0%9F%92%9A Close half and set sl to entry";    
				telegram.useTelegramForUpdateSignalResult_VIP(msg,this.dataDao.getTheVipMsgIdOfSignalPairById(data.getId()));
				telegram.useTelegramForUpdateSignalResult_FREE(msg,this.dataDao.getTheFreeMsgIdOfSignalPairById(data.getId()));
			}
			
			
		}
		
			
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/report");
		return redirectView; 
	}

	
	
	
	
	/*
	 * API : /delete/{id}
	 * 
	 * Task : 1) This API is linked with a trash icon on the report page.
	 *        2) If user click on that icon then the id of the clicked data will fetch by this method By the @PathVAriable long id.
	 *        3) With help of that id this method will fetch the data of a particular data followed by the fetched id.
	 *        4) After checking the channel name this method will call an method of telegram class which will delete the msg from the telegram channel.
	 *        5) After that by using dataaDao class method this API/Method will delete the data from the database as well.
	 *        
	 * Return : A RedirectView with "/report" API
	 */
	@RequestMapping("/delete/{id}")
	public RedirectView update(@PathVariable("id") long id) throws MalformedURLException, IOException {
		Data data=this.dataDao.getById(id);           //Fetching the signal msg from the data table stored in database.
		
		//Checking the channel name to send the signal msg (vip, free or both)
		if(data.getChannel().equals("VIP"))
		{
			System.out.println("Vip");
			System.out.println(data.getMsgIdOfVipChannel());
			this.telegram.useTelegramForDeleteSignalMsg_VIP(data.getMsgIdOfVipChannel());         //Deleteing the signal from vip channel
		}
		else if(data.getChannel().equals("FREE"))
		{
			System.out.println("Free");
			System.out.println(data.getMsgIdOfFreeChannel());
			this.telegram.useTelegramForDeleteSignalMsg_FREE(data.getMsgIdOfFreeChannel());       //Deleteing the signal from free channel
		}
		else if(data.getChannel().equals("BOTH"))
		{
			System.out.println("Both");
			System.out.println(data.getMsgIdOfVipChannel());
			this.telegram.useTelegramForDeleteSignalMsg_VIP(data.getMsgIdOfVipChannel());         //Deleteing the signal from vip channel					   

			System.out.println(data.getMsgIdOfFreeChannel());
			this.telegram.useTelegramForDeleteSignalMsg_FREE(data.getMsgIdOfFreeChannel());       //Deleteing the signal from free channel
		}
		
		
		this.dataDao.deleteById(id);    //After delete the data from the telegram this statement will delete the data from database as well
		
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/report");
		return redirectView; 
	}
	
	@RequestMapping("/testing")
	public String testing() throws IOException {
		this.currencyExchange.getEntryPoint("USD","JPY");
		return "home";
	}
}
