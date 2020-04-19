package com.rsm.hospitalManage;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Hospital {
	private int hosID;
	private String hosName;
	private String hosTelNo;
	private String hosAddress;
	
	
	public int getHosID() {
		return hosID;
	}
	public void setHosID(int hosID) {
		this.hosID = hosID;
	}
	public String getHosName() {
		return hosName;
	}
	public void setHosName(String hosName) {
		this.hosName = hosName;
	}
	public String getHosTelNo() {
		return hosTelNo;
	}
	public void setHosTelNo(String hosTelNo) {
		this.hosTelNo = hosTelNo;
	}
	public String getHosAddress() {
		return hosAddress;
	}
	public void setHosAddress(String hosAddress) {
		this.hosAddress = hosAddress;
	}
	@Override
	public String toString() {
		return "Hospital [hosID=" + hosID + ", hosName=" + hosName + ", hosTelNo=" + hosTelNo + ", hosAddress="
				+ hosAddress + "]";
	}
	
	
}
