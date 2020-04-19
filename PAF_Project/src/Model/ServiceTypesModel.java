package Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ServiceTypesModel {

	private String idService;
	private String serviceName;
	private String description;
	public String getIdService() {
		return idService;
	}
	public void setIdService(String idService) {
		this.idService = idService;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
