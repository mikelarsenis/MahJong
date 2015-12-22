import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class MahJongBoard extends JPanel implements MouseListener
{
		Tile[][][] tileLocationArray = new Tile[15][8][5]; 	//Tile[column][row][layer]
		TileDeck td;// = new TileDeck(); 						//creates tile instances and randomizes them in an arraylist
		public ArrayList<Tile> undoList = new ArrayList<Tile>();
		
		
		//to be used for setting the offset of the tiles. Sets the (0,0) position of all layers	
		private int xLayer0 = 78;
		private int yLayer0 = 1;
		private int xLayer1 = xLayer0+(16*1);
		private int yLayer1 = yLayer0-(20*1);
		private int xLayer2 = xLayer0+(16*2);
		private int yLayer2 = yLayer0-(20*2);
		private int xLayer3 = xLayer0+(16*3);
		private int yLayer3 = yLayer0-(20*3);
		private int xLayer4 = xLayer0+(16*4);
		private int yLayer4 = yLayer0-(20*4);
		private int xTileOffset = 78;
		private int yTileOffset = 100;
		
		//selected tiles
		int numTilesSelected = 0;
		Tile selected1 = null;
		Tile selected2 = null;
			
		//constructor
		public MahJongBoard()
		{			
			td = new TileDeck();
			MahJong.remainingTiles = 144;
		//Fill the location array with instances
			fillLayer0();
			fillLayer1();
			fillLayer2();
			fillLayer3();
			fillLayer4();
	
			setOpaque(false);
			setLayout(null);
			
			DrawBoard();			
			
		} //end constructor
		
		//constructor that takes seed. Used for reset option
		public MahJongBoard(long seed)
		{			
			td = new TileDeck(seed);
			MahJong.remainingTiles = 144;
		//Fill the location array with instances
			fillLayer0();
			fillLayer1();
			fillLayer2();
			fillLayer3();
			fillLayer4();
	
			setOpaque(false);
			setLayout(null);
			
			DrawBoard();
		} //end constructor
		
		//draws dragon on center of window
		public void paintComponent(Graphics g)
		{
			ImageIcon dragon = new ImageIcon(MahJong.class.getResource("images/dragon_bg.png"));			
			double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
			double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
			double dragonWidth = dragon.getImage().getWidth(null);
			double dragonHeight = dragon.getImage().getHeight(null);
			
			g.drawImage(dragon.getImage(), (int)((screenWidth/2)-(dragonWidth/2)), (int)((screenHeight/2)-(dragonHeight/2)), null);
		}
				
		//draws board
		public void DrawBoard()
		{
			drawSpecialTile();
			for(int i = 4; i>-1; i--)
			{
				drawLayer(i);
			}
		}
		
		//creates instances of tiles and fills the tileLocationArray
		public void fillLayer0()
		{
			for(int j = 0; j<8; j++)	
			{	
				switch(j)
				{
					case 0:
						//row 0, layer 0  tileLocationArray[column][row][layer]
						for(int i=0; i<15; i++)
						{
							Tile temp = null;
							if(i<1 || i>12)
								tileLocationArray[i][j][0] = null;
							else
							{
								temp = td.Deal();
								temp.setColumn(i);
								temp.setRow(j);
								temp.setLayer(0);
								tileLocationArray[i][j][0] = temp;
							}
						}
						break;
						
					case 1:
						//row 1, layer 0
						for(int i=0;i<15;i++)
						{	
							Tile temp = null;
							if(i<3 || i>10)
								tileLocationArray[i][j][0] = null;
							else
							{
								temp = td.Deal();
								temp.setColumn(i);
								temp.setRow(j);
								temp.setLayer(0);
								tileLocationArray[i][j][0] = temp;
							}
						}
						break;
						
					case 2:
						//row 2, layer 0
						for(int i = 0; i < 15; i++)
						{
							Tile temp = null;
							if(i<2 || i>11)
								tileLocationArray[i][j][0] = null;
							else
							{
								temp = td.Deal();
								temp.setColumn(i);
								temp.setRow(j);
								temp.setLayer(0);
								tileLocationArray[i][j][0] = temp;
							}
						}
						break;
						
					case 3:
						//row 3, layer 0 (no nulls)
						for(int i = 0; i < 15; i++)
						{
							Tile temp = td.Deal();
							temp.setColumn(i);
							temp.setRow(j);
							temp.setLayer(0);
							tileLocationArray[i][j][0] = temp;
						}
						break;
					
					case 4:
						//row 4, layer 0
						for(int i = 0; i < 15; i++)
						{
							Tile temp = null;
							if(i<1 || i>12)
								tileLocationArray[i][j][0] = null;
							else
							{
								temp = td.Deal();
								temp.setColumn(i);
								temp.setRow(j);
								temp.setLayer(0);
								tileLocationArray[i][j][0] = temp;
							}
						}
						break;
						
					case 5:
						//row 5, layer 0
						for(int i = 0; i < 15; i++)
						{
							Tile temp = null;
							if(i<2 || i>11)
								tileLocationArray[i][j][0] = null;
							else
							{
								temp = td.Deal();
								temp.setColumn(i);
								temp.setRow(j);
								temp.setLayer(0);
								tileLocationArray[i][j][0] = temp;
							}
						}
						break;
					
					case 6:
						//row 6, layer 0
						for(int i = 0; i < 15; i++)
						{
							Tile temp = null;
							if(i<3 || i>10)
								tileLocationArray[i][j][0] = null;
							else
							{
								temp = td.Deal();
								temp.setColumn(i);
								temp.setRow(j);
								temp.setLayer(0);
								tileLocationArray[i][j][0] = temp;
							}
						}
						break;
						
					case 7:
						//row 7, layer 0
						for(int i = 0; i < 15; i++)
						{
							Tile temp = null;
							if(i<1 || i>12)
								tileLocationArray[i][j][0] = null;
							else
							{
								temp = td.Deal();
								temp.setColumn(i);
								temp.setRow(j);
								temp.setLayer(0);
								tileLocationArray[i][j][0] = temp;
							}
						}
						break;
					
					default:
						System.out.println("We've got a problem in the switch statement");
					
						
				}//send switch
				
			}//end outer for loop
		
		}//end method
		public void fillLayer1()
		{
			//j is the row value
			for(int j = 0; j<8; j++)
			{
				switch(j)
				{
					case 0:
					case 7:
						for(int i =0; i<15; i++)
						{
							tileLocationArray[i][j][1] = null;
						}
						break;
						
					default:
						for(int i = 0; i<15; i++)
						{
							Tile temp = null;
							if(i<4 || i>9)
							{
								tileLocationArray[i][j][1] = null;
							}
							else
							{
								temp = td.Deal();
								temp.setColumn(i);
								temp.setRow(j);
								temp.setLayer(1);
								tileLocationArray[i][j][1] = temp;
							}
						}
						break;
				}//end switch
			
			}//end outer for
						
		}//end method
		public void fillLayer2()
		{
			for(int j =0; j<8; j++)
			{
				Tile temp = null;
				switch(j)
				{
					case 0:
					case 1:
					case 6:
					case 7:
						for(int i=0; i<15; i++)
						{
							tileLocationArray[i][j][2] = null;
						}
						break;
						
					default:
						for(int i =0; i<15; i++)
						{
							if(i<5 || i>8)
							{
								tileLocationArray[i][j][2] = null;
							}
							else
							{
								temp = td.Deal();
								temp.setColumn(i);
								temp.setRow(j);
								temp.setLayer(2);
								tileLocationArray[i][j][2] = temp;
							}
						}
						break;
				}
			}
		}
		public void fillLayer3()
		{
			for(int j = 0; j<8; j++)
			{
				Tile temp = null;
				switch(j)
				{
					case 0:
					case 1:
					case 2:
					case 5:
					case 6:
					case 7:
						for(int i=0; i<15; i++)
						{
							tileLocationArray[i][j][3] = null;
						}
						break;
					
					default:
						for(int i = 0; i<15; i++)
						{
							if(i<6 || i>7)
							{
								tileLocationArray[i][j][3] = null;
							}
							else
							{
								temp = td.Deal();
								temp.setColumn(i);
								temp.setRow(j);
								temp.setLayer(3);
								tileLocationArray[i][j][3] = temp;
							}
						}
				}//end switch
				
			}//end outer for
			
		}//end method
		public void fillLayer4()
		{
			for(int j = 0; j<8; j++)
			{
				Tile temp = null;
				switch(j)
				{
					case 3:
						for(int i = 0; i<15; i++)
						{
							if(i!=6)
							{
								tileLocationArray[i][j][4] = null;
							}
							else
							{
								temp = td.Deal();
								temp.setColumn(i);
								temp.setRow(j);
								temp.setLayer(4);
								tileLocationArray[i][j][4] = temp;
							}
						}
						break;
						
					default:
						for(int i = 0; i<15; i++)
						{
							tileLocationArray[i][j][4] = null;
						}
						break;
						
				} //end switch
				
			}//end outer for
			
		}//end method

		//draws the entire layer
		public void drawLayer(int layer)
		{
			//draw left to right
			//draw bottom to top
			for(int j = 7; j>=0; j--)
			{
				for(int i = 0; i<15; i++)
				{
					if(tileLocationArray[i][j][layer] != null)
					{
						drawTile(i,j,layer);
						repaint();
					}
				}
			}
		}// end method
	
		//draws the left-most tile and the top tile
		public void drawSpecialTile()
		{
			Tile t;
			//tile(0,3,0)
			t=tileLocationArray[0][3][0];
			t.setLocation(getXLayer(0) + (xTileOffset*0), getYLayer(0) + (yTileOffset*3)+((yTileOffset)/2));
			t.addMouseListener(this);
			add(t);	
			t.setZOrder();
			
			//top tile
			t=tileLocationArray[6][3][4];
			t.setLocation(getXLayer(4) + (xTileOffset*6)+((xTileOffset)/2), getYLayer(4) + (yTileOffset*3)+((yTileOffset)/2));
			t.addMouseListener(this);
			add(t);
			t.setZOrder();
		}
		
		//draws on tile
		public void drawTile(int x, int y, int layer)
				{
					Tile t;
					t = tileLocationArray[x][y][layer];
					//if tile is special case
					//(0,3,0), (0,13,0), (0,14,0)
					if((x==0 && y==3 && layer==0) || (x==6 && y==3 && layer == 4))
					{
						
						return;
					}
					if(x==13 && y==3 && layer==0)
					{
						t=tileLocationArray[13][3][0];
						t.setLocation(getXLayer(0) + (xTileOffset*13), getYLayer(0) + (yTileOffset*3)+((yTileOffset)/2));
						t.addMouseListener(this);
						add(t);
						t.setZOrder();

						return;
					}
					
					if(x==14 && y==3 && layer==0)
					{
						t=tileLocationArray[14][3][0];
						t.setLocation(getXLayer(0) + (xTileOffset*14), getYLayer(0) + (yTileOffset*3)+((yTileOffset)/2));
						t.addMouseListener(this);
						add(t);
						t.setZOrder();
						return;
					}
					else
					{
						t.setLocation(getXLayer(layer) + (xTileOffset*x), getYLayer(layer) + (yTileOffset*y));
					}
					t.addMouseListener(this);
					add(t);
					t.setZOrder();
				}
				
		//returns the x and y offset of a given layer
		public int getXLayer(int layer)
		{
			if(layer == 0)
				return xLayer0;
			else if(layer == 1)
				return xLayer1;
			else if(layer == 2)
				return xLayer2;
			else if(layer == 3)
				return xLayer3;
			else
				return xLayer4;
		}
		public int getYLayer(int layer)
		{
			if(layer == 0)
				return yLayer0;
			else if(layer == 1)
				return yLayer1;
			else if(layer == 2)
				return yLayer2;
			else if(layer == 3)
				return yLayer3;
			else
				return yLayer4;
		}

		//checks for tiles to be the same/playable
		public boolean removableTiles(Tile t1, Tile t2)
		{
			//potentially season or flower tiles
			if(selected1 != null && selected2 != null)
			{
			//check if they are the same tile
				if(t1.toString().equals(t2.toString()))
				{
					return true;
				}
			//same class (Season/Flower)
				if(t1.getClass() == t2.getClass() && (t1.getClass() == (new SeasonTile("Winter").getClass()) || 
						(t1.getClass() == (new FlowerTile("Plum").getClass()))))
				{
					return true;
				}
			//no match
				else
				{
					return false;
				}
			}
			//there aren't two tiles selected
			else 
				return false;
		}
		
		//checks for playable tile
		public boolean playableTile(Tile t)
		{
			
		//special tiles [column][row][layer]
			//tiles[0][3][0], [14][3][0] -- always playable
			if((t.getColumn()==14 && t.getRow()==3 && t.getLayer()==0) || (t.getColumn()==0 && t.getRow()==3 && t.getLayer()==0))
			{
				return true;
			}
			//[1][3][0],[1][4][0] -- look if [0][3][0] is null
			else if((t.getColumn()==1 && t.getRow()==3 && t.getLayer()==0) || (t.getColumn()==1 && t.getRow()==4 && t.getLayer()==0))
			{
				if(tileLocationArray[0][3][0] == null)
					return true;
				else
					return false;
			}
			//[13][3][0] --look if [14][3][0] is null
			else if(t.getColumn()==13 && t.getRow()==3 && t.getLayer()==0)
			{
				if(tileLocationArray[14][3][0] == null)
					return true;
				else
					return false;
			}
			//[12][3][0],[12][4][0] -- check if [13][3][0] is null
			else if((t.getColumn()==12 && t.getRow()==3 && t.getLayer()==0) || (t.getColumn()==12 && t.getRow()==4 && t.getLayer()==0))
			{
				if(tileLocationArray[13][3][0] == null)
					return true;
				else
					return false;
			}
			//layer 3 -- check if top piece is null
			else if(t.getLayer() == 3)
			{
				if(tileLocationArray[6][3][4] == null)
					return true;
				else
					return false;
			}
			//top piece
			else if(t.getLayer() == 4)
				return true;
			//Regular tile, checks for open sides/top
			else
			{
				//left side or right side and layer+1 open
				if( ((tileLocationArray[t.getColumn()-1][t.getRow()][t.getLayer()] == null) || 
						(tileLocationArray[t.getColumn()+1][t.getRow()][t.getLayer()] == null)) )
				{
				//check layer above
					if(tileLocationArray[t.getColumn()][t.getRow()][t.getLayer()+1] == null)
						return true;
					else
						return false;
				}
				else
					return false;
			}
		}
		
		//event listeners
		public void mouseClicked(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) 
		{
			Tile t = (Tile)e.getSource();
					
				//check if tile that generated event is playable
				if(playableTile(t))
				{
					//first selection
					if(selected1 == null)
					{
						selected1 = t;
						t.drawSelection(this.getGraphics(), t);
						numTilesSelected++;
					}
					//deselecting our first selection
					else if(selected1 == t)
					{
						selected1 = null;	
						t.repaint();
						numTilesSelected--;
					}
					else if(selected2 == null)
					{
						selected2=t;
						numTilesSelected++;
						//check if the tiles are able to be removed together
						if(removableTiles(selected1,selected2))
						{
						//Removable tiles
							//get Z-Order of removed tiles and add to undoList, check if we've won the game
							selected1.setZOrder();
							remove(selected1);
							selected2.setZOrder();
							remove(selected2);
					
						//add tiles to undo list
							undoList.add(selected1);
							undoList.add(selected2);
							MahJong.remainingTiles = MahJong.remainingTiles-2;
							
							//setting array to nulls
							tileLocationArray[selected1.getColumn()][selected1.getRow()][selected1.getLayer()] = null;
							tileLocationArray[selected2.getColumn()][selected2.getRow()][selected2.getLayer()] = null;
							selected1 = null;
							selected2 = null;
							
							repaint();
							GameWon();
							return;
						}
						else
						{
						//reset selected tiles
							selected1 = null;
							selected2 = null;
							repaint();
						}
					}
					
				}
		}
		public void mouseEntered(MouseEvent e) 
		{
			Tile t = (Tile)e.getSource();
			if(playableTile(t))
			{
				t.drawPlayable(this.getGraphics(), t);
			}
		}
		public void mouseExited(MouseEvent e) 
		{ 
			Tile t = (Tile)e.getSource();
			if(selected1 != null)
			{
				if(t!=selected1)
				{
					t.repaint(); 
				}
			}
			else
			{
				t.repaint();
			}
		}

		//Game win method
		public void GameWon()
		{
			if(MahJong.remainingTiles>0)
			{
				return;
			}
			else
			{
				MahJong.GameWon();				
			}
		}	
	
} //end MahJongBoard class