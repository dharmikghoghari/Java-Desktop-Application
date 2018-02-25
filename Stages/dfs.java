package stages;

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
import static stages.bfs.nodes;
import static stages.graphnew.nodes;

public class dfs{

	//int V=9,n=14,r=15;
    private double SCENE_WIDTH = 900;
    private double SCENE_HEIGHT = 500;
	
	Pane root;
        Path path;
        static int nodes=graphnew.nodes;
        static int[][] graph=graphnew.graph1;
        static int[][] dist=new int[nodes][nodes];
        Circle[] circle=new Circle[nodes];
	Text[] text=new Text[nodes];
        int alpha=65,radius=15;
        
    Canvas canvas;

        int del=2;
        int d=2;
        int start=0;
        int end=nodes-1;
        int max=65530;
        int[] q=new int[10];
        int q1=0,q2=0;
        Group group;
        int vis[]=new int[nodes];
        int stack[]=new int[nodes];
        //static int q[]=new int[9];
        int front=-1,rear=-1,top=-1;

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
        System.out.println("1");
        text1.setFont(new Font(20));
        root.getChildren().addAll(line);
        //root.getChildren().addAll(text1);
    }

	private Path createPath(int x1,int y1,int x2,int y2) {

        Path path1 = new Path();

        //path.setStroke(Color.RED);
        //path.setStrokeWidth(10);
        path1.getElements().addAll(new MoveTo(x1,y1), new LineTo(x2,y2));

        return path1;
    }	

	public void add(int item)
        {
            if(rear==19)
                System.out.println("QUEUE FULL");
            else
            {
                if(rear==-1)
                {
                    q[++rear]=item;
                    front++;
                }
                else
                    q[++rear]=item;
            }
        }
        public int delete()
        {
            int k;
            if((front>rear)||(front==-1))
                return(-1);
            else
            {
                k=q[front++];
                return(k);
            }
        }
        
        void push(int item)
        {
            if(top==19){}
                //printf("Stack overflow ");
            else
                stack[++top]=item;
        }
        
        int pop()
        {
            int k;
            if(top==-1)
                return(-1);
            else
            {
                k=stack[top--];
                return(k);
            }
        }
        
        public void dfs_code(int src)
        {
            int p,i;
            push(src);
            vis[src]=1;
            p=pop();
                for(i=0;i<nodes;i++)
                {
                    //System.out.println(src+" hello "+i);
                    if((dist[src][i]!=0)&&(vis[i]==0))//if there is a edge between p and i and visited of i is false
                    {
                        push(i);
                        Path path1 = createPath((int)circle[src].getCenterX(),(int)circle[src].getCenterY(),(int)circle[i].getCenterX(),(int)circle[i].getCenterY());
                        Animation animation = createPathAnimation(path1, Duration.seconds(2));
        		animation.play();
                        //System.out.println(src+" inside "+i);
                        d=d+2;
                        vis[i]=1;
                        p=pop();
                        dfs_code(p);
                    }
                }
            
        }
	
   // @Override
    public void startcode() {
	Stage primaryStage = new Stage();
	root = new Pane();
        path = createPath(20,20,200,20);
        canvas = new Canvas(SCENE_WIDTH,SCENE_HEIGHT);
        
        cal_distance();
        st();
        root.getChildren().add(canvas);
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
                    drawline(circle[i],circle[j],dist[i][j]);
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
        
        primaryStage.setScene(new Scene(root, SCENE_WIDTH, SCENE_HEIGHT));
        primaryStage.show();
        Button btn=new Button("Back");
        btn.setLayoutX(700);
        btn.setLayoutY(400);
        btn.setStyle("-fx-background-color:#99d6ff ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 60px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
        root.getChildren().add(btn);
        btn.setOnAction(eve-> {primaryStage.close();});
	dfs_code(start);
        for(int i=0;i<nodes;i++)
                if(vis[i]==0)
            dfs_code(i);
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

    public static class Location {
        double x;
        double y;
    }
    
    dfs()
    {
	startcode();
    }
}