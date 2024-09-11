package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        try{
            Parent root = FXMLLoader.load(getClass().getResource("index.fxml"));
            primaryStage.setTitle("Aplicativo de ordenação");
            primaryStage.setScene(new Scene(root, 1024, 768));
            primaryStage.show();
        }catch(IOException io) {
            io.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}