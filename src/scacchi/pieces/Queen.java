package scacchi.pieces;

import scacchi.utils.Colore;
import scacchi.utils.Name;
import scacchi.utils.Position;

public class Queen extends Piece {
	/**
	 * 
	 * Costruttore della regina
	 * 
	 * @param colore
	 */
	public Queen(Colore colore) {
		super(Name.QUEEN, colore);
	}

	/**
	 * 
	 * @param piecePosition la posizione della pedina
	 * @param board la scacchiera
	 * @return le mosse possibili della Regina 
	 */
	public int[][] possibleMoves(Position piecePosition, Piece[][] board) {
		int[][] moves = new int[8][8];
		int k;
		int l;

	
		for (k = piecePosition.getColumn() + 1; k < columnNumber; k++) {
			if (board[piecePosition.getRow()][k] == null)
				moves[piecePosition.getRow()][k] = 1;
			else {
				if (board[piecePosition.getRow()][k].getColore() != this
						.getColore())
					moves[piecePosition.getRow()][k] = 2;
				break;
			}
		}
		for (k = piecePosition.getColumn() - 1; k >= 0; k--) {
			if (board[piecePosition.getRow()][k] == null)
				moves[piecePosition.getRow()][k] = 1;
			else {
				if (board[piecePosition.getRow()][k].getColore() != this
						.getColore())
					moves[piecePosition.getRow()][k] = 2;
				break;
			}
		}


		for (k = piecePosition.getRow() + 1; k < rowNumber; k++) {
			if (board[k][piecePosition.getColumn()] == null)
				moves[k][piecePosition.getColumn()] = 1;
			else {
				if (board[k][piecePosition.getColumn()].getColore() != this
						.getColore())
					moves[k][piecePosition.getColumn()] = 2;
				break;
			}
		}
		for (k = piecePosition.getRow() - 1; k >= 0; k--) {
			if (board[k][piecePosition.getColumn()] == null)
				moves[k][piecePosition.getColumn()] = 1;
			else {
				if (board[k][piecePosition.getColumn()].getColore() != this
						.getColore())
					moves[k][piecePosition.getColumn()] = 2;
				break;
			}
		}

		k = piecePosition.getRow() - 1;
		l = piecePosition.getColumn() + 1;
		while (k >= 0 && l < columnNumber) {
			if (board[k][l] == null) {
				moves[k][l] = 1;
				k--;
				l++;
			} else {
				if (board[k][l].getColore() != this.getColore())
					moves[k][l] = 2;
				break;
			}
		}

		k = piecePosition.getRow() - 1;
		l = piecePosition.getColumn() - 1;
		while (k >= 0 && l >= 0) {
			if (board[k][l] == null) {
				moves[k][l] = 1;
				k--;
				l--;
			} else {
				if (board[k][l].getColore() != this.getColore())
					moves[k][l] = 2;
				break;
			}
		}

		k = piecePosition.getRow() + 1;
		l = piecePosition.getColumn() + 1;
		while (k < rowNumber && l < columnNumber) {
			if (board[k][l] == null) {
				moves[k][l] = 1;
				k++;
				l++;
			} else {
				if (board[k][l].getColore() != this.getColore())
					moves[k][l] = 2;
				break;
			}
		}

		k = piecePosition.getRow() + 1;
		l = piecePosition.getColumn() - 1;
		while (k < rowNumber && l >= 0) {
			if (board[k][l] == null) {
				moves[k][l] = 1;
				k++;
				l--;
			} else {
				if (board[k][l].getColore() != this.getColore())
					moves[k][l] = 2;
				break;
			}
		}
		return moves;
	}

}
