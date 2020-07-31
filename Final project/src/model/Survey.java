package model;

public class Survey {
	private String employeeId;
	private String surveyDate;
	private String location;
	private String temperatureValue;
	private Boolean travel14Days;
	private Boolean covidSymptoms; // 
	private Boolean covidContact; // contact with anyone with symptoms
	
	public Survey(String employeeId, String surveyDate, String location, String temperatureValue) {
		this.employeeId = employeeId;
		this.surveyDate = surveyDate;
		this.location = location;
		this.temperatureValue = temperatureValue;
	}

	public Survey(String employeeId, String surveyDate, String location, String temperatureValue, Boolean travel14Days,
			Boolean covidSymptoms, Boolean covidContact) {
		super();
		this.employeeId = employeeId;
		this.surveyDate = surveyDate;
		this.location = location;
		this.temperatureValue = temperatureValue;
		this.travel14Days = travel14Days;
		this.covidSymptoms = covidSymptoms;
		this.covidContact = covidContact;
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

	public Boolean getTravel14Days() {
		return travel14Days;
	}

	public void setTravel14Days(Boolean travel14Days) {
		this.travel14Days = travel14Days;
	}

	public Boolean getCovidSymptoms() {
		return covidSymptoms;
	}

	public void setCovidSymptoms(Boolean covidSymptoms) {
		this.covidSymptoms = covidSymptoms;
	}

	public Boolean getCovidContact() {
		return covidContact;
	}

	public void setCovidContact(Boolean covidContact) {
		this.covidContact = covidContact;
	}
	
}
