module JavaFXTxtFileOps {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens txt.file.ops to javafx.graphics, javafx.fxml;
}
