import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class HighScoreLoader 
{
	private int highScore;
	public HighScoreLoader()
	{
		try 
		{
			File file = new File(System.getenv("APPDATA"), "\\.snake");
			if(file.exists())
			{
				this.highScore = new DataInputStream(new BufferedInputStream(new FileInputStream(file))).readInt();
			}
			else
			{
				file.createNewFile();
				this.highScore = 0;
			}
		}
		catch (Exception e) 
		{
			this.highScore = 0;
			e.printStackTrace(); //erreur interne ne peut pas lire le fichier
		}
	}
	
	public void setScore(int score)
	{
		try 
		{
			DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File(System.getenv("APPDATA"), "\\.snake"))));
			dos.writeInt(score);
			dos.close();
		}
		catch (Exception e) 
		{
			this.highScore = 0;
			e.printStackTrace();
		}
	}
	
	public int getHighScore()
	{
		return highScore;
	}
}
