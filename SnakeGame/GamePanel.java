// imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
public class GamePanel extends JPanel implements ActionListener
{
	//wall parameters
	static final int screenWidth = 900;
	static final int screenHeight = 700;
	static final int unit = 50;
	static final int delay = 175;
	static final int gameUnits = (screenWidth * screenHeight) / (unit * unit);
	//direction characters
	char direction1 = 'R';
	char direction2 = 'R';
	//running boolean loop and timer
	boolean running = false;
	Timer timer;
	Random random;
	//to create random donuts
	Random r = new Random();
	Random newr = new Random();
	int number, newNumber;
	//images and toolkit initialization
	Image yuvi, chocolateDonut, strawberryDonut, vanillaDonut, glazedDonut, bostoncreampieDonut, jellyDonut, radioactiveDonut;
  ImageIcon gameBackground;
	Image myBackground;
	JLabel backgroundLabel;
	Toolkit tk;
	//train1 variables
	final int x[] = new int[gameUnits];
	final int y[] = new int[gameUnits];
	int bodyPartsPlayer1 = 3;
	int donutsConsumedPlayer1;
	boolean player1won = false;
	//train2 variables
	final int a[] = new int[gameUnits];
	final int z[] = new int[gameUnits];
	int bodyPartsPlayer2 = 3;
	int donutsConsumedPlayer2;
	boolean player2won = false;
	//position and location variables
	int donutX;
	int donutY;
	int newDonutX;
	int newDonutY;
	int yuviX;
	int yuviY;
	//final score
	final int winningScore = 1;
	Boolean checkScore = true;

	public GamePanel()
	{
		Color yuvinatorPink = new Color(237, 145, 173);
		random = new Random();
		// panel / frame settings
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(yuvinatorPink);
		this.setFocusable(true);	
		this.addKeyListener(new MyKeyAdapter());
		this.getToolkit().sync();
		tk = Toolkit.getDefaultToolkit();
		//images
		chocolateDonut = tk.getImage("ChocolateDonut.png");
		strawberryDonut = tk.getImage("StrawberryDonut.png");
		vanillaDonut = tk.getImage("VanillaDonut.png");
		glazedDonut = tk.getImage("GlazedDonut.png");
		bostoncreampieDonut = tk.getImage("BostonCreamPieDonut.png");
		yuvi = tk.getImage("Yuvi.png");
		radioactiveDonut = tk.getImage("RadioactiveDonut.png");
		jellyDonut = tk.getImage("jellyDonut.png");
		myBackground = tk.getImage("snakeGameBackground.png");
		gameBackground = new ImageIcon("snakeGameBackground.png");
		backgroundLabel = new JLabel(gameBackground);
		backgroundLabel.setBounds(0, 0, 100, 100);
		//starts the game
		startGame();
	}
	//starts the game
	public void startGame() 
	{
		newGoodDonut();
		newYuvi();
		running = true;
		timer = new Timer(delay, this);
		timer.start();
	}
	//paints
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		draw(g);
	}
	//draws
	public void draw(Graphics g)
	{
		if(running) //true
		{
			//creates background
			g.drawImage(myBackground, 0, 0, null);
			
			//random donut generation
			if(number == 1)
			{
				g.drawImage(glazedDonut, donutX - 15, donutY - 15, null);
			}
			if(number == 2)
			{
				g.drawImage(bostoncreampieDonut, donutX - 15, donutY - 15, null);
			}
			if(number == 3)
			{
				g.drawImage(jellyDonut, donutX - 15, donutY - 15, null);
			}
			if(number == 4)
			{
				g.drawImage(yuvi, donutX, donutY, null);
			}
			if(newNumber == 1)
			{
				g.drawImage(glazedDonut, newDonutX - 15, newDonutY - 15, null);
			}
			if(newNumber == 2)
			{
				g.drawImage(bostoncreampieDonut, newDonutX - 15, newDonutY - 15, null);
			}
			if(newNumber == 3)
			{
				g.drawImage(jellyDonut, newDonutX - 15, newDonutY - 15, null);
			}
			if(newNumber == 4)
			{
				g.drawImage(yuvi, newDonutX, newDonutY, null);
			}
			//increments length
			for(int i = 0; i < bodyPartsPlayer1; i++) 
			{
				if(i == 0) 
				{
					Color yuvinatorPink = new Color(237, 145, 173);
					g.drawImage(chocolateDonut, x[i] - 20, y[i] - 20, null);
					g.setColor(yuvinatorPink);
				}
				else 
				{
					g.drawImage(chocolateDonut, x[i] - 20, y[i] - 20, null);
				}			
			}
			for(int j = 0; j < bodyPartsPlayer2; j++) 
			{
				if(j == 0) 
				{
					Color yuvinatorPink = new Color(237, 145, 173);
					g.drawImage(strawberryDonut, a[j] - 20, z[j] - 20, null);
					g.setColor(yuvinatorPink);
				}
				else 
				{
					g.drawImage(strawberryDonut, a[j] - 20, z[j] - 20, null);
				}			
			}
			//Scoreboard
			Color yuvinatorPurple = new Color(153, 0, 255);
			g.setColor(yuvinatorPurple);
			g.setFont( new Font("Ink Free", Font.BOLD, 40));
			FontMetrics metrics = getFontMetrics(g.getFont());
			g.drawString("Player 1: " + donutsConsumedPlayer1 + "   Player 2: " + donutsConsumedPlayer2 + "   ", (screenWidth - metrics.stringWidth("Player 1: " + donutsConsumedPlayer1 + "   Player 2: " + donutsConsumedPlayer2 + "   ")) / 2, g.getFont().getSize());
		}
		else 
		{
			gameOver(g);
		}
	}
	public void newNewDonut()
	{
		//new donut again
		newNumber = newr.nextInt(5 - 1) + 1;
		newDonutX = random.nextInt((int)(screenWidth / unit)) * unit;
		newDonutY = random.nextInt((int)(screenWidth / unit)) * unit;
		
	}
	public void newGoodDonut()
	{			
		//new donut
		number = r.nextInt(5 - 1) + 1;
		donutX = random.nextInt((int)(screenWidth / unit)) * unit;
		donutY = random.nextInt((int)(screenHeight / unit)) * unit;
	}
	public void newYuvi()
	{
		// new Yuvi
		yuviX = random.nextInt((int)(screenWidth / unit)) * unit;
		yuviY = random.nextInt((int)(screenHeight / unit)) * unit;
	}
	public void move()
	{ //movement
		for(int i = bodyPartsPlayer1; i > 0; i--) 
		{
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		for(int j = bodyPartsPlayer2; j > 0; j--)
			{
				a[j] = a[j-1];
				z[j] = z[j-1];
			}
		switch(direction1) 
		{
		case 'U':
			y[0] = y[0] - unit;
			break;
		case 'D':
			y[0] = y[0] + unit;
			break;
		case 'L':
			x[0] = x[0] - unit;
			break;
		case 'R':
			x[0] = x[0] + unit;
			break;
		}
		switch(direction2) 
		{
		case 'U':
			z[0] = z[0] - unit;
			break;
		case 'D':
			z[0] = z[0] + unit;
			break;
		case 'L':
			a[0] = a[0] - unit;
			break;
		case 'R':
			a[0] = a[0] + unit;
			break;
		}
		//case ''
	}
	public void checkYuvi()
	{//check for Yuvi collision
		if((x[0] == yuviX) && (y[0] == yuviY))
		{
			running = false;
			repaint();
		}
		if((a[0] == yuviX) && (z[0] == yuviY))
		{
			running = false;
			repaint();
		}
	}
	public void checkDonut() 
	{
		//check for donut collision
		if((x[0] == donutX) && (y[0] == donutY))
		{
			bodyPartsPlayer1++;
			donutsConsumedPlayer1++;
			newGoodDonut();
			newNewDonut();
			newYuvi();
		}
		if((a[0] == donutX) && (z[0] == donutY))
		{
			bodyPartsPlayer2++;
			donutsConsumedPlayer2++;
			newGoodDonut();
			newNewDonut();
			newYuvi();
		}
		if((x[0] == newDonutX) && (y[0] == newDonutY))
		{
			bodyPartsPlayer1++;
			donutsConsumedPlayer1++;
			newGoodDonut();
			newNewDonut();
			newYuvi();
		}
		if((a[0] == newDonutX) && (z[0] == newDonutY))
		{
			bodyPartsPlayer2++;
			donutsConsumedPlayer2++;
			newGoodDonut();
			newNewDonut();
			newYuvi();
		}
		if(bodyPartsPlayer1 == 10)
		{
			//frame.dispose();
			WinningScreen ws = new WinningScreen();
		}
		if(bodyPartsPlayer2 == 10)
		{
			//frame.dispose();
			WinningScreen ws = new WinningScreen();
		}
	}
	public void checkCollisions()
	{
		//checks if head collides with body
		for(int i = bodyPartsPlayer1; i > 0; i--) 
		{
			if((x[0] == x[i])&& (y[0] == y[i])) 
			{
				running = true;
			}
		}
		for(int j = bodyPartsPlayer2; j > 0; j--) 
		{
			if((a[0] == a[j])&& (z[0] == z[j])) 
			{
				running = true;
			}
		}
		//check if head touches left border
		if(x[0] < 0)
		{
			running = true;
			//donutsConsumedPlayer1--;
		}
		if(a[0] < 0)
		{
			running = true;
			//donutsConsumedPlayer2--;
		}
		//check if head touches right border
		if(x[0] > screenWidth)
		{
			running = true;
			//donutsConsumedPlayer1--;
		}
		if(a[0] > screenWidth)
		{
			running = true;
			//donutsConsumedPlayer2--;
		}
		//check if head touches top border
		if(y[0] < 0) 
		{
			running = true;
			
			//donutsConsumedPlayer1--;
		}
		if(z[0] < 0) 
		{
			running = true;
			
			//donutsConsumedPlayer2--;
		}
		//check if head touches bottom border
		if(y[0] > screenHeight)
		{
			running = true;
			
			//donutsConsumedPlayer1--;
		}
		if(z[0] > screenHeight)
		{
			running = true;
			
			//donutsConsumedPlayer2--;
		}
		if(!running) 
		{
			timer.stop();
		}
	}
	public void gameOver(Graphics g) 
	{
		//Score
		g.setColor(Color.red);
		g.setFont( new Font("Ink Free",Font.BOLD, 40));
		FontMetrics metrics1 = getFontMetrics(g.getFont());
		g.drawString("Score: "+donutsConsumedPlayer1, (screenWidth - metrics1.stringWidth("Score: "+donutsConsumedPlayer1))/2, g.getFont().getSize());
		//Game Over text
		g.setColor(Color.red);
		g.setFont( new Font("Ink Free",Font.BOLD, 75));
		FontMetrics metrics2 = getFontMetrics(g.getFont());
		g.drawString("Game Over", (screenWidth - metrics2.stringWidth("Game Over"))/2, screenHeight/2);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(running)
		{
			move();
			checkDonut();
			checkCollisions();
		}
		repaint();
	}
	public class MyKeyAdapter extends KeyAdapter
	{
		@Override
		public void keyPressed(KeyEvent e)
		{
			switch(e.getKeyCode()) 			
			{
				case KeyEvent.VK_D:
					if(direction1 != 'L')
					{
						direction1 = 'R';
					}
					break;
				case KeyEvent.VK_A:
					if(direction1 != 'R')
					{
						direction1 = 'L';
					}
					break;
				case KeyEvent.VK_W:
					if(direction1 != 'D')
					{
						direction1 = 'U';
					}
					break;
				case(KeyEvent.VK_S):
					if(direction1 != 'U')
					{
						direction1 = 'D';
					}
				break;
			case KeyEvent.VK_RIGHT:
				if(direction2 != 'L') 
				{
					direction2 = 'R';
				}
				break;
			case KeyEvent.VK_LEFT:
				if(direction2 != 'R')
				{
					direction2 = 'L';
				}
				break;
			case KeyEvent.VK_UP:
				if(direction2 != 'D')
				{
					direction2 = 'U';
				}
				break;
			case KeyEvent.VK_DOWN:
				if(direction2 != 'U') 
				{
					direction2 = 'D';
				}
				break;
			}
		}
	}
}
