package model;
/**
 * Survey class is used to store survey data. each element is private with a getter and a setter.
 * method isSickSurvey() is used to score the survey data if it has all been loaded
 * @author rongrong
 *
 */
public class Survey {
	private String employeeId;
	private String surveyDate;
	private String location;
	private String temperatureValue;
	private Boolean travel14Days;
	private Boolean covidSymptoms; // 
	private Boolean covidContact; // contact with anyone with symptoms
	private Boolean sickStatus;
	
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
	
	public Boolean isSickSurvey() {
		
		if (travel14Days || covidSymptoms || covidContact || (Double.parseDouble(temperatureValue)>100.4)) {
			sickStatus = true;
			
		} 
		else {
			sickStatus = false;
		}
		return sickStatus;
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
