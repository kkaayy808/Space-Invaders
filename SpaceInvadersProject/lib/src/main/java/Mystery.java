import java.awt.Graphics2D;
import java.awt.Image;

import javax.sound.sampled.Clip;

public class Mystery extends Invader{
	 private int speed = 5;
	 private int direction;
	 private int[] possiblePoints = {50, 100, 150, 300};
	 private Image image;
	 private Clip mysterySound;
	 private int pulseCnt;
	 
	 public Mystery(int x, int y) {
	        super(x, y);
	        points = getRandomPoints();
	        direction = getRandomDirection();
	        image = getImage("img_mystery.gif");
	        mysterySound = getSound("aud_mystery.wav");
	        pulseCnt = 0;
	    }

	 @Override
	    public void draw(Graphics2D g2) {
		 	g2.drawImage(image, getX(), getY(), null); 
	        move();
	    }

	    private int getRandomPoints() {
	        return possiblePoints[(int) (Math.random() * possiblePoints.length)];
	    }

	    private int getRandomDirection() {
	        return (Math.random() < 0.5) ? -1 : 1; 
	    }
	    
	    public void move() {
	    	
	    	if(pulseCnt % 2 == 0) {
	    		int width = 490; // needs to be updated later
		        setX(getX() + direction * speed);

		        if (getX() <= 0 || getX() >= width) {
		            setX(direction > 0 ? 0 : width);
		            points = getRandomPoints();
		            direction = getRandomDirection();
		        }
	    	}
	    	
//	    	int width = 490; // needs to be updated later
//	        setX(getX() + direction * speed);
//
//	        if (getX() <= 0 || getX() >= width) {
//	            setX(direction > 0 ? 0 : width);
//	            points = getRandomPoints();
//	            direction = getRandomDirection();
//	        }
	        
	        if (pulseCnt == 0) {
	        	playSound();
	        }
	        
	        ++pulseCnt;
	        
	        if(pulseCnt == 185) {
	        	pulseCnt = 0;
	        }
	        
	       
	        
	    }
	    
	    public void playSound() {
			mysterySound.setFramePosition(0);
			mysterySound.start();
		}
}
