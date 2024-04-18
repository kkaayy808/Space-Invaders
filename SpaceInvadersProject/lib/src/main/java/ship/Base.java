package ship;

import java.awt.Graphics2D;
import java.awt.Image;

public class Base extends Ship{
	public enum Direction {LEFT, RIGHT}
	private Image image;
	public Base(int x, int y) {
		super(x, y);
		image = getImage( "img_base.gif" );
	}
	@Override
	public void draw(Graphics2D g2) {
		g2.drawImage( image, getX(), getY(), null );
	}
	public void move(Direction direction) {
		var x = getX();
		switch (direction) {
		case LEFT  -> setX( x - 10 );
		case RIGHT -> setX( x + 10 );
		}
	}
	public Missile fireTorpedo() {
		var missile = new Missile( getX() + 20, getY() );
		missile.playSound();
		return missile;
	}
}
