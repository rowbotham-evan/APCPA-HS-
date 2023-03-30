import java.awt.*;

public class PongPaddle
{

  int xposition, yposition, width, length, yvelocity;
  private Color color;
  Image imagePaddle;

  public PongPaddle(Image image, int x, int y, int w, int l, Color c)
  {
    imagePaddle = image;
    xposition = x;
    yposition = y;
    width = w;
    length = l;
    color = c; 
    yvelocity = 5;
  }

  public void moveUp(int borderTop)
  {
    if(yposition <= borderTop)
    {
      yposition = yposition + yvelocity;
    }
    else
    {
      yposition = yposition + -yvelocity; 
    }
  }

  public void moveDown(int borderBottom)
  {
    if(yposition + length >= borderBottom)
    {
      yposition = yposition + -yvelocity;
    }
    else 
    {
      yposition = yposition + yvelocity;
    }
  }

  public int getXPosition()
  {
    return xposition;
  }

  public int getYPosition()
  {
    return yposition;
  }

  public int getWidth()
  {
    return width;
  }

  public int getLength()
  {
    return length;
  }

  public void draw(Graphics g)
  {
    g.setColor(color);
    g.drawImage(imagePaddle, xposition, yposition, null);
  }


}
