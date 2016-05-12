
public abstract class Task 
{
	private long delay;
	private long lastWork;
	public abstract void work();
	
	public Task(long d)
	{
		this.delay = d;
		this.lastWork = 0;
	}
	
	public long getDelay() 
	{
		return delay;
	}
	
	public void setDelay(long d) 
	{
		this.delay = d;
	}
	
	public long getLastWork() 
	{
		return lastWork;
	}
	
	public void setLastWork(long lastWork) 
	{
		this.lastWork = lastWork;
	}
	
}
