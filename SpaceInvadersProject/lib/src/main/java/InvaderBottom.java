import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

public class InvaderBottom extends Invader{

	public InvaderBottom(int x, int y) {
		super(x, y);
		points = 10;
		loadImages("img_invaderbottomA.gif", "img_invaderbottomB.gif");
    }
	
	@Override 
	public void draw(Graphics2D g2) {
		 Image currentImage = getCurrentImage();
		 g2.drawImage(getCurrentImage(), getX(), getY(), null);
	}
	
	public void move() {
		int panelWidth = 500;
	    if (hitsSide(panelWidth)) {
	        reverseDirection();
	        moveDown(10);
	    } else {
	        moveHorizontally(); 
	    }
    }
}
