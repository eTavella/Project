package scacchi.pieces;

import scacchi.utils.Colore;
import scacchi.utils.Name;
import scacchi.utils.Position;

public class Rook extends Piece {
	/**
	 * 
	 * Costruttore della torre
	 * 
	 * @param colore
	 */
	public Rook(Colore colore) {
		super(Name.ROOK, colore);
	}

	/**
	 * 
	 * @param piecePosition la posizione della pedina
	 * @param board la scacchiera
	 * @return le mosse possibili della Torre
	 */
	public int[][] possibleMoves(Position piecePosition, Piece[][] board) {
		int[][] mosse = new int[8][8];
		int k;

		for (k = piecePosition.getColumn() + 1; k < columnNumber; k++) {
			if (board[piecePosition.getRow()][k] == null)
				mosse[piecePosition.getRow()][k] = 1;
			else {
				if (board[piecePosition.getRow()][k].getColore() != this
						.getColore())
					mosse[piecePosition.getRow()][k] = 2;
				break;
			}
		}
		for (k = piecePosition.getColumn() - 1; k >= 0; k--) {
			if (board[piecePosition.getRow()][k] == null)
				mosse[piecePosition.getRow()][k] = 1;
			else {
				if (board[piecePosition.getRow()][k].getColore() != this
						.getColore())
					mosse[piecePosition.getRow()][k] = 2;
				break;
			}
		}

	
		for (k = piecePosition.getRow() + 1; k < rowNumber; k++) {
			if (board[k][piecePosition.getColumn()] == null)
				mosse[k][piecePosition.getColumn()] = 1;
			else {
				if (board[k][piecePosition.getColumn()].getColore() != this
						.getColore())
					mosse[k][piecePosition.getColumn()] = 2;
				break;
			}
		}
		for (k = piecePosition.getRow() - 1; k >= 0; k--) {
			if (board[k][piecePosition.getColumn()] == null)
				mosse[k][piecePosition.getColumn()] = 1;
			else {
				if (board[k][piecePosition.getColumn()].getColore() != this
						.getColore())
					mosse[k][piecePosition.getColumn()] = 2;
				break;
			}
		}

		return mosse;
	}

}
