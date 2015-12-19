import java.awt.*;
import java.awt.event.ActionEvent;
import  javax.swing.*;

//public class MahJong extends JFrame
public class MahJong extends JFrame
{		
	private boolean gameInPlay = false;
	public static long lastSeed;
	public static int remainingTiles;
	public MahJongBoard board;
	
	public MahJong()
	{
		setTitle("MahJong");
//		setSize(500,800);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createMenu();
		getContentPane().setBackground(new Color(108,123,139));
		
		
		setVisible(true);
		
	//give options on startup
		String[] options = {"New Game", "Numbered Game", "Game Rules"};
		int choice = JOptionPane.showOptionDialog(this, "Welcome to Mahjong Solitare. Choose from the options below.", "Mahjong", 
				JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		
		if(choice == 0)
			Play();
		else if(choice == 1)
			Numbered();
		else if(choice == 2)
		{			
			GameRules();
						
		//Open options after game rules displayed
			String[] options2 = {"New Game", "Numbered Game"};
			choice = JOptionPane.showOptionDialog(this, "Welcome to Mahjong Solitare. Choose from the options below.", "Mahjong", 
					JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, null, options2, options[0]);
			if(choice == 0)
				Play();
			else if(choice == 1)
				Numbered();
		}	
	} //end constructor
	
//creates Menu
	private JMenu makeMenu(String label)
	{
		JMenu	menu = new JMenu(label);
		return menu;
	}
	
//creates the menu bar
	public void createMenu()
	{
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu gameMenu = makeMenu("Game");
		JMenu moveMenu = makeMenu("Move");
		JMenu helpMenu = makeMenu("Help");
		
	//Game Menu Actions
		Action playAction = new AbstractAction("Play")	
		{
			public void actionPerformed(ActionEvent e)
			{
				
				Play(); 
			}
		};
		Action restartAction = new AbstractAction("Restart")	
		{
			public void actionPerformed(ActionEvent e)
			{
				Restart(); 
			}
		};
		Action numberedAction = new AbstractAction("Play Numbered Game")
		{
			public void actionPerformed(ActionEvent e)
			{
				Numbered(); 
			}
		};
		Action getSeed = new AbstractAction("Current Board Number")
		{
			public void actionPerformed(ActionEvent e)
			{
				getSeed(); 
			}
		};
	//Game Menu Creation
		menuBar.add(gameMenu);
			JMenuItem play = new JMenuItem(playAction);
			play.setToolTipText("Start a new game");
			play.setMnemonic('P');
			play.setAccelerator(KeyStroke.getKeyStroke("ctrl P"));
			gameMenu.add(play);
			
			JMenuItem restart = new JMenuItem(restartAction);
			gameMenu.add(restart);
			restart.setMnemonic('R');
			restart.setAccelerator(KeyStroke.getKeyStroke("ctrl R"));
			restart.setToolTipText("Reset current game");
			
			gameMenu.addSeparator();
			JMenu numbered = makeMenu("Numbered");
			numbered.setMnemonic('N');
			gameMenu.add(numbered);
			
			JMenuItem startNumbered = new JMenuItem(numberedAction);
			startNumbered.setToolTipText("Open specific board number");
			numbered.add(startNumbered);
			
			JMenuItem getBoardSeed = new JMenuItem(getSeed);
			getBoardSeed.setToolTipText("Get current board number");
			numbered.add(getBoardSeed);
						
	//Move menu Actions
		Action undoAction = new AbstractAction("Undo")
		{
			public void actionPerformed(ActionEvent e)
			{
				Undo();
			}
		};
	//Move Menu Creation	
		menuBar.add(moveMenu);
			JMenuItem undo = new JMenuItem(undoAction);
			moveMenu.add(undo);
			undo.setToolTipText("Undo move");
			undo.setAccelerator(KeyStroke.getKeyStroke("ctrl Z"));
			
	//Help Menu Action
		Action operationAction = new AbstractAction("Operation")	
		{
			public void actionPerformed(ActionEvent e)
			{
				Operations(); 
			}
		};	
		Action gameRulesAction = new AbstractAction("Game Rules")	
		{
			public void actionPerformed(ActionEvent e)
			{
				GameRules(); 
			}
		};
		
	//Help Menu Creation
		menuBar.add(helpMenu);
			JMenuItem operation = new JMenuItem(operationAction);
			helpMenu.add(operation);
			operation.setToolTipText("View menu descriptions");
			JMenuItem gameRules = new JMenuItem(gameRulesAction);
			helpMenu.add(gameRules);
			gameRules.setToolTipText("View game rules");
	}// end create menu
	
//Game menu Methods
	public void Play()
	{
		//make sure they want to start over if game in play
		if(gameInPlay == true)
		{
			//give warning of lost progress if current game in progress
			if(JOptionPane.showConfirmDialog(this, "Start a new game? Current progress will be lost.", "New Game", 
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) 
					== JOptionPane.OK_OPTION)
			{
				getContentPane().removeAll();
				setVisible(false);
				lastSeed = System.currentTimeMillis()%1000;
				board = new MahJongBoard(lastSeed);
				add(board);
				setVisible(true);
				gameInPlay = true;
			}
		}
		//reset JFrame and populate with tiles
		else
		{
			getContentPane().removeAll();
			setVisible(false);
			lastSeed = System.currentTimeMillis()%1000;
			board = new MahJongBoard(lastSeed);
			add(board);
			setVisible(true);
			gameInPlay = true;
		}		
	}
	public void Restart()
	{
		//give warning of lost progress if current game in progress
		if(JOptionPane.showConfirmDialog(this, "Start over? Current progress will be lost.", "Restart Game", 
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) 
				== JOptionPane.OK_OPTION)	
		{	
			getContentPane().removeAll();
			setVisible(false);
			board = new MahJongBoard(lastSeed);
			add(board);			
			setVisible(true);
			gameInPlay = true;
		}
	}
	public void Numbered()
	{
		if(gameInPlay == true)
		{
			if(JOptionPane.showConfirmDialog(this, "Start a numbered game? Current progress will be lost.", "Numbered Game", 
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) 
					== JOptionPane.OK_OPTION)
			{
				//get board #, parse to long, store in lastSeed
				String boardNum = JOptionPane.showInputDialog(this, "Please enter the board number: ", "Board number", JOptionPane.PLAIN_MESSAGE);
				//display one more time if blank info
					if( boardNum == null || boardNum.length() == 0)
					{
						boardNum = JOptionPane.showInputDialog(this, "Enter the board number: ", "Board number", JOptionPane.PLAIN_MESSAGE);
						lastSeed = Long.parseLong(boardNum);
					}
					else
					{
						lastSeed = Long.parseLong(boardNum);
					}
				
					//reset JFrame and display tiles
					getContentPane().removeAll();
					setVisible(false);
					board = new MahJongBoard(lastSeed);
					add(board);
					setVisible(true);
					gameInPlay = true;
			}
		}
		else
		{
			//get board #, parse to long, store in lastSeed
			String boardNum = JOptionPane.showInputDialog(this, "Please enter the board number: ", "Board number", JOptionPane.PLAIN_MESSAGE);
			
			//display one more time if blank info
			if( boardNum == null || boardNum.length() == 0)
			{
				boardNum = JOptionPane.showInputDialog(this, "Enter the board number: ", "Board number", JOptionPane.PLAIN_MESSAGE);
				lastSeed = Long.parseLong(boardNum);
			}
			else
			{
				lastSeed = Long.parseLong(boardNum);
			}
			
			//reset JFrame and display tiles
			getContentPane().removeAll();
			setVisible(false);
			board = new MahJongBoard(lastSeed);
			add(board);
			setVisible(true);
			gameInPlay = true;
		}
	}
	public void getSeed()
	{
		if(lastSeed == 0)
		{
			JOptionPane.showMessageDialog(this, "No board currently loaded.", "No board number", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(this, "The current board number: " + lastSeed, "Board Number", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
//Move menu Methods
	public void Undo()
	{
		if(board.undoList.size()>0)
		{
			Tile t1 = board.undoList.remove(board.undoList.size()-1);
			Tile t2 = board.undoList.remove(board.undoList.size()-1);
			
		//place tiles back in location array
			board.tileLocationArray[t1.getColumn()][t1.getRow()][t1.getLayer()] = t1;
			board.tileLocationArray[t2.getColumn()][t2.getRow()][t2.getLayer()] = t2;
			
		//adding tiles back to the board
			//board.add(t1, t1.getZOrder());
			//board.add(t2, t2.getZOrder());
			board.add(t1);
			board.add(t2);
			board.setComponentZOrder(t1, t1.getZOrder());
			board.setComponentZOrder(t2, t2.getZOrder());
			
			board.repaint();
		}
		else
		{
			JOptionPane.showMessageDialog(this, "There are no move to undo.", "Undo Move", JOptionPane.ERROR_MESSAGE);
		}
	}
	
//Help menu	
	public void GameRules()
	{
		JOptionPane.showMessageDialog(this, "   The goal of the game is to remove all tiles from the board.\n"
										  + "Tiles may be removed in pairs if they match.  Two tiles match\n"
										  + "if they are the same kind of tile and if their ranks are equal.\n"
										  + "For example, a Bamboo 6 tile matches any of the other three\n"
										  + "Bamboo tiles on the board, but it does not match a Bamboo 5\n"
										  + "nor a Circle 6 tile.  Any two season tiles match as do any\n"
										  + "two flower tiles.",
										  "Mahjong Rules", JOptionPane.PLAIN_MESSAGE);
	}
	public void Operations()
	{
		char bullet = "\u00b7".toCharArray()[0];
		//display menu breakdown
		JOptionPane.showMessageDialog(this, " Menu Breakdown:\n\n"
				  + " GAME\n"
				  + "    " + bullet + "Play - start a new game\n"
				  + "    " + bullet + "Restart - restart the current board configuration\n"
				  + "    " + bullet + "Numbered\n"
				  + "        " + bullet + "Play Numbered Game - enter board number to play\n"
				  + "        " + bullet + "Current Board Number - get current board info\n"
				  + " SOUND\n"
				  + "     " + bullet + "On - turn sound on\n"
				  + "     " + bullet + "Off - turn sound off\n"
				  + " MOVE\n"
				  + "     " + bullet + "Undo - undo last move\n"
				  + " HELP\n"
				  + "     " + bullet + "Operation - info on running this program\n"
				  + "     " + bullet + "Game Rules - Mahjong Solitare rules\n",
				  "Program Operations", JOptionPane.PLAIN_MESSAGE);
		
		//display how to select things
		JOptionPane.showMessageDialog(this, "SELECTING TILES:\n"
				+ "  Hover over a tile to view if the tile is able \n"
				+"to be selected or not.  If it is able to be selected,\n"
				+ "an icon will appear on the tile your mouse cursor \n"
				+ "is over.  Click the selectable tile and a larger icon\n"
				+ "will display on the tile signifying it is selected.\n"
				+ "Select the same tile again to deselect it.  After \n"
				+ "selecting the first tile, click on any selectable tile\n"
				+ "to see if they match. Matching tiles will be removed \n"
				+ "from the board.  Once all tiles are removed from the \n"
				+ "board, the game is won!"
					, "Program Operations", JOptionPane.PLAIN_MESSAGE);
		
	}
	
	public static void GameWon()
	{
		JOptionPane.showMessageDialog(null, "CONGRATULATIONS!!! You won the game!", "Winner!", JOptionPane.PLAIN_MESSAGE);
		System.exit(0);
	}
//MAIN
	public static void main (String args[])
	{
		new MahJong();
	}

}  //end Mahjong
