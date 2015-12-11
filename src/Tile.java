import javax.swing.*;
import java.awt.*;

abstract public class Tile extends JPanel
//public class Tile extends JPanel
{
	public int faceOffset = 16;
	public int faceWidth = 78;
	public int faceHeight = 100;
	//public Color GREEN = new Color(0,205,0);
	public Color GREEN = new Color(0,201,87);
	public Color BLUE = new Color(39,64,139);
	public Color RED = new Color(205,38,38);
	
	
	public Tile()
	{
		setSize(new Dimension(95,121));
		setToolTipText(toString());
		setOpaque(false);
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
		if(other.getClass()== this.getClass())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
/*	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tile");
		frame.add(new Tile());
		frame.pack();
		frame.setVisible(true);
	}
	*/
}
