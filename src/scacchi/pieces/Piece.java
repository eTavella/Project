package scacchi.pieces;

import scacchi.utils.Colore;
import scacchi.utils.Name;
import scacchi.utils.Position;

public abstract class Piece {

	private final Name name;
	private final Colore colore;

	protected static int rowNumber = 8;
	protected static int columnNumber = 8;

	/**
	 * 
	 * Costruttore delle pedine
	 * 
	 * @param name
	 * @param colore
	 */
	public Piece(Name name, Colore colore) {
		this.name = name;
		this.colore = colore;
	}

	/**
	 * 
	 * @return il nome della pedina
	 */
	public Name getName() {
		return this.name;
	}

	/**
	 * 
	 * @return il colore della pedina
	 */
	public Colore getColore() {
		return this.colore;
	}

	/**
	 * 
	 * @param posPedina
	 * @param board
	 * @return array multidimensionale che indica le mosse possibili della pedina
	 * 0 se NON si può muovere
	 * 1 se può muoversi
	 * 2 se può mangiare
	 */
	public abstract int[][] possibleMoves(Position posPedina,
			Piece[][] board);
}
