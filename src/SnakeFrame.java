import javax.swing.JFrame;


public class SnakeFrame extends JFrame 
{
	private static final long serialVersionUID = 1L;

	public SnakeFrame()
	{
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Snake");
		this.addKeyListener(Main.clavier);
		this.setVisible(true);
	}
}
