

//import static java.awt.Frame.base;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Panel extends JPanel{
	
	
	private boolean right;
	private boolean left;
	private Base base;
	public static Timer timer;
		
	public Panel() {
		
		
		
		setPreferredSize(new Dimension(500, 400));
		setBackground(Color.BLACK);
		
		base = new Base(225,350);
		
		
		//basic timer
		timer = new Timer(20, e -> {
			if(left) base.move(Base.Direction.LEFT);
			if(right) base.move(Base.Direction.RIGHT);
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
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		base.draw(g2); 
	}
	
	
}
