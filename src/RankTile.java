import java.awt.Graphics;

abstract public class RankTile extends Tile
{
	protected int rank;
	
	RankTile(int rank)
	{
		super();
		this.rank = rank;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	}
	
	public boolean matches(Tile other)
	{
		if(super.matches(other)== true) //classes match
		{
			RankTile temp = (RankTile)other; //
			
			if(temp.rank == rank)
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
}
