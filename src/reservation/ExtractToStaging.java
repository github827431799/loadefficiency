package reservation;

import java.sql.SQLException;
import java.sql.Statement;

public class ExtractToStaging {
	
	public String load(LoadEfficiency loadEfficiency) throws SQLException {

		//variables for connection and SQL scripts 
		Statement statementInsert = null;		
		String sqlLoadEfficiency = null;
		
		//Result
		String result = null;		
		
		//Insert data to DB
		try {	
			//Create statement
			statementInsert = ReservationExtraction.conn.createStatement();	
			
			//Execute SQL for LoadEfficiency
			for(int i = 0; i < loadEfficiency.getSize(); i++) {
				sqlLoadEfficiency = "INSERT INTO EX_LoadEfficiency(companyName,whName,platformName," +
						"resNumber, resStatus, resReview," +
						"resType, resCode, resBegindate," +
						"resEnddate, truckName, driverName," +
						"driverMobile, markInsert, markMov," +
						"markCancel, markRefuse, markLate," +
						"markDel, signDate, callDate," +
						"admissionDate, completeDate, appearanceDate," +
						"waitHour, workHour, totalWaitHour," +
						"factoryHour, resReason, resRemarks," +
						"modifyRemarks, createId, createDate," +
						"modifyId, modifyDate, totalQuantity," +
						"totalWeight,totalVolume,grossWeight," +
			            "metaSource,metaCreateOn) VALUES('" + 
						loadEfficiency.getCompanyName(i) + "','" + loadEfficiency.getWhName(i) + "','" + loadEfficiency.getPlatformName(i) + "','" + 
						loadEfficiency.getResNumber(i) + "','" + loadEfficiency.getResStatus(i) + "','" + loadEfficiency.getResReview(i) + "','" + 
						loadEfficiency.getResType(i) + "','" + loadEfficiency.getResCode(i) + "','" + loadEfficiency.getResBegindate(i) + "','" + 
						loadEfficiency.getResEnddate(i) + "','" + loadEfficiency.getTruckName(i) + "','" + loadEfficiency.getDriverName(i) + "','" + 
						loadEfficiency.getDriverMobile(i) + "','" + loadEfficiency.getMarkInsert(i) + "','" + loadEfficiency.getMarkMov(i) + "','" + 
						loadEfficiency.getMarkCancel(i) + "','" + loadEfficiency.getMarkRefuse(i) + "','" + loadEfficiency.getMarkLate(i) + "','" + 
						loadEfficiency.getMarkDel(i) + "','" + loadEfficiency.getSignDate(i) + "','" + loadEfficiency.getCallDate(i) + "','" + 
						loadEfficiency.getAdmissionDate(i) + "','" + loadEfficiency.getCompleteDate(i) + "','" + loadEfficiency.getAppearanceDate(i) + "','" + 
						loadEfficiency.getWaitHour(i) + "','" + loadEfficiency.getWorkHour(i) + "','" + loadEfficiency.getTotalWaitHour(i) + "','" + 
						loadEfficiency.getFactoryHour(i) + "','" + loadEfficiency.getResReason(i) + "','" + loadEfficiency.getResReMarks(i) + "','" + 
						loadEfficiency.getModifyReMarks(i) + "','" + loadEfficiency.getCreateId(i) + "','" + loadEfficiency.getCreateDate(i) + "','" + 
						loadEfficiency.getModifyId(i) + "','" + loadEfficiency.getModifyDate(i) + "','" + loadEfficiency.getTotalQuantity(i) + "','" + 
						loadEfficiency.getTotalWeight(i) + "','" + loadEfficiency.getTotalVolume(i) + "','" + loadEfficiency.getGrossWeight(i) + "','" + 
			            "OTMS" + "','" + ReservationOutbound.dateTime  + "')";			
				statementInsert.executeUpdate(sqlLoadEfficiency);
				ReservationOutbound.loadEfficiencyCount = ReservationOutbound.loadEfficiencyCount + statementInsert.getUpdateCount();
			}
			
			//Commit one transaction
			ReservationExtraction.conn.commit();
			System.out.println("=================Inserted");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			result = result + e.toString() +"\n";
		}finally {			
			if (statementInsert != null) {
				statementInsert.close();
			}
			
		}//try
		
		return result;
	}//load method

}
