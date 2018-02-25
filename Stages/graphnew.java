package stages;

import javafx.geometry.Insets; 
import javafx.scene.layout.GridPane; 
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.text.Text; 
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class graphnew {
    
     Text head;
     Pane gridPane;
        static int[] nos;
        static int cir;
        static int nodes=graph.nodes;
        static int[][] graph1=graph.graph1;
        static int[][] dist=new int[nodes][nodes];
   public static Button back,home,bfs,dfs,dj,prims;
   public static int test=0;
   public static CheckBox[][] chk=new CheckBox[nodes][nodes];
   public static CheckBox[] chk1=new CheckBox[nodes];
   public static CheckBox[] chk2=new CheckBox[nodes];
   
   int alpha=65;
   
   public void cal_distance()
	{
		for(int i=0;i<nodes;i++)
		{
			for(int j=0;j<nodes;j++)
			{
				dist[i][j]=(int)Math.sqrt(Math.pow((graph1[i][0]-graph1[j][0]),2)+Math.pow((graph1[i][1]-graph1[j][1]),2));
                                dist[j][i]=dist[i][j];
                        }
		}
	}
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
         for(int i=0;i<nodes;i++)
         {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText("Enter links from "+(char)(alpha+i));
            GridPane gp=new GridPane();
            for(int j=0,k=0;j<nodes;j++)
            {
                alert.getDialogPane().setContent(home);
                if(i!=j)
                {
                    chk[i][j]=new CheckBox(""+(char)(alpha+j));
                    gp.add(chk[i][j],0,k++);
                }
            }
            alert.getDialogPane().setContent(gp);
            alert.showAndWait();
         }
        Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText("Enter nodes to start from: ");
            GridPane gp=new GridPane();
            for(int j=0,k=0;j<nodes;j++)
            {
                alert.getDialogPane().setContent(home);
                    chk1[j]=new CheckBox(""+(char)(alpha+j));
                    gp.add(chk1[j],0,k++);
            }
            alert.getDialogPane().setContent(gp);
            alert.showAndWait();
         //p.close();
         new bfs();
     }
public void close4(Stage p)
     {
         for(int i=0;i<nodes;i++)
         {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText("Enter links from "+(char)(alpha+i));
            GridPane gp=new GridPane();
            for(int j=0,k=0;j<nodes;j++)
            {
                alert.getDialogPane().setContent(home);
                if(i!=j)
                {
                    chk[i][j]=new CheckBox(""+(char)(alpha+j));
                    gp.add(chk[i][j],0,k++);
                }
            }
            alert.getDialogPane().setContent(gp);
            alert.showAndWait();
         }
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText("Enter nodes to start from: ");
            GridPane gp=new GridPane();
            for(int j=0,k=0;j<nodes;j++)
            {
                alert.getDialogPane().setContent(home);
                    chk1[j]=new CheckBox(""+(char)(alpha+j));
                    gp.add(chk1[j],0,k++);
            }
            alert.getDialogPane().setContent(gp);
            alert.showAndWait();
         //p.close();
         new dfs();
     }
public void close5(Stage p)
     {
         for(int i=0;i<nodes;i++)
         {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText("Enter links from "+(char)(alpha+i));
            GridPane gp=new GridPane();
            for(int j=0,k=0;j<nodes;j++)
            {
                alert.getDialogPane().setContent(home);
                if(i!=j)
                {
                    chk[i][j]=new CheckBox(""+(char)(alpha+j));
                    gp.add(chk[i][j],0,k++);
                }
            }
            alert.getDialogPane().setContent(gp);
            alert.showAndWait();
         }
         Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText("Enter node to start from: ");
            GridPane gp=new GridPane();
            for(int j=0,k=0;j<nodes;j++)
            {
                alert.getDialogPane().setContent(home);
                    chk1[j]=new CheckBox(""+(char)(alpha+j));
                    gp.add(chk1[j],0,k++);
            }
            alert.getDialogPane().setContent(gp);
            alert.showAndWait();
            Alert alert1 = new Alert(AlertType.INFORMATION);
            alert1.setHeaderText("Enter node to end at: ");
            GridPane gp1=new GridPane();
            for(int j=0,k=0;j<nodes;j++)
            {
                alert1.getDialogPane().setContent(home);
                    chk2[j]=new CheckBox(""+(char)(alpha+j));
                    gp1.add(chk2[j],0,k++);
            }
            alert1.getDialogPane().setContent(gp1);
            alert1.showAndWait();
         //p.close();
         new Dj();
     }
public void close6(Stage p)
     {
         for(int i=0;i<nodes;i++)
         {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText("Enter links from "+(char)(alpha+i));
            GridPane gp=new GridPane();
            for(int j=0,k=0;j<nodes;j++)
            {
                alert.getDialogPane().setContent(home);
                if(i!=j)
                {
                    chk[i][j]=new CheckBox(""+(char)(alpha+j));
                    gp.add(chk[i][j],0,k++);
                }
            }
            alert.getDialogPane().setContent(gp);
            alert.showAndWait();
         }
         Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText("Enter nodes to start from: ");
            GridPane gp=new GridPane();
            for(int j=0,k=0;j<nodes;j++)
            {
                alert.getDialogPane().setContent(home);
                    chk1[j]=new CheckBox(""+(char)(alpha+j));
                    gp.add(chk1[j],0,k++);
            }
            alert.getDialogPane().setContent(gp);
            alert.showAndWait();
         //p.close();
         new prims();
     }

     public static void css_style1()
     {
         bfs.setStyle("-fx-background-color: #4d79ff ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 35px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
         bfs.setText("     BFS  >>     ");
     }  
    public static void css_style1_over()
     {
         bfs.setStyle("-fx-background-color: #99d6ff  ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 60px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
         bfs.setText("     BFS     ");
     } 
    
    public static void css_style2()
     {
         dfs.setStyle("-fx-background-color: #4d79ff; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 35px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
         dfs.setText("    DFS  >>    ");
     }  
    public static void css_style2_over()
     {
         dfs.setStyle("-fx-background-color: #99d6ff  ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 60px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
         dfs.setText("    DFS    ");
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
         dj.setStyle("-fx-background-color: #4d79ff ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 49px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
         dj.setText("Dijkstra  >>");
     }  
    public static void css_style5_over()
     {
         dj.setStyle("-fx-background-color: #99d6ff  ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 74px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
         dj.setText("Dijkstra");
     }
    
    public static void css_style6()
     {
         prims.setStyle("-fx-background-color: #4d79ff; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 54px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
         prims.setText("Prims  >>");
     }  
    public static void css_style6_over()
     {
         prims.setStyle("-fx-background-color: #99d6ff  ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 79px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
         prims.setText("Prims");
     }
     
    graphnew()
    {
        {
            Stage primaryStage=new Stage();
            head=new Text("Graph Options");
      gridPane = new Pane();    
      gridPane.setMinSize(400, 200); 
      gridPane.setPadding(new Insets(10, 10, 10, 10)); 
   
     back=new Button("Back");
     home=new Button("Home");
     bfs=new Button("     BFS     ");
     dfs=new Button("    DFS    ");
     dj=new Button("DJsktra");
     prims=new Button("PRIMS");
     
     cal_distance();
     
     back.setOnAction(eve-> close1(primaryStage));
     home.setOnAction(eve-> close2(primaryStage));
     bfs.setOnAction(eve-> close3(primaryStage));
     dfs.setOnAction(eve-> close4(primaryStage));
     dj.setOnAction(eve-> close5(primaryStage));
     prims.setOnAction(eve-> close6(primaryStage));
     
     back.setStyle("-fx-background-color:#99d6ff ; -fx-border-radius: 5; -fx-font-size: 15pt; -fx-padding:10px 30px; -fx-border-width:2px; -fx-border-style: solid; -fx-border-color:white");
     home.setStyle("-fx-background-color:#99d6ff ; -fx-border-radius: 5; -fx-font-size: 15pt; -fx-padding:10px 30px; -fx-border-width:2px; -fx-border-style: solid; -fx-border-color:white");
     bfs.setStyle("-fx-background-color:#99d6ff ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 60px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
     dfs.setStyle("-fx-background-color:#99d6ff ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 60px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
        dj.setStyle("-fx-background-color:#99d6ff ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 74px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
         prims.setStyle("-fx-background-color:#99d6ff ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 74px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
     
      
      bfs.setOnMouseEntered(eve-> css_style1());
     bfs.setOnMouseExited(eve-> css_style1_over());
         
         dfs.setOnMouseEntered(eve-> css_style2());
        dfs.setOnMouseExited(eve-> css_style2_over());
        
        home.setOnMouseEntered(eve-> css_style3());
     home.setOnMouseExited(eve-> css_style3_over());
        
         back.setOnMouseEntered(eve-> css_style4());
        back.setOnMouseExited(eve-> css_style4_over());
        
        dj.setOnMouseEntered(eve-> css_style5());
     dj.setOnMouseExited(eve-> css_style5_over());
        
         prims.setOnMouseEntered(eve-> css_style6());
        prims.setOnMouseExited(eve-> css_style6_over());
     
     back.setLayoutX(30);
     back.setLayoutY(20);
     
     home.setLayoutX(750);
     home.setLayoutY(20);
     
     bfs.setLayoutX(180);
     bfs.setLayoutY(240);
     
     dfs.setLayoutX(500);
     dfs.setLayoutY(240);
     
     dj.setLayoutX(180);
     dj.setLayoutY(380);
     
     prims.setLayoutX(500);
     prims.setLayoutY(380);
     
     
     gridPane.setStyle("-fx-background-color: BLACK;"); //BEIGE
             head.setStyle("-fx-background-color: Black ; -fx-font-size: 40pt; -fx-alignment: Center;");
             head.applyCss();
             head.setFill(Color.WHITE);
             head.setX(280.0);
             head.setY(150.0);
             head.setFont(Font.font("Comic-Sans", FontWeight.BOLD, 0));
       
        gridPane.getChildren().addAll(head,back,home,bfs,dfs,dj,prims);    
    primaryStage.setTitle("SORTING");
    Scene scene = new Scene(gridPane, 900, 500);
    primaryStage.setScene(scene);
    primaryStage.show();
     
    }
        
    }
}