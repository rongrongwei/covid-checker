package application;


import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
//import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.DataStore;
import model.Survey;
/** 
* Displays the survey results from survey page
*/

public class AdminController {
	
    @FXML
    private ListView<String> adminList;
	
	@FXML
	Button resultsButton;
	private DataStore data;
	
	
	@FXML
	public void resultsButtonAction(ActionEvent event) throws Exception{
		/**
		 * used to populate the list view with a set of employees who are currently sick
		 */
		adminList.getItems().clear();
		data = new DataStore("123", "keyfile", "employeefile", "surveyfile"); // remove hard-coding later
    	ArrayList<Survey> surveyList = data.loadSurveysList();
    	
		for (Survey survey: surveyList) {
			
			// only display sick employees
			if (survey.isSickSurvey()) {
	    		String listItem = survey.getEmployeeId() +":    " + survey.getTemperatureValue();
	    		adminList.getItems().add(listItem);
			}
			
		}
				
		adminList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

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
