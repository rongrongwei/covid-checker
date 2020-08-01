package application;


import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import model.DataStore;
import model.Survey;
import model.TestDataStore;


public class AdminController {
	
	@FXML 
	TextArea resultsTextArea;
	
	@FXML
	Button resultsButton;
	private DataStore data;
	private Survey survey;
	private TestDataStore test;
	private ArrayList<Survey> arr = new ArrayList<Survey>();
	
	
	@FXML
	public void resultsButtonAction(ActionEvent event) throws Exception{
		arr =(data.loadSurveysList());
		survey =arr.get(0);
		resultsTextArea.setText(survey.getEmployeeId()+ " "+survey.getSurveyDate()+" "+survey.getLocation()+" "+survey.getTemperatureValue()+" "+survey.getTravel14Days()+" "+survey.getCovidSymptoms()+" "+survey.getCovidContact());
		
		
	}
}
