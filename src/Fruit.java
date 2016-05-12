import java.awt.Image;
import java.util.Random;


public class Fruit 
{
	private int posX;
	private int posY;
	private Image img;
	private int score;
	
	public Fruit()
	{
		this.reset();
	}
	
	public int getPosX() 
	{
		return posX;
	}
	public void setPosX(int posX) 
	{
		this.posX = posX;
	}
	public int getPosY() 
	{
		return posY;
	}
	public void setPosY(int posY) 
	{
		this.posY = posY;
	}
	
	public void reset()
	{
		this.posX = new Random().nextInt(40);
		this.posY = new Random().nextInt(30);
		int i = new Random().nextInt(100);
		if(i >= 0 && i < 35)
		{
			this.img = ImageList.APPLE.getImage();
			this.score = 5;
		}
		else if(i >= 35 && i < 60)
		{
			this.img = ImageList.BANANA.getImage();
			this.score = 10;
		}
		else if(i >= 60 && i < 80)
		{
			this.img = ImageList.MELON.getImage();
			this.score = 15;
		}
		else if(i >= 80 && i < 90)
		{
			this.img = ImageList.LEMON.getImage();
			this.score = 20;
		}
		else if(i >= 90 && i < 98)
		{
			this.img = ImageList.PEAR.getImage();
			this.score = 25;
		}
		else if(i >= 98 && i < 100)
		{
			this.img = ImageList.CHERRY.getImage();
			this.score = 50;
		}
	}

	public Image getImage() 
	{
		return this.img;
	}

	public int getScore() 
	{
		return this.score;
	}
}
