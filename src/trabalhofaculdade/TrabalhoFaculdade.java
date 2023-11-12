package trabalhofaculdade;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TrabalhoFaculdade extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        String file = "TelaLogin.fxml";
        URL url = getClass().getResource(file);
        Parent root = FXMLLoader.load(url);        
        Scene scene = new Scene(root);        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
