package stages;

import java.awt.Graphics;
import javafx.scene.Group;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

public class prims{

	int n=14,r=15;
        int nodes=graphnew.nodes,count=0,x,y,radius=15,start=1;
        int[][] graph=graphnew.graph1;
        //static int[][] graph={{100,100},{200,200},{300,300},{100,150},{200,150},{200,110}};
	int[][] dist=new int[nodes][nodes];
        int[] vis=new int[nodes];
    private double SCENE_WIDTH = 900;
    private double SCENE_HEIGHT = 500;
	Circle[] circle=new Circle[nodes];
        Text[] text=new Text[nodes];
	Pane root;
        Path path;
        Canvas canvas;
        Graphics g;

        int del=2;
        int d=2;
        int end=8;
        int max=65530;
        int[] q=new int[10];
        int q1=0,q2=0;
        Group group;
        int stack[]=new int[9];
        //static int q[]=new int[9];
        int front=-1,rear=-1,top=-1;
         int alpha=65;

         public void st()
        {
            for(int i=0;i<nodes;i++)
            {
                if(graphnew.chk1[i].isSelected())
                {
                    start=i;
                }
            }
        }
         
	public void drawline(Circle c1,Circle c2,int no)
    {
        int x1=(int)c1.getCenterX();
        int y1=(int)c1.getCenterY();
        int x2=(int)c2.getCenterX();
        int y2=(int)c2.getCenterY();
        Line line = new Line();
        line.setStartX(x1);
        line.setStartY(y1);
        line.setEndX(x2);
        line.setEndY(y2);
        int x=(x1+x2)/2;
        int y=(y1+y2)/2;
        Text text1 = new Text(x,y-15,""+no);
        text1.setFont(new Font(20));
        root.getChildren().addAll(line);
        //root.getChildren().addAll(text1);
    }

	private Path createPath(int x1,int y1,int x2,int y2) {

        Path path1 = new Path();
        path1.getElements().addAll(new MoveTo(x1,y1), new LineTo(x2,y2));
        return path1;
    }	


    private Animation createPathAnimation(Path path, Duration duration) {

        GraphicsContext gc = canvas.getGraphicsContext2D();

        // move a node along a path. we want its position
        Circle pen = new Circle(0, 0, 4);

        // create path transition
        PathTransition pathTransition = new PathTransition( duration, path, pen);
	pathTransition.setDelay(Duration.seconds(d));
        pathTransition.currentTimeProperty().addListener( new ChangeListener<Duration>() {

            Location oldLocation = null;

            /**
             * Draw a line from the old location to the new location
             */
            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {

                // skip starting at 0/0
                if( oldValue == Duration.ZERO)
                    return;

                // get current location
                double x = pen.getTranslateX();
                double y = pen.getTranslateY();

                // initialize the location
                if( oldLocation == null) {
                    oldLocation = new Location();
                    oldLocation.x = x;
                    oldLocation.y = y;
                    return;
                }

                // draw line
                gc.setStroke(Color.BLUE);
                gc.setFill(Color.YELLOW);
                gc.setLineWidth(7);
                gc.strokeLine(oldLocation.x, oldLocation.y, x, y);

                // update old location with current one
                oldLocation.x = x;
                oldLocation.y = y;
            }
        });

        return pathTransition;
    }


    public int cal_min(int num)
	{
		int min_index=0;
		int min_dist=10000;
		for(int i=0;i<nodes;i++)
		{
			if(i!=num && vis[i]==0 && dist[num][i]!=0)
			{
				if(dist[num][i]<min_dist)
				{
					min_dist=dist[num][i];
					min_index=i;
				}
			}
		}
		return min_index;
	}

	public int is_empty()
	{
		int flag=0;
		for(int i=0;i<nodes;i++)
		{
			if(vis[i]==0)
			{
				flag=1;
				break;
			}
		}
		if(flag==0)
			return 1;
		else 
			return 0;
	}

	public void cal_distance()
	{
		for(int i=0;i<nodes;i++)
		{
			for(int j=0;j<nodes;j++)
			{
                            if(i!=j && graphnew.chk[i][j].isSelected())
                            {
				dist[i][j]=(int)Math.sqrt(Math.pow((graph[i][0]-graph[j][0]),2)+Math.pow((graph[i][1]-graph[j][1]),2));
                                dist[j][i]=dist[i][j];
                            }
                        }
		}
	}
        
        public void prims_code()
        {
        for(int i=0;i<nodes;i++)
        {
            circle[i]=new Circle(graph[i][0],graph[i][1],radius);
            
            text[i]=new Text(graph[i][0]-3,graph[i][1]+3,(char)alpha+"");
            alpha++;
             root.getChildren().addAll(circle[i],text[i]);  
             circle[i].setFill(Color.LIGHTGREEN);
        }
        for(int i=0;i<nodes;i++)
        {
            for(int j=0;j<nodes;j++)
            {
                if(i!=j && graphnew.chk[i][j].isSelected())
                    drawline(circle[i],circle[j],4);
            }
        }
	alpha=65;
        for(int i=0;i<nodes;i++)
        {
            circle[i]=new Circle(graph[i][0],graph[i][1],radius);
            
            text[i]=new Text(graph[i][0]-3,graph[i][1]+3,(char)alpha+"");
            alpha++;
             root.getChildren().addAll(circle[i],text[i]);  
             circle[i].setFill(Color.LIGHTGREEN);
        }
                cal_distance();
		int empty=is_empty();
		vis[start]=1;
		while(empty==0)
		{
			int min_index=cal_min(start);
                        vis[min_index]=1;
			Path path1=createPath(graph[start][0],graph[start][1],graph[min_index][0],graph[min_index][1]);
                        Animation animation = createPathAnimation(path1, Duration.seconds(2));
        		animation.play();
                        d+=2;
                    
                        int new_start=0;
                        int new_dist=10000;
                        for(int i=0;i<nodes;i++)
                        {
                            if(vis[i]==1)
                            {
                               if(new_dist>dist[i][cal_min(i)])
                               {
                                   new_dist=dist[i][cal_min(i)];
                                   new_start=i;
                               }
                            }
                        }
                        start=new_start;
                        empty=is_empty();
		}
        }
    
    

    public class Location {
        double x;
        double y;
    }
    
    prims()
    {
        
        Stage primaryStage = new Stage();
	root = new Pane();
        path = createPath(20,20,200,20);
        //System.out.println(111110);
        canvas = new Canvas(SCENE_WIDTH,SCENE_HEIGHT);
        //System.out.println(111113);
        
        Button btn=new Button("Back");
        btn.setLayoutX(700);
        btn.setLayoutY(400);
        btn.setStyle("-fx-background-color:#99d6ff ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 60px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
        root.getChildren().add(btn);
        btn.setOnAction(eve-> {primaryStage.close();});
        
        primaryStage.setScene(new Scene(root, SCENE_WIDTH, SCENE_HEIGHT));
        primaryStage.show();
        //System.out.println(111112);
        root.getChildren().add(canvas);
        st();
       prims_code();
        
	
        
    }
}