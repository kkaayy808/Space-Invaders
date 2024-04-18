package ship;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SpaceInvaders extends JFrame{
	
	public SpaceInvaders() {
		setTitle("Space Invaders");
		setSize(500, 450);
		add(new JPanel() {
			private Base base;
			{
			setBackground(Color.BLACK);
			base = new Base(0,0);
			}
		});
		var menu = new JMenuBar();
		setJMenuBar(menu);
		
		var game = new JMenu("Game");
		var help = new JMenu("Help");
		
		
		//"Game" menu drop down
		menu.add(game);
		var newGame = game.add("New Game");
		game.addSeparator();
		var pause = game.add("Pause");
		var resume = game.add("Resume");
		game.addSeparator();
		var quit = game.add("Quit");
		
		quit.addActionListener(e -> {
			var result = JOptionPane.showConfirmDialog(SpaceInvaders.this, "Dare to Quit?");
			if(result == JOptionPane.YES_OPTION) {
				dispose();
			}
		});
		
		
		//"Help" menu drop down
		menu.add(help);
		var about = help.add("About...");
		
		about.addActionListener(e -> JOptionPane.showMessageDialog(SpaceInvaders.this, 
				new JLabel("<html><b>SpaceInvaders</b><br>by Josiah Briggs & Kaitlyn Asato<hr><")));
		
		
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		var f = new SpaceInvaders();
		f.setVisible(true);
	}
}
