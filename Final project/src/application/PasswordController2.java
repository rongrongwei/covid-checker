package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/** 
* Ask the administrator for password in order to go to the create new page
*/
public class PasswordController2 {
	
	@FXML
	private AnchorPane passwordPane;
    @FXML
    private PasswordField password;

    @FXML
    public void loginButton(ActionEvent event) throws IOException {
    	String p = password.getText();
    	String key = "123";

    	Alert a = new Alert(AlertType.NONE); 
    	if (p.equals(key)) {
    		passwordPane= FXMLLoader.load(getClass().getResource("Admin.fxml"));
	        Stage stage = new Stage();
	        Scene scene = new Scene(passwordPane);
	        stage.setScene(scene);
	        stage.show(); 
   			((Stage)(((Button)event.getSource()).getScene().getWindow())).close();

    	}
    	else {
    		a.setAlertType(AlertType.ERROR);
    		a.setTitle("Login Page");
    		a.setHeaderText("Wrong Password");
    		a.setContentText("Please re-enter again");
    		a.show(); 
    	}
    	
    	
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
