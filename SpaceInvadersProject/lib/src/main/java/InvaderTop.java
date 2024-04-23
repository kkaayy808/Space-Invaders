import java.awt.Graphics2D;

public class InvaderTop extends Invader{

	public InvaderTop(int x, int y) {
		super(x, y);
		points = 30;
		loadImages("img_invadertopA.gif", "img_invadertopB.gif");
	}
	
	@Override
	public void draw(Graphics2D g2) {
		g2.drawImage(getCurrentImage(), getX(), getY(), null);
	}
	
//	public void move() {
//		int panelWidth = 500;
//	    if (hitsSide(panelWidth)) {
//	        reverseDirection();
//	        moveDown(10);
//	    } else {
//	        moveHorizontally(); 
//	    }
//    }

}
