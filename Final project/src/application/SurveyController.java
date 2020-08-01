package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class SurveyController {

	@FXML
	private TextArea survey;
	
	@FXML
	private TextField nameID;
	
	@FXML
	private TextField locationDateTime;
	
	public ArrayList<String> list = new ArrayList<String>();
	
	private Scanner reader;
	
	@FXML
	public void getSurvey(ActionEvent event) throws IOException{
		File f = new File("new.txt");
		reader = new Scanner(f);
		while(reader.hasNextLine()){
			String line = reader.nextLine();
			survey.setText(line);
		}
		
	}
	
	@FXML 
	public void submitButton(ActionEvent event) throws IOException{
		String page = survey.getText().toString();
		String user = nameID.getText().toString();
		String stamp = locationDateTime.getText().toString();
		
		if((page == null || page.isEmpty()) || (user == null) || (user.isEmpty()) || (stamp == null) || stamp.isEmpty()){
			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("Error");
			error.setHeaderText("Missing info");
			error.setContentText("Try Again");
			error.showAndWait();
		}
		
		list.add(user);
		list.add(page);
		list.add(stamp);
		
		File file = new File"SurveyResults.txt");
		FileWriter f = new FileWriter(file);
		BufferedWriter writer = new BufferedWriter(f);
		
		for(int i = 0; i < list.size(); i++){
			writer.write(list.get(i).toString());
			writer.newLine();
		}
		
		writer.close();
		
		survey.clear();
		nameID.clear();
		locationDateTime.clear();
	}
	
	@FXML
    	public void goBack(ActionEvent event) {
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
