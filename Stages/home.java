package stages;

//import static java.awt.Color.white;
import javafx.scene.control.Button;
import javafx.geometry.Insets; 
import javafx.scene.text.Text; 
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import quiz.*;

public class home {//9769912866
    
    Pane gridPane;
    
     Text welcome=new Text("Welcome!! "+stage0.name);
     static Button btn1 = new Button("Learn");
      static Button btn2 = new Button("Quiz");
      static Button btn3 = new Button("Game");
      
   public Button back,home,sort,graph;
   
public static void close1(Stage p)
     {
         p.close();
         new learn();
     }
     public static void close2(Stage p)
     {
         //p.close();
         new bs_quiz2().q2(); 
        // new quick_sort().tp();
     }
     public static void close3(Stage p)
     {
         //p.close();
         
         new theory.Theory().main_theory();
     }
     
    public static void css_style1()
     {
         btn1.setStyle("-fx-background-color: #4d79ff ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 35px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
         btn1.setText("Learn  >>");
     }  
    public static void css_style1_over()
     {
         btn1.setStyle("-fx-background-color: #99d6ff  ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 60px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
         btn1.setText("Learn");
     }
    
    public static void css_style2()
     {
         btn2.setStyle("-fx-background-color: #4d79ff ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 36px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
         btn2.setText("Quiz  >>");
     }  
    public static void css_style2_over()
     {
         btn2.setStyle("-fx-background-color: #99d6ff  ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 60px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
         btn2.setText("Quiz");
     }
    
    public static void css_style3()
     {
         btn3.setStyle("-fx-background-color: #4d79ff ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 36px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
         btn3.setText("Game  >>");
     }  
    public static void css_style3_over()
     {
         btn3.setStyle("-fx-background-color: #99d6ff  ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 60px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
         btn3.setText("Game");
     }
    

    public home()
    {
        {
            
             welcome.setStyle("-fx-background-color: Black ; -fx-font-size: 40pt; -fx-alignment: Center;");
             welcome.applyCss();
             welcome.setFill(Color.WHITE);
             welcome.setX(240.0);
             welcome.setY(150.0);
             welcome.setFont(Font.font("Comic-Sans", FontWeight.BOLD, 0));
        btn1.setStyle("-fx-background-color:#99d6ff ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 60px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
           
        btn2.setStyle("-fx-background-color: #99d6ff ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 60px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
     
        btn3.setStyle("-fx-background-color: #99d6ff ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 60px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
             
        Stage primaryStage=new Stage(); 
        
        
        btn1.setOnMouseEntered(eve-> css_style1());
        btn1.setOnMouseExited(eve-> css_style1_over());
        
         btn2.setOnMouseEntered(eve-> css_style2());
        btn2.setOnMouseExited(eve-> css_style2_over());
        
         btn3.setOnMouseEntered(eve-> css_style3());
        btn3.setOnMouseExited(eve-> css_style3_over());
        
        btn1.setOnAction(eve-> close1(primaryStage));
         btn2.setOnAction(eve-> close2(primaryStage));
         btn3.setOnAction(eve-> close3(primaryStage));
        
        
         
        gridPane = new Pane(); 
        gridPane.setMinSize(400, 200); 
        //Setting the padding  
      gridPane.setPadding(new Insets(10, 10, 10, 10)); 
      
      gridPane.getChildren().addAll(welcome,btn1,btn2,btn3);//,btn1,btn2,btn3);
       //gridPane.getChildren().add(btn1);
        gridPane.setStyle("-fx-background-color: BLACK;"); //BEIGE
		
        btn1.setLayoutX(120);
        btn1.setLayoutY(250);
        
        btn2.setLayoutX(370);
        btn2.setLayoutY(250);
        
        btn3.setLayoutX(610);
        btn3.setLayoutY(250);
        
        primaryStage.setTitle("PrimaryStage");
         Scene scene = new Scene(gridPane, 900, 500);
		primaryStage.setScene(scene);
                primaryStage.setTitle("Home");
        primaryStage.show();
    }
        
    }
}