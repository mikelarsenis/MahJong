import java.awt.*;

public class Bamboo extends Tile
{
	private int x;
	private int y;
	private int ovalWidth = 12;
	private int ovalHeight = 7;
	private int rectWidth = 8;
	private int rectHeight = faceHeight/4-2;
	private Color color;
	
	public Bamboo(int x, int y, Color color)
	{
		this.x = x+faceOffset-(rectWidth/2);
		this.y = y+4;
		this.color = color;
	}
	
	public void draw(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(Color.WHITE);
		g2d.fillOval(x-rectWidth/4, y-ovalHeight/2+(rectHeight)+1, ovalWidth, ovalHeight);
		g2d.setColor(color);
		g2d.fillRect(x, y, rectWidth, rectHeight);
		g2d.fillOval(x-rectWidth/4, y-ovalHeight/2+(rectHeight), ovalWidth, ovalHeight);
		g2d.setColor(Color.WHITE);
		g2d.drawRect(x+4, y, 1, rectHeight);
		g2d.fillOval(x-rectWidth/4, y-ovalHeight/2+1, ovalWidth, ovalHeight);
		g2d.fillOval(x-rectWidth/4, y-ovalHeight/2+(rectHeight/2)+1, ovalWidth, ovalHeight);
		g2d.setColor(color);
		g2d.fillOval(x-rectWidth/4, y-ovalHeight/2, ovalWidth, ovalHeight);
		g2d.fillOval(x-rectWidth/4, y-ovalHeight/2+(rectHeight/2), ovalWidth, ovalHeight);
	}

}

