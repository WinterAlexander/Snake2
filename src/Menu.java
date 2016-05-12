import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.JPanel;


public class Menu
{
	public Menu()
	{
		Main.panel.setLayout(new BorderLayout());
		Main.panel.add(new JPanel()
		{
			private static final long serialVersionUID = 1L;
			
			@Override
			public void paintComponent(Graphics g)
			{
				g.drawImage(ImageList.MENU.getImage(), this.getWidth() / 2 - 320, this.getHeight() / 2 - 240, null);
			}
		}, BorderLayout.CENTER);
	}
}
