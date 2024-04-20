package ship;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.sound.sampled.Clip;

public class Missile extends Drawable{
		private static final int Width= 2;
		private static final int Height = 10;
		
		public Missile(int x, int y) {
			super( x, y );
		}
		@Override
		public void draw(Graphics2D g2) {
			g2.setColor(Color.WHITE);
			g2.fillRect(getX(),  getY(),  Width,  Height);
		}
		
		//will have to alter this for missiles fired by the ships
		public void move() {
			setY(getY() - 5);
		}
}
