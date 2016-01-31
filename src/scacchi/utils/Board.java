package scacchi.utils;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import scacchi.core.BoardPanel;
import scacchi.core.Controller;
import scacchi.core.PieceFrame;
import scacchi.pieces.Bishop;
import scacchi.pieces.King;
import scacchi.pieces.Knight;
import scacchi.pieces.Pawn;
import scacchi.pieces.Piece;
import scacchi.pieces.Queen;
import scacchi.pieces.Rook;

public class Board {

	private Piece[][] board;
	private Colore turn = Colore.BIANCO;
	Controller controller;

	/**
	 * Costruttore della scacchiera
	 * 
	 */
	public Board() {
		
			restart();
	}

	public Piece[][] getBoard() {
		return board;
	}

	/**
	 * Metodo che setta la pedina p nella posizione pos della scacchiera usato
	 * per la promozione del pedone
	 * 
	 * @param pos la posizione
	 * @param piece la pedina
	 */
	public void setBoard(Position pos, Piece piece) {
		board[pos.getRow()][pos.getColumn()] = piece;
	}

/**
 * 
 * @param pos la posizione
 * @return la pedina
 */
	public Piece getPedina(Position pos) {
		return board[pos.getRow()][pos.getColumn()];
	}

	/**
	 * @param pos
	 *            la posizione della pedina da muovere
	 * @return una matrice di interi dove sono indicate le posizioni possibili;
	 *       	0= posizione non valida
	 *       	1= posizione valida
	 *       	2= posizione valida e mangia una pedina
	 */
	public int[][] getMoves(Position pos) {
		if (board[pos.getRow()][pos.getColumn()].getColore().equals(turn)) {
			int[][] moves = board[pos.getRow()][pos.getColumn()].possibleMoves(pos, board);
			return moves;
		} else
			return new int[8][8];
	}

	/**
	 * Metodo che ritorna le mosse possibili
	 * 
	 * @param pos la posizione della pedina
	 * 
	 * @return ArrayList con le mosse possibili della pedina
	 */
	public ArrayList<Position> getMovesArrayList(Position pos) {
		ArrayList<Position> mosse = new ArrayList<Position>();
		if (board[pos.getRow()][pos.getColumn()].getColore().equals(turn)) {
			int[][] moves = board[pos.getRow()][pos.getColumn()].possibleMoves(pos, board);
			for (int i = 0; i < moves.length; i++)
				for (int j = 0; j < moves[0].length; j++) {
					if (moves[i][j] != 0) {
						mosse.add(new Position(i, j));
					}
				}
		}

		return mosse;
	}

	/**
	 * 
	 * @param startcposizione attuale della pedina
	 * @param end: posizione di arrivo della pedina
	 * @param boardPanel pannello della scacchiera
	 * 
	 * @return true se riesco a muovere, altrimenti vuol dire che c'è scacco
	 */
	public boolean move(Position start, Position end, BoardPanel boardPanel) {

		if (!canMove(start, end)) { 
			JOptionPane.showMessageDialog(null, "Mossa non valida, metterebbe il re sotto scacco!", "Mossa non valida",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (getMoves(start)[end.getRow()][end.getColumn()] == 0) { // mossa non valida
			return false;
		}

		board[end.getRow()][end.getColumn()] = board[start.getRow()][start.getColumn()];
		board[start.getRow()][start.getColumn()] = null;

		// controllo se devo promuovere il pedone
		if (turn == Colore.BIANCO && board[end.getRow()][end.getColumn()] instanceof Pawn
				&& end.getRow() == 0) {
			pawnPromotion(new Position(end.getRow(), end.getColumn()), boardPanel);
			boardPanel.setEnabled(false);
			boardPanel.revalidate();
			boardPanel.repaint();
		}

		if (turn == Colore.NERO && board[end.getRow()][end.getColumn()] instanceof Pawn
				&& end.getRow() == 7) {
			pawnPromotion(new Position(end.getRow(), end.getColumn()), boardPanel);
			boardPanel.setEnabled(false);
			boardPanel.revalidate();
			boardPanel.repaint();
		}

		// cambio turno
		if (turn.equals(Colore.BIANCO))
			turn = Colore.NERO;
		else {
			turn = Colore.BIANCO;
		}

		return true;
	}

	/**
	 * 
	 * @param s La stringa da stampare in una pannello di informazione,
	 *  usato per dare l'avviso dello scacco
	 * 
	 */
	
	
	public static boolean printMessage(String s) {
		JOptionPane.showMessageDialog(null, s, "Scacco", JOptionPane.INFORMATION_MESSAGE);
		return false;
	}

	/**
	 * Verifico che la mossa non metta il proprio re sotto scacco
	 * 
	 * @param start
	 *            la posizione di partenza
	 * @param end
	 *            la posizione di arrivo
	 *            
	 * @return true se posso muovere senza mettere sotto scacco il re
	 */
	public boolean canMove(Position start, Position end) {
		boolean mangiato = false;
		boolean canMove = true;
		Piece piece = null;
		if (board[end.getRow()][end.getColumn()] != null) {
			mangiato = true;
			piece = board[end.getRow()][end.getColumn()];
		}
		board[end.getRow()][end.getColumn()] = board[start.getRow()][start.getColumn()];
		board[start.getRow()][start.getColumn()] = null;


		if (turn == Colore.BIANCO) {
			if (check() == 1)
				canMove = false;
		} else {
			if (check() == -1)
				canMove = false;
		}

	// torno alla situazione precedente
		board[start.getRow()][start.getColumn()] = board[end.getRow()][end.getColumn()];
		board[end.getRow()][end.getColumn()] = null;
		if (mangiato) {
			board[end.getRow()][end.getColumn()] = piece;
		}
		return canMove;
	}

	/**
	 * @return il turno corrente
	 */
	public Colore getTurno() {
		return turn;
	}

	/**
	 * @param pos
	 *            la posizione attuale
	 *            
	 * @param boardPanelper poter fare il repaint
	 */
	public void pawnPromotion(Position pos, BoardPanel boardPanel) {
		PieceFrame fsp = new PieceFrame(turn, this, pos, boardPanel);
		fsp.setVisible(true);
	}

	/**
	 * Controllo se nelle mosse degli avversari è presente la posizione del re
	 * 
	 * @return 1 = re bianco sotto scacco
	 * 		  -1 = re nero sotto scacco
	 *         0 = non c'è scacco
	 */
	public int check() {
	
		Position blackKing = null;
		Position whiteKing = null;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j] != null) {
					if (board[i][j].getName() == Name.KING && board[i][j].getColore() == Colore.BIANCO)
						whiteKing = new Position(i, j); 
					
					else if (board[i][j].getName() == Name.KING && board[i][j].getColore() == Colore.NERO)
						blackKing = new Position(i, j); 
				}
			}
		}

		int[][] mosPos = null;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j] != null) {
					if (board[i][j].getColore() == Colore.NERO) { 
						mosPos = board[i][j].possibleMoves(new Position(i, j), board);
						if (mosPos[whiteKing.getRow()][whiteKing.getColumn()] == 2)
							return 1;
					}
					if (board[i][j].getColore() == Colore.BIANCO) {
						mosPos = board[i][j].possibleMoves(new Position(i, j), board);
						if (mosPos[blackKing.getRow()][blackKing.getColumn()] == 2)
							return -1;
					}
				}
			}
		}

		return 0;
	}

	/**
	 * Funzione chiamata in caso di scacco, verifica se c'è scacco matto
	 * 
	 * @return true se il giocatore del turno corrente è sotto scacco matto
	 */
	public boolean checkmate() {

		Position re = null;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j] != null && board[i][j] instanceof King
						&& board[i][j].getColore() == turn) {
					re = new Position(i, j);
				}
			}
		}

		ArrayList<Position> kingMoves = getMovesArrayList(re);
		for (Position p : kingMoves) {
			if (canMove(re, p))
				return false;
		}

		if (!kingSaving())
			return true;
		else
			return false;
	}

	/**
	 * Metodo per controllare se è possibile o meno, per qualche pedina, salvare il re
	 * 
	 */
	public boolean kingSaving() {
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++) {
				if (board[i][j] != null && board[i][j].getColore().equals(turn)) {
					
					ArrayList<Position> r = getMovesArrayList(new Position(i, j));
					for (Position p : r) {
						if (turn == Colore.BIANCO) {
							if (canMove(new Position(i, j), p) && check() != 1)
								
								return true;
						} else {
							if (canMove(new Position(i, j), p) && check() != -1)
							
								return true;
						}
					}
				}
			}
		return false;
	}

	/**
	 * Metodo per inizializzare la scacchiera
	 * 
	 */
	public void restart() {
		board = new Piece[8][8];
		turn = Colore.BIANCO;

		board[0][0] = new Rook(Colore.NERO);
		board[0][1] = new Knight(Colore.NERO);
		board[0][2] = new Bishop(Colore.NERO);
		board[0][3] = new Queen(Colore.NERO);
		board[0][4] = new King(Colore.NERO);
		board[0][5] = new Bishop(Colore.NERO);
		board[0][6] = new Knight(Colore.NERO);
		board[0][7] = new Rook(Colore.NERO);
		for (int i = 0; i < 8; i++)
			board[1][i] = new Pawn(Colore.NERO);


		board[7][0] = new Rook(Colore.BIANCO);
		board[7][1] = new Knight(Colore.BIANCO);
		board[7][2] = new Bishop(Colore.BIANCO);
		board[7][3] = new Queen(Colore.BIANCO);
		board[7][4] = new King(Colore.BIANCO);
		board[7][5] = new Bishop(Colore.BIANCO);
		board[7][6] = new Knight(Colore.BIANCO);
		board[7][7] = new Rook(Colore.BIANCO);

		for (int i = 0; i < 8; i++)
			board[6][i] = new Pawn(Colore.BIANCO);

	}
}