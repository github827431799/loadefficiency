package reservation;

import java.util.ArrayList;
import java.util.List;

//Model LoadEfficiency
public class LoadEfficiency {	

	private List<String> companyName = new ArrayList<String>();
	private List<String> whName = new ArrayList<String>();
	private List<String> platformName = new ArrayList<String>();
	private List<String> resNumber = new ArrayList<String>();
	private List<String> resStatus = new ArrayList<String>();
	private List<String> resReview = new ArrayList<String>();
	private List<String> resType = new ArrayList<String>();
	private List<String> resCode = new ArrayList<String>();
	private List<String> resBegindate = new ArrayList<String>();
	private List<String> resEnddate = new ArrayList<String>();
	private List<String> truckName = new ArrayList<String>();
	private List<String> driverName = new ArrayList<String>();
	private List<String> driverMobile = new ArrayList<String>();
	private List<String> markInsert = new ArrayList<String>();
	private List<String> markMov = new ArrayList<String>();
	private List<String> markCancel = new ArrayList<String>();
	private List<String> markRefuse = new ArrayList<String>();
	private List<String> markLate = new ArrayList<String>();
	private List<String> markDel = new ArrayList<String>();
	private List<String> signDate = new ArrayList<String>();
	private List<String> callDate = new ArrayList<String>();
	private List<String> admissionDate = new ArrayList<String>();
	private List<String> completeDate = new ArrayList<String>();
	private List<String> appearanceDate = new ArrayList<String>();
	private List<Integer> waitHour = new ArrayList<Integer>();
	private List<Integer> workHour = new ArrayList<Integer>();
	private List<Integer> totalWaitHour = new ArrayList<Integer>();
	private List<Integer> factoryHour = new ArrayList<Integer>();
	private List<String> resReason = new ArrayList<String>();
	private List<String> resRemarks = new ArrayList<String>();
	private List<String> modifyRemarks = new ArrayList<String>();
	private List<String> createId = new ArrayList<String>();
	private List<String> createDate = new ArrayList<String>();
	private List<String> modifyId = new ArrayList<String>();
	private List<String> modifyDate = new ArrayList<String>();
	private List<Integer> totalQuantity = new ArrayList<Integer>();
	private List<Double> totalWeight = new ArrayList<Double>();
	private List<Double> totalVolume = new ArrayList<Double>();
	private List<Double> grossWeight = new ArrayList<Double>();
	
	//Get method
	public String getCompanyName(int i) {
		return companyName.get(i);
	}
	public String getWhName(int i) {
		return whName.get(i);
	}
	public String getPlatformName(int i) {
		return platformName.get(i);
	}
	public String getResNumber(int i) {
		return resNumber.get(i);
	}
	public String getResStatus(int i) {
		return resStatus.get(i);
	}
	public String getResReview(int i) {
		return resReview.get(i);
	}
	public String getResType(int i) {
		return resType.get(i);
	}
	public String getResCode(int i) {
		return resCode.get(i);
	}
	public String getResBegindate(int i) {
		return resBegindate.get(i);
	}
	public String getResEnddate(int i) {
		return resEnddate.get(i);
	}
	public String getTruckName(int i) {
		return truckName.get(i);
	}
	public String getDriverName(int i) {
		return driverName.get(i);
	}
	public String getDriverMobile(int i) {
		return driverMobile.get(i);
	}
	public String getMarkInsert(int i) {
		return markInsert.get(i);
	}
	public String getMarkMov(int i) {
		return markMov.get(i);
	}
	public String getMarkCancel(int i) {
		return markCancel.get(i);
	}
	public String getMarkRefuse(int i) {
		return markRefuse.get(i);
	}
	public String getMarkLate(int i) {
		return markLate.get(i);
	}
	public String getMarkDel(int i) {
		return markDel.get(i);
	}
	public String getSignDate(int i) {
		return signDate.get(i);
	}
	public String getCallDate(int i) {
		return callDate.get(i);
	}
	public String getAdmissionDate(int i) {
		return admissionDate.get(i);
	}
	public String getCompleteDate(int i) {
		return completeDate.get(i);
	}
	public String getAppearanceDate(int i) {
		return appearanceDate.get(i);
	}
	public Integer getWaitHour(int i) {
		return waitHour.get(i);
	}
	public Integer getWorkHour(int i) {
		return workHour.get(i);
	}
	public Integer getTotalWaitHour(int i) {
		return totalWaitHour.get(i);
	}
	public Integer getFactoryHour(int i) {
		return factoryHour.get(i);
	}
	public String getResReason(int i) {
		return resReason.get(i);
	}
	public String getResReMarks(int i) {
		return resRemarks.get(i);
	}
	public String getModifyReMarks(int i) {
		return modifyRemarks.get(i);
	}
	public String getCreateId(int i) {
		return createId.get(i);
	}
	public String getCreateDate(int i) {
		return createDate.get(i);
	}
	public String getModifyId(int i) {
		return modifyId.get(i);
	}
	public String getModifyDate(int i) {
		return modifyDate.get(i);
	}
	public Integer getTotalQuantity(int i) {
		return totalQuantity.get(i);
	}
	public Double getTotalWeight(int i) {
		return totalWeight.get(i);
	}
	public Double getTotalVolume(int i) {
		return totalVolume.get(i);
	}
	public Double getGrossWeight(int i) {
		return grossWeight.get(i);
	}

	//Set method
	public void setCompanyName(String newCompanyName) {
		companyName.add(newCompanyName);
	}	
	public void setWhName(String newWhName) {
		whName.add(newWhName);
	}	
	public void setPlatformName(String newPlatformName) {
		platformName.add(newPlatformName);
	}	
	public void setResNumber(String newResNumber) {
		resNumber.add(newResNumber);
	}
	public void setResStatus(String newResStatus) {
		resStatus.add(newResStatus);
	}
	public void setResReview(String newResReview) {
		resReview.add(newResReview);
	}
	public void setResType(String newResType) {
		resType.add(newResType);
	}
	public void setResCode(String newResCode) {
		resCode.add(newResCode);
	}
	public void setResBegindate(String newResBegindate) {
		resBegindate.add(newResBegindate);
	}
	public void setResEnddate(String newResEnddate) {
		resEnddate.add(newResEnddate);
	}
	public void setTruckName(String newTruckName) {
		truckName.add(newTruckName);
	}
	public void setDriverName(String newDriverName) {
		driverName.add(newDriverName);
	}
	public void setDriverMobile(String newDriverMobile) {
		driverMobile.add(newDriverMobile);
	}
	public void setMarkInsert(String newMarkInsert) {
		markInsert.add(newMarkInsert);
	}
	public void setMarkMov(String newMarkMov) {
		markMov.add(newMarkMov);
	}
	public void setMarkCancel(String newMarkCancel) {
		markCancel.add(newMarkCancel);
	}
	public void setMarkRefuse(String newMarkRefuse) {
		markRefuse.add(newMarkRefuse);
	}
	public void setMarkLate(String newMarkLate) {
		markLate.add(newMarkLate);
	}
	public void setMarkDel(String newMarkDel) {
		markDel.add(newMarkDel);
	}
	public void setSignDate(String newSignDate) {
		signDate.add(newSignDate);
	}
	public void setCallDate(String newCallDate) {
		callDate.add(newCallDate);
	}
	public void setAdmissionDate(String newAdmissionDate) {
		admissionDate.add(newAdmissionDate);
	}
	public void setCompleteDate(String newCompleteDate) {
		completeDate.add(newCompleteDate);
	}
	public void setAppearanceDate(String newAppearanceDate) {
		appearanceDate.add(newAppearanceDate);
	}
	public void setWaitHour(Integer newWaitHour) {
		waitHour.add(newWaitHour);
	}
	public void setWorkHour(Integer newWorkHour) {
		workHour.add(newWorkHour);
	}
	public void setTotalWaitHour(Integer newTotalWaitHour) {
		totalWaitHour.add(newTotalWaitHour);
	}
	public void setFactoryHour(Integer newFactoryHour) {
		factoryHour.add(newFactoryHour);
	}
	public void setResReason(String newResReason) {
		resReason.add(newResReason);
	}
	public void setResReMarks(String newResReMarks) {
		resRemarks.add(newResReMarks);
	}
	public void setModifyReMarks(String newModifyReMarks) {
		modifyRemarks.add(newModifyReMarks);
	}
	public void setCreateId(String newCreateId) {
		createId.add(newCreateId);
	}
	public void setCreateDate(String newCreateDate) {
		createDate.add(newCreateDate);
	}
	public void setModifyId(String newModifyId) {
		modifyId.add(newModifyId);
	}
	public void setModifyDate(String newModifyDate) {
		modifyDate.add(newModifyDate);
	}
	public void setTotalQuantity(Integer newTotalQuantity) {
		totalQuantity.add(newTotalQuantity);
	}
	public void setTotalWeight(Double newTotalWeight) {
		totalWeight.add(newTotalWeight);
	}
	public void setTotalVolume(Double newTotalVolume) {
		totalVolume.add(newTotalVolume);
	}
	public void setGrossWeight(Double newGrossWeight) {	
		grossWeight.add(newGrossWeight);
	}

	
	//Calculate size
	public int getSize() {
		return this.companyName.size();
	}	

}
