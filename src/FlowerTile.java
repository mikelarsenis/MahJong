import java.awt.Graphics;
import javax.swing.*;

public class FlowerTile extends PictureTile
{
	private String name;
	
	FlowerTile(String name)
	{
		super(name);
		this.name = name;
		setToolTipText(toString());
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		switch(name)
		{			
			case "Chrysanthemum":
				ImageIcon image = new ImageIcon(MahJong.class.getResource("images/Chrysanthemum.png"));
				g.drawImage(image.getImage(), faceOffset+4, 12, faceWidth-6, faceWidth-6, null);
				break;
			
			case "Orchid":
				image = new ImageIcon(MahJong.class.getResource("images/Orchid.png"));
				g.drawImage(image.getImage(), faceOffset+4, 12, faceWidth-6, faceWidth-6, null);
				break;
			
			case "Plum":
				image = new ImageIcon(MahJong.class.getResource("images/Plum.png"));
				g.drawImage(image.getImage(), faceOffset+4, 12, faceWidth-6, faceWidth-6, null);
				break;
			
			case "Bamboo":
				image = new ImageIcon(MahJong.class.getResource("images/Bamboo.png"));
				g.drawImage(image.getImage(), faceOffset+4, 12, faceWidth-6, faceWidth-6, null);
				break;			
		}
		
	}
}
