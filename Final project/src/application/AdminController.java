package application;


import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.DataStore;
import model.Survey;



public class AdminController {
	
	@FXML 
	TextArea resultsTextArea;
	
	@FXML
	Button resultsButton;
	private DataStore data;
	private Survey survey;
	private ArrayList<Survey> arr = new ArrayList<Survey>();
	
	
	@FXML
	public void resultsButtonAction(ActionEvent event) throws Exception{
		arr =(data.loadSurveysList());
		survey =arr.get(0);
		resultsTextArea.setText(survey.getEmployeeId()+ " "+survey.getSurveyDate()+" "+survey.getLocation()+" "+survey.getTemperatureValue()+" "+survey.getTravel14Days()+" "+survey.getCovidSymptoms()+" "+survey.getCovidContact());
		
		
	}
	
	@FXML
    void goBack(ActionEvent event) {
    	try{
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("frontPage.fxml"));
    		Parent root1 = (Parent) fxmlLoader.load();
    		Stage stage = new Stage();
    		stage.setTitle("Survey");
    		stage.setScene(new Scene(root1));
    		stage.show();

   			((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    	} catch (Exception e){
    		System.out.println("Cant load new window");
    	}
    }
}
