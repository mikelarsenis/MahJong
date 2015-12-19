import java.awt.*;

public class CharacterTile extends Tile 
{
	protected char symbol;
	
	CharacterTile(char symbol)
	{
		super();
		this.symbol = symbol;
		setToolTipText(toString());
	}
	
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			    RenderingHints.VALUE_ANTIALIAS_ON);
		super.paintComponent(g);
		Font defaultFont = new Font("TimesRoman", Font.PLAIN, 28);
		Font specialCharFont = new Font("TimesRoman", Font.PLAIN, 50);
		Point regCharCoords = new Point(40,40);
		Point specialCharCoords = new Point(30,70);
		
		drawSymbolChar(g);
		g.setFont(defaultFont);
		g.setColor(Color.BLACK);
		
	//switch statement for what to draw on each
		switch(symbol)
		{
			case '1': 
				g.drawString("\u4E00", regCharCoords.x, regCharCoords.y);
				drawWan(g);
				break;
			
			case '2': 
				g.drawString("\u4E8C", regCharCoords.x, regCharCoords.y);
				drawWan(g);
				break;
					
			case '3': 
				g.drawString("\u4E09", regCharCoords.x, regCharCoords.y);
				drawWan(g);
				break;
			
			case '4': 
				g.drawString("\u56DB", regCharCoords.x, regCharCoords.y);
				drawWan(g);
				break;
			
			case '5': 
				g.drawString("\u4E94", regCharCoords.x, regCharCoords.y);
				drawWan(g);
				break;
			
			case '6': 
				g.drawString("\u516D", regCharCoords.x, regCharCoords.y);
				drawWan(g);
				break;
			
			case '7': 
				g.drawString("\u4E03", regCharCoords.x, regCharCoords.y);
				drawWan(g);
				break;
			
			case '8': 
				g.drawString("\u516B", regCharCoords.x, regCharCoords.y);
				drawWan(g);
				break;
			
			case '9': 
				g.drawString("\u4E5D", regCharCoords.x, regCharCoords.y);
				drawWan(g);
				break;
			
			case 'N': 
				g.setFont(specialCharFont);
				g.drawString("\u5317", specialCharCoords.x, specialCharCoords.y);
				break;
			
			case 'E': 
				g.setFont(specialCharFont);
				g.drawString("\u6771", specialCharCoords.x, specialCharCoords.y);
				break;
			
			case 'W': 
				g.setFont(specialCharFont);
				g.drawString("\u897F", specialCharCoords.x, specialCharCoords.y);
				break;
			
			case 'S': 
				g.setFont(specialCharFont);
				g.drawString("\u5357", specialCharCoords.x, specialCharCoords.y);
				break;
			
			//Red Dragon
			case 'C': 
				g.setColor(Color.RED);
				g.setFont(specialCharFont);
				g.drawString("\u4E2D", specialCharCoords.x, specialCharCoords.y);
				break;
				
			//Green Dragon
			case 'F': 
				g.setColor(new Color(0,205,0)); //green
				g.setFont(specialCharFont);
				g.drawString("\u767C", specialCharCoords.x, specialCharCoords.y);
				break;
				
		}
	}
	
	
	public void drawWan(Graphics g)
	{	g.setFont(new Font("TimesRoman", Font.PLAIN, 28));
		g.setColor(Color.RED);
		g.drawString("\u842C", 40, 80);
	}
	
	
	public void drawSymbolChar(Graphics g)
	{	
		Point symbolCoords = new Point (77,20);
		Font symbols = new Font("TimesRoman", Font.PLAIN, 12);
		g.setFont(symbols);
		g.setColor(Color.RED);
		g.drawString(Character.toString(symbol), symbolCoords.x, symbolCoords.y);
	}
	
	
	public boolean matches(Tile other)
	{
		if(super.matches(other)== true)
		{
			CharacterTile temp = (CharacterTile)other;
			if(temp.symbol == symbol)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	
	public String toString()
	{
		switch(symbol)
		{
		case 'N':
			return "North Wind";
		case 'E':
			return "East Wind";
		case 'W':
			return "West Wind";
		case 'S':
			return "South Wind";
		case 'C':
			return "Red Dragon";
		case 'F':
			return "Green Dragon";
		default:
			return "Character " + symbol;
		}
	}
}
