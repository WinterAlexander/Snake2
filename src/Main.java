import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main
{
	public static JFrame frame;
	public static Clavier clavier;
	public static Scheduler scheduler;
	public static Snake snake;
	public static JPanel panel;
	public static Menu menu;
	
	public static void main(String[] args) 
	{
		
		Main.scheduler = new Scheduler();
		Main.clavier = new Clavier();
		Main.frame = new SnakeFrame();
		
		Main.panel = new JPanel();
		Main.frame.setContentPane(Main.panel);
		Main.menu = new Menu();
		
		while(true)
		{
			Main.scheduler.refresh();
		}
	}
}
