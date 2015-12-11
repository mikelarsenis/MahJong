import javax.swing.*;
import java.awt.*;

public class Dragon extends JPanel
{
	ImageIcon image = new ImageIcon("images/dragon_bg.png");
	Dragon()
	{
		setPreferredSize(new Dimension(100,200));
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(image.getImage(), 0, 0, null);
	}
}
