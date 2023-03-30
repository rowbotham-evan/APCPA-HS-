import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PongGUI extends JPanel implements KeyListener, ActionListener
{
  // Globals 
  PongPaddle paddle1;
  PongPaddle paddle2;
  PongBall ball;
  Timer time;
  final int borderTop = 0;
  final int borderBottom = 300;
  final int borderLeft = 0; 
  final int borderRight = 600;
  PongScoreBoard scoreBoard;
  Toolkit tk;
  Image imageBackground;

  public PongGUI() //constructor 
  {
    //Images
    tk = Toolkit.getDefaultToolkit();
    Image imagePaddle1 = tk.getImage("paddle.png");
    Image imagePaddle2 = tk.getImage("paddle.png");
    Image imageBall = tk.getImage("ball.png"); 
    imageBackground = tk.getImage("PongBackground.png");

    //Timer and Objects
    time = new Timer(17, this);
    setLayout(null);
    scoreBoard = new PongScoreBoard(time);
    add(scoreBoard);
    paddle1 = new PongPaddle(imagePaddle1, 20, 20, 30, 100, Color.RED);
    paddle2 = new PongPaddle(imagePaddle2, 550, 20, 30, 100, Color.GREEN);
    ball = new PongBall(imageBall, 250, 200, 20, 20, Color.BLACK);
    setFocusable(true);
    addKeyListener(this);
  }

  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource() == time)
    {
      ball.move(borderTop, borderBottom, borderLeft, borderRight, scoreBoard);
      ball.checkPaddleCollision(paddle2);
      ball.checkPaddleCollision(paddle1);
      repaint();
    }
  }

  public void keyPressed(KeyEvent e)
  {
    
    if(e.getKeyCode() == KeyEvent.VK_UP)
    {
      paddle1.moveUp(borderTop);
      repaint();
    }

    if(e.getKeyCode() == KeyEvent.VK_DOWN)
    {
      paddle1.moveDown(borderBottom);
      repaint();
    }

    if(e.getKeyCode() == KeyEvent.VK_W)
    {
      paddle2.moveUp(borderTop);
      repaint();
    }

    if(e.getKeyCode() == KeyEvent.VK_S)
    {
      paddle2.moveDown(borderBottom);
      repaint();
    }

  }
  
  public void keyReleased(KeyEvent e){}
  public void keyTyped(KeyEvent e){}

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    g.drawImage(imageBackground, borderLeft, borderTop, this);
    g.drawRect(borderLeft, borderTop, borderRight, borderBottom);
    paddle1.draw(g);
    paddle2.draw(g);
    ball.draw(g);
  }

}
