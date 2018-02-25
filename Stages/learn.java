package stages;

import java.util.Optional;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.text.Text; 
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
//import static stages.home.btn1;


public class learn {
    
     Text head;
     Pane gridPane;
        static int[] nos;
        static int cir;
        static int nodes;
   public static Button back,home,sort,graph;
   
public void close1(Stage p)
     {
         p.close();
         new home();
     }
public void close2(Stage p)
     {
         p.close();
         new home();
     }
public void close3(Stage p)
     {
         TextInputDialog dialog = new TextInputDialog();
         dialog.initStyle(StageStyle.UTILITY);
        dialog.setTitle(" Graphs!");
        dialog.setGraphic(new ImageView());
        dialog.setHeaderText("Please enter numbers separated by spaces.");
        Optional<String> result = dialog.showAndWait();
        String str=result.get();
        
        String[] temp=str.split(" ");
        nos=new int[temp.length];
        for(int i=0;i<temp.length;i++)
            nos[i]=Integer.parseInt(temp[i]);
        
        
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setContentText("Choose your option to display sorting in form of CIRCLES or BARS.");
        alert.setTitle(" Sorting!");
        alert.initStyle(StageStyle.UTILITY);
        alert.setGraphic(new ImageView());
        
        ButtonType circle = new ButtonType("Circle");
        ButtonType bars = new ButtonType("Bars");
        ButtonType cancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(circle,bars);

        Optional<ButtonType> result1 = alert.showAndWait();
        if (result1.get() == circle){
            cir=1;
        } 
        else{
            cir=2;
        } 
        
         p.close();
         new sort();
     }
public void close4(Stage p)
     {
         TextInputDialog dialog = new TextInputDialog();
         dialog.initStyle(StageStyle.UTILITY);
        dialog.setTitle(" Graphs!");
        dialog.setGraphic(new ImageView());
        dialog.setHeaderText("Please enter number of nodes.");
        Optional<String> result = dialog.showAndWait();
        nodes=Integer.parseInt(result.get());
        
         p.close();
         new graphnew();
         new graph1();
     }

     public static void css_style1()
     {
         sort.setStyle("-fx-background-color: #4d79ff ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 35px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
         sort.setText("Sorting  >>");
     }  
    public static void css_style1_over()
     {
         sort.setStyle("-fx-background-color: #99d6ff  ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 60px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
         sort.setText("Sorting");
     }
    
    public static void css_style2()
     {
         graph.setStyle("-fx-background-color: #4d79ff; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 35px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
         graph.setText("Graphs  >>");
     }  
    public static void css_style2_over()
     {
         graph.setStyle("-fx-background-color: #99d6ff  ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 60px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
         graph.setText("Graphs");
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

    learn()
    {
        {
            Stage primaryStage=new Stage();
     gridPane = new Pane();    
      gridPane.setPadding(new Insets(10, 10, 10, 10)); 
      head=new Text("Learning Time");
     back=new Button("Back");
     home=new Button("Home");
     sort=new Button("Sorting");
     graph=new Button("Graphs");
     
     back.setStyle("-fx-background-color:#99d6ff ; -fx-border-radius: 5; -fx-font-size: 15pt; -fx-padding:10px 30px; -fx-border-width:2px; -fx-border-style: solid; -fx-border-color:white");
     home.setStyle("-fx-background-color:#99d6ff ; -fx-border-radius: 5; -fx-font-size: 15pt; -fx-padding:10px 30px; -fx-border-width:2px; -fx-border-style: solid; -fx-border-color:white");
     sort.setStyle("-fx-background-color:#99d6ff ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 60px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
     graph.setStyle("-fx-background-color:#99d6ff ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 60px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
     
     sort.setOnMouseEntered(eve-> css_style1());
     sort.setOnMouseExited(eve-> css_style1_over());
        
         graph.setOnMouseEntered(eve-> css_style2());
        graph.setOnMouseExited(eve-> css_style2_over());
        
        home.setOnMouseEntered(eve-> css_style3());
     home.setOnMouseExited(eve-> css_style3_over());
        
         back.setOnMouseEntered(eve-> css_style4());
        back.setOnMouseExited(eve-> css_style4_over());
        
     
     back.setLayoutX(30);
     back.setLayoutY(20);
     
     home.setLayoutX(750);
     home.setLayoutY(20);
     
     sort.setLayoutX(200);
     sort.setLayoutY(300);
     
     graph.setLayoutX(500);
     graph.setLayoutY(300);
     gridPane.setStyle("-fx-background-color: BLACK;"); //BEIGE
             head.setStyle("-fx-background-color: Black ; -fx-font-size: 40pt; -fx-alignment: Center;");
             head.applyCss();
             head.setFill(Color.WHITE);
             head.setX(290.0);
             head.setY(180.0);
             head.setFont(Font.font("Comic-Sans", FontWeight.BOLD, 0));
     
     back.setOnAction(eve-> close1(primaryStage));
     home.setOnAction(eve-> close2(primaryStage));
     sort.setOnAction(eve-> close3(primaryStage));
     graph.setOnAction(eve-> close4(primaryStage));
     
     gridPane.setStyle("-fx-background-color: BLACK;"); 
		
		
    gridPane.getChildren().addAll(head,back,home,sort,graph);    
    primaryStage.setTitle("LEARN");
    Scene scene = new Scene(gridPane, 900, 500);
    primaryStage.setScene(scene);
    primaryStage.show();
    }
        
    }
}