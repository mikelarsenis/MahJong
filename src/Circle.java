/*------------------------
 * DRAWS ONE CIRCLE ICON
 ------------------------*/

import java.awt.*;

public class Circle extends Tile
{
	private int x;
	private int y;
	private Color color;
	private int radius;
	private boolean drawX;
	private boolean border;
	private Color borderColor;
	private int strokeWeight;
	private String strokeType;
	
	public Circle(int x, int y, int radius, Color color, boolean drawX) //basic circle, draws X or not
	{
		this.x = (x-radius/2) + faceOffset;
		this.y = y-radius/2;
		this.radius = radius;
		this.color = color;
		this.drawX = drawX;
	}
	
	//basic circle, draws x, sets border, border color, and stroke weight
	public Circle(int x, int y, int radius, Color color, boolean drawX, boolean border, Color borderColor, int strokeWeight)
	{
		this.x = (x-radius/2) + faceOffset;
		this.y = y-radius/2;
		this.radius = radius;
		this.color = color;
		this.drawX = drawX;
		this.border = border;
		this.borderColor = borderColor;
		this.strokeWeight = strokeWeight;
	}
	
	//basic circle, draws x, sets border, border color, and stroke weight, stroke type
		public Circle(int x, int y, int radius, Color color, boolean drawX, boolean border, Color borderColor, int strokeWeight, String strokeType)
		{
			this.x = (x-radius/2) + faceOffset;
			this.y = y-radius/2;
			this.radius = radius;
			this.color = color;
			this.drawX = drawX;
			this.border = border;
			this.borderColor = borderColor;
			this.strokeWeight = strokeWeight;
			this.strokeType = strokeType;
		}
	
	
	public void draw(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			    RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.BLACK);
		if(border == true) 
		{ 
						
			if(strokeType=="dotted") //no fill, just dotted border
			{
				g2d.setColor(borderColor);
				Stroke dotted = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 0, new float[] {3,4}, 0);
				g2d.setStroke(dotted);
				g2d.drawOval(x, y, radius, radius);
			}
			else //filled circle with border
			{
				g2d.setColor(color);
				g.fillOval(x, y, radius, radius);
				//border
				g2d.setColor(borderColor);
				g2d.setStroke(new BasicStroke(strokeWeight));
				g2d.drawOval(x, y, radius, radius); 
				g2d.setStroke(new BasicStroke(1));
			}
		}
		else 
		{ 
			g.setColor(color);
			g.fillOval(x, y, radius, radius); 
		}
		if(drawX == true)
		{
			g.setColor(Color.white);
			g.drawLine(x+5, y+5, (x+radius)-5, (y+radius)-5);
			g.drawLine(x+5, (y+radius)-5, (x+radius)-5, y+5);
		}
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
}
