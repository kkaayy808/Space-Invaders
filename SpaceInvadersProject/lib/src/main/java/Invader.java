

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class Invader extends Ship{
	protected int points;
	protected Image a;
	protected Image b;
	protected boolean alternate = false;
	protected boolean moveRight = true;
	
	public Invader(int x, int y) {
		super(x, y);
	}
	
	public int getPoints() {
		return points;
	}
	
	public abstract void draw(Graphics2D g2);
	
	protected void loadImages(String nameA, String nameB) {
		ImageIcon iiA = new ImageIcon(getClass().getResource(nameA));
        a = iiA.getImage();

        ImageIcon iiB = new ImageIcon(getClass().getResource(nameB));
        b = iiB.getImage();
	}
	
	protected Image getCurrentImage() {
		return alternate ? b : a;
	}
	
	protected void toggleImage() {
		alternate = !alternate;
	}
	
	protected void moveHorizontally() {
        if (moveRight) {
            setX(getX() + 1); //right
        } else {
            setX(getX() - 1); //left
        }
    }
	
	protected void reverseDirection() {
        moveRight = !moveRight;
    }
	
	protected void moveDown(int amount) {
        setY(getY() + amount);
    }
	
	protected boolean hitsSide(int panelWidth) {
        return getX() <= 0 || getX() >= panelWidth - 5;
    }
	
	protected void move() {
	    int panelWidth = 500;
	    if (hitsSide(panelWidth)) {
	        reverseDirection();
	        moveDown(10);
	    } else {
	        moveHorizontally(); 
	    }
	}
}
