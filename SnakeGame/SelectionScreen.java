// imports
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class SelectionScreen extends JFrame implements ActionListener, KeyListener
{
  // Globals
	JFrame frame = new JFrame();
 	JProgressBar bar = new JProgressBar(0, 100);
	Timer time;
	Toolkit tk;
	int counter = 0;
	JLabel player1, player2;
	String[] characterOptions = {"Chocolate Donut", "Vanilla Donut", "Strawberry Donut", "Radioactive Donut"};
  JComboBox optionsPlayer1, optionsPlayer2;
	JButton enterGame;
	int x = 0;
	JTextField namePlayer1, namePlayer2;
	Image selectionBackground;
	boolean player1Chocolate, player1Vanilla, player1Strawberry, player1Radioactive, player2Chocolate, player2Vanilla, player2Strawberry, player2Radioactive;
 	
 	public SelectionScreen()
	{
		tk = Toolkit.getDefaultToolkit();
		selectionBackground = tk.getImage("SelectionBackground.png");
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 1000);
		frame.setLayout(null);
		frame.setVisible(true);

		bar.setValue(0);
		bar.setBounds(100, 750, 650, 80);
		bar.setStringPainted(true);
		bar.setFont(new Font("Helvetica", Font.BOLD, 50));
		Color yuvinatorPurple = new Color(153, 0, 255);
	  Color yuvinatorDonut = new Color(255, 202, 128);
		bar.setForeground(yuvinatorPurple);
		bar.setBackground(yuvinatorDonut);
		frame.add(bar);
		fill();

    // Setting up the players' graphics 
		JLabel player1 = new JLabel(" Player 1 ");
		JLabel player2 = new JLabel(" Player 2 ");
		player1.setFont(new Font("Helvetica", Font.BOLD, 25));
		player2.setFont(new Font("Helvetica", Font.BOLD, 25));
		player1.setBackground(Color.BLACK);
		player2.setBackground(Color.BLACK);
		player1.setForeground(Color.CYAN);
		player2.setForeground(Color.CYAN);
		player1.setBounds(200, 100, 200, 100);
		player2.setBounds(500, 100, 200, 100);
		frame.add(player1);
		frame.add(player2);

		JComboBox optionsPlayer1 = new JComboBox(characterOptions);
  	JComboBox optionsPlayer2 = new JComboBox(characterOptions);
		optionsPlayer1.setFont(new Font("Helvetica", Font.BOLD, 25));
		optionsPlayer2.setFont(new Font("Helvetica", Font.BOLD, 25));
		optionsPlayer1.addActionListener(this);
		optionsPlayer2.addActionListener(this);
		optionsPlayer1.setBackground(yuvinatorPurple);
		optionsPlayer2.setBackground(yuvinatorPurple);
		optionsPlayer1.setForeground(yuvinatorDonut);
		optionsPlayer2.setForeground(yuvinatorDonut);
		optionsPlayer1.setBounds(100, 175, 300, 100);
		optionsPlayer2.setBounds(425, 175, 300, 100);
		optionsPlayer1.setVisible(true);
		optionsPlayer2.setVisible(true);
		frame.add(optionsPlayer1);
		frame.add(optionsPlayer2);

		JTextField namePlayer1 = new JTextField("Enter name");
		JTextField namePlayer2 = new JTextField("Enter name");
		namePlayer1.setHorizontalAlignment(JTextField.CENTER);
		namePlayer2.setHorizontalAlignment(JTextField.CENTER);
		namePlayer1.setFont(new Font("Helvetica", Font.BOLD, 25));
		namePlayer2.setFont(new Font("Helvetica", Font.BOLD, 25));
		namePlayer1.setBackground(Color.MAGENTA);
		namePlayer2.setBackground(Color.MAGENTA);
		namePlayer1.setForeground(Color.BLACK);
		namePlayer2.setForeground(Color.BLACK);
		namePlayer1.setBounds(100, 300, 300, 100);
		namePlayer2.setBounds(425, 300, 300, 100);
		frame.add(namePlayer1);
		frame.add(namePlayer2);

		enterGame = new JButton("Play Now!");
		enterGame.setFont(new Font("Helvetica", Font.BOLD, 25));
		enterGame.setBackground(Color.CYAN);
		enterGame.setForeground(yuvinatorPurple);
		enterGame.setBounds(262, 425, 300, 100);
		enterGame.addActionListener(this);
		frame.add(enterGame);
 	}	
	public String getP1Char()
	{
		String user1Character = optionsPlayer1.getSelectedItem().toString();
		return user1Character;
	}
public String getP2Char()
	{
		String user2Character = optionsPlayer2.getSelectedItem().toString();
		return user2Character;
	}

	public void fill() 
  {
		while(counter <= 100) 
    {
			bar.setValue(counter);
			try 
      {
				Thread.sleep(50);
			} 
      catch(InterruptedException e) 
      {
				e.printStackTrace();
			}
			counter += 1;
    }
	}
	public String returnPlayer1Name()
	{
		String p1Name = namePlayer1.getText();
		return p1Name;
	}
	public String returnPlayer2Name()
	{
		String p2Name = namePlayer2.getText();
		return p2Name;
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == enterGame)
		{
			System.out.println("cooval");
			frame.dispose();
			//getP1Char();
			//getP2Char();
			GameFrame gameFrame = new GameFrame();
			//returnPlayer1Name();
			//returnPlayer2Name();
			System.out.println("ඞ");
		}
		if(e.getSource() == optionsPlayer1) 
    {
      if(optionsPlayer1.getSelectedIndex() == 0)
      {
        optionsPlayer2.removeItemAt(0);
      }
      if(optionsPlayer1.getSelectedIndex() == 1)
      {
        optionsPlayer2.removeItemAt(1);
      }
      if(optionsPlayer1.getSelectedIndex() == 2)
      {
        optionsPlayer2.removeItemAt(2);
      }
			if(optionsPlayer1.getSelectedIndex() == 3)
			{
				optionsPlayer2.removeItemAt(3);
			}
    }
		if(e.getSource() == optionsPlayer2) 
    {
      if(optionsPlayer2.getSelectedIndex() == 0)
      {
        optionsPlayer1.removeItemAt(0);
      }
      if(optionsPlayer2.getSelectedIndex() == 1)
      {
        optionsPlayer1.removeItemAt(1);
      }
      if(optionsPlayer2.getSelectedIndex() == 2)
      {
        optionsPlayer1.removeItemAt(2);
      }
			if(optionsPlayer2.getSelectedIndex() == 3)
			{
				optionsPlayer1.removeItemAt(3);
			}
    }
	}
	public void keyReleased(KeyEvent e){}
  public void keyTyped(KeyEvent e){}
  public void keyPressed(KeyEvent e){}
}
