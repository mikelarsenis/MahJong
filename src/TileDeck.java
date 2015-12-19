import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TileDeck 
{
	public ArrayList<Tile> tileList = new ArrayList<Tile>();
	private long seed;
	
	public TileDeck()
	{
		//populate tiles into tileList that need 4 instances
		//need four of each tile, two pairs of each
		for (int i = 0; i< 4; i++)
		{
			tileList.add(new CharacterTile('1'));
			tileList.add(new CharacterTile('2'));
			tileList.add(new CharacterTile('3'));
			tileList.add(new CharacterTile('4'));
			tileList.add(new CharacterTile('5'));
			tileList.add(new CharacterTile('6'));
			tileList.add(new CharacterTile('7'));
			tileList.add(new CharacterTile('8'));
			tileList.add(new CharacterTile('9'));
			tileList.add(new CharacterTile('N'));
			tileList.add(new CharacterTile('E'));
			tileList.add(new CharacterTile('W'));
			tileList.add(new CharacterTile('S'));
			tileList.add(new CharacterTile('C'));
			tileList.add(new CharacterTile('F'));
			tileList.add(new CircleTile(1));
			tileList.add(new CircleTile(2));
			tileList.add(new CircleTile(3));
			tileList.add(new CircleTile(4));
			tileList.add(new CircleTile(5));
			tileList.add(new CircleTile(6));
			tileList.add(new CircleTile(7));
			tileList.add(new CircleTile(8));
			tileList.add(new CircleTile(9));
			tileList.add(new BambooTile(2));
			tileList.add(new BambooTile(3));
			tileList.add(new BambooTile(4));
			tileList.add(new BambooTile(5));
			tileList.add(new BambooTile(6));
			tileList.add(new BambooTile(7));
			tileList.add(new BambooTile(8));
			tileList.add(new BambooTile(9));
			tileList.add(new WhiteDragonTile());
			tileList.add(new Bamboo1Tile());
		}
		
		//any two flower tiles can be paired, same with season tiles
		tileList.add(new FlowerTile("Chrysanthemum"));
		tileList.add(new FlowerTile("Orchid"));
		tileList.add(new FlowerTile("Plum"));
		tileList.add(new FlowerTile("Bamboo"));
		tileList.add(new SeasonTile("Spring"));
		tileList.add(new SeasonTile("Summer"));
		tileList.add(new SeasonTile("Fall"));
		tileList.add(new SeasonTile("Winter"));
		
		//Collections.shuffle(tileList,new Random(4)); //shuffle everything
		Collections.shuffle(tileList); 
	}
	
	public TileDeck(long seed)
	{
		this.seed = seed;
		//populate tiles into tileList that need 4 instances
		//need four of each tile, two pairs of each
		for (int i = 0; i< 4; i++)
		{
			tileList.add(new CharacterTile('1'));
			tileList.add(new CharacterTile('2'));
			tileList.add(new CharacterTile('3'));
			tileList.add(new CharacterTile('4'));
			tileList.add(new CharacterTile('5'));
			tileList.add(new CharacterTile('6'));
			tileList.add(new CharacterTile('7'));
			tileList.add(new CharacterTile('8'));
			tileList.add(new CharacterTile('9'));
			tileList.add(new CharacterTile('N'));
			tileList.add(new CharacterTile('E'));
			tileList.add(new CharacterTile('W'));
			tileList.add(new CharacterTile('S'));
			tileList.add(new CharacterTile('C'));
			tileList.add(new CharacterTile('F'));
			tileList.add(new CircleTile(1));
			tileList.add(new CircleTile(2));
			tileList.add(new CircleTile(3));
			tileList.add(new CircleTile(4));
			tileList.add(new CircleTile(5));
			tileList.add(new CircleTile(6));
			tileList.add(new CircleTile(7));
			tileList.add(new CircleTile(8));
			tileList.add(new CircleTile(9));
			tileList.add(new BambooTile(2));
			tileList.add(new BambooTile(3));
			tileList.add(new BambooTile(4));
			tileList.add(new BambooTile(5));
			tileList.add(new BambooTile(6));
			tileList.add(new BambooTile(7));
			tileList.add(new BambooTile(8));
			tileList.add(new BambooTile(9));
			tileList.add(new WhiteDragonTile());
			tileList.add(new Bamboo1Tile());
		}
		
		//any two flower tiles can be paired, same with season tiles
		tileList.add(new FlowerTile("Chrysanthemum"));
		tileList.add(new FlowerTile("Orchid"));
		tileList.add(new FlowerTile("Plum"));
		tileList.add(new FlowerTile("Bamboo"));
		tileList.add(new SeasonTile("Spring"));
		tileList.add(new SeasonTile("Summer"));
		tileList.add(new SeasonTile("Fall"));
		tileList.add(new SeasonTile("Winter"));
		 
		Collections.shuffle(tileList,new Random(seed));
	}
	
	public long getSeed()
	{
		return seed;
	}

	//when called, it will return the last tile in the array list
	public Tile Deal()
	{
		Tile t = tileList.remove(tileList.size()-1);
		return t;
	}

}
