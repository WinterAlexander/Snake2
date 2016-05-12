import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class Snake 
{
	private int score;
	private HighScoreLoader highScore;
	private JLabel label;
	private JPanel panel;
	public ArrayList<SnakePart> snakebody;
	public Fruit fruit;
	private Direction originalDirection;
	public boolean lost;
	public boolean cheatwinter;
	public boolean cheatmitsler;

	public Snake()
	{
		this.cheatwinter = false;
		this.cheatmitsler = false;
		this.highScore = new HighScoreLoader();
		this.panel = new SnakePanel();
		
		this.label = new JLabel("Score: " + this.score + " Highscore: " + this.highScore);
		this.label.setFont(new Font("Arial", 0, 24));
		this.label.setHorizontalAlignment(JLabel.CENTER);
		
		Main.panel.setLayout(new BorderLayout());
		Main.panel.add(this.label, BorderLayout.NORTH);
		Main.panel.add(this.panel, BorderLayout.CENTER);
		
		this.snakebody = new ArrayList<SnakePart>();
		
		int snakeX = new Random().nextInt(40);
		for(int i = 0; i < 5; i++)
		{
			this.snakebody.add(new SnakePart(snakeX, 25 + i, Direction.UP));
		}

		boolean isInContactWithTheSnake;
		do
		{
			isInContactWithTheSnake = false;
			this.fruit = new Fruit();
			
			for(SnakePart part : this.snakebody)
			{
				if(this.fruit.getPosX() == part.getPosX() && this.fruit.getPosY() == part.getPosY())
				{
					isInContactWithTheSnake = true;
				}
			}
			
		}while(isInContactWithTheSnake);
		
		Main.scheduler.addTask(new Move(100));
	}

	public int getScore() 
	{
		return score;
	}

	public void addScore(int addition) 
	{
		this.score += addition;
	}
	
	public void move()
	{
		for(int i = this.snakebody.size() - 1; i >= 0; i--)
		{
			if(i == 0)
			{
				SnakePart part = this.snakebody.get(i);
				switch(this.snakebody.get(0).getDirection())
				{
				case LEFT:
					part.setPosX(part.getPosX() - 1);
					this.snakebody.set(i, part);
					break;
					
				case UP:
					part.setPosY(part.getPosY() - 1);
					this.snakebody.set(i, part);
					break;
					
				case RIGHT:
					part.setPosX(part.getPosX() + 1);
					this.snakebody.set(i, part);
					break;
					
				case DOWN:
					part.setPosY(part.getPosY() + 1);
					this.snakebody.set(i, part);
					break;
				}
			}
			else
			{
				this.snakebody.get(i).setPosX(this.snakebody.get(i - 1).getPosX());
				this.snakebody.get(i).setPosY(this.snakebody.get(i - 1).getPosY());
				this.snakebody.get(i).setDirection(this.snakebody.get(i - 1).getDirection());
			}
		}
		this.originalDirection = this.snakebody.get(0).getDirection();
		
		if(this.snakebody.get(0).getPosX() >= 40
		|| this.snakebody.get(0).getPosX() < 0
		|| this.snakebody.get(0).getPosY() >= 30
		|| this.snakebody.get(0).getPosY() < 0)
		{
			this.lose();
			Main.clavier.resetCheat();
		}
		else
		{
			for(SnakePart part : this.snakebody)
			{
				if(this.snakebody.get(0).getPosX() == part.getPosX() && this.snakebody.get(0).getPosY() == part.getPosY())
				{
					if(this.snakebody.indexOf(part) != 0)
					{
						this.lose();
						break;
					}
				}
			}
		}
		
		
	}
	
	private void lose() 
	{
		if(!this.cheatwinter)
		{
			Main.scheduler.cancelAll();
			
			if(this.score > this.highScore.getHighScore())
				this.highScore.setScore(this.score);
			
			this.lost = true;
		}
	}

	public Direction getOriginalDirection() 
	{
		return originalDirection;
	}

	public static class Move extends Task
	{
		public Move(long d) 
		{
			super(d);
		}

		@Override
		public void work() 
		{
			Main.snake.move();
			if(Main.snake.snakebody.get(0).getPosX() == Main.snake.fruit.getPosX()
			&& Main.snake.snakebody.get(0).getPosY() == Main.snake.fruit.getPosY())
			{
				Main.snake.addScore(Main.snake.fruit.getScore());
				Main.snake.addSnakes(4);
				
				boolean isInContactWithTheSnake;
				do
				{
					isInContactWithTheSnake = false;
					Main.snake.fruit.reset();
					this.setDelay((long)(this.getDelay() / 1.01));
					for(SnakePart part : Main.snake.snakebody)
					{
						if(Main.snake.fruit.getPosX() == part.getPosX() && Main.snake.fruit.getPosY() == part.getPosY())
						{
							isInContactWithTheSnake = true;
						}
					}
					
				}while(isInContactWithTheSnake);
			}
			Main.frame.repaint();
			if(Main.snake.score < Main.snake.highScore.getHighScore())
				Main.snake.label.setText("Score: " + Main.snake.getScore() + " Highscore: " + Main.snake.highScore.getHighScore());
			else
				Main.snake.label.setText("Score: " + Main.snake.getScore() + " Highscore: " + Main.snake.score);
		}
		
	}

	public void addSnakes(int i) 
	{
		for(int a = 0; a < i; a++)
			this.snakebody.add(new SnakePart(this.snakebody.get(this.snakebody.size() - 1).getPosX(), this.snakebody.get(this.snakebody.size() - 1).getPosY(), this.snakebody.get(this.snakebody.size() - 1).getDirection()));
	}
}
