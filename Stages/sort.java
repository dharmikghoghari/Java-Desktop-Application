package stages;

import javafx.scene.control.Button;
import javafx.scene.text.Text; 
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
//import static stages.home.btn1;


public class sort {
     Text head;
     Pane gridPane;
   public static Button  back,home,selection,insertion,bubble,quick;
   public static int test=0;
   
   public void close1(Stage p)
     {
         p.close();
         new learn();
     }
public void close2(Stage p)
     {
         p.close();
         new home();
     }
   public void close3(Stage p)
     {
         test=1;
         //p.close();
         if(learn.cir==1)
            new NewStage();
         else
             new NewStage2();
     }
   public void close4(Stage p)
     {
         test=2;
         //p.close();
         if(learn.cir==1)
            new NewStage();
         else
             new NewStage2();
     }
   public void close5(Stage p)
     {
         test=3;
         //p.close();
         if(learn.cir==1)
            new NewStage();
         else
             new NewStage2();
     }
   public void close6(Stage p)
     {
         test=4;
         //p.close();
         if(learn.cir==1)
            new NewStage();
         else
             new NewStage2();
     }
   
    public static void css_style1()
     {
         selection.setStyle("-fx-background-color: #4d79ff ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 35px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
         selection.setText("Selection  >>");
     }  
    public static void css_style1_over()
     {
         selection.setStyle("-fx-background-color: #99d6ff  ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 60px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
         selection.setText("Selection");
     }
    
    public static void css_style2()
     {
         insertion.setStyle("-fx-background-color: #4d79ff; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 35px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
         insertion.setText("Insertion  >>");
     }  
    public static void css_style2_over()
     {
         insertion.setStyle("-fx-background-color: #99d6ff  ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 60px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
         insertion.setText("Insertion");
     }
    
    public static void css_style3()
     {
        home.setStyle("-fx-background-color:#4d79ff ; -fx-border-radius: 5; -fx-font-size: 15pt; -fx-padding:10px 14px; -fx-border-width:2px; -fx-border-style: solid; -fx-border-color:white");
        home.setText("Home >>"); 
     }  
    public static void css_style3_over()
     {
        home.setStyle("-fx-background-color:#99d6ff ; -fx-border-radius: 5; -fx-font-size: 15pt; -fx-padding:10px 30px; -fx-border-width:2px; -fx-border-style: solid; -fx-border-color:white");
        home.setText("Home");
     }
    
    public static void css_style4()
     {
        back.setStyle("-fx-background-color:#4d79ff ; -fx-border-radius: 5; -fx-font-size: 15pt; -fx-padding:10px 14px; -fx-border-width:2px; -fx-border-style: solid; -fx-border-color:white");
        back.setText("<< Back"); 
     }  
    public static void css_style4_over()
     {
        back.setStyle("-fx-background-color:#99d6ff ; -fx-border-radius: 5; -fx-font-size: 15pt; -fx-padding:10px 30px; -fx-border-width:2px; -fx-border-style: solid; -fx-border-color:white");
        back.setText("Back");
     }
    
    public static void css_style5()
     {
         bubble.setStyle("-fx-background-color: #4d79ff ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 48px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
         bubble.setText("Bubble  >>");
     }  
    public static void css_style5_over()
     {
         bubble.setStyle("-fx-background-color: #99d6ff  ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 73px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
         bubble.setText("Bubble");
     }
    
    public static void css_style6()
     {
         quick.setStyle("-fx-background-color: #4d79ff; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 54px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
         quick.setText("Quick  >>");
     }  
    public static void css_style6_over()
     {
         quick.setStyle("-fx-background-color: #99d6ff  ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 79px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
         quick.setText("Quick");
     }
   
    sort()
    {
        
            head=new Text("Sorting Time");
            Stage primaryStage=new Stage();
            gridPane=new Pane();
        back = new Button("Back");
        home = new Button("Home");
        selection = new Button("Selection");
        insertion = new Button("Insertion");
        bubble = new Button("Bubble");
        quick = new Button("Quick");
      
        back.setOnAction(eve-> close1(primaryStage));
        home.setOnAction(eve-> close2(primaryStage));
        selection.setOnAction(eve-> close3(primaryStage));
        insertion.setOnAction(eve-> close4(primaryStage));
        bubble.setOnAction(eve-> close5(primaryStage));
        quick.setOnAction(eve-> close6(primaryStage));
        
        back.setStyle("-fx-background-color:#99d6ff ; -fx-border-radius: 5; -fx-font-size: 15pt; -fx-padding:10px 30px; -fx-border-width:2px; -fx-border-style: solid; -fx-border-color:white");
     home.setStyle("-fx-background-color:#99d6ff ; -fx-border-radius: 5; -fx-font-size: 15pt; -fx-padding:10px 30px; -fx-border-width:2px; -fx-border-style: solid; -fx-border-color:white");
     selection.setStyle("-fx-background-color:#99d6ff ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 60px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
     insertion.setStyle("-fx-background-color:#99d6ff ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 60px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
        bubble.setStyle("-fx-background-color:#99d6ff ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 73px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
         quick.setStyle("-fx-background-color:#99d6ff ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 79px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
     
      
      selection.setOnMouseEntered(eve-> css_style1());
     selection.setOnMouseExited(eve-> css_style1_over());
         
         insertion.setOnMouseEntered(eve-> css_style2());
        insertion.setOnMouseExited(eve-> css_style2_over());
        
        home.setOnMouseEntered(eve-> css_style3());
     home.setOnMouseExited(eve-> css_style3_over());
        
         back.setOnMouseEntered(eve-> css_style4());
        back.setOnMouseExited(eve-> css_style4_over());
        
        bubble.setOnMouseEntered(eve-> css_style5());
     bubble.setOnMouseExited(eve-> css_style5_over());
        
         quick.setOnMouseEntered(eve-> css_style6());
        quick.setOnMouseExited(eve-> css_style6_over());
     
     back.setLayoutX(30);
     back.setLayoutY(20);
     
     home.setLayoutX(750);
     home.setLayoutY(20);
     
     selection.setLayoutX(180);
     selection.setLayoutY(240);
     
     insertion.setLayoutX(500);
     insertion.setLayoutY(240);
     
     bubble.setLayoutX(180);
     bubble.setLayoutY(380);
     
     quick.setLayoutX(500);
     quick.setLayoutY(380);
     
     
     gridPane.setStyle("-fx-background-color: BLACK;"); //BEIGE
             head.setStyle("-fx-background-color: Black ; -fx-font-size: 40pt; -fx-alignment: Center;");
             head.applyCss();
             head.setFill(Color.WHITE);
             head.setX(300.0);
             head.setY(150.0);
             head.setFont(Font.font("Comic-Sans", FontWeight.BOLD, 0));
       
        gridPane.getChildren().addAll(head,back,home,selection,insertion,bubble,quick);    
    primaryStage.setTitle("SORTING");
    Scene scene = new Scene(gridPane, 900, 500);
    primaryStage.setScene(scene);
    primaryStage.show();
    }
        
    }
