package ship;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.sound.sampled.Clip;

public class Missile extends Drawable{
		private Image image;
		private Clip  sound;
		
		public Missile(int x, int y) {
			super( x, y );
			image = getImage( "photon.png" ); // wrong image
			sound = getSound( "aud_basefire.wav" );
		}
		@Override
		public void draw(Graphics2D g2) {
			g2.drawImage( image, getX(), getY(), 50, 50, null );
		}
		public void move() {
			setY( getY() - 8 );
		}
		public void playSound() {
			sound.setFramePosition(0);
			sound.start();
		}
	}
}
