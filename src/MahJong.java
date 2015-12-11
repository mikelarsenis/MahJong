import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//public class MahJong extends JFrame
public class MahJong extends JFrame
{
	Tile[][][] tileLocationArray = new Tile[15][8][5]; //Tile[column][row][layer]
	//to be used for setting the offset of the tiles. Sets the (0,0) position of all layers	
	private int xLayer0 = 78;
	private int yLayer0 = 0;
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
	
		
	public MahJong()
	{
		setTitle("MahJong");
		//setSize(600,400);
		setSize(Toolkit.getDefaultToolkit().getScreenSize()); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().setBackground(new Color(108,123,139));
		//getContentPane().add(new Dragon());

		add(new MahJongBoard());
		setVisible(true);
	}
	
	public class MahJongBoard extends JPanel implements MouseListener
	{
		TileDeck td = new TileDeck(); //creates tile instances and randomizes them in an arraylist
		
				
		//constructor
		public MahJongBoard()
		{			
			//Fill the location array with instances
			fillLayer0();
			fillLayer1();
			fillLayer2();
			fillLayer3();
			fillLayer4();
	
			setOpaque(false);
			setLayout(null);
			
			
			//draw board			
			drawSpecialTile();
			for(int i = 4; i>-1; i--)
			{
				drawLayer(i);
			}
						
		} //end constructor
		
		
		//creates instances of tiles and fills the tileLocationArray
		public void fillLayer0()
		{
			for(int j = 0; j<7; j++)	
			{	
				switch(j)
				{
				
					case 0:
						//row 0, layer 0  tileLocationArray[column][row][layer]
						for(int i=0; i<15; i++)
						{
							if(i<1 || i>12)
								tileLocationArray[i][j][0] = null;
							else
								tileLocationArray[i][j][0] = td.Deal();
						}
						break;
						
					case 1:
						//row 1, layer 0
						for(int i=0;i<15;i++)
						{
							if(i<3 || i>10)
								tileLocationArray[i][j][0] = null;
							else
								tileLocationArray[i][j][0] = td.Deal();
						}
						break;
						
					case 2:
						//row 2, layer 0
						for(int i = 0; i < 15; i++)
						{
							if(i<2 || i>11)
								tileLocationArray[i][j][0] = null;
							else
								tileLocationArray[i][j][0] = td.Deal();
						}
						break;
						
					case 3:
						//row 3, layer 0 (no nulls)
						for(int i = 0; i < 15; i++)
						{
							tileLocationArray[i][j][0] = td.Deal();
						}
						break;
					
					case 4:
						//row 4, layer 0
						for(int i = 0; i < 15; i++)
						{
							if(i<1 || i>12)
								tileLocationArray[i][j][0] = null;
							else
								tileLocationArray[i][j][0] = td.Deal();
						}
						break;
						
					case 5:
						//row 5, layer 0
						for(int i = 0; i < 15; i++)
						{
							if(i<2 || i>11)
								tileLocationArray[i][j][0] = null;
							else
								tileLocationArray[i][j][0] = td.Deal();
						}
						break;
					
					case 6:
						//row 6, layer 0
						for(int i = 0; i < 15; i++)
						{
							if(i<3 || i>10)
								tileLocationArray[i][j][0] = null;
							else
								tileLocationArray[i][j][0] = td.Deal();
						}
						break;
						
					case 7:
						//row 7, layer 0
						for(int i = 0; i < 15; i++)
						{
							if(i<1 || i>12)
								tileLocationArray[i][j][0] = null;
							else
								tileLocationArray[i][j][0] = td.Deal();
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
							if(i<4 || i>9)
							{
								tileLocationArray[i][j][1] = null;
							}
							else
							{
								tileLocationArray[i][j][1] = td.Deal();
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
								tileLocationArray[i][j][2] = td.Deal();
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
								tileLocationArray[i][j][3] = td.Deal();
							}
						}
				}//end switch
				
			}//end outer for
			
		}//end method
		public void fillLayer4()
		{
			for(int j = 0; j<8; j++)
			{
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
								tileLocationArray[i][j][4] = td.Deal();
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
			
			//top tile
			t=tileLocationArray[6][3][4];
			t.setLocation(getXLayer(4) + (xTileOffset*6)+((xTileOffset)/2), getYLayer(4) + (yTileOffset*3)+((yTileOffset)/2));
			t.addMouseListener(this);
			add(t);
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
						return;
					}
					
					if(x==14 && y==3 && layer==0)
					{
						t=tileLocationArray[14][3][0];
						t.setLocation(getXLayer(0) + (xTileOffset*14), getYLayer(0) + (yTileOffset*3)+((yTileOffset)/2));
						t.addMouseListener(this);
						add(t);
						return;
					}
					else
					{
						t.setLocation(getXLayer(layer) + (xTileOffset*x), getYLayer(layer) + (yTileOffset*y));
					}
					t.addMouseListener(this);
					add(t);
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

		
		//event listeners
		public void mouseClicked(MouseEvent e) {}
		public void mousePressed(MouseEvent e) 
		{
			Tile t = (Tile)e.getSource();
			
			//System.out.println(t);
			remove(t);
			revalidate();
			repaint();
			
		}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) 
		{
			//System.out.println(e.getSource());
		}
		public void mouseExited(MouseEvent e) {}

		
		
	} //end MahJongBoard class
	
	public class Dragon extends JComponent
	{
		private ImageIcon image = new ImageIcon("images/dragon_bg.png");
		public Dragon()
		{
			setOpaque(false);
		}
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawImage(image.getImage(), 0, 0, null);
		}
	}
	
	public void paintComponent(Graphics g)
	{
		String fileString = "images/dragon_bg.png";
		ImageIcon dragon = new ImageIcon(getClass().getResource(fileString));
		g.drawImage(dragon.getImage(), 100, 50, null);
	}
	public static void main (String args[])
	{
		new MahJong();
	}

}//end MahJong class
