import java.awt.*;
import java.util.Random;

public class PongBall
{
  int xposition, yposition, width, length, xvelocity, yvelocity;
  Color color;
  Random r;
  Image imageBall;

  public PongBall(Image image, int x, int y, int w, int l, Color c)
  {
    imageBall = image;
    r = new Random();
    resetBall();
    width = w;
    length = l;
    xvelocity = 2;
    yvelocity = 2;
    color = c;
  }

  public void resetBall()
  {
    xposition = 300;
    yposition = r.nextInt(250) + 50; 
    if(r.nextInt(2) == 0)
    {
      xvelocity = -xvelocity;
    }
    if(r.nextInt(2) == 0)
    {
      yvelocity = -yvelocity;
    }
  }

  public void move(int borderTop, int borderBottom, int borderLeft, int borderRight, PongScoreBoard scoreBoard)
  {
    if(yposition + length >= borderBottom)
    {
      yvelocity = -yvelocity;
    }
    else if(xposition + width >= borderRight)
    {
      xvelocity = -xvelocity;
      scoreBoard.scoredGoal(2);
      resetBall();
    }
    else if(yposition <= borderTop)
    {
      yvelocity = -yvelocity;
    }
    else if(xposition <= borderLeft)
    {
      xvelocity = -xvelocity;
      scoreBoard.scoredGoal(1);
      resetBall();
    }
    yposition = yposition + yvelocity;
    xposition = xposition + xvelocity;
  }

  public void checkPaddleCollision(PongPaddle paddle)
  {
    if(xposition + width >= paddle.getXPosition() && yposition + length >= paddle.getYPosition() && yposition <= paddle.getYPosition() + paddle.getLength() && xposition <= paddle.getXPosition() + paddle.getWidth())
    {
      xvelocity = -xvelocity;
    }

  }

  public void draw(Graphics g)
  {
    g.setColor(color);
    //g.fillOval(xposition, yposition, width, length);
    g.drawImage(imageBall, xposition, yposition, null); 
  }


}
