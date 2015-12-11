import java.awt.Graphics;

import javax.swing.ImageIcon;

public class SeasonTile extends PictureTile
{
	String name;
	
	SeasonTile(String name)
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
			case "Spring":
				ImageIcon image = new ImageIcon(MahJong.class.getResource("images/Spring.png"));
				g.drawImage(image.getImage(), faceOffset+4, 12, faceWidth-6, faceWidth-6, null);
				break;
			
			case "Summer":
				image = new ImageIcon(MahJong.class.getResource("images/Summer.png"));
				g.drawImage(image.getImage(), faceOffset+4, 12, faceWidth-6, faceWidth-6, null);
				break;
			
			case "Fall":
				image = new ImageIcon(MahJong.class.getResource("images/Fall.png"));
				g.drawImage(image.getImage(), faceOffset+4, 12, faceWidth-6, faceWidth-6, null);
				break;
			
			case "Winter":
				image = new ImageIcon(MahJong.class.getResource("images/Winter.png"));
				g.drawImage(image.getImage(), faceOffset+4, 12, faceWidth-6, faceWidth-6, null);
				break;			
		}
		
	}
	
}
