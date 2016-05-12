


public class SnakePart 
{
	private Direction direction;
	private int posX;
	private int posY;
	
	public SnakePart(int posX, int posY, Direction direction)
	{
		this.setDirection(direction);
		this.setPosX(posX);
		this.setPosY(posY);
	}

	public Direction getDirection() 
	{
		return direction;
	}

	public void setDirection(Direction direction) 
	{
		this.direction = direction;
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
}
