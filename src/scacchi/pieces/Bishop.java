package scacchi.pieces;

import scacchi.utils.Colore;
import scacchi.utils.Name;
import scacchi.utils.Position;

public class Bishop extends Piece {
	/**
	 * 
	 * Costruttore dell'alfiere
	 * 
	 * @param colore
	 */
	public Bishop(Colore colore) {
		super(Name.BISHOP, colore);
	}

	/**
	 * 
	 * @param piecePosition la posizione della pedina
	 * @param board la scacchiera
	 * @return le mosse possibili dell' alfiere
	 */
	public int[][] possibleMoves(Position piecePosition, Piece[][] board) {
		int[][] moves = new int[8][8];
		int row;
		int column;

	
		row = piecePosition.getRow() - 1;
		column = piecePosition.getColumn() + 1;
		while (row >= 0 && column < columnNumber) {
			if (board[row][column] == null) {
				moves[row][column] = 1;
				row--;
				column++;
			} else {
				if (board[row][column].getColore() != this.getColore())
					moves[row][column] = 2;
				break;
			}
		}


		row = piecePosition.getRow() - 1;
		column = piecePosition.getColumn() - 1;
		while (row >= 0 && column >= 0) {
			if (board[row][column] == null) {
				moves[row][column] = 1;
				row--;
				column--;
			} else {
				if (board[row][column].getColore() != this.getColore())
					moves[row][column] = 2;
				break;
			}
		}


		row = piecePosition.getRow() + 1;
		column = piecePosition.getColumn() + 1;
		while (row < rowNumber && column < columnNumber) {
			if (board[row][column] == null) {
				moves[row][column] = 1;
				row++;
				column++;
			} else {
				if (board[row][column].getColore() != this.getColore())
					moves[row][column] = 2;
				break;
			}
		}


		row = piecePosition.getRow() + 1;
		column = piecePosition.getColumn() - 1;
		while (row < rowNumber && column >= 0) {
			if (board[row][column] == null) {
				moves[row][column] = 1;
				row++;
				column--;
			} else {
				if (board[row][column].getColore() != this.getColore())
					moves[row][column] = 2;
				break;
			}
		}

		return moves;
	}

}
