

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class SpaceInvaders extends JFrame{
    
	public SpaceInvaders(){
		setTitle("Space Invaders");
		setSize(500, 450);
		//adds the Jpanel for the game
		add(new Panel() {
		});
		
		var menu = new JMenuBar();
		setJMenuBar(menu);
		
		var game = new JMenu("Game");
		var help = new JMenu("Help");
		
		
		//"Game" menu drop down
		menu.add(game);
		var newGame = game.add("New Game");
		
		newGame.addActionListener(e -> {
			 Panel gamePanel = (Panel) getContentPane().getComponent(0); //this does not work :(((
			 gamePanel.restartGame();
		});
		
		game.addSeparator();
		var pause = game.add("Pause");
		
		pause.addActionListener(e -> {
			Panel.timer.stop();
		});
		
		var resume = game.add("Resume");
		
		resume.addActionListener(e -> {
			Panel.timer.start();
		});
		
		game.addSeparator();
		var quit = game.add("Quit");
		
		quit.addActionListener(e -> {
			var result = JOptionPane.showConfirmDialog(SpaceInvaders.this, "Dare to Quit?");
			if(result == JOptionPane.YES_OPTION) {
				Panel.timer.stop();
				dispose();
			}
			
			
		});
		
		
		//"Help" menu drop down
		menu.add(help);
		var about = help.add("About...");
		
		about.addActionListener(e -> JOptionPane.showMessageDialog(SpaceInvaders.this, 
				new JLabel("<html><b>SpaceInvaders</b><br>by Josiah Briggs & Kaitlyn Asato<hr><")));
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Panel.timer.stop();
			}
		});
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args){
		var f = new SpaceInvaders();
		f.setVisible(true);
	}
}
