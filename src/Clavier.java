import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Clavier implements KeyListener 
{	
	private int cheatwinter;
	private int cheatmitsler;
	
	@Override
	public void keyPressed(KeyEvent arg0) 
	{
		if(Main.snake != null)
			switch(arg0.getKeyCode())
			{
			case 37:
				if(Main.snake.getOriginalDirection() != Direction.RIGHT)
					Main.snake.snakebody.get(0).setDirection(Direction.LEFT);
				break;
			
				
			case 38:
				if(Main.snake.getOriginalDirection() != Direction.DOWN)
					Main.snake.snakebody.get(0).setDirection(Direction.UP);
				break;
			
						
			case 39:
				if(Main.snake.getOriginalDirection() != Direction.LEFT)
					Main.snake.snakebody.get(0).setDirection(Direction.RIGHT);
				break;
			
				
			case 40:
				if(Main.snake.getOriginalDirection() != Direction.UP)
					Main.snake.snakebody.get(0).setDirection(Direction.DOWN);
				break;
				
			case 10:
				if(Main.snake.lost)
				{
					Main.panel.removeAll();
					Main.snake = new Snake();
				}
				break;
				
			case 69://e
				if(this.cheatwinter == 4)
					this.cheatwinter++;
				if(this.cheatmitsler == 5)
					this.cheatmitsler++;
				break;
				
			case 73://i
				if(this.cheatwinter == 1)
					this.cheatwinter++;
				if(this.cheatmitsler == 1)
					this.cheatmitsler++;
				break;
				
			case 76://l
				if(this.cheatmitsler == 4)
					this.cheatmitsler++;
				break;
				
			case 77://m
				if(this.cheatmitsler == 0)
					this.cheatmitsler++;
				break;
				
			case 78://n
				if(this.cheatwinter == 2)
					this.cheatwinter++;
				break;
				
			case 82://r
				if(this.cheatwinter == 5)
					Main.snake.cheatwinter = true;
				if(this.cheatmitsler == 6)
				{
					Main.snake.cheatmitsler = true;
					Main.scheduler.tasks.get(0).setDelay(50);
				}
				break;
				
			case 83://s
				if(this.cheatmitsler == 3)
					this.cheatmitsler++;
				break;
				
			case 84://t
				if(this.cheatwinter == 3)
					this.cheatwinter++;
				if(this.cheatmitsler == 2)
					this.cheatmitsler++;
				break;
				
			case 87://w
				if(this.cheatwinter == 0)
					this.cheatwinter++;
				break;
			
				
			default:
				System.out.println("caractere non-utilise: '" + arg0.getKeyChar() + "' id:'" + arg0.getKeyCode() + "'");
				break;
			}
		
		else if(arg0.getKeyCode() == 10)
		{
			Main.panel.removeAll();
			Main.snake = new Snake();
		}
	}
	
	public void resetCheat()
	{
		cheatwinter = 0;
		cheatmitsler = 0;
	}

	@Override
	public void keyReleased(KeyEvent arg0){}

	@Override
	public void keyTyped(KeyEvent arg0){}
	
}
