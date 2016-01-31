package scacchi.pieces;

import java.util.ArrayList;

import scacchi.utils.Colore;
import scacchi.utils.Name;
import scacchi.utils.Position;

public class King extends Piece {
	/**
	 * 
	 * Costruttore del Re
	 * 
	 * @param colore
	 */
	public King(Colore colore) {
		super(Name.KING, colore);

	}

	/**
	 * 
	 * @param piecePosition la posizione della pedina
	 * @param board la scacchiera
	 * @return le mosse possibili del re
	 */
	public int[][] possibleMoves(Position piecePosition, Piece[][] board) {
		ArrayList<Position> positions = new ArrayList<Position>();
		int[][] moves = new int[8][8];

		positions.add(new Position(piecePosition.getRow() + 1, piecePosition
				.getColumn())); 
		positions.add(new Position(piecePosition.getRow() - 1, piecePosition
				.getColumn())); 

		positions.add(new Position(piecePosition.getRow(),
				piecePosition.getColumn() + 1)); 
		positions.add(new Position(piecePosition.getRow(),
				piecePosition.getColumn() - 1)); 

		positions.add(new Position(piecePosition.getRow() + 1, piecePosition
				.getColumn() + 1));
		positions.add(new Position(piecePosition.getRow() - 1, piecePosition
				.getColumn() + 1));

		positions.add(new Position(piecePosition.getRow() + 1, piecePosition
				.getColumn() - 1));
		positions.add(new Position(piecePosition.getRow() - 1, piecePosition
				.getColumn() - 1)); 

		// controllo che le mosse stiano dentro la scacchiera
		boolean controllo;
		do {
			controllo = false;
			for (int i = 0; i < positions.size(); i++) {
				Position pos = positions.get(i);
				if (pos.getRow() < 0 || pos.getColumn() < 0
						|| pos.getRow() >= rowNumber
						|| pos.getColumn() >= columnNumber) {
					controllo = true;
					positions.remove(pos);
				}
			}
		} while (controllo);
		for (Position p : positions)
			if (board[p.getRow()][p.getColumn()] == null) {
				moves[p.getRow()][p.getColumn()] = 1;
			} else {
				if (board[p.getRow()][p.getColumn()].getColore() != this
						.getColore())
					moves[p.getRow()][p.getColumn()] = 2;
			}

		return moves;

	}

}