package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.DataStore;
import model.Survey;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
/** 
* Asks user to answer some questions and store that data using Survey class / DataStore class (see model package)
*/
public class SurveyController implements Initializable{

    @FXML
    private TextField temperatureBox;

    @FXML
    private Button submitButton;

    @FXML
    private TextField DateBox;

    @FXML
    private Button mainMenuButton;

    @FXML
    private TextField employeeIDBox;

    @FXML
    private RadioButton travelYes;

    @FXML
    private ToggleGroup symptoms;

    @FXML
    private RadioButton symptomsYes;

    @FXML
    private RadioButton contactYes;

    @FXML
    private ToggleGroup contact;

    @FXML
    private RadioButton travelNo;

    @FXML
    private RadioButton symptomsNo;

    @FXML
    private ToggleGroup travel;

    @FXML
    private ComboBox<String> locationBox;

    @FXML
    private RadioButton contactNo;

    @FXML
    void goBack(ActionEvent event) {
    	/**
    	 * this button controller takes the user back to the front page
    	 */
    	try{
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("frontPage.fxml"));
    		Parent root1 = (Parent) fxmlLoader.load();
    		Stage stage = new Stage();
    		stage.setTitle("Survey");
    		stage.setScene(new Scene(root1));
    		stage.show();

   			((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    	} catch (Exception e){
    		e.printStackTrace();
    		System.out.println("Cant load new window");
    	}
    }


    @FXML
    void submitButton(ActionEvent event) throws Exception {
	    /**
	     * This method validates the survey form to make sure all data has been entered correctly
	     * This method saves the survey data using the DataStore
	     * This method raises a warning window if the user has entered data that might indicate that the user
	     * is at risk for spreading COVID-19
	     */
    	// get text fields
    	String employeeId = employeeIDBox.getText();
    	String date = DateBox.getText();
    	String location = locationBox.getValue();
    	String temperature = temperatureBox.getText();
    	
    	if (employeeId.isEmpty() || date.isEmpty() || location.isEmpty() || temperature.isEmpty()) {
    		System.out.println("HELP2");
    		incompleteError();
    		return;
    	}
    	

    	// validate temperature
    	try
    	{
    	  Double.parseDouble(temperature);
    	}
    	catch(NumberFormatException e)
    	{
    		invalidTemperatureError();
    		return;
    	}
    	
    	if (Double.parseDouble(temperature) < 90 || Double.parseDouble(temperature) > 110 ) {
    		invalidTemperatureError();
    		return;
    	}
    	
    	// Travel 14 Days 
    	Boolean travelStatus = false;
    	if (travel.getSelectedToggle() == travelYes) {
    		travelStatus = true;
    	}
    	else if (travel.getSelectedToggle() == travelNo) {
    		travelStatus = false;
    	}
    	else {
    		System.out.println("Travel Incomplete");
    		incompleteError();
    		return;
    	}
    		
    	// Symptoms
    	Boolean symptomsStatus = false;
    	if (symptoms.getSelectedToggle() == symptomsYes) {
    		symptomsStatus = true;
    	}
    	else if (symptoms.getSelectedToggle() == symptomsNo) {
    		symptomsStatus = false;
    	}
    	else {
    		System.out.println("Symptoms Incomplete");
    		incompleteError();
    		return;
    	}

    	// Contact
    	Boolean contactStatus = false;
    	if (contact.getSelectedToggle() == contactYes) {
    		contactStatus = true;
    	}
    	else if (contact.getSelectedToggle() == contactNo) {
    		contactStatus = false;
    	}
    	else {
    		System.out.println("Contact Incomplete");
    		incompleteError();
    		return;
    	}
    		
    	// make new survey
    	Survey newSurvey = new Survey(employeeId, date, location, temperature, travelStatus, symptomsStatus, contactStatus);
    	
    	// Use Data Store to Save Survey
    	DataStore data = new DataStore("123", "keyfile", "employeefile", "surveyfile"); // remove hardcoding later
    	ArrayList<Survey> surveyList = data.loadSurveysList();
    	surveyList.add(newSurvey);
    	data.saveSurveysList(surveyList);
    	

    	// GO BACK TO MAIN PAGE
    	try{
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("frontPage.fxml"));
    		Parent root1 = (Parent) fxmlLoader.load();
    		Stage stage = new Stage();
    		stage.setTitle("Survey");
    		stage.setScene(new Scene(root1));
    		stage.show();

   			((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    	} catch (Exception e){
    		e.printStackTrace();
    		System.out.println("Cant load main page window");
    	}
    	if (newSurvey.isSickSurvey()) {
    		finishedSickAlert();
    	}
    	else {
        	finishedSurveyAlert();

    	}

    	return;
    }
    
    void incompleteError() {
    	Alert a = new Alert(AlertType.NONE);
    	// set alert type
    	a.setAlertType(AlertType.ERROR);
    	a.setContentText("Finish Filling out Survey Please");
    	a.show();
    }
    
	void invalidTemperatureError() {
    	Alert a = new Alert(AlertType.NONE);
    	// set alert type
    	a.setAlertType(AlertType.ERROR);
    	a.setContentText("Please enter a valid temperature between 90 and 110");
    	a.show();
	}
	
	void finishedSurveyAlert() {
    	Alert a = new Alert(AlertType.NONE);
    	// set alert type
    	a.setAlertType(AlertType.CONFIRMATION);
    	a.setContentText("Successfully Signed In!");
    	a.show();
	}

	void finishedSickAlert() {
    	Alert a = new Alert(AlertType.NONE);
    	// set alert type
    	a.setAlertType(AlertType.WARNING);
    	a.setContentText("Please go home and quarantine!");
    	a.show();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/**
		 * populates drop down box 
		 */
		// Hard Code Locations for Now
		locationBox.getItems().removeAll(locationBox.getItems());
		locationBox.getItems().addAll("Location A", "Location B", "Location C");
		locationBox.getSelectionModel().select("Location A");
		
	}
	 
}
