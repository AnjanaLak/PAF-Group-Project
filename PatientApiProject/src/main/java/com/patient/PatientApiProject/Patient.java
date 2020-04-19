package com.patient.PatientApiProject;

public class Patient {
	
	public int PID;
	public String PName;
	public int PAge;
	public String TypeOfSick;
	
	public int getPID() {
		return PID;
	}
	public void setPID(int pID) {
		PID = pID;
	}
	
	public String getPName() {
		return PName;
	}
	public void setPName(String pName) {
		PName = pName;
	}
	public int getPAge() {
		return PAge;
	}
	public void setPAge(int pAge) {
		PAge = pAge;
	}
	public String getTypeOfSick() {
		return TypeOfSick;
	}
	public void setTypeOfSick(String typeOfSick) {
		TypeOfSick = typeOfSick;
	}
	@Override
	public String toString() {
		return "Patient [PID=" + PID + ", PName=" + PName + ", PAge=" + PAge + ", TypeOfSick=" + TypeOfSick + "]";
	}
	
	
}
