package stages;

import java.util.Optional;
import javafx.application.Application;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class stage0 extends Application{
    
   
      static String name="UNKNOWN";
      
      
     public static void main(String[] args) {
        Application.launch(args);
    }
     
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        
        TextInputDialog dialog = new TextInputDialog();
        dialog.initStyle(StageStyle.UTILITY);
        dialog.setTitle(" Welcome!!");
        dialog.setGraphic(new ImageView());
        dialog.setHeaderText("Please enter your name:");
        Optional<String> result = dialog.showAndWait();
        name=result.get();
        
        new home();
    }
}