package stages;

import javafx.animation.PathTransition;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import static stages.bfs.nodes;

class Dj{
        private static final int V=9;
        static int n=14;
        static int del=3;
        static int d=3;
        static int nodes=graphnew.nodes;
        static int[][] graph=graphnew.graph1;
        static int[][] dist1=new int[nodes][nodes];
	static Circle[] circle=new Circle[nodes];
	static Text[] text=new Text[nodes];
        static int start;
        static int end;
        static int max=65530;
        static int r=15;
        static int[] q=new int[nodes];
        static int q1=0,q2=0;
        static Group group;
         int alpha=65,radius=15;

         public void st()
        {
            for(int i=0;i<nodes;i++)
            {
                if(graphnew.chk1[i].isSelected())
                {
                    start=i;
                }
                if(graphnew.chk2[i].isSelected())
                {
                    end=i;
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
				dist1[i][j]=(int)Math.sqrt(Math.pow((graph[i][0]-graph[j][0]),2)+Math.pow((graph[i][1]-graph[j][1]),2));
                                dist1[j][i]=dist1[i][j];
                            }
                        }
		}
	}
         
    private Path generateCurvyPath1(int x1,int y1,int x2,int y2)
   {
      	final Path path = new Path();
      	path.getElements().add(new MoveTo(x1,y1));
   	path.getElements().add(new LineTo(x2,y1));
      	return path;
   }

   private Path generateCurvyPath2(int x1,int y1,int x2,int y2)
   {
      	final Path path = new Path();
      	path.getElements().add(new MoveTo(x2,y2));
   	path.getElements().add(new LineTo(x1,y2));  
      	return path;
   }

   public void generatePathTransition(final Shape shape, final Path path)
   {
      final PathTransition pathTransition = new PathTransition();
      pathTransition.setDuration(Duration.seconds(del));
      pathTransition.setDelay(Duration.seconds(0+d));
      pathTransition.setPath(path);
      pathTransition.setNode(shape);
      pathTransition.setOrientation(PathTransition.OrientationType.NONE);
      pathTransition.setCycleCount(1);
      pathTransition.play();
   }
   // A utility function to find the vertex with minimum distance
// value, from the set of vertices not yet included in shortest
// path tree
int minDistance(int dist[], boolean sptSet[])
{
    // Initialize min value
    int min = max, min_index=0;
 
    for (int v = 0; v < nodes; v++)
        if (sptSet[v] == false && dist[v] <= min)
        {
            min = dist[v];
            min_index = v;
        }
    return min_index;
}
 
// Function to print shortest path from source to j
// using parent array
void printPath(int parent[], int j)
{
    // Base Case : If j is source
    if (parent[j]==-1)
    {
        //q[q1++]=j;
        return;
    }
    printPath(parent, parent[j]);
    q[q1++]=j;
    System.out.println( j);   
}
public void drawcolorline(Circle c1,Circle c2)
    {
        int x1=(int)c1.getCenterX();
        int y1=(int)c1.getCenterY();
        int x2=(int)c2.getCenterX();
        int y2=(int)c2.getCenterY();
        Line line = new Line();
        line.setStyle("-fx-stroke: red;");
        line.setStrokeWidth(5.0f);
        line.setStartX(x1);
        line.setStartY(y1);
        line.setEndX(x2);
        line.setEndY(y2);
        
        int x=(x1+x2)/2;
        int y=(y1+y2)/2;
        //Text text1 = new Text(x,y-15);
        //text1.setFont(new Font(20));
        group.getChildren().add(line);
        //group.getChildren().add(text1);
    }
 void temp()
 {
     drawcolorline(circle[start],circle[q[0]]);
     System.out.println("outside" +q1);
     for(int i=q2;i<q1-1;i++)
     {
         System.out.println("inside");
         drawcolorline(circle[q[i]],circle[q[i+1]]);
     }
 }
// A utility function to print the constructed distance
// array
void printSolution(int dist[], int n, int parent[])
{
    int src = start;
    System.out.println("Vertex\t  Distance\tPath");
    for (int i = 1; i < 2; i++)
    {
        //q[q1++]=start;
        //System.out.println("\n"+src+" -> "+i+" \t\t "+dist[i]+"\t\t "+src);
        printPath(parent, end);
        temp();
    }
    alpha=65;
    for(int i=0;i<nodes;i++)
        {
            circle[i]=new Circle(graph[i][0],graph[i][1],radius);
            text[i]=new Text(graph[i][0]-3,graph[i][1]+3,(char)alpha+"");
            alpha++;
             group.getChildren().addAll(circle[i],text[i]);  
             circle[i].setFill(Color.LIGHTGREEN);
        }
}
 
// Funtion that implements Dijkstra's single source shortest path
// algorithm for a graph represented using adjacency matrix
// representation 
 void dijkstra(int src)
{
    int dist[]=new int[nodes];  // The output array. dist[i] will hold
                  // the shortest distance from src to i
 
    // sptSet[i] will true if vertex i is included / in shortest
    // path tree or shortest distance from src to i is finalized
    boolean sptSet[]=new boolean[nodes];
 
    // Parent array to store shortest path tree
    int parent[]=new int[nodes];
 
    // Initialize all distances as INFINITE and stpSet[] as false
    for (int i = 0; i < nodes; i++)
    {
        parent[i] = -1;
        dist[i] = max;
        sptSet[i] = false;
    }
 
    // Distance of source vertex from itself is always 0
    dist[src] = 0;
 
    // Find shortest path for all vertices
    for (int count = 0; count < nodes-1; count++)
    {
        // Pick the minimum distance vertex from the set of
        // vertices not yet processed. u is always equal to src
        // in first iteration.
        int u = minDistance(dist, sptSet);
 
        // Mark the picked vertex as processed
        sptSet[u] = true;
 
        // Update dist value of the adjacent vertices of the
        // picked vertex.
        for (int v = 0; v < nodes; v++)
 
            // Update dist[v] only if is not in sptSet, there is
            // an edge from u to v, and total weight of path from
            // src to v through u is smaller than current value of
            // dist[v]
            if (!sptSet[v] && dist1[u][v]!=0 && ((dist[u] + dist1[u][v]) < dist[v]))
            {
                parent[v]  = u;
                dist[v] = dist[u] + dist1[u][v];
            }  
    }
 
    // print the constructed distance array
    printSolution(dist, nodes, parent);
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
        group.getChildren().add(line);
        //group.getChildren().add(text1);
    }
   
    
    
   public void startcode()
   {
       {
        for(int i=0;i<nodes;i++)
        {
            circle[i]=new Circle(graph[i][0],graph[i][1],radius);
            text[i]=new Text(graph[i][0]-3,graph[i][1]+3,(char)alpha+"");
            alpha++;
             group.getChildren().addAll(circle[i],text[i]);  
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
             group.getChildren().addAll(circle[i],text[i]);  
             circle[i].setFill(Color.LIGHTGREEN);
        }
            
    dijkstra(start);
 
   
}
   }

    Dj()
    {
        Stage subStage = new Stage();
        subStage.setTitle("New Stage");
        
	group = new Group();
        cal_distance();
        FlowPane root = new FlowPane();
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(group, 900, 500, Color.GHOSTWHITE);
        st();
        root.getChildren().add(new Button("New Stage"));
        Button btn=new Button("Back");
        btn.setLayoutX(700);
        btn.setLayoutY(400);
        btn.setStyle("-fx-background-color:#99d6ff ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 60px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
        root.getChildren().add(btn);
        btn.setOnAction(eve-> {subStage.close();});
        subStage.setScene(scene);
        subStage.show();
	startcode();
    }
}