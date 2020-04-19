package Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LaboratoryModel {

	private String idLaboratory;
	private String LabName;
	private String address;
	private int telNo;
	private String city;
	public String getIdLaboratory() {
		return idLaboratory;
	}
	public void setIdLaboratory(String idLaboratory) {
		this.idLaboratory = idLaboratory;
	}
	public String getLabName() {
		return LabName;
	}
	public void setLabName(String labName) {
		LabName = labName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getTelNo() {
		return telNo;
	}
	public void setTelNo(int telNo) {
		this.telNo = telNo;
	}
	
	@Override
	public String toString() {
		return "Laboratory [idLaboratory=" + idLaboratory + ", LabName=" + LabName + ", address=" + address + ", city="
				+ city + ", telNo=" + telNo + "]";
	}
	
}
