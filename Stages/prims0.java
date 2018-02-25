package stages;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;

class prims01
{
    public prims0 frame;
    prims01 () {
        java.awt.EventQueue.invokeLater(new Runnable() {
              @Override
              public void run() {
                    frame=new prims0();
                    frame.setVisible(true);
              }
        });
        
    }
}

public class prims0 extends JFrame implements ActionListener, MouseListener {
    Shape circle = new Ellipse2D.Float(10, 10, 10, 10);
	Graphics g;
	static int nodes=3;
	static int[][] graph=new int[nodes][2];
	//int[][] dist=new int[nodes][nodes];
	int count=0;
	int start=2;
	int[] vis=new int[nodes];
	int radius=15;
        int temp=63;
        
        prims0() {
            
        setSize(900,500);
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
       //System.out.println(temp);
        g.drawString((char)temp+"",x-3,y+3);
        temp++;
        g.setColor(Color.BLACK);
        g.fillOval(x, y, 2, 2);
    }

    int x, y;

    @Override
    public void mouseClicked(MouseEvent e) {
	if(count<nodes)
	{
   	 	x = e.getX();
    		y = e.getY();
		graph[count][0]=x-radius;
		graph[count][1]=y-radius;
		count++;
    		repaint();
	}
        else
        {
            //prims01.frame.setVisible(false);
            //prims01.frame=null;
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