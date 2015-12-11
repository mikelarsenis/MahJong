import java.awt.*;
//import java.awt.geom.Ellipse2D;
//import javax.swing.*;

public class CircleTile extends RankTile 
{
	CircleTile(int rank)
	{
		super(rank);
		setToolTipText(toString());
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g); //calls RankTile paint which calls Tile paint
		switch(rank)
		{
			case 1:
				//Circle(int x, int y, int radius, Color color, boolean drawX, boolean border)
				new Circle(faceWidth/2, faceHeight/2, faceWidth/6*5, GREEN, false, true, Color.BLACK, 2).draw(g);
				new Circle(faceWidth/2, faceHeight/2, faceWidth/4, RED, true, true, Color.WHITE, 2).draw(g); //red circle X
				new Circle(faceWidth/2, faceHeight/2, faceWidth/5*3, Color.PINK, false, true, Color.WHITE, 2, "dotted").draw(g);
				break;
			case 2:			
				new Circle(faceWidth/2, faceHeight/4, faceWidth/2+3, GREEN, true).draw(g);
				new Circle(faceWidth/2, faceHeight/4*3, faceWidth/2+3, BLUE, true).draw(g);
				break;
			case 3:
				new Circle(faceWidth/6+3, faceHeight/6, faceWidth/3, BLUE, true).draw(g);
				new Circle(faceWidth/6*3, faceHeight/6*3, faceWidth/3, RED, true).draw(g);
				new Circle(faceWidth/6*5-2, faceHeight/6*5+2, faceWidth/3, GREEN, true).draw(g);
				break;
			case 4:
				new Circle(faceWidth/4, faceHeight/4, faceWidth/2-5, BLUE, true).draw(g);
				new Circle(faceWidth/4*3, faceHeight/4, faceWidth/2-5, GREEN, true).draw(g);
				new Circle(faceWidth/4, faceHeight/4*3, faceWidth/2-5, GREEN, true).draw(g);
				new Circle(faceWidth/4*3, faceHeight/4*3, faceWidth/2-5, BLUE, true).draw(g);
				break;
			case 5:
				new Circle(faceWidth/6+3, faceHeight/6, faceWidth/3, BLUE, true).draw(g);
				new Circle(faceWidth/6+3, faceHeight/6*5+2, faceWidth/3, GREEN, true).draw(g);
				new Circle(faceWidth/6*3, faceHeight/6*3, faceWidth/3, RED, true).draw(g);
				new Circle(faceWidth/6*5-2, faceHeight/6, faceWidth/3, GREEN, true).draw(g);
				new Circle(faceWidth/6*5-2, faceHeight/6*5+2, faceWidth/3, BLUE, true).draw(g);
				break;
			case 6:
				new Circle(faceWidth/4, faceHeight/6, faceWidth/3, GREEN, true).draw(g);
				new Circle(faceWidth/4, faceHeight/6*3, faceWidth/3, RED, true).draw(g);
				new Circle(faceWidth/4, faceHeight/6*5, faceWidth/3, RED, true).draw(g);
				new Circle(faceWidth/4*3, faceHeight/6, faceWidth/3, GREEN, true).draw(g);
				new Circle(faceWidth/4*3, faceHeight/6*3, faceWidth/3, RED, true).draw(g);
				new Circle(faceWidth/4*3, faceHeight/6*5, faceWidth/3, RED, true).draw(g);
				break;
			case 7:
				new Circle(faceWidth/4, faceHeight/6*4, faceWidth/4, RED, true).draw(g);
				new Circle(faceWidth/4, faceHeight/6*5+7, faceWidth/4, RED, true).draw(g);
				new Circle(faceWidth/4*3, faceHeight/6*4, faceWidth/4, RED, true).draw(g);
				new Circle(faceWidth/4*3, faceHeight/6*5+7, faceWidth/4, RED, true).draw(g);
				new Circle(faceWidth/6+2, faceHeight/6, faceWidth/4, GREEN, true).draw(g);
				new Circle(faceWidth/6*3, faceHeight/6*2-3, faceWidth/4, GREEN, true).draw(g);
				new Circle(faceWidth/6*5-2, faceHeight/6*3-6, faceWidth/4, GREEN, true).draw(g);
				break;
			case 8:
				new Circle(faceWidth/4, faceHeight/8, faceWidth/4, BLUE, true).draw(g);
				new Circle(faceWidth/4, faceHeight/8*3, faceWidth/4, BLUE, true).draw(g);
				new Circle(faceWidth/4, faceHeight/8*5, faceWidth/4, BLUE, true).draw(g);
				new Circle(faceWidth/4, faceHeight/8*7, faceWidth/4, BLUE, true).draw(g);
				new Circle(faceWidth/4*3, faceHeight/8, faceWidth/4, BLUE, true).draw(g);
				new Circle(faceWidth/4*3, faceHeight/8*3, faceWidth/4, BLUE, true).draw(g);
				new Circle(faceWidth/4*3, faceHeight/8*5, faceWidth/4, BLUE, true).draw(g);
				new Circle(faceWidth/4*3, faceHeight/8*7, faceWidth/4, BLUE, true).draw(g);
				break;
			case 9:
				new Circle(faceWidth/6, faceHeight/6, faceWidth/4, GREEN, true).draw(g);
				new Circle(faceWidth/6*3, faceHeight/6, faceWidth/4, GREEN, true).draw(g);
				new Circle(faceWidth/6*5, faceHeight/6, faceWidth/4, GREEN, true).draw(g);
				new Circle(faceWidth/6, faceHeight/6*3, faceWidth/4, RED, true).draw(g);
				new Circle(faceWidth/6*3, faceHeight/6*3, faceWidth/4, RED, true).draw(g);
				new Circle(faceWidth/6*5, faceHeight/6*3, faceWidth/4, RED, true).draw(g);
				new Circle(faceWidth/6, faceHeight/6*5, faceWidth/4, BLUE, true).draw(g);
				new Circle(faceWidth/6*3, faceHeight/6*5, faceWidth/4, BLUE, true).draw(g);
				new Circle(faceWidth/6*5, faceHeight/6*5, faceWidth/4, BLUE, true).draw(g);
				break;		
		}	
	}
	
	public String toString()
	{
		if(rank<1 || rank>9) //valid 1-9
		{
			return "Invalid Circle Tile Rank";
		}
		else
		{
			return "Circle " + rank;
		}
	}
/*	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Circle Tiles");

		frame.add(new CircleTile(1));
		frame.add(new CircleTile(2));
		frame.add(new CircleTile(3));
		frame.add(new CircleTile(4));
		frame.add(new CircleTile(5));
		frame.add(new CircleTile(6));
		frame.add(new CircleTile(7));
		frame.add(new CircleTile(8));
		frame.add(new CircleTile(9));

		frame.pack();
		frame.setVisible(true);
	}
	*/
}
