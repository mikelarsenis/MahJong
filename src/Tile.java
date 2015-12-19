import javax.swing.*;
import java.awt.*;

abstract public class Tile extends JPanel
//public class Tile extends JPanel
{
	static int faceOffset = 16;
	static int faceWidth = 78;
	static int faceHeight = 100;
	
	//global colors
	static Color GREEN = new Color(0,201,87);
	static Color BLUE = new Color(39,64,139);
	static Color RED = new Color(205,38,38);
	static Color sGRAY = Color.DARK_GRAY;
	static Color sCYAN = new Color(0,238,238);
	
	//tile location information
	private int tileRow;
	private int tileColumn;
	private int tileLayer;
	private int zOrder = 0;
	
	public Tile()
	{
		setSize(new Dimension(95,121));
		setToolTipText(toString());
		setOpaque(false);
	}
	
	//getters/setters
	public int getRow()
	{
		return tileRow;
	}
	public int getColumn()
	{
		return tileColumn;
	}
	public int getLayer()
	{
		return tileLayer;
	}
	public void setRow(int row)
	{
		tileRow = row;
	}
	public void setColumn(int column)
	{
		tileColumn = column;
	}
	public void setLayer(int layer)
	{
		tileLayer = layer;
	}
	public int getZOrder()
	{
		return zOrder;
	}
	public void setZOrder()
	{
		zOrder = getParent().getComponentZOrder(this);
	}
	public void resetZOrder()
	{
		getParent().setComponentZOrder(this,  zOrder);
	}
	
	//draw Selection circle
	public void drawSelection(Graphics g, Tile t)
	{
		//offset for drawing the selection circle
		int xOffset0 = ((Tile.faceWidth))*(t.tileColumn+1)+(Tile.faceWidth/2)-3;
		int yOffset0 = ((Tile.faceHeight))*(t.tileRow)+(Tile.faceHeight/2)-23;
		int xOffset1 = xOffset0+(16*1);
		int yOffset1 = yOffset0-(20*1);
		int xOffset2 = xOffset0+(16*2);
		int yOffset2 = yOffset0-(20*2);
		int xOffset3 = xOffset0+(16*3);
		int yOffset3 = yOffset0-(20*3);
		int xOffset4 = xOffset0+(16*4);
		int yOffset4 = yOffset0-(20*4);
		
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			    RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.ORANGE);
		
	//special tile cases ([column][row][layer]) -[0][3][0], [13][3][0], [14][3][0], [6][3][4]
		//[0][3][0], [13][3][0], [14][3][0] case
		if((t.getColumn() == 0 && t.getRow() == 3 && t.getLayer() == 0) ||
				(t.getColumn() == 13 && t.getRow() == 3 && t.getLayer() == 0) ||
				(t.getColumn() == 14 && t.getRow() == 3 && t.getLayer() == 0))
		{
			g.fillOval(xOffset0, yOffset0+(Tile.faceHeight/2), 40, 40);
			g2.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke(2));
			g2.drawOval(xOffset0, yOffset0+(Tile.faceHeight/2), 40, 40);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 23));
			g.drawString("\u4E80", xOffset0+9, yOffset0+(Tile.faceHeight/2)+27);
		}
		//[6][3][4]
		else if(t.getLayer() == 4)
		{
			g.fillOval(xOffset4+(Tile.faceWidth/2), yOffset4+(Tile.faceHeight/2), 40, 40);
			g2.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke(2));
			g2.drawOval(xOffset4+(Tile.faceWidth/2), yOffset4+(Tile.faceHeight/2), 40, 40);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 23));
			g.drawString("\u4E80", xOffset4+(Tile.faceWidth/2+9), yOffset4+(Tile.faceHeight/2)+27);
		}
	//regular tiles
		//regular tile, layer 0
		else if (t.getLayer() == 0)
		{
			
			g.fillOval(xOffset0, yOffset0, 40, 40);
			g2.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke(2));
			g2.drawOval(xOffset0, yOffset0, 40, 40);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 23));
			g.drawString("\u4E80", xOffset0+9, yOffset0+27);
		}
		//regular tile, layer 1
		else if (t.getLayer() == 1)
		{
			g.fillOval(xOffset1, yOffset1, 40, 40);
			g2.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke(2));
			g2.drawOval(xOffset1, yOffset1, 40, 40);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 23));
			g.drawString("\u4E80", xOffset1+9, yOffset1+27);
		}
		else if(t.getLayer() == 2)
		{
			g.fillOval(xOffset2, yOffset2, 40, 40);
			g2.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke(2));
			g2.drawOval(xOffset2, yOffset2, 40, 40);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 23));
			g.drawString("\u4E80", xOffset2+9, yOffset2+27);
		}
		else if(t.getLayer() == 3)
		{
			g.fillOval(xOffset3, yOffset3, 40, 40);
			g2.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke(2));
			g2.drawOval(xOffset3, yOffset3, 40, 40);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 23));
			g.drawString("\u4E80", xOffset3+9, yOffset3+27);
		}
	}
	
	
	//draws playable indicator
	public void drawPlayable(Graphics g, Tile t)
	{
		int xOffset0 = ((Tile.faceWidth))*(t.tileColumn+1)+(Tile.faceWidth/2)-3;
		int yOffset0 = ((Tile.faceHeight))*(t.tileRow)+(Tile.faceHeight/2)-23;
		int xOffset1 = xOffset0+(16*1);
		int yOffset1 = yOffset0-(20*1);
		int xOffset2 = xOffset0+(16*2);
		int yOffset2 = yOffset0-(20*2);
		int xOffset3 = xOffset0+(16*3);
		int yOffset3 = yOffset0-(20*3);
		int xOffset4 = xOffset0+(16*4);
		int yOffset4 = yOffset0-(20*4);
		
		g.setColor(sCYAN);
		
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			    RenderingHints.VALUE_ANTIALIAS_ON);
		
		//special tile cases ([column][row][layer]) -[0][3][0], [13][3][0], [14][3][0], [6][3][4]
			//[0][3][0], [13][3][0], [14][3][0] case
			if((t.getColumn() == 0 && t.getRow() == 3 && t.getLayer() == 0) ||
					(t.getColumn() == 13 && t.getRow() == 3 && t.getLayer() == 0) ||
					(t.getColumn() == 14 && t.getRow() == 3 && t.getLayer() == 0))
			{
				g.fillOval(xOffset0+10, yOffset0+10+(Tile.faceHeight/2), 20, 20);
				g2.setColor(sGRAY);
				g2.setStroke(new BasicStroke(2));
				g2.drawOval(xOffset0+10, yOffset0+10+(Tile.faceHeight/2), 20, 20);
			}
			//[6][3][4]
			else if(t.getLayer() == 4)
			{
				g.fillOval(xOffset4+10+(Tile.faceWidth/2), yOffset4+10+(Tile.faceHeight/2), 20, 20);
				g2.setColor(sGRAY);
				g2.setStroke(new BasicStroke(2));
				g2.drawOval(xOffset4+10+(Tile.faceWidth/2), yOffset4+10+(Tile.faceHeight/2), 20, 20);
			}
		//regular tiles
			//regular tile, layer 0
			else if (t.getLayer() == 0)
			{
				
				g.fillOval(xOffset0+10, yOffset0+10, 20, 20);
				g2.setColor(sGRAY);
				g2.setStroke(new BasicStroke(2));
				g2.drawOval(xOffset0+10, yOffset0+10, 20, 20);
			}
			//regular tile, layer 1
			else if (t.getLayer() == 1)
			{
				g.fillOval(xOffset1+10, yOffset1+10, 20, 20);
				g2.setColor(sGRAY);
				g2.setStroke(new BasicStroke(2));
				g2.drawOval(xOffset1+10, yOffset1+10, 20, 20);
			}
			else if(t.getLayer() == 2)
			{
				g.fillOval(xOffset2+10, yOffset2+10, 20, 20);
				g2.setColor(sGRAY);
				g2.setStroke(new BasicStroke(2));
				g2.drawOval(xOffset2+10, yOffset2+10, 20, 20);
			}
			else if(t.getLayer() == 3)
			{
				g.fillOval(xOffset3+10, yOffset3+10, 20, 20);
				g2.setColor(sGRAY);
				g2.setStroke(new BasicStroke(2));
				g2.drawOval(xOffset3+10, yOffset3+10, 20, 20);
			}
	}
	
	//build paint component
	public void paintComponent(Graphics g)
	{
		//points for poly1
		int xPoly1[] = {8,8,16,16};
		int yPoly1[] = {10,110,100,0};
		int nPoly1 = 4;
		Polygon Poly1 = new Polygon(xPoly1, yPoly1, nPoly1);
		
		//points for poly2
		int xPoly2[] = {16,8,86,94};
		int yPoly2[] = {100,110,110,100};
		int nPoly2 = 4;	
		Polygon Poly2 = new Polygon(xPoly2, yPoly2, nPoly2);
		
		//points for poly3
		int xPoly3[] = {8,0,0,8};
		int yPoly3[] = {10,20,120,110};
		int nPoly3 = 4;
		Polygon Poly3 = new Polygon(xPoly3, yPoly3, nPoly3);
		
		//points for poly4
		int xPoly4[] = {8,0,78,86};
		int yPoly4[] = {110,120,120,110};
		int nPoly4 = 4;
		Polygon Poly4 = new Polygon(xPoly4, yPoly4, nPoly4);
		
		//gradient setup
		Graphics2D g2 = (Graphics2D)g; //gradient drawer
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			    RenderingHints.VALUE_ANTIALIAS_ON);
		Color color = new Color(0, 205, 205);
		Color colorDarker = new Color(0,203,203);
		
		//create gradient coordinates
		GradientPaint gradPoly3 = new GradientPaint(8,15, color.darker(), 8, 115, color.brighter()); //GradientPaint (float x1, float y1, Color color1, float x2, float y2, Color color2)
		//GradientPaint gradPoly4 = new GradientPaint(8,115, color.brighter(), 83,115, color.darker());
		GradientPaint gradPoly4 = new GradientPaint(8,115, color.brighter(), 83,115, colorDarker);
		GradientPaint rect = new GradientPaint( 16, 100, new Color(244,244,244), 94, 0, new Color(214,228,218));
		GradientPaint gradPoly1 = new GradientPaint(12,5, new Color(224,238,238).darker(), 12, 105, new Color(224,224,224)); 
		GradientPaint gradPoly2 = new GradientPaint(12, 105, new Color(224,224,224), 83,115, new Color(200,200,200));
		
		super.paintComponent(g);
		//draw gradients on polygons
		g2.setPaint(gradPoly3);
		g2.fillPolygon(Poly3);
		g2.setPaint(gradPoly4);
		g2.fillPolygon(Poly4);
		g2.setPaint(rect);
		g2.fillRect(16,0,78,100);
		g2.setPaint(gradPoly1);
		g2.fillPolygon(Poly1);
		g2.setPaint(gradPoly2);
		g2.fillPolygon(Poly2);
		
		//draw outlines for polygons
		//g2.setPaint(Color.BLACK);
		g2.setPaint(new Color(142,142,142));
		g.drawRect(16,0,78,100); //face of tile
		g.drawPolygon(Poly1);	//g.drawPolygon(xPoly1, yPoly1, nPoly1);
		g.drawPolygon(Poly2);
		g.drawPolygon(Poly3);
		g.drawPolygon(Poly4);
		
	}
	
	public boolean matches(Tile other)
	{
		if(other.getClass() == this.getClass())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	

}
