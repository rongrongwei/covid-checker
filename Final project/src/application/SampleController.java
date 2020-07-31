package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SampleController {
	 @FXML
	    private Button signIn;

	    @FXML
	    private Button Admin;

	    @FXML
	    private Button createNew;

	    @FXML
	    void toSignInPage(ActionEvent event) {
	    	try{
	    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("signIn.fxml"));
	    		Parent root1 = (Parent) fxmlLoader.load();
	    		Stage stage = new Stage();
	    		stage.setTitle("Sign-In");
	    		stage.setScene(new Scene(root1));
	    		stage.show();

	   			((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
	    	} catch (Exception e){
	    		System.out.println("Cant load new window");
	    	}

	    }

	    @FXML
	    void toCreateNewPage(ActionEvent event) {
	    	try{
	    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Password.fxml"));
	    		Parent root1 = (Parent) fxmlLoader.load();
	    		Stage stage = new Stage();
	    		stage.setTitle("Create New");
	    		stage.setScene(new Scene(root1));
	    		stage.show();

	   			((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
	    	} catch (Exception e){
	    		System.out.println("Cant load new window");
	    	}

	    }

	    @FXML
	    void toAdminPage(ActionEvent event) {
	    	try{
	    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Admin.fxml"));
	    		Parent root1 = (Parent) fxmlLoader.load();
	    		Stage stage = new Stage();
	    		stage.setTitle("Administrator");
	    		stage.setScene(new Scene(root1));
	    		stage.show();

	   			((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
	    	} catch (Exception e){
	    		System.out.println("Cant load new window");
	    	}
	    }
	    
	    @FXML
	    void goToSurveyPage(ActionEvent event) {
	    	try{
	    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("survey.fxml"));
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
