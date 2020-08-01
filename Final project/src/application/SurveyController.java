package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.DataStore;
import model.Survey;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
/** 
* Asks user to answer some questions and store that data
*/
public class SurveyController implements Initializable{
//
//	@FXML
//	private TextArea survey;
//	
//	@FXML
//	private TextField nameID;
//	
//	@FXML
//	private TextField locationDateTime;
//	
//	public ArrayList<String> list = new ArrayList<String>();
//	
//	private Scanner reader;
//	
//	@FXML
//	public void getSurvey(ActionEvent event) throws IOException{
//		File f = new File("new.txt");
//		reader = new Scanner(f);
//		while(reader.hasNextLine()){
//			String line = reader.nextLine();
//			survey.setText(line);
//		}
//		
//	}
//	
//	@FXML 
//	public void submitButton(ActionEvent event) throws IOException{
//		String page = survey.getText().toString();
//		String user = nameID.getText().toString();
//		String stamp = locationDateTime.getText().toString();
//		
//		if((page == null || page.isEmpty()) || (user == null) || (user.isEmpty()) || (stamp == null) || stamp.isEmpty()){
//			Alert error = new Alert(AlertType.ERROR);
//			error.setTitle("Error");
//			error.setHeaderText("Missing info");
//			error.setContentText("Try Again");
//			error.showAndWait();
//		}
//		
//		list.add("===================================================");
//		list.add("Employee:");
//		list.add(user);
//		list.add("Survey Results:");
//		list.add(page);
//		list.add("Location, Date, time:");
//		list.add(stamp);
//		list.add("===================================================");
//		
//		File file = new File"SurveyResults.txt");
//		FileWriter f = new FileWriter(file);
//		BufferedWriter writer = new BufferedWriter(f);
//		
//		for(int i = 0; i < list.size(); i++){
//			writer.write(list.get(i).toString());
//			writer.newLine();
//		}
//		
//		writer.close();
//		
//		survey.clear();
//		nameID.clear();
//		locationDateTime.clear();
//	}
//	
//	@FXML
//    	public void goBack(ActionEvent event) {
//    		try{
//    			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("frontPage.fxml"));
//    			Parent root1 = (Parent) fxmlLoader.load();
//    			Stage stage = new Stage();
//    			stage.setTitle("Survey");
//    			stage.setScene(new Scene(root1));
//    			stage.show();
//
//   			((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
//    		} catch (Exception e){
//    		System.out.println("Cant load new window");
//    		}
//    	}


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
		
		// Hard Code Locations for Now
		locationBox.getItems().removeAll(locationBox.getItems());
		locationBox.getItems().addAll("Location A", "Location B", "Location C");
		locationBox.getSelectionModel().select("Location A");
		
	}
	 
}
