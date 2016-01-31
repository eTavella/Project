package scacchi.core;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import scacchi.utils.Board;

/**
 * Classe che crea il pannello e lo inserisce in un frame
 * 
 * @author Edoardo Tavella
 *
 */
public class FrameBase extends JFrame {
	private static final long serialVersionUID = 1L;

	public FrameBase() {
		JMenuBar menuBar = new JMenuBar();
		JMenu optionsMenu = new JMenu("Options");
		menuBar.add(optionsMenu);
		setJMenuBar(menuBar);
		JMenuItem restart = new JMenuItem("Restart");
		optionsMenu.add(restart);

		Board board = new Board();
		BoardPanel boardPanel = new BoardPanel(board);
		setTitle("Progetto scacchi Univr");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		new Controller(boardPanel, board);
		setLayout(new GridLayout(1, 0));
		setResizable(false);
		add(boardPanel);
		setVisible(true);
		pack();
		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int confirm = JOptionPane.showConfirmDialog(null, "Sicuro di voler iniziare una nuova partita?",
						"Nuova partita", JOptionPane.YES_NO_OPTION);
				if (confirm == 0) { // 0 = l'utente ha cliccato si: inizia una nuova partita
					board.restart();
					boardPanel.repaint();
				}
			}
		});

	}

}

