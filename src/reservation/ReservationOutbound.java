package reservation;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReservationOutbound {
	
	//Statistics for orders inserted into DB
	public static Integer loadEfficiencyCount = 0;
	
	//Timestamp for generating order
	public static String dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());    
	
	
	public String extractOrder(String otmsUrl) throws IOException {
		
		// TODO Auto-generated method stub
		//**********************
		//Call OTMS web service by POST(HttpURLConnection). 
		//Send XML(include user/password) to server using getOutputStream.
		//Get response with XML using getInputStream.
		//URL: https://login.otms.cn/ws/orderOutbound
		//Method: POST
		//content-type: application/xml;charset=UTF-8
		URL url = null;
		HttpURLConnection connection = null;
		OutputStream outputStream = null;
		InputStream inputStream = null;
		String result = null;
		ParseJson parseJson = null;
				
		try{			
			//Create URL, not WSDL	
	        url = new URL(otmsUrl);
	        connection = (HttpURLConnection) url.openConnection();
	        //Set parameters
	        connection.setRequestMethod("GET");
	        connection.setRequestProperty("content-type", "application/json;charset=UTF-8");
	        //Output default = false
	        //connection.setDoOutput(true);
	        connection.connect();
	                
	        //Get response and input JSON
	        int responseCode = connection.getResponseCode();
	        if(responseCode == 200){//success
	        
	        	//Get reservation from JSON
	        	inputStream = connection.getInputStream();
				System.out.println("=================Responsed"); 
	        	parseJson = new ParseJson();
	        	result = parseJson.getReservation(inputStream);
	            
	        }else {
	        	result = result + "responseCode: " + responseCode +"\n";
	        }
	        
	        
		}catch(Exception e){
			e.printStackTrace();
			result = result + e.toString() +"\n";
		}finally {
			if (outputStream != null) {
				//System.out.println(outputStream);
				outputStream.close();
			}			
			if (inputStream != null) {
				//System.out.println(inputStream);
				inputStream.close();
			}
			
		}//try
		
		if(result == null) {
			result = "Successfully!\r\n" + 
					 "Reservation inserted into DB:\r\n" +
		             "EX_LoadEfficiency: " + loadEfficiencyCount + "\r\n";
			
			loadEfficiencyCount = 0;
		}
		
		return result;
		
    }
	
	
				
	

}
