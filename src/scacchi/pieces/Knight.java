package scacchi.pieces;

import java.util.ArrayList;

import scacchi.utils.Colore;
import scacchi.utils.Name;
import scacchi.utils.Position;

public class Knight extends Piece {

	/**
	 * 
	 * Costruttore del cavallo
	 * 
	 * @param colore
	 */
	public Knight(Colore colore) {
		super(Name.KNIGHT, colore);
	}

	/**
	 * 
	 * @param piecePosition la posizione della pedina
	 * @param board la scacchiera
	 * @return le mosse possibili del Cavallo 
	 */
	public int[][] possibleMoves(Position piecePosition, Piece[][] board) {

		ArrayList<Position> positions = new ArrayList<Position>();
		int[][] mosse = new int[8][8];

		positions.add(new Position(piecePosition.getRow() - 1, piecePosition
				.getColumn() - 2));
		positions.add(new Position(piecePosition.getRow() + 1, piecePosition
				.getColumn() - 2));
		positions.add(new Position(piecePosition.getRow() - 1, piecePosition
				.getColumn() + 2));
		positions.add(new Position(piecePosition.getRow() + 1, piecePosition
				.getColumn() + 2));

		positions.add(new Position(piecePosition.getRow() - 2, piecePosition
				.getColumn() - 1));
		positions.add(new Position(piecePosition.getRow() - 2, piecePosition
				.getColumn() + 1));
		positions.add(new Position(piecePosition.getRow() + 2, piecePosition
				.getColumn() - 1));
		positions.add(new Position(piecePosition.getRow() + 2, piecePosition
				.getColumn() + 1));

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
			if (board[p.getRow()][p.getColumn()] == null)
				mosse[p.getRow()][p.getColumn()] = 1;
			else {
				if (board[p.getRow()][p.getColumn()].getColore() != this
						.getColore())
					mosse[p.getRow()][p.getColumn()] = 2;
			}

		return mosse;
	}

}