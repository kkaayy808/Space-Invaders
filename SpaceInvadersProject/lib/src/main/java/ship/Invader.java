package ship;

import java.awt.Graphics2D;

public abstract class Invader extends Ship{
	protected int points;
	public Invader(int x, int y) {
		super(x, y);
	}
	
	public int getPoints() {
		return points;
	}
	
	public void hit() {
		playSound("aud_hit.wav");
	}
	
	public abstract void draw(Graphics2D g2);
}
