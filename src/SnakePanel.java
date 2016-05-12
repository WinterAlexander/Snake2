import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class SnakePanel extends JPanel 
{
	private static final long serialVersionUID = 1L;

	@Override
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.BLACK);
		if(Main.snake.cheatmitsler)
			g.drawImage(ImageList.BACKGROUND2.getImage(), this.getWidth() / 2 - 320, this.getHeight() / 2 - 240, null);
		else
			g.drawImage(ImageList.BACKGROUND.getImage(), this.getWidth() / 2 - 320, this.getHeight() / 2 - 240, null);
		
		g.drawImage(Main.snake.fruit.getImage(), this.getWidth() / 2 - 320 + Main.snake.fruit.getPosX() * 16, this.getHeight() / 2 - 240 + Main.snake.fruit.getPosY() * 16, null);
		
		for(int i = 0; i < Main.snake.snakebody.size(); i++)
		{
			int posX = this.getWidth() / 2 - 320 + Main.snake.snakebody.get(i).getPosX() * 16;
			int posY = this.getHeight() / 2 - 240 + Main.snake.snakebody.get(i).getPosY() * 16;
			
			if(i + 1 == Main.snake.snakebody.size())
			{
				switch(Main.snake.snakebody.get(i).getDirection())
				{
				case LEFT:
					g.drawImage(ImageList.TAIL_LEFT.getImage(), posX, posY, null);
					break;
					
				case UP:
					g.drawImage(ImageList.TAIL_UP.getImage(), posX, posY, null);
					break;
					
				case RIGHT:
					g.drawImage(ImageList.TAIL_RIGHT.getImage(), posX, posY, null);
					break;
					
				case DOWN:
					g.drawImage(ImageList.TAIL_DOWN.getImage(), posX, posY, null);
					break;
				}
			}
			else if(i != 0)
			{
				int posPreviousX = Main.snake.snakebody.get(i - 1).getPosX();
				int posPreviousY = Main.snake.snakebody.get(i - 1).getPosY();
				
				int posNextX = Main.snake.snakebody.get(i + 1).getPosX();
				int posNextY = Main.snake.snakebody.get(i + 1).getPosY();
				
				if(posPreviousX == posNextX && Math.sqrt(Math.pow(posPreviousY - posNextY, 2)) == 2)
				{
					g.drawImage(ImageList.BODY_VERTICAL.getImage(), posX, posY, null);
				}
				else if(posPreviousY == posNextY && Math.sqrt(Math.pow(posPreviousX - posNextX, 2)) == 2)
				{
					g.drawImage(ImageList.BODY_HORIZONTAL.getImage(), posX, posY, null);
				}
				else if(posPreviousX + 1 == posNextX && posPreviousY + 1 == posNextY && posNextX == Main.snake.snakebody.get(i).getPosX()
				|| posPreviousX == posNextX + 1 && posPreviousY == posNextY + 1 && posPreviousX == Main.snake.snakebody.get(i).getPosX())
				{
					g.drawImage(ImageList.BODY_DOWN_LEFT.getImage(), posX, posY, null);
				}
				else if(posPreviousX + 1 == posNextX && posPreviousY + 1 == posNextY && posPreviousX == Main.snake.snakebody.get(i).getPosX()
				|| posPreviousX == posNextX + 1 && posPreviousY == posNextY + 1 && posNextX == Main.snake.snakebody.get(i).getPosX())
				{
					g.drawImage(ImageList.BODY_UP_RIGHT.getImage(), posX, posY, null);
				}
				else if(posPreviousX + 1 == posNextX && posPreviousY - 1 == posNextY && posPreviousX == Main.snake.snakebody.get(i).getPosX()
				|| posPreviousX == posNextX + 1 && posPreviousY == posNextY - 1 && posNextX == Main.snake.snakebody.get(i).getPosX())
				{
					g.drawImage(ImageList.BODY_DOWN_RIGHT.getImage(), posX, posY, null);
				}
				else if(posPreviousX + 1 == posNextX && posPreviousY - 1 == posNextY && posNextX == Main.snake.snakebody.get(i).getPosX()
				|| posPreviousX == posNextX + 1 && posPreviousY == posNextY - 1 && posPreviousX == Main.snake.snakebody.get(i).getPosX())
				{
					g.drawImage(ImageList.BODY_UP_LEFT.getImage(), posX, posY, null);
				}
				
			}
		}
		
		switch(Main.snake.snakebody.get(0).getDirection())
		{
		case LEFT:
			g.drawImage(ImageList.HEAD_LEFT.getImage(), this.getWidth() / 2 - 320 + Main.snake.snakebody.get(0).getPosX() * 16, this.getHeight() / 2 - 240 + Main.snake.snakebody.get(0).getPosY() * 16, null);
			break;
			
		case UP:
			g.drawImage(ImageList.HEAD_UP.getImage(), this.getWidth() / 2 - 320 + Main.snake.snakebody.get(0).getPosX() * 16, this.getHeight() / 2 - 240 + Main.snake.snakebody.get(0).getPosY() * 16, null);
			break;
			
		case RIGHT:
			g.drawImage(ImageList.HEAD_RIGHT.getImage(), this.getWidth() / 2 - 320 + Main.snake.snakebody.get(0).getPosX() * 16, this.getHeight() / 2 - 240 + Main.snake.snakebody.get(0).getPosY() * 16, null);
			break;
			
		case DOWN:
			g.drawImage(ImageList.HEAD_DOWN.getImage(), this.getWidth() / 2 - 320 + Main.snake.snakebody.get(0).getPosX() * 16, this.getHeight() / 2 - 240 + Main.snake.snakebody.get(0).getPosY() * 16, null);
			break;
		}
		
		if(Main.snake.lost)
		{
			g.drawImage(ImageList.GAMEOVER.getImage(), this.getWidth() / 2 - 320, this.getHeight() / 2 - 240, null);
		}
	}
}
