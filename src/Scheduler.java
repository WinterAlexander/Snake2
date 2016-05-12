import java.util.ArrayList;
import java.util.ConcurrentModificationException;


public class Scheduler 
{
	public ArrayList<Task> tasks;
	public ArrayList<Task> corbeille;
	
	public Scheduler()
	{
		this.tasks = new ArrayList<Task>();
		this.corbeille = new ArrayList<Task>();
	}
	
	public void refresh()
	{
		try
		{
			for(Task task : this.tasks)
			{
				if(task.getLastWork() < System.currentTimeMillis() - task.getDelay())
				{
					task.work();
					task.setLastWork(System.currentTimeMillis());
				}
			}
		}
		catch(ConcurrentModificationException e)
		{
			e.printStackTrace();
		}
		this.removeCancelledTasks();
	}
	
	public void cancel(Task task)
	{
		this.corbeille.add(task);
	}
	
	public void cancelAll()
	{
		this.tasks = new ArrayList<Task>();
		this.corbeille = new ArrayList<Task>();
	}
	
	public void addTask(Task task)
	{
		this.tasks.add(task);
	}
	
	private void removeCancelledTasks()
	{
		for(Task task : this.corbeille)
		{
			if(this.tasks.contains(task))
			{
				this.tasks.remove(task);
			}
		}
		
		if(this.corbeille.size() > 0)
			System.out.println(this.corbeille.size() + " erreur(s)");
		
		this.corbeille = new ArrayList<Task>();
	}
}
