import javax.swing.*;

class Main {
  public static void main(String[] args) 
  {
    JFrame frame = new JFrame();
    frame.setVisible(true);
    frame.setContentPane(new PongGUI());
    frame.setSize(700,400);
  }
}
