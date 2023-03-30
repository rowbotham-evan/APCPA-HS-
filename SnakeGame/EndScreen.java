//END SCREEN WITH OUR PICTURES
import java.awt.*;
import javax.swing.*;
public class EndScreen extends JFrame
{
	JFrame frame = new JFrame();
	ImageIcon PDEY, N;
	JLabel PDEYlabel, Nlabel;
	JLabel ty;
	
	public EndScreen()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 1000);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.BLACK);
		Color yuvinatorPurple = new Color(153, 0, 255);
		Color yuvinatorDonut = new Color(255, 202, 128);

		JLabel ty = new JLabel("Thanks for playing!");
		ty.setBounds(350, 350, 400, 40);
		ty.setFont(new Font(null, Font.BOLD, 25));
		ty.setForeground(Color.MAGENTA);
		ty.setBackground(yuvinatorPurple);
		frame.add(ty);

		PDEY = new ImageIcon("FINAL.png");
		PDEYlabel = new JLabel(PDEY);
		PDEYlabel.setBounds(100, 100, 800, 800);
		frame.add(PDEYlabel);
	}
}
