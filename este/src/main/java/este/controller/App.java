package este.controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
public class App extends Application {
    public static void main( String[] args ){
    	launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
    	AnchorPane page = (AnchorPane) FXMLLoader.load(this.getClass().getResource("/este/view/crud.fxml"));
        Scene scene = new Scene(page);

        primaryStage.setScene(scene);
        primaryStage.show();
	}
}