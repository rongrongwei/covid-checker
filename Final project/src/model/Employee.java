package model;
import java.util.ArrayList;

public class Employee {
	public String employeeId;
	private String firstName;
	private String lastName;
	private Boolean illnessStatus;
	private ArrayList<Survey> surveyList;
	
	public Employee(String employeeId) {
		this.employeeId = employeeId;
		illnessStatus = false;	
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Boolean getIllnessStatus() {
		return illnessStatus;
	}

	public void setIllnessStatus(Boolean illnessStatus) {
		this.illnessStatus = illnessStatus;
	}
	
	public void addSurvey(Survey s) {
		surveyList.add(s);
	}
	
	public ArrayList<Survey> getSurveys() {
		return surveyList;
	}
}
