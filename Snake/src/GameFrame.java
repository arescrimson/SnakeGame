import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class GameFrame extends JFrame implements ActionListener {
	
	JButton resetButton;
	GamePanel game;
	
	GameFrame() { 
		resetButton = new JButton("Reset");
		resetButton.addActionListener(this);
		
		
		
		game = new GamePanel(resetButton); 
		resetButton.setVisible(false);
		this.setLayout(new BorderLayout());
		this.add(game, BorderLayout.CENTER);
		this.add(resetButton, BorderLayout.SOUTH);
		
		this.setFocusable(true);
		this.add(game);
		this.setTitle("SnakeGame");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false); 		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == resetButton) { 
			this.remove(game);
			game = new GamePanel(resetButton);
			game.add(resetButton);
			this.setLayout(new BorderLayout());
			this.add(game, BorderLayout.CENTER);
			this.add(resetButton, BorderLayout.SOUTH);
			SwingUtilities.updateComponentTreeUI(this); 
		}
	}
}