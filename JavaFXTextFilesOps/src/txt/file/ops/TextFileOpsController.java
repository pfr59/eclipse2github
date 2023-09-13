package txt.file.ops;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextFileOpsController {
	
	@FXML
	// TextArea property Wrap Text has been checked in Scene Builder.
	private TextArea txtArea;
	
    File fileApp;
	
	// create a File chooser
    FileChooser filechooser = new FileChooser();
    	
	public void openFile() {
		// Place Holder Stub.
		System.out.println("Method: openFile()");
		filechooser.setTitle("Open File");
		setFileChoserExtenstions();
		fileApp = filechooser.showOpenDialog(null);
		writeFileToTextArea();
	}
	
	public void saveFile() {
		// Place Holder Stub.
		System.out.println("Method: saveFile()");
		filechooser.setTitle("Save File");
		setFileChoserExtenstions();
		fileApp = filechooser.showSaveDialog(null);
		writeTextAreaToFile();
	}
	
	private void setFileChoserExtenstions() {
		// File extensions as per: https://docs.oracle.com/javase/8/javafx/api/javafx/stage/FileChooser.html
		filechooser.getExtensionFilters().addAll(
		         new ExtensionFilter("Text Files", "*.txt", "*.doc"),
		         new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
		         new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
		         new ExtensionFilter("All Files", "*.*"));
	}
	
	public void closeApp() {
		// Place Holder Stub.
		System.out.println("Method: closeApp()");
        Platform.exit();
        System.exit(0);
	}	
	
	public void aboutApp() {
		// Place Holder Stub.
		System.out.println("Method: aboutApp()");
		// Message box created as per: https://code.makery.ch/blog/javafx-dialogs-official/
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("About This Program");
		alert.setHeaderText("");
		alert.setContentText("This Program was developed as an exercise in using "
				+ "Scene Builder, JavaFX and text file open and save operations.");
		alert.showAndWait();
	}
	
	public void writeFileToTextArea() {
		// Place Holder Stub.
		System.out.println("Method: writeFileToTextArea()");
		String strToTextArea;
        try {
        	Path filePath = fileApp.toPath();
        	strToTextArea = Files.readString(filePath);
        	txtArea.setText(strToTextArea);
        } catch (IOException e) {
            e.printStackTrace();
        }		
	}
	
	public void writeTextAreaToFile() {
		// Place Holder Stub.
		System.out.println("Method: writeTextAreaToFile()");
		try
		{
			PrintWriter writer;
			writer = new PrintWriter(fileApp);
			writer.println(txtArea.getText());
			writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
