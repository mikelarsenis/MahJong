import java.awt.*;

public class WhiteDragonTile extends Tile
{	
	Color BLACK = new Color(40,40,40);
	WhiteDragonTile()
	{
		super();
	}
	
	public String toString()
	{
		return "White Dragon";
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		drawHorizontal(g,0,20,BLUE);
		drawHorizontal(g,0,81,BLUE);
		drawVertical(g,0,20,BLUE,0);
		drawVertical(g,59,20,BLUE,1);
		g.setColor(BLACK);
		int[] xPoly1 = {0,0,64,64};
			//shift everything to the right the faceOffset
			for(int i = 0; i<4;i++)
			{
				xPoly1[i] += faceOffset+8;
			}
		int[] yPoly1 = {19,86,86,19};
		g.drawPolygon(xPoly1, yPoly1, 4);
		int[] xPoly2 = {5,5,59,59};
		//shift everything to the right the faceOffset
			for(int i = 0; i<4;i++)
			{
				xPoly2[i] += faceOffset+8;
			}
		int[] yPoly2 = {24,81,81,24};
		g.drawPolygon(xPoly2, yPoly2, 4);
	}
	
	public void drawHorizontal(Graphics g, int x, int y, Color c)
	{
		x+=faceOffset;
		
		for(int i=0;i<8;i++)
		{
			if(i%2==1)
			{
				g.setColor(c);
			}
			else
			{
				g.setColor(Color.WHITE);
			}
			g.fillRect(x*i/2+faceOffset+8, y, 8, 5);
			
		}
	}
	
	public void drawVertical(Graphics g, int x, int y, Color c, int rep)
	{
		x+=faceOffset+8;
		y+=5;
		
		for(int i=0;i<7;i++)
		{
			if(i%2==rep)
			{
				g.setColor(c);
			}
			else
			{
				g.setColor(Color.WHITE);
			}
			g.fillRect(x, y+(8*i), 5, 8);
		}
	}
}

