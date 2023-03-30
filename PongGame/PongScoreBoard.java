import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PongScoreBoard extends JPanel implements ActionListener
{
  JButton start, pause;
  Timer time;
  JLabel playerLabel1, playerLabel2, playerScoreLabel1, playerScoreLabel2, winnerLabel;
  final int winningScore = 3; 
  int playerScore1 = 0, playerScore2 = 0;

  public PongScoreBoard(Timer t)
  {
    time = t;
    setBounds(0, 320, 600, 100);
    setBackground(Color.CYAN);
    playerLabel1 = new JLabel("Player 1");
    playerLabel2 = new JLabel("Player 2");
    playerScoreLabel1 = new JLabel("" + playerScore1);
    playerScoreLabel2 = new JLabel("" + playerScore2);
    start = new JButton("Start Game");
    pause = new JButton("Pause Game");
    add(playerLabel1);
    add(playerScoreLabel1);
    add(start);
    add(pause);
    add(playerLabel2);
    add(playerScoreLabel2);
    start.addActionListener(this);
    pause.addActionListener(this);
    pause.setFocusable(false);
    start.setFocusable(false);
  }

  public void scoredGoal(int playerScoredAgainst)
  {
    if(playerScoredAgainst == 2)
    {
      playerScore1++;
      playerScoreLabel1.setText("" + playerScore1);
    }
    else
    {
      playerScore2++;
      playerScoreLabel2.setText("" + playerScore2);
    }

    if(checkForWin() == 1)
    {
      playerScoreLabel1.setText("wins!");
      time.stop();
    }

    if(checkForWin() == 2)
    {
      playerScoreLabel2.setText("wins!");
      time.stop();
    }
  }

  public int checkForWin()
  {
    if(playerScore1 == winningScore)
    {
      return 1; 
    }

    else if(playerScore2 == winningScore)
    {
      return 2;
    }

    else
    {
      return 0; 
    }
  }



  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource() == start)
    {
      time.start();
    }

    if(e.getSource() == pause)
    {
      time.stop();
    }
  }
}









