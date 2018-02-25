package stages;

import javafx.animation.PathTransition;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

class NewStage{
   
	int[] nos=new int[learn.nos.length];
	Circle[] circle=new Circle[nos.length];
	int d=0;
	int del=2;  //delay
        int y=200;  //y coordinate
        int r=25; //radius
	Text[] text=new Text[nos.length];
        Group rootGroup;
        int swap1=0;
	
   private Path generateCurvyPath1(int x1,int y1,int x2,int y2)
   {
      	final Path path = new Path();
      	path.getElements().add(new MoveTo(x1,y1));
	path.getElements().add(new LineTo(x1+((x2-x1)/2),y-50));
   	path.getElements().add(new LineTo(x2,y2));   
      	return path;
   }

   private Path generateCurvyPath2(int x1,int y1,int x2,int y2)
   {
      	final Path path = new Path();
	path.getElements().add(new MoveTo(x2,y2));
	path.getElements().add(new LineTo(x1+((x2-x1)/2),y+50));
   	path.getElements().add(new LineTo(x1,y1));   
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
   
   private void insertion(final Group group)
   {
        for(int i=0;i<nos.length;i++)
        {
               nos[i]=learn.nos[i];
        }
	for(int i=0;i<nos.length;i++)
	{
		circle[i]=new Circle((i+1)*(900/(nos.length+1)),y,r);
		text[i] = new Text((i+1)*(900/(nos.length+1)), y, ""+nos[i]);
                text[i].setStyle("-fx-font-size:20px;");
		group.getChildren().add(circle[i]);
		group.getChildren().add(text[i]);
                circle[i].setFill(Color.LIGHTGREEN);
                circle[i].setStyle("-fx-stroke:BLACK;");
                                final Path pathcurrent=new Path();
                                pathcurrent.getElements().add(new MoveTo((i+1)*(900/(nos.length+1))-1, y));
                                pathcurrent.getElements().add(new LineTo((i+1)*(900/(nos.length+1)), y));
                                generatePathTransition(text[i],pathcurrent);
	}

	int[] arr=nos;
	int[] temp1=new int[nos.length];
	for(int i=0;i<nos.length;i++)
	{
		temp1[i]=i+1;
	}
	int temp=0;
        Text end=new Text(1500,0,"SORTED LIST");
        end.setStyle("-fx-font-size:30px;-fx-color:RED;");
        end.setFont(Font.font("Comic-Sans", FontWeight.BOLD, 0));
        group.getChildren().add(end);
        int swap=0;
        long tex;
        long t1=System.currentTimeMillis();
	for(int i=1; i < nos.length; i++)
	{  
                 for(int j=i; j > 0; j--)
		{  
                          if(arr[j] < arr[j-1])
			{  
                                
				final Path path1 = generateCurvyPath1((j)*(900/(nos.length+1)),y,(j+1)*(900/(nos.length+1)),y);
				final Path path2 = generateCurvyPath2((j)*(900/(nos.length+1)),y,(j+1)*(900/(nos.length+1)),y);
                         	
				generatePathTransition(circle[temp1[j-1]-1],path1);
				generatePathTransition(circle[temp1[j]-1],path2);
				generatePathTransition(text[temp1[j-1]-1],path1);
				generatePathTransition(text[temp1[j]-1],path2);
                                
                                swap++;
                                Text current=new Text(1001,0,"CURRENTLY SWAPPING : "+arr[j]+" and "+arr[j-1]);
                                current.setStyle("-fx-font-size:30px;-fx-color:RED;");
                                current.setFont(Font.font("Comic-Sans", FontWeight.BOLD, 0));
                                group.getChildren().add(current);
                                
                                final Path pathcurrent=new Path();
                                pathcurrent.getElements().add(new MoveTo(450,50));
                                pathcurrent.getElements().add(new LineTo(451,50));
                                generatePathTransition(current,pathcurrent);
                                
				d+=del;
                                
                                final Path pathend=new Path();
                                pathend.getElements().add(new MoveTo(1500,0));
                                pathend.getElements().add(new LineTo(1501,0));
                                generatePathTransition(current,pathend);
                                
                                //swap elements  
                                temp = arr[j-1];  
                                arr[j-1] = arr[j];  
                                arr[j] = temp;  
                                 
				temp=temp1[j-1];
				temp1[j-1]=temp1[j];
				temp1[j]=temp;
				for(int z=0;z<nos.length;z++)
				{
					System.out.print(""+temp1[z]+" "+arr[z]+" ");
				}
				System.out.println();
			}  
                 }  
         } 
            long t2=System.currentTimeMillis();
            tex=t2-t1;
                                Text time=new Text(1001,0,"Time taken for execution: "+tex+" milliseconds. \nNo of swaps : "+swap);
                                time.setStyle("-fx-font-size:20px;-fx-color:RED;");
                                time.setFont(Font.font("Comic-Sans", FontWeight.BOLD, 0));
                                group.getChildren().add(time);
                                
                                final Path pathcurrent=new Path();
                                pathcurrent.getElements().add(new MoveTo(450,50));
                                pathcurrent.getElements().add(new LineTo(451,50));
                                generatePathTransition(end,pathcurrent);
                                
                                final Path pathcurrent1=new Path();
                                pathcurrent1.getElements().add(new MoveTo(450,400));
                                pathcurrent1.getElements().add(new LineTo(451,400));
                                generatePathTransition(time,pathcurrent1);
   }  
   
   private void selection(final Group group)
   {
        for(int i=0;i<nos.length;i++)
        {
               nos[i]=learn.nos[i];
        }
	for(int i=0;i<nos.length;i++)
	{
		circle[i]=new Circle((i+1)*(900/(nos.length+1)),y,r);
		text[i] = new Text((i+1)*(900/(nos.length+1)), y, ""+nos[i]);
                text[i].setStyle("-fx-font-size:20px;");
		group.getChildren().add(circle[i]);
		group.getChildren().add(text[i]);
                circle[i].setFill(Color.LIGHTGREEN);
                circle[i].setStyle("-fx-stroke:BLACK;");
                                final Path pathcurrent=new Path();
                                pathcurrent.getElements().add(new MoveTo((i+1)*(900/(nos.length+1))-1, y));
                                pathcurrent.getElements().add(new LineTo((i+1)*(900/(nos.length+1)), y));
                                generatePathTransition(text[i],pathcurrent);
	}

	int[] arr=nos;
	int[] temp1=new int[nos.length];
	for(int i=0;i<nos.length;i++)
	{
		temp1[i]=i+1;
	}
	int temp=0;
        Text end=new Text(1500,0,"SORTED LIST");
        end.setStyle("-fx-font-size:30px;-fx-color:RED;");
        end.setFont(Font.font("Comic-Sans", FontWeight.BOLD, 0));
        group.getChildren().add(end);
        int swap=0;
        long tex;
        long t1=System.currentTimeMillis();
	for(int i=0; i < nos.length-1; i++)
	{  
                int index=i;
                
                int test=0;
                 for(int j=i+1; j < nos.length; j++)
		{  
                          if(arr[j] < arr[index])
			{  
                                index=j;
                                test=1;
                        }
                }
                if(test==1)
                {
				final Path path1 = generateCurvyPath1((i+1)*(900/(nos.length+1)),y,(index+1)*(900/(nos.length+1)),y);
				final Path path2 = generateCurvyPath2((i+1)*(900/(nos.length+1)),y,(index+1)*(900/(nos.length+1)),y);
                         	
				generatePathTransition(circle[temp1[i]-1],path1);
				generatePathTransition(circle[temp1[index]-1],path2);
				generatePathTransition(text[temp1[i]-1],path1);
				generatePathTransition(text[temp1[index]-1],path2);

                                swap++;
                                Text current=new Text(1001,0,"CURRENTLY SWAPPING : "+arr[i]+" and "+arr[index]);
                                current.setStyle("-fx-font-size:30px;-fx-color:RED;");
                                current.setFont(Font.font("Comic-Sans", FontWeight.BOLD, 0));
                                group.getChildren().add(current);
                                
                                final Path pathcurrent=new Path();
                                pathcurrent.getElements().add(new MoveTo(450,50));
                                pathcurrent.getElements().add(new LineTo(451,50));
                                generatePathTransition(current,pathcurrent);
                                
				d+=del;
                                
                                final Path pathend=new Path();
                                pathend.getElements().add(new MoveTo(1500,0));
                                pathend.getElements().add(new LineTo(1501,0));
                                generatePathTransition(current,pathend);

                                //swap elements  
                                 temp = arr[index];  
                                 arr[index] = arr[i];  
                                 arr[i] = temp; 
                                
				temp=temp1[index];
				temp1[index]=temp1[i];
				temp1[i]=temp;
                }
				for(int z=0;z<nos.length;z++)
				{
					System.out.print(""+temp1[z]+" "+arr[z]+" ");
				}
				System.out.println();
         }  
        long t2=System.currentTimeMillis();
            tex=t2-t1;
                                Text time=new Text(1001,0,"Time taken for execution: "+tex+" milliseconds. \nNo of swaps : "+swap);
                                time.setStyle("-fx-font-size:20px;-fx-color:RED;");
                                time.setFont(Font.font("Comic-Sans", FontWeight.BOLD, 0));
                                group.getChildren().add(time);
                                
                                final Path pathcurrent=new Path();
                                pathcurrent.getElements().add(new MoveTo(450,50));
                                pathcurrent.getElements().add(new LineTo(451,50));
                                generatePathTransition(end,pathcurrent);
                                
                                final Path pathcurrent1=new Path();
                                pathcurrent1.getElements().add(new MoveTo(450,400));
                                pathcurrent1.getElements().add(new LineTo(451,400));
                                generatePathTransition(time,pathcurrent1);
   }
   
   private void bubble(final Group group)
   {
        for(int i=0;i<nos.length;i++)
        {
               nos[i]=learn.nos[i];
        }
	for(int i=0;i<nos.length;i++)
	{
		circle[i]=new Circle((i+1)*(900/(nos.length+1)),y,r);
		text[i] = new Text((i+1)*(900/(nos.length+1)), y, ""+nos[i]);
                text[i].setStyle("-fx-font-size:20px;");
		group.getChildren().add(circle[i]);
		group.getChildren().add(text[i]);
                circle[i].setFill(Color.LIGHTGREEN);
                circle[i].setStyle("-fx-stroke:BLACK;");
                                final Path pathcurrent=new Path();
                                pathcurrent.getElements().add(new MoveTo((i+1)*(900/(nos.length+1))-1, y));
                                pathcurrent.getElements().add(new LineTo((i+1)*(900/(nos.length+1)), y));
                                generatePathTransition(text[i],pathcurrent);
	}

	int[] arr=nos;
	int[] temp1=new int[nos.length];
	for(int i=0;i<nos.length;i++)
	{
		temp1[i]=i+1;
	}
	int temp=0;
        Text end=new Text(1500,0,"SORTED LIST");
        end.setStyle("-fx-font-size:30px;-fx-color:RED;");
        end.setFont(Font.font("Comic-Sans", FontWeight.BOLD, 0));
        group.getChildren().add(end);
        int swap=0;
        long tex;
        long t1=System.currentTimeMillis();
	for(int i=0; i < nos.length; i++)
	{  
                 for(int j=1; j < (nos.length-i); j++)
		{  
                          if(arr[j-1] > arr[j])
			{  
				final Path path1 = generateCurvyPath1((j)*(900/(nos.length+1)),y,(j+1)*(900/(nos.length+1)),y);
				final Path path2 = generateCurvyPath2((j)*(900/(nos.length+1)),y,(j+1)*(900/(nos.length+1)),y);
                         	
				generatePathTransition(circle[temp1[j-1]-1],path1);
				generatePathTransition(circle[temp1[j]-1],path2);
				generatePathTransition(text[temp1[j-1]-1],path1);
				generatePathTransition(text[temp1[j]-1],path2);

                                swap++;
                                Text current=new Text(1001,0,"CURRENTLY SWAPPING : "+arr[j]+" and "+arr[j-1]);
                                current.setStyle("-fx-font-size:30px;-fx-color:RED;");
                                current.setFont(Font.font("Comic-Sans", FontWeight.BOLD, 0));
                                group.getChildren().add(current);
                                
                                final Path pathcurrent=new Path();
                                pathcurrent.getElements().add(new MoveTo(450,50));
                                pathcurrent.getElements().add(new LineTo(451,50));
                                generatePathTransition(current,pathcurrent);
                                
				d+=del;
                                
                                final Path pathend=new Path();
                                pathend.getElements().add(new MoveTo(1500,0));
                                pathend.getElements().add(new LineTo(1501,0));
                                generatePathTransition(current,pathend);

                                //swap elements  
                                temp = arr[j-1];  
                                arr[j-1] = arr[j];  
                                arr[j] = temp;  
                                 
				temp=temp1[j-1];
				temp1[j-1]=temp1[j];
				temp1[j]=temp;
				for(int z=0;z<nos.length;z++)
				{
					System.out.print(""+temp1[z]+" "+arr[z]+" ");
				}
				System.out.println();
			}  
                 }  
         }  
        long t2=System.currentTimeMillis();
            tex=t2-t1;
                                Text time=new Text(1001,0,"Time taken for execution: "+tex+" milliseconds. \nNo of swaps : "+swap);
                                time.setStyle("-fx-font-size:20px;-fx-color:RED;");
                                time.setFont(Font.font("Comic-Sans", FontWeight.BOLD, 0));
                                group.getChildren().add(time);
                                
                                final Path pathcurrent=new Path();
                                pathcurrent.getElements().add(new MoveTo(450,50));
                                pathcurrent.getElements().add(new LineTo(451,50));
                                generatePathTransition(end,pathcurrent);
                                
                                final Path pathcurrent1=new Path();
                                pathcurrent1.getElements().add(new MoveTo(450,400));
                                pathcurrent1.getElements().add(new LineTo(451,400));
                                generatePathTransition(time,pathcurrent1);
   }

   private void quicksort(int arr[],int temp1[],int low,int high)
   {
        int i = low, j = high;
        int temp;
        int pivot = arr[(low + high) / 2];
        
        
        
        /** partition **/
        while (i <= j) 
        {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) 
            {
                if(!(arr[i]==arr[j]))
                {
                final Path path1 = generateCurvyPath1((i+1)*(900/(nos.length+1)),y,(j+1)*(900/(nos.length+1)),y);
		final Path path2 = generateCurvyPath2((i+1)*(900/(nos.length+1)),y,(j+1)*(900/(nos.length+1)),y);
                         	
		generatePathTransition(circle[temp1[i]-1],path1);
		generatePathTransition(circle[temp1[j]-1],path2);
		generatePathTransition(text[temp1[i]-1],path1);
		generatePathTransition(text[temp1[j]-1],path2);
                
                                swap1++;
                                Text current=new Text(1001,0,"CURRENTLY SWAPPING : "+arr[j]+" and "+arr[i]);
                                current.setStyle("-fx-font-size:30px;-fx-color:RED;");
                                current.setFont(Font.font("Comic-Sans", FontWeight.BOLD, 0));
                                rootGroup.getChildren().add(current);
                                
                                final Path pathcurrent=new Path();
                                pathcurrent.getElements().add(new MoveTo(450,50));
                                pathcurrent.getElements().add(new LineTo(451,50));
                                generatePathTransition(current,pathcurrent);

		d+=del;
                
                                final Path pathend=new Path();
                                pathend.getElements().add(new MoveTo(1500,0));
                                pathend.getElements().add(new LineTo(1501,0));
                                generatePathTransition(current,pathend);
                
                /** swap **/
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
 
                
                temp=temp1[i];
		temp1[i]=temp1[j];
		temp1[j]=temp;
                }
                i++;
                j--;
                
                for(int z=0;z<nos.length;z++)
		{
			System.out.print(""+temp1[z]+" "+arr[z]+" ");
		}
		System.out.println();
            }
        }
 
        /** recursively sort lower half **/
        if (low < j)
            quicksort(arr,temp1, low, j);
        /** recursively sort upper half **/
        if (i < high)
            quicksort(arr, temp1,i, high);
   }
   
   private void quick(final Group group)
   {
        for(int i=0;i<nos.length;i++)
        {
               nos[i]=learn.nos[i];
        }
	for(int i=0;i<nos.length;i++)
	{
		circle[i]=new Circle((i+1)*(900/(nos.length+1)),y,r);
		text[i] = new Text((i+1)*(900/(nos.length+1)), y, ""+nos[i]);
                text[i].setStyle("-fx-font-size:20px;");
		group.getChildren().add(circle[i]);
		group.getChildren().add(text[i]);
                circle[i].setFill(Color.LIGHTGREEN);
                circle[i].setStyle("-fx-stroke:BLACK;");
                                final Path pathcurrent=new Path();
                                pathcurrent.getElements().add(new MoveTo((i+1)*(900/(nos.length+1))-1, y));
                                pathcurrent.getElements().add(new LineTo((i+1)*(900/(nos.length+1)), y));
                                generatePathTransition(text[i],pathcurrent);
	}

	int[] arr=nos;
	int[] temp1=new int[nos.length];
	for(int i=0;i<nos.length;i++)
	{
		temp1[i]=i+1;
	}
        Text end=new Text(1500,0,"SORTED LIST");
        end.setStyle("-fx-font-size:30px;-fx-color:RED;");
        end.setFont(Font.font("Comic-Sans", FontWeight.BOLD, 0));
        rootGroup.getChildren().add(end);
        //int swap=0;
        long tex;
        long t1=System.currentTimeMillis();
        
	quicksort(nos,temp1,0,nos.length-1);  
        
        long t2=System.currentTimeMillis();
            tex=t2-t1;
                                Text time=new Text(1001,0,"Time taken for execution: "+tex+" milliseconds. \nNo of swaps : "+swap1);
                                time.setStyle("-fx-font-size:20px;-fx-color:RED;");
                                time.setFont(Font.font("Comic-Sans", FontWeight.BOLD, 0));
                                group.getChildren().add(time);
                                
                                final Path pathcurrent=new Path();
                                pathcurrent.getElements().add(new MoveTo(450,50));
                                pathcurrent.getElements().add(new LineTo(451,50));
                                generatePathTransition(end,pathcurrent);
                                
                                final Path pathcurrent1=new Path();
                                pathcurrent1.getElements().add(new MoveTo(450,400));
                                pathcurrent1.getElements().add(new LineTo(451,400));
                                generatePathTransition(time,pathcurrent1);
        
   }
   
    NewStage()
    {
        Stage subStage = new Stage();
        subStage.setTitle("New Stage");
        
	rootGroup = new Group();
        
        FlowPane root = new FlowPane();
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(rootGroup, 900, 500, Color.GHOSTWHITE);
        
        Button btn=new Button("Back");
        btn.setLayoutX(700);
        btn.setLayoutY(400);
        btn.setStyle("-fx-background-color:#99d6ff ; -fx-border-radius: 5; -fx-font-size: 20pt; -fx-padding:14px 60px; -fx-border-width:5px; -fx-border-style: solid; -fx-border-color:white");
        rootGroup.getChildren().add(btn);
        btn.setOnAction(eve-> {subStage.close();});
        
        root.getChildren().add(new Button("New Stage"));
        subStage.setScene(scene);
        subStage.show();
        
        if(sort.test==1)
            selection(rootGroup);
        else if(sort.test==2)
            insertion(rootGroup);
        else if(sort.test==3)
            bubble(rootGroup);
        else
            quick(rootGroup);
               
    }
}