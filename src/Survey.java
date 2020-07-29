
public class Survey {
	private String employeeId;
	private String surveyDate;
	private String location;
	private String temperatureValue;
	private String symptoms;
	
	public Survey(String employeeId, String surveyDate, String location, String temperatureValue) {
		super();
		this.employeeId = employeeId;
		this.surveyDate = surveyDate;
		this.location = location;
		this.temperatureValue = temperatureValue;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getSurveyDate() {
		return surveyDate;
	}
	public void setSurveyDate(String surveyDate) {
		this.surveyDate = surveyDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTemperatureValue() {
		return temperatureValue;
	}
	public void setTemperatureValue(String temperatureValue) {
		this.temperatureValue = temperatureValue;
	}
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	
}
