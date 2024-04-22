import java.awt.Image;

import javax.sound.sampled.Clip;

public abstract class Ship extends Drawable{
	
	private boolean isHit;
	private Clip hitSound;
	private Image hitShip;

	public Ship(int x, int y) {
		super(x, y);
		hitSound = getSound("aud_hit.wav");
		isHit = false;
	}
	
	public boolean shipHit() {
		return isHit;
	}
	
	public void gotHit() {
		isHit = true;
		hitSound.setFramePosition(0);
		hitSound.start();
	}

}
