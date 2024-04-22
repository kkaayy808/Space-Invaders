


public abstract class Ship extends Drawable{
	public enum Direction { UP, DOWN, LEFT, RIGHT }
	public Ship(int x, int y) {
		super( x, y );
	}
	public void move(Direction direction) {
		var x = getX();
		var y = getY();
		switch (direction) {
		case UP    -> setY( y - 15 );
		case DOWN  -> setY( y + 15 );
		case LEFT  -> setX( x - 15 );
		case RIGHT -> setX( x + 15 );
		}
	}
	public Missile fireTorpedo() {
		var missile = new Missile( getX() + 20, getY() );
		missile.playSound();
		return missile;
	}

}
