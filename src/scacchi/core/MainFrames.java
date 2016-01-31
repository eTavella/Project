package scacchi.core;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Classe Main
 * 
 * @author Edoardo Tavella
 *
 */
public class MainFrames {

	public static void main(String[] args) {
		

	      JPanel panel = new JPanel();
	      panel.add(new JLabel("Vuoi iniziare una partita a scacchi?"),BorderLayout.EAST);
	      int choice = JOptionPane.showConfirmDialog(null, panel, "Progetto scacchi Univr", JOptionPane.OK_OPTION);
	      if (choice == JOptionPane.OK_OPTION) {
	    	  FrameBase b = new FrameBase();
	    	  b.setVisible(true);
	      }
	}

}
