import java.awt.*;
//import javax.swing.*;

public class BambooTile extends RankTile 
{
	BambooTile(int rank)
	{
		super(rank);
		setToolTipText(toString());
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);	
		
		//Bamboo(int x, int y, Color color, [float degreesRotation])
		switch(rank)
		{
			case 2:
				new Bamboo(faceWidth/2,faceHeight/4-8,BLUE).draw(g);
				new Bamboo(faceWidth/2,faceHeight/2,GREEN).draw(g);
				break;
			case 3:
				new Bamboo(faceWidth/2,faceHeight/4-8,BLUE).draw(g);
				new Bamboo(faceWidth/3,faceHeight/2,GREEN).draw(g);
				new Bamboo(faceWidth/3*2,faceHeight/2,GREEN).draw(g);
				break;
			case 4:
				new Bamboo(faceWidth/3,faceHeight/4-8,BLUE).draw(g);
				new Bamboo(faceWidth/3*2,faceHeight/4-8,GREEN).draw(g);				
				new Bamboo(faceWidth/3,faceHeight/2,GREEN).draw(g);
				new Bamboo(faceWidth/3*2,faceHeight/2,BLUE).draw(g);
				break;
			case 5:
				new Bamboo(faceWidth/4,faceHeight/4-8,GREEN).draw(g);
				new Bamboo(faceWidth/4*3,faceHeight/4-8,BLUE).draw(g);	
				new Bamboo(faceWidth/2, faceHeight/3, RED).draw(g);
				new Bamboo(faceWidth/4,faceHeight/2,BLUE).draw(g);
				new Bamboo(faceWidth/4*3,faceHeight/2,GREEN).draw(g);
				break;
			case 6:
				new Bamboo(faceWidth/4,faceHeight/4-8,GREEN).draw(g);
				new Bamboo(faceWidth/4*2,faceHeight/4-8,GREEN).draw(g);
				new Bamboo(faceWidth/4*3,faceHeight/4-8,GREEN).draw(g);
				new Bamboo(faceWidth/4,faceHeight/2,BLUE).draw(g);
				new Bamboo(faceWidth/4*2,faceHeight/2,BLUE).draw(g);
				new Bamboo(faceWidth/4*3,faceHeight/2,BLUE).draw(g);
				break;
			case 7:
				new Bamboo(faceWidth/4,faceHeight/4*3-8,GREEN).draw(g);
				new Bamboo(faceWidth/4*2,faceHeight/4*3-8,BLUE).draw(g);
				new Bamboo(faceWidth/4*3,faceHeight/4*3-8,GREEN).draw(g);
				new Bamboo(faceWidth/4,faceHeight/2-14,GREEN).draw(g);
				new Bamboo(faceWidth/4*2,faceHeight/2-14,BLUE).draw(g);
				new Bamboo(faceWidth/4*3,faceHeight/2-14,GREEN).draw(g);
				new Bamboo(faceWidth/4*2,4,RED).draw(g); //top
				break;
			case 8:
				new Bamboo(faceWidth/4,faceHeight/4*3-8,BLUE).draw(g);
				new Bamboo(faceWidth/4*2,faceHeight/4*3-8,BLUE).draw(g);
				new Bamboo(faceWidth/4*3,faceHeight/4*3-8,BLUE).draw(g);
				new Bamboo(faceWidth/3,faceHeight/2-14,RED).draw(g);
				new Bamboo(faceWidth/3*2-3,faceHeight/2-14,RED).draw(g);
				new Bamboo(faceWidth/4,4,GREEN).draw(g);
				new Bamboo(faceWidth/4*2,4,GREEN).draw(g);
				new Bamboo(faceWidth/4*3,4,GREEN).draw(g);
				
				break;
			case 9:
				new Bamboo(faceWidth/4,4,RED).draw(g);
				new Bamboo(faceWidth/2,4,BLUE).draw(g);
				new Bamboo(faceWidth/4*3,4,GREEN).draw(g);
				new Bamboo(faceWidth/4,faceHeight/2-14,RED).draw(g);
				new Bamboo(faceWidth/2,faceHeight/2-14,BLUE).draw(g);
				new Bamboo(faceWidth/4*3,faceHeight/2-14,GREEN).draw(g);
				new Bamboo(faceWidth/4,faceHeight/4*3-8,RED).draw(g);
				new Bamboo(faceWidth/2,faceHeight/4*3-8,BLUE).draw(g);
				new Bamboo(faceWidth/4*3,faceHeight/4*3-8,GREEN).draw(g);
				break;
				
				
		}
	}
	
	public String toString()
	{
		if(rank < 2 || rank > 9)
		{
			return "Invalid BambooTile rank";
		}
		else
		{
			return "Bamboo " + rank;
		}
	}

/*	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Bamboo Tiles");

		frame.add(new BambooTile(2));
		frame.add(new BambooTile(3));
		frame.add(new BambooTile(4));
		frame.add(new BambooTile(5));
		frame.add(new BambooTile(6));
		frame.add(new BambooTile(7));
		frame.add(new BambooTile(8));
		frame.add(new BambooTile(9));

		frame.pack();
		frame.setVisible(true);
	}*/
}
