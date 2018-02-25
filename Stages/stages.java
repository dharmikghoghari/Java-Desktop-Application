package stages;

import javafx.scene.control.Button;
import javafx.geometry.Insets; 
import javafx.geometry.Pos; 
import javafx.scene.layout.GridPane; 
import javafx.scene.text.Text; 
import javafx.scene.control.TextField; 
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;


public class stages {
    //public static int[] nos1={10,25,35,100,50};
    //public static int[] nos2={ 10,25,35,100,50};
    static int count=Integer.parseInt("2");
     Text[] text=new Text[count];
    public static TextField[] textField=new TextField[count];
   public static RadioButton rb1,rb2,rb3,rb4;

    stages()
    {
        {
            Stage primaryStage=new Stage();
      for(int i=0;i<count;i++)
      {
      text[i] = new Text("Number "+(i+1)+":"); 
      textField[i] = new TextField();
      }
      
      final ToggleGroup group = new ToggleGroup();
      
      rb1 = new RadioButton("Insertion Sort");
      rb1.setToggleGroup(group);
      rb1.setSelected(true);
      
      rb2 = new RadioButton("Selection Sort");
      rb2.setToggleGroup(group);
      
      rb3 = new RadioButton("Bubble Sort");
      rb3.setToggleGroup(group);
     
      rb4 = new RadioButton("Quick Sort");
      rb4.setToggleGroup(group);
      
        Button btn1 = new Button("Circle");
        btn1.setOnAction(eve-> new prims01());
      
	  Button btn2 = new Button("Blocks");
        btn2.setOnAction(eve-> new NewStage2());
      
        Button btn3 = new Button("Blocks");
        btn3.setOnAction(eve-> new prims());
        
      //Creating a Grid Pane 
      GridPane gridPane = new GridPane();    
      
      //Setting size for the pane 
      gridPane.setMinSize(400, 200); 
      
      //Setting the padding  
      gridPane.setPadding(new Insets(10, 10, 10, 10)); 
      
      //Setting the vertical and horizontal gaps between the columns 
      gridPane.setVgap(5); 
      gridPane.setHgap(5);       
      
      //Setting the Grid alignment 
      gridPane.setAlignment(Pos.CENTER); 
       
      //Arranging all the nodes in the grid 
      
      for(int i=0;i<count;i++)
      {
        gridPane.add(text[i], 0, i); 
        gridPane.add(textField[i], 1, i); 
      }
     
	  gridPane.add(btn1, 0, count);
          gridPane.add(btn2, 1, count);
          gridPane.add(btn3, 2, count);
          gridPane.add(rb1,0,count+1);
          gridPane.add(rb2,1,count+1);
          gridPane.add(rb3,2,count+1);
          gridPane.add(rb4,3,count+1);
	  
       
      //Styling nodes  
      //button1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"); 
      //button2.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"); 
       
      //text1.setStyle("-fx-font: normal bold 20px 'serif' "); 
      //text2.setStyle("-fx-font: normal bold 20px 'serif' ");  
      gridPane.setStyle("-fx-background-color: BEIGE;"); 
		
		
        
        primaryStage.setTitle("PrimaryStage");
        
       // FlowPane root = new FlowPane();
       // root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(gridPane, 700, 700);
	//	root.getChildren().add(btn);
    
		primaryStage.setScene(scene);
        primaryStage.show();
    }
        
    }
}