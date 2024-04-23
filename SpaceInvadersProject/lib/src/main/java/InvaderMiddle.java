import java.awt.Color;
import java.awt.Graphics2D;

public class InvaderMiddle extends Invader{

	public InvaderMiddle(int x, int y) {
		super(x, y);
		points = 20;
		loadImages("img_invadermiddleA.gif", "img_invadermiddleB.gif");
	}
	
	@Override
    public void draw(Graphics2D g2) {
		g2.drawImage(getCurrentImage(), getX(), getY(), null);
    }
	
	public void move() {
        moveHorizontally();
    }
}
