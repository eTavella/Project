package scacchi.pieces;

import scacchi.utils.Colore;
import scacchi.utils.Name;
import scacchi.utils.Position;

public class Pawn extends Piece {
	/**
	 * 
	 * Costruttore del pedone
	 * 
	 * @param colore
	 */
	public Pawn(Colore colore) {
		super(Name.PAWN, colore);
	}

	/**
	 * 
	 * @param piecePosition la posizione della pedina
	 * @param board la scacchiera
	 * @return le mosse possibili del Pedone
	 */
	public int[][] possibleMoves(Position piecePosition, Piece[][] board) {
		int[][] mosse = new int[8][8];

		if (this.getColore() == Colore.NERO) {

			// mossa normale
			if (((piecePosition.getRow() + 1) < rowNumber)
					&& (board[piecePosition.getRow() + 1][piecePosition
							.getColumn()] == null))
				mosse[piecePosition.getRow() + 1][piecePosition.getColumn()] = 1;

			// mangia
			
			if (((piecePosition.getRow() + 1) < rowNumber)
					&& ((piecePosition.getColumn() - 1) >= 0)
					&& (board[piecePosition.getRow() + 1][piecePosition
							.getColumn() - 1] != null))
				if (board[piecePosition.getRow() + 1][piecePosition.getColumn() - 1]
						.getColore() != this.getColore())
					mosse[piecePosition.getRow() + 1][piecePosition.getColumn() - 1] = 2;

			
			if (((piecePosition.getRow() + 1) < rowNumber)
					&& ((piecePosition.getColumn() + 1) < columnNumber)
					&& (board[piecePosition.getRow() + 1][piecePosition
							.getColumn() + 1] != null))
				if (board[piecePosition.getRow() + 1][piecePosition.getColumn() + 1]
						.getColore() != this.getColore())
					mosse[piecePosition.getRow() + 1][piecePosition.getColumn() + 1] = 2;

		} else { 

			// mossa normale
			if (((piecePosition.getRow() - 1) >= 0)
					&& (board[piecePosition.getRow() - 1][piecePosition
							.getColumn()] == null))
				mosse[piecePosition.getRow() - 1][piecePosition.getColumn()] = 1;

			// -mangia
			if (((piecePosition.getRow() - 1) >= 0)
					&& ((piecePosition.getColumn() - 1) >= 0)
					&& (board[piecePosition.getRow() - 1][piecePosition
							.getColumn() - 1] != null))
				if (board[piecePosition.getRow() - 1][piecePosition.getColumn() - 1]
						.getColore() != this.getColore())
					mosse[piecePosition.getRow() - 1][piecePosition.getColumn() - 1] = 2;

		
			if (((piecePosition.getRow() - 1) >= 0)
					&& ((piecePosition.getColumn() + 1) < columnNumber)
					&& (board[piecePosition.getRow() - 1][piecePosition
							.getColumn() + 1] != null))
				if (board[piecePosition.getRow() - 1][piecePosition.getColumn() + 1]
						.getColore() != this.getColore())
					mosse[piecePosition.getRow() - 1][piecePosition.getColumn() + 1] = 2;

		}
		return mosse;
	}

}
