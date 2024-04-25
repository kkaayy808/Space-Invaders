

//import static java.awt.Frame.base;
import java.util.Random;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
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
	private int scoreAmt = 0;
	private JLabel score;
	private JLabel gameOver;
		
	public Panel() {		
		setPreferredSize(new Dimension(500, 400));
		setBackground(Color.BLACK);
		
		setLayout(new BorderLayout());
		
		gameOver = new JLabel("Game Over");
    	gameOver.setForeground(Color.GREEN);
    	gameOver.setHorizontalAlignment(SwingConstants.CENTER);
    	add(gameOver, BorderLayout.CENTER);
    	gameOver.setVisible(false);
		
		base = new Base(225,350);
		topInvaders = new ArrayList<>();
        middleInvaders = new ArrayList<>();
        bottomInvaders = new ArrayList<>();
        initializeInvaders();
        mysteryShip = new Mystery(0, 50); //???
		
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
			scoreBoard();
			for (Missile missile : invaderMissiles) {
			    missile.move();
			    if (missile.getY() > 400) {
			        invaderMissiles.remove(missile);
			    }
			}
			fireInvaderMissiles();
			
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
        	if(missile != null && missile.getX() >= invader.getX() && missile.getX() <= invader.getX() + 35) {
        		if(missile.getY() >= invader.getY() && missile.getY() <= invader.getY() + 35) {
        			invader.setX(-invader.getX()* 10);
        			invader.setY(-invader.getY() * 10);
        			missile = null;
        			invader.gotHit();
        			scoreAmt += invader.getPoints();
        			scoreBoard();
        		}
        	}
            if(invader.hitsSide(500)) {
            	for(InvaderTop eachInvader : topInvaders) {
            		eachInvader.reverseDirection();
            		eachInvader.moveDown(12);
                	eachInvader.moveHorizontally();
            	}
            }
            if(invader.getY() >= 370) {
            	gameOver.setVisible(true);
            	timer.stop();
            }
            else {
            	invader.move();
            }
        }
        //middle invaders
        for (InvaderMiddle invader : middleInvaders) {
        	if(missile != null && missile.getX() >= invader.getX() && missile.getX() <= invader.getX() + 35) {
        		if(missile.getY() >= invader.getY() && missile.getY() <= invader.getY() + 35) {
        			invader.setX(-invader.getX()* 10);
        			invader.setY(-invader.getY() * 10);
        			missile = null;
        			invader.gotHit();
        			scoreAmt += invader.getPoints();
        			scoreBoard();
        		}
        	}
            if(invader.hitsSide(500)) {
            	for(InvaderMiddle eachInvader : middleInvaders) {
            		eachInvader.reverseDirection();
            		eachInvader.moveDown(12);
                	eachInvader.moveHorizontally();
            	}
            }
            if(invader.getY() >= 370) {
            	gameOver.setVisible(true);
            	timer.stop();
            }
            else {
            	invader.move();
            }
        }
        //bottom invaders
        for (InvaderBottom invader : bottomInvaders) {
        	if(missile != null && missile.getX() >= invader.getX() && missile.getX() <= invader.getX() + 35) {
        		if(missile.getY() >= invader.getY() && missile.getY() <= invader.getY() + 35) {
        			missile = null;
        			invader.gotHit();
        			scoreAmt += invader.getPoints();
        			scoreBoard();
        			invader.setX(-invader.getX() * 10);
        			invader.setY(-invader.getY() * 10);
        		}
        	}
            if(invader.hitsSide(500)) {
            	for(InvaderBottom eachInvader : bottomInvaders) {
            		eachInvader.reverseDirection();
            		eachInvader.moveDown(12);
                	eachInvader.moveHorizontally();
            	}
            }
            if(invader.getY() >= 370) {
            	gameOver.setVisible(true);
            	timer.stop();
            }
            else {
            	invader.move();;
            }
        }
        //mystery ship
        
        
        if(missile != null && missile.getX() >= mysteryShip.getX() && missile.getX() <= mysteryShip.getX() + 35) {
    		if(missile.getY() >= mysteryShip.getY() && missile.getY() <= mysteryShip.getY() + 35) {
    			mysteryShip.setX(-mysteryShip.getX() * 10);
    			missile = null;
    			mysteryShip.gotHit();
    			scoreAmt += mysteryShip.getPoints();
    			scoreBoard();
    		}
    	}
        else {
        	mysteryShip.move();;
        }
        
    }
	
	private void scoreBoard() {
		
		if(score == null) {
			score = new JLabel("score: " + scoreAmt);
			score.setForeground(Color.GREEN);
			score.setHorizontalAlignment(SwingConstants.RIGHT);
			add(score, BorderLayout.NORTH);
		}
		else {
			score.setText("score: " + scoreAmt);
		}
		
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
		for (Missile missile : invaderMissiles) {
		    missile.draw(g2);
		}
	}
	
	private ArrayList<Missile> invaderMissiles = new ArrayList<>();

	private void fireInvaderMissiles() {
	    Random random = new Random();
	    for (Invader invader : topInvaders) {
	        // Random chance to fire a missile
	        if (random.nextInt(5000) < 1) { 
	            int invaderX = invader.getX() + 20; 
	            int invaderY = invader.getY() + 35; 
	            invaderMissiles.add(new Missile(invaderX, invaderY)); 
	        }
	    }
	    for (Invader invader : middleInvaders) {
	        if (random.nextInt(5000) < 1) {
	            int invaderX = invader.getX() + 20;
	            int invaderY = invader.getY() + 35;
	            invaderMissiles.add(new Missile(invaderX, invaderY));
	        }
	    }
	    for (Invader invader : bottomInvaders) {
	        if (random.nextInt(5000) < 1) { 
	            int invaderX = invader.getX() + 20;
	            int invaderY = invader.getY() + 35;
	            invaderMissiles.add(new Missile(invaderX, invaderY));
	        }
	    }
	}

	
	public void restartGame() {
		timer.stop();
		base.reset();
		topInvaders.clear();
		bottomInvaders.clear();
		middleInvaders.clear();
		initializeInvaders();
		scoreAmt = 0;
		gameOver.setVisible(false);
		timer.start();
		repaint();
		
		
	}
	
}
