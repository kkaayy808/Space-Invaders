

//import static java.awt.Frame.base;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Panel extends JPanel{
	private ArrayList<InvaderTop> topInvaders;
    private ArrayList<InvaderMiddle> middleInvaders;
    private ArrayList<InvaderBottom> bottomInvaders;
    private Mystery mysteryShip;
	private boolean right;
	private boolean left;
	private Base base;
	public static Timer timer;
	private Missile missile;
		
	public Panel() {		
		setPreferredSize(new Dimension(500, 400));
		setBackground(Color.BLACK);
		
		base = new Base(225,350);
		topInvaders = new ArrayList<>();
        middleInvaders = new ArrayList<>();
        bottomInvaders = new ArrayList<>();
        initializeInvaders();
        mysteryShip = new Mystery(0, 0); //???
		
		//basic timer
		timer = new Timer(10, e -> {
			if (missile != null) {
				missile.move();
				if(missile.getY() < -50) {
					missile = null;
				}
		}
			if(left) base.move(Base.Direction.LEFT);
			if(right) base.move(Base.Direction.RIGHT);
			moveInvaders();
			repaint();
		});
		timer.start();
		setFocusable(true);
		
		
		//I think this is what we will use to register hits and stuff not sure yet
		addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch(keyCode) {
				case KeyEvent.VK_LEFT -> left = true;
				case KeyEvent.VK_RIGHT -> right = true;
				case KeyEvent.VK_SPACE -> {
					if (missile == null) {
						missile = base.fireMissile();
						}
					}
				}
            }
            
            @Override
			public void keyReleased(KeyEvent e) {
				var key = e.getKeyCode();
				switch(key) {
				case KeyEvent.VK_LEFT -> left = false;
				case KeyEvent.VK_RIGHT -> right = false;
				}
			}
        });
	}
	
	private void initializeInvaders() {
        //top invaders
        for (int i = 0; i < 10; i++) {
            topInvaders.add(new InvaderTop(35 * i + 75, 80));
        }
        //middle invaders
        for (int i = 0; i < 10; i++) {
            middleInvaders.add(new InvaderMiddle(35 * i + 75, 105));
        }
        for (int i = 0; i < 10; i++) {
            middleInvaders.add(new InvaderMiddle(35 * i + 75, 130));
        }
        //bottom invaders
        for (int i = 0; i < 10; i++) {
            bottomInvaders.add(new InvaderBottom(35 * i + 75, 155));
        }
        for (int i = 0; i < 10; i++) {
            bottomInvaders.add(new InvaderBottom(35 * i + 75, 180));
        }
    }
	
	private void moveInvaders() {
        //top invaders
        for (InvaderTop invader : topInvaders) {
            invader.move();
        }
        //middle invaders
        for (InvaderMiddle invader : middleInvaders) {
            invader.move();
        }
        //bottom invaders
        for (InvaderBottom invader : bottomInvaders) {
            invader.move();
        }
        //mystery ship
        mysteryShip.move();
    }
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		base.draw(g2); 
		//top invaders
        for (InvaderTop invader : topInvaders) {
            invader.draw(g2);
        }
        //middle invaders
        for (InvaderMiddle invader : middleInvaders) {
            invader.draw(g2);
        }
        //bottom invaders
        for (InvaderBottom invader : bottomInvaders) {
            invader.draw(g2);
        }
        //mystery ship
        mysteryShip.draw(g2);
		if(missile != null) {
			missile.draw(g2);
		}
	}
	
	
}
