package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class NewController {

    @FXML
    private TextField question1;
    @FXML
    private TextField location1;
    @FXML
	private AnchorPane homePane;
    
	public ArrayList<String> text = new ArrayList<String>();
	static File file = new File("new.txt");

    @FXML
    public void addButton(ActionEvent event) throws IOException{
		text.add(question1.getText());
		question1.clear();
    }

    @FXML
    public void enterButton(ActionEvent event) throws IOException{
    	text.add(location1.getText());
    	location1.clear();
    }

    @FXML
    public void doneButton(ActionEvent event) throws IOException{
    	newFile(text);
    	homePane= FXMLLoader.load(getClass().getResource("frontPage.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(homePane);
        stage.setScene(scene);
        stage.show();
		((Stage)(((Button)event.getSource()).getScene().getWindow())).close();

    }

    private static void newFile(ArrayList<String> text)
	{
		try {
	        FileWriter fw = new FileWriter(file);
	        BufferedWriter output = new BufferedWriter(fw);
	        for (int i = 0; i < text.size(); i++)
	        {
	            output.write(text.get(i).toString());
	            output.newLine();
	        }
	        
	        output.close();
			} catch (Exception e) {
				e.printStackTrace();
				}
		
	}
}

