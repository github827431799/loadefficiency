package reservation;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.stream.JsonReader;

public class ParseJson {	
		
	//Parse JSON using Gson(Google open source for parsing JSON)
	public String getReservation(InputStream inputStream) throws IOException {		
			
		//Db table object
		ExtractToStaging extractToStaging = null;
		LoadEfficiency loadEfficiency = null;		
		
		//Use Google Gson to parse Json
		JsonReader jsonReader = null;
		String name = null;
		
        //Result
        String result = null;
        
        //For LoadEfficiency set method
        String companyName = null;
        String whName = null;
        String platformName = null;
        String resNumber = null;
        String resStatus = null;
        String resReview = null;
        String resType = null;
        String resCode = null;
        String resBegindate = null;
        String resEnddate = null;
        String truckName = null;
        String driverName = null;
        String driverMobile = null;
        String markInsert = null;
        String markMov = null;
        String markCancel = null;
        String markRefuse = null;
        String markLate = null;
        String markDel = null;
        String signDate = null;
        String callDate = null;
        String admissionDate = null;
        String completeDate = null;
        String appearanceDate = null;
        int waitHour = 0;
        int workHour = 0;
        int totalWaitHour = 0;
        int factoryHour = 0;
        String resReason = null;
        String resRemarks = null;
        String modifyRemarks = null;
        String createId = null;
        String createDate = null;
        String modifyId = null;
        String modifyDate = null;
        int totalQuantity = 0;
        double totalWeight = 0.0;
        double totalVolume = 0.0;
        double grossWeight = 0.0;		
		
		try {
			loadEfficiency = new LoadEfficiency();
			
			jsonReader = new JsonReader(new InputStreamReader(inputStream,"UTF-8"));
			jsonReader.beginObject();//begin1
			while (jsonReader.hasNext()) {
				name = jsonReader.nextName();
				if (name.equals("result")) {
					jsonReader.beginObject();//begin2
					while (jsonReader.hasNext()) {
						name = jsonReader.nextName();
						if (name.equals("records")) {
							jsonReader.beginArray();//begin3
							while (jsonReader.hasNext()) {
								jsonReader.beginObject();//begin4
								while (jsonReader.hasNext()) {
									name = jsonReader.nextName();
									if (name.equals("companyName")) {
										//System.out.println("companyName: " + jsonReader.nextString());
										companyName = jsonReader.nextString();
									}else if (name.equals("whName")) {
										//System.out.println("whName: " + jsonReader.nextString());
										whName = jsonReader.nextString();
									}else if (name.equals("platformName")) {
										//System.out.println("platformName: " + jsonReader.nextString());
										platformName = jsonReader.nextString();
									}else if (name.equals("resNumber")) {
										//System.out.println("resNumber: " + jsonReader.nextString());
										resNumber = jsonReader.nextString();
									}else if (name.equals("resStatus")) {
										//System.out.println("resStatus: " + jsonReader.nextString());
										resStatus = jsonReader.nextString();
									}else if (name.equals("resReview")) {
										//System.out.println("resReview: " + jsonReader.nextString());
										resReview = jsonReader.nextString();
									}else if (name.equals("resType")) {
										//System.out.println("resType: " + jsonReader.nextString());
										resType = jsonReader.nextString();
									}else if (name.equals("resCode")) {
										//System.out.println("resCode: " + jsonReader.nextString());
										resCode = jsonReader.nextString();
									}else if (name.equals("resBegindate")) {
										//System.out.println("resBegindate: " + jsonReader.nextString());
										resBegindate = jsonReader.nextString();
									}else if (name.equals("resEnddate")) {
										//System.out.println("resEnddate: " + jsonReader.nextString());
										resEnddate = jsonReader.nextString();
									}else if (name.equals("truckName")) {
										//System.out.println("truckName: " + jsonReader.nextString());
										truckName = jsonReader.nextString();
									}else if (name.equals("driverName")) {
										//System.out.println("driverName: " + jsonReader.nextString());
										driverName = jsonReader.nextString();
									}else if (name.equals("driverMobile")) {
										//System.out.println("driverMobile: " + jsonReader.nextString());
										driverMobile = jsonReader.nextString();
									}else if (name.equals("markInsert")) {
										//System.out.println("markInsert: " + jsonReader.nextString());
										markInsert = jsonReader.nextString();
									}else if (name.equals("markMov")) {
										//System.out.println("markMov: " + jsonReader.nextString());
										markMov = jsonReader.nextString();
									}else if (name.equals("markCancel")) {
										//System.out.println("markCancel: " + jsonReader.nextString());
										markCancel = jsonReader.nextString();
									}else if (name.equals("markRefuse")) {
										//System.out.println("markRefuse: " + jsonReader.nextString());
										markRefuse = jsonReader.nextString();
									}else if (name.equals("markLate")) {
										//System.out.println("markLate: " + jsonReader.nextString());
										markLate = jsonReader.nextString();
									}else if (name.equals("markDel")) {
										//System.out.println("markDel: " + jsonReader.nextString());
										markDel = jsonReader.nextString();
									}else if (name.equals("signDate")) {
										//System.out.println("signDate: " + jsonReader.nextString());
										signDate = jsonReader.nextString();
									}else if (name.equals("callDate")) {
										//System.out.println("callDate: " + jsonReader.nextString());
										callDate = jsonReader.nextString();
									}else if (name.equals("admissionDate")) {
										//System.out.println("admissionDate: " + jsonReader.nextString());
										admissionDate = jsonReader.nextString();
									}else if (name.equals("completeDate")) {
										//System.out.println("completeDate: " + jsonReader.nextString());
										completeDate = jsonReader.nextString();
									}else if (name.equals("appearanceDate")) {
										//System.out.println("appearanceDate: " + jsonReader.nextString());
										appearanceDate = jsonReader.nextString();
									}else if (name.equals("waitHour")) {
										//System.out.println("waitHour: " + jsonReader.nextInt());
										waitHour = jsonReader.nextInt();
									}else if (name.equals("workHour")) {
										//System.out.println("workHour: " + jsonReader.nextInt());
										workHour = jsonReader.nextInt();
									}else if (name.equals("totalWaitHour")) {
										//System.out.println("totalWaitHour: " + jsonReader.nextInt());
										totalWaitHour = jsonReader.nextInt();
									}else if (name.equals("factoryHour")) {
										//System.out.println("factoryHour: " + jsonReader.nextInt());
										factoryHour = jsonReader.nextInt();
									}else if (name.equals("resReason")) {
										//System.out.println("resReason: " + jsonReader.nextString());
										resReason = jsonReader.nextString();
									}else if (name.equals("resRemarks")) {
										//System.out.println("resRemarks: " + jsonReader.nextString());
										resRemarks = jsonReader.nextString();
									}else if (name.equals("modifyRemarks")) {
										//System.out.println("modifyRemarks: " + jsonReader.nextString());
										modifyRemarks = jsonReader.nextString();
									}else if (name.equals("createId")) {
										//System.out.println("createId: " + jsonReader.nextString());
										createId = jsonReader.nextString();
									}else if (name.equals("createDate")) {
										//System.out.println("createDate: " + jsonReader.nextString());
										createDate = jsonReader.nextString();
									}else if (name.equals("modifyId")) {
										//System.out.println("modifyId: " + jsonReader.nextString());
										modifyId = jsonReader.nextString();
									}else if (name.equals("modifyDate")) {
										//System.out.println("modifyDate: " + jsonReader.nextString());
										modifyDate = jsonReader.nextString();
									}else if (name.equals("totalQuantity")) {
										//System.out.println("totalQuantity: " + jsonReader.nextInt());
										totalQuantity = jsonReader.nextInt();
									}else if (name.equals("totalWeight")) {
										//System.out.println("totalWeight: " + jsonReader.nextDouble());
										totalWeight = jsonReader.nextDouble();
									}else if (name.equals("totalVolume")) {
										//System.out.println("totalVolume: " + jsonReader.nextDouble());
										totalVolume = jsonReader.nextDouble();
									}else if (name.equals("grossWeight")) {
										//System.out.println("grossWeight: " + jsonReader.nextDouble());
										grossWeight = jsonReader.nextDouble();
									} else {
										jsonReader.skipValue();
									}//companyName									
								}//while4								
								jsonReader.endObject();//end4	
								//Set value for variables
								loadEfficiency.setCompanyName(companyName);
								loadEfficiency.setWhName(whName);
								loadEfficiency.setPlatformName(platformName);
								loadEfficiency.setResNumber(resNumber);
								loadEfficiency.setResStatus(resStatus);
								loadEfficiency.setResReview(resReview);
								loadEfficiency.setResType(resType);
								loadEfficiency.setResCode(resCode);
								loadEfficiency.setResBegindate(resBegindate);
								loadEfficiency.setResEnddate(resEnddate);
								loadEfficiency.setTruckName(truckName);
								loadEfficiency.setDriverName(driverName);
								loadEfficiency.setDriverMobile(driverMobile);
								loadEfficiency.setMarkInsert(markInsert);
								loadEfficiency.setMarkMov(markMov);
								loadEfficiency.setMarkCancel(markCancel);
								loadEfficiency.setMarkRefuse(markRefuse);
								loadEfficiency.setMarkLate(markLate);
								loadEfficiency.setMarkDel(markDel);
								loadEfficiency.setSignDate(signDate);
								loadEfficiency.setCallDate(callDate);
								loadEfficiency.setAdmissionDate(admissionDate);
								loadEfficiency.setCompleteDate(completeDate);
								loadEfficiency.setAppearanceDate(appearanceDate);
								loadEfficiency.setWaitHour(waitHour);
								loadEfficiency.setWorkHour(workHour);
								loadEfficiency.setTotalWaitHour(totalWaitHour);
								loadEfficiency.setFactoryHour(factoryHour);
								loadEfficiency.setResReason(resReason);
								loadEfficiency.setResReMarks(resRemarks);
								loadEfficiency.setModifyReMarks(modifyRemarks);
								loadEfficiency.setCreateId(createId);
								loadEfficiency.setCreateDate(createDate);
								loadEfficiency.setModifyId(modifyId);
								loadEfficiency.setModifyDate(modifyDate);
								loadEfficiency.setTotalQuantity(totalQuantity);
								loadEfficiency.setTotalWeight(totalWeight);
								loadEfficiency.setTotalVolume(totalVolume);
								loadEfficiency.setGrossWeight(grossWeight);
						        companyName = null;
						        whName = null;
						        platformName = null;
						        resNumber = null;
						        resStatus = null;
						        resReview = null;
						        resType = null;
						        resCode = null;
						        resBegindate = null;
						        resEnddate = null;
						        truckName = null;
						        driverName = null;
						        driverMobile = null;
						        markInsert = null;
						        markMov = null;
						        markCancel = null;
						        markRefuse = null;
						        markLate = null;
						        markDel = null;
						        signDate = null;
						        callDate = null;
						        admissionDate = null;
						        completeDate = null;
						        appearanceDate = null;
						        waitHour = 0;
						        workHour = 0;
						        totalWaitHour = 0;
						        factoryHour = 0;
						        resReason = null;
						        resRemarks = null;
						        modifyRemarks = null;
						        createId = null;
						        createDate = null;
						        modifyId = null;
						        modifyDate = null;
						        totalQuantity = 0;
						        totalWeight = 0.0;
						        totalVolume = 0.0;
						        grossWeight = 0.0;
								
							}//while3							
							jsonReader.endArray();//end3								
						} else {
							jsonReader.skipValue();
						}//records						
					}//while2
					jsonReader.endObject();//end2					
				} else {
					jsonReader.skipValue();
				}//result				
			}//while1
			jsonReader.endObject();//end1				

			System.out.println("=================Parsed"); 
			
            //Insert into DB
			extractToStaging = new ExtractToStaging();
			result = extractToStaging.load(loadEfficiency);
		}catch(Exception e) {
			//e.printStackTrace();
			result = result + e.toString() +"\n";
		}finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (jsonReader != null) {
				jsonReader.close();
			}
		}//try

		return result;
		
	}//getReservation method

}
