package stages;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;
import javafx.scene.control.CheckBox;

class graph1
{
    public graph frame;
    graph1 () {
        java.awt.EventQueue.invokeLater(new Runnable() {
              @Override
              public void run() {
                    frame=new graph();
                    frame.setVisible(true);
              }
        });
        
    }
}

public class graph extends JFrame implements ActionListener, MouseListener {
    Shape circle = new Ellipse2D.Float(10, 10, 10, 10);
	Graphics g;
	static int nodes=learn.nodes;
	static int[][] graph1=new int[nodes][2];
	int count=0;
	int start=2;
	int[] vis=new int[nodes];
	int radius=15;
        int temp=63;
        public static CheckBox[][] chk=new CheckBox[nodes][nodes];
        
        graph() {
         
            this.setLocation(1366/2 - 450, 768/2 - 250);
        setSize(900,500);
        //Button btn=new Button("hello");
        addMouseListener(this);
    }
        
    

@Override
public void paint(Graphics g) {
    drawCircle(x, y);
}


    @Override
    public void actionPerformed(ActionEvent ae) {

    }

    public void drawCircle(int x, int y) {
       g = this.getGraphics();
        g.drawOval(x-radius, y-radius, 2*radius, 2*radius);
        g.drawString((char)temp+"",x-3,y+3);
        temp++;
    }

    int x, y;

    @Override
    public void mouseClicked(MouseEvent e) {
	if(count<nodes)
	{
   	 	x = e.getX();
    		y = e.getY();
		graph1[count][0]=x-radius;
		graph1[count][1]=y-radius;
		count++;
    		repaint();
                if(count==nodes)
                {
                    int x=750,y=400;
                    String str=new String("PROCEED!!");
                    FontMetrics fm=g.getFontMetrics();
                    Rectangle2D rect=fm.getStringBounds(str, g);
                    g.setColor(Color.GREEN);
                    g.fillRect(x-5, y-fm.getAscent()-5, (int)rect.getWidth()+10, (int)rect.getHeight()+10);
                    g.setColor(Color.BLACK);
                    g.drawString(str, x, y);
                }
	}
        else
        {
            graphnew.test=1;
            dispose();   
        }
}

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }
}