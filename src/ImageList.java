import java.awt.Image;
import javax.imageio.ImageIO;


public enum ImageList
{
	HEAD_LEFT("/images/snake_head_left.png"),
	HEAD_UP("/images/snake_head_up.png"),
	HEAD_RIGHT("/images/snake_head_right.png"),
	HEAD_DOWN("/images/snake_head_down.png"),
	
	BODY_UP_LEFT("/images/snake_body_up_left.png"),
	BODY_UP_RIGHT("/images/snake_body_up_right.png"),
	BODY_DOWN_LEFT("/images/snake_body_down_left.png"),
	BODY_DOWN_RIGHT("/images/snake_body_down_right.png"),
	
	BODY_HORIZONTAL("/images/snake_body_horizontal.png"),
	BODY_VERTICAL("/images/snake_body_vertical.png"),
	
	TAIL_LEFT("/images/snake_tail_left.png"),
	TAIL_UP("/images/snake_tail_up.png"),
	TAIL_RIGHT("/images/snake_tail_right.png"),
	TAIL_DOWN("/images/snake_tail_down.png"),
	
	APPLE("/images/apple.png"),
	BANANA("/images/banana.png"),
	MELON("/images/melon.png"),
	LEMON("/images/lemon.png"),
	PEAR("/images/pear.png"),
	CHERRY("/images/cherry.png"),
	
	BACKGROUND("/images/background.png"), 
	GAMEOVER("/images/gameover.png"), 
	MENU("/images/menu.png"), 
	BACKGROUND2("/images/background2.png");
	
	private Image image;
	
	private ImageList(String path)
	{
		try 
		{
			this.image = ImageIO.read(this.getClass().getResourceAsStream(path));
			System.out.println("Image " + path + " chargée.");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("Erreur avec l'image " + path);
		}
	}
	
	public Image getImage() 
	{
		return image;
	}
}
