import javax.swing.*;
import java.awt.*;

public class Bamboo1Tile extends PictureTile
{
	//private ImageIcon image = new ImageIcon("images/Sparrow.png");
	private ImageIcon image = new ImageIcon(MahJong.class.getResource("images/Sparrow.png"));
	
	Bamboo1Tile()
	{
		super("Sparrow");
		setToolTipText(toString());
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(image.getImage(), faceOffset+4, 12, faceWidth-6, faceWidth-6, null);
	}
	
	public String toString()
	{
		return "Bamboo 1";
	}

//	public static void main(String[] args)
//	{
//		JFrame	frame = new JFrame();
//
//		frame.setLayout(new FlowLayout());
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setTitle("BambooTile1");
//
//		frame.add(new Bamboo1Tile());
//
//		frame.pack();
//		frame.setVisible(true);
//	}
}
