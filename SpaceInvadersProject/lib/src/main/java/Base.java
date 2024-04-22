

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;

import javax.sound.sampled.Clip;

public class Base extends Ship{
	public enum Direction {LEFT, RIGHT}
	private Image image;
	private Clip sound;
	
	public Base(int x, int y){
		super(x, y);
		image = getImage("img_base.gif");
		sound = getSound("aud_basefire.wav");
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
	public Missile fireMissile() {
		var missile = new Missile( getX() + 20, getY() );
		playSound();
		return missile;
	}
	
	public void playSound() {
		sound.setFramePosition(0);
		sound.start();
	}
}
