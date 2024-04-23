import java.awt.Graphics2D;
import java.awt.Image;

public class Mystery extends Invader{
	 private int speed = 2;
	 private int direction;
	 private int[] possiblePoints = {50, 100, 150, 300};
	 private Image image;
	 
	 public Mystery(int x, int y) {
	        super(x, y);
	        points = getRandomPoints();
	        direction = getRandomDirection();
	        image = getImage("img_mystery.gif");
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
	    	int width = 490; // needs to be udated later
	        setX(getX() + direction * speed);

	        if (getX() <= 0 || getX() >= width) {
	            setX(direction > 0 ? 0 : width);
	            points = getRandomPoints();
	            direction = getRandomDirection();
	        }
	    }
}
