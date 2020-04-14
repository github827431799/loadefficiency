package reservation;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.io.InputStream;

public class ReservationExtraction {
	
	//For log file path
	public static String logFilePath = null;
	public static Connection conn = null;		
	public static String insertedFlag = "N";	

	public static void main(String[] args) throws SQLException, IOException {
		// TODO Auto-generated method stub
		ReservationOutbound reservationOutbound = null;
		//String otmsUrl = "http://warehouse.prod.firefoxstudio.com/api/ResRport/List?BeginTime=2019-12-12&EndTime=2019-12-12&AppKey=dvwbg5qi&AppSecret=HxX7Gust35QASqjQ";
		String otmsUrl = null;
		//MySQL
		String filePath = null;
		String host = null;
		String port = null;
		String db = null;		
		String dgUrl = null;	
		String user = null;
		String password = null;	
		InputStream inputStream = null;
		Properties props = null;
		Statement statementQuery = null;
		Statement statementInsert = null;
		Statement statementPreUpdate = null;
		String result = null;
		String resBegindate = null;
		String resEnddate = null;
				
		//Get reservation from dgUrl
		try {
			//Log file path
			logFilePath = args[2] + "\\DGOTMS\\log_DGOTMS_ReservationExtraction.log";
						
			//MySQL
			filePath = args[1] + "\\CustomerProperties\\DBConnections.properties";
			inputStream = new BufferedInputStream (new FileInputStream(filePath));
			props = new Properties();
			props.load(inputStream);
			Enumeration<?> en = props.propertyNames();  
	        while (en.hasMoreElements()) {  
	            String key = (String) en.nextElement();  
	            String property = props.getProperty(key);  
	            if (key.equals("DGOTMS_host")) {
	            	host = property;
	            }else if(key.equals("DGOTMS_port")) {
	            	port = property;
	            	
	            }else if(key.equals("DGOTMS_db")) {
	            	db = property;
	            	
	            }else if(key.equals("DGOTMS_user")) {
	            	user = property;
	            	
	            }else if(key.equals("DGOTMS_password")) {
	            	password = property;
	            	
	            }
	            
	        }  		
	        password = password.replace("Encrypted ", "");
	        password = Encr.decryptPassword(password);
	        dgUrl = "jdbc:mysql://" + host + ":" + port + "/" + db + "?useUnicode=true&characterEncoding=utf8&useSSL=false";
				
			//System.out.println(dgUrl);
			//System.out.println(user);
			//System.out.println(password);
			conn = DriverManager.getConnection(dgUrl, user, password);
			conn.setAutoCommit(false);
			System.out.println("=================Connected");
			
			statementQuery = conn.createStatement();	
			statementInsert = conn.createStatement();
			statementPreUpdate = conn.createStatement();
			
			//Extracting reservation into DB from web service of OTMS
			//Get max date
			ResultSet rs = statementQuery.executeQuery("SELECT DATE_FORMAT(DATE_ADD(NOW(),INTERVAL -7 DAY),'%Y-%m-%d') AS resEnddate;");
			while(rs.next()) {
				resBegindate =  rs.getString("resEnddate");
				resEnddate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
				
			}			
			System.out.println("=================GotMaxDate");
			
			//Delete
			statementInsert.executeUpdate("INSERT INTO EX_LoadEfficiency_His(companyName,whName,platformName,resNumber,resStatus,resReview,resType,resCode," + 
					"resBegindate,resEnddate,truckName,driverName,driverMobile,markInsert,markMov,markCancel," + 
					"markRefuse,markLate,markDel,signDate,callDate,admissionDate,completeDate,appearanceDate," + 
					"waitHour,workHour,totalWaitHour,factoryHour,resReason,resRemarks,modifyRemarks,createId," + 
					"createDate,modifyId,modifyDate,totalQuantity,totalWeight,totalVolume,grossWeight,metaComment," + 
					"metaIsEffective,metaEffectiveFrom,metaEffectiveTo,metaSource,metaCreateOn,metaCreatedBy," + 
					"metaUpdateOn,metaUpdateBy) SELECT companyName,whName,platformName,resNumber,resStatus,resReview,resType,resCode," +  
					"resBegindate,resEnddate,truckName,driverName,driverMobile,markInsert,markMov,markCancel," + 
					"markRefuse,markLate,markDel,signDate,callDate,admissionDate,completeDate,appearanceDate," +  
					"waitHour,workHour,totalWaitHour,factoryHour,resReason,resRemarks,modifyRemarks,createId," +  
					"createDate,modifyId,modifyDate,totalQuantity,totalWeight,totalVolume,grossWeight,metaComment," + 
					"metaIsEffective,metaEffectiveFrom,metaEffectiveTo,metaSource,'" + ReservationOutbound.dateTime + "',metaCreatedBy," + 
					"metaUpdateOn,metaUpdateBy FROM EX_LoadEfficiency " + 
			        "WHERE DATE_FORMAT(resEnddate, '%Y-%m-%d') >= '" + resBegindate + "' AND DATE_FORMAT(resEnddate, '%Y-%m-%d') <= '" + resEnddate + "';");
			statementPreUpdate.executeUpdate("DELETE FROM EX_LoadEfficiency WHERE DATE_FORMAT(resEnddate, '%Y-%m-%d') >= '" + resBegindate + "' AND" + " DATE_FORMAT(resEnddate, '%Y-%m-%d') <= '" + resEnddate + "';");
			conn.commit();
			System.out.println("=================Deleted");
			
			
			//Extracting
			otmsUrl = args[0] + "?BeginTime=" + resBegindate + "&EndTime=" + resEnddate + "&AppKey=dvwbg5qi&AppSecret=HxX7Gust35QASqjQ";
			reservationOutbound = new ReservationOutbound();						
			result = reservationOutbound.extractOrder(otmsUrl);			
					
			//Write log
            LogFile.write(result);
            System.out.println(result);
			
			if(result == null) {
				result = "No reservation need to extract!";//Write log
	            LogFile.write("======================================");
	            LogFile.write(ReservationOutbound.dateTime);
				LogFile.write(result);
				System.out.println(result);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			result = result + e.toString() +"\n";
            LogFile.write("======================================");
            LogFile.write(ReservationOutbound.dateTime);
			LogFile.write(result);
			System.out.println(result);
		}finally {		
			if (inputStream != null) {
				inputStream.close();
			}
			if (statementQuery != null) {
				statementQuery.close();
			}	
			if (conn != null) {
				conn.close();
			}
			
		}//try	
		
		

	}

}
