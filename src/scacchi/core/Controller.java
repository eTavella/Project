package scacchi.core;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import scacchi.utils.Board;
import scacchi.utils.Colore;
import scacchi.utils.Position;

/**
 * Classe controller
 * 
 * @author Edoardo Tavella
 *
 */
public class Controller {

	boolean highlight = false;
	Position oldPos;

	/**
	 * 
	 * @param boardPanel
	 *           boardPanel il pannello della scacchiera
	 * @param board
	 *            memorizza lo stato corrente della scacchiera
	 */
	public Controller(BoardPanel boardPanel, Board board) {

		boardPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
		
				int colonna = e.getX();
				int riga = e.getY();
				// passaggio da coordinate in pixel a numero di riga e colonna
				// (da 0 a 7)
				colonna /= 50;
				riga /= 50;

				if (!highlight) {

					// casella vuota
					if (board.getBoard()[riga][colonna] == null) {
						return;
					}

					// selezione pedina da muovere
					highlight = true;
					oldPos = new Position(riga, colonna); 
					boardPanel.setHighlight(board.getMoves(new Position(riga, colonna)), highlight);
					boardPanel.repaint();
				} else { 

					// se la posizione è permessa
					if (boardPanel.getHighlated()[riga][colonna] != 0) {

					
						board.move(oldPos, new Position(riga, colonna), boardPanel);

						//cambio turno quindi cancello le caselle evidenziate
						boardPanel.setHighlight(new int[8][8], highlight);
						boardPanel.repaint();
						highlight = false;
					} else { // posizione non permessa
						if (board.getBoard()[riga][colonna] != null
								&& board.getBoard()[riga][colonna].getColore()
										.equals(board.getTurno())) {
							highlight = true;
							oldPos = new Position(riga, colonna);
							boardPanel.setHighlight(board.getMoves(new Position(riga, colonna)), highlight);
							boardPanel.repaint();
						} else { // mossa non valida
							boardPanel.repaint();
						}
					}

					int check = board.check();
					boolean checkmate = false; 
					if (check != 0) {
						checkmate = board.checkmate();
						scacchi.utils.Board.printMessage("Scacco al Re " + board.getTurno().toString().toLowerCase());
					}
					if (check != 0 && checkmate) {
						Colore turn;
	
						if (board.getTurno().equals(Colore.BIANCO))
							turn = Colore.NERO;
						else {
							turn = Colore.BIANCO;
						}
						int confirm = JOptionPane.showConfirmDialog(null,
								"Complimenti giocatore " + turn.toString().toLowerCase()
										+ " hai vinto!\nVuoi cominciare una nuova partita?",
								"Scacco Matto", JOptionPane.YES_NO_OPTION);

						if (confirm == 0) {
							board.restart();
							boardPanel.repaint();
						} else {
							System.exit(0);
						}
					}

				}

			}
		});

	}
}
