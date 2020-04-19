package Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AppointmentModel {

	private String idAppointment;
	private String date;
	private String idPatient;
	private int lab_service_ID;
	
	
	public String getIdAppointment() {
		return idAppointment;
	}
	public void setIdAppointment(String idAppointment) {
		this.idAppointment = idAppointment;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(String idPatient) {
		this.idPatient = idPatient;
	}
	public int getLab_service_ID() {
		return lab_service_ID;
	}
	public void setLab_service_ID(int lab_service_ID) {
		this.lab_service_ID = lab_service_ID;
	}
	
	
	
	
}
