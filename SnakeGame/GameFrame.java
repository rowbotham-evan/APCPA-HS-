import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GameFrame extends JFrame
{
	public GameFrame()
	{
		this.add(new GamePanel());
		this.setTitle("Yuvinators");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		//this.setLayout(null);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
