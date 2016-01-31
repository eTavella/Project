package scacchi.utils;

public class Position {
	
	private int row;
	private int column;

	public Position(int riga, int colonna) {
		this.row = riga;
		this.column = colonna;
	}
	
	/**
	 * 
	 * @return il numero della riga
	 */
	public int getRow(){
		return row;
	}
	/**
	 * 
	 * @return il numero della colonna
	 */
	public int getColumn(){
		return column;
	}
	
}
