

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class Invader extends Ship{
	protected int points;
	protected Image a;
	protected Image b;
	protected Image invaderHit;
	protected boolean alternate = false;
	protected boolean moveRight = true;
	protected int pulseCount; //number of pulses
							  //run by the timer 
	protected double speed; //the desired pace per pulse 
	
	public Invader(int x, int y) {
		super(x, y);
		speed = 40;
		invaderHit = getImage("img_invaderhit.gif");
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
            setX(getX() + 5); //right
        } else {
            setX(getX() - 5); //left
        }
    }
	
	protected void reverseDirection() {
        moveRight = !moveRight;
        speed = speed * 0.8;
    }
	
	protected void moveDown(int amount) {
        setY(getY() + amount);
    }
	
	protected boolean hitsSide(int panelWidth) {
        return getX() <= 0 || getX() >= panelWidth - 35;
    }
	
	protected void move() {
		if (pulseCount >= speed) {
			moveHorizontally();
			toggleImage();
//			int panelWidth = 500;
//		    if (hitsSide(panelWidth)) {
//		        reverseDirection();
//		        moveDown(12);
//		        moveHorizontally();
//		    } else {
//		        moveHorizontally();
//		        toggleImage();
//		    }
		    pulseCount = 0;
		}
//
//		//but the pulseCount code makes the speed of the invaders correct, but messed up the reverseDirection()
//		//it wont bounce off the left wall with the pulse code...idk
		
		++pulseCount;
		
		
//		moveHorizontally();
//		toggleImage();
	}
}
