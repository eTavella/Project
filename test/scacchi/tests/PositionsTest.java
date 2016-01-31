package scacchi.tests;

import org.junit.Assert;
import org.junit.Test;

import scacchi.utils.Board;
import scacchi.utils.Colore;
import scacchi.utils.Name;
import scacchi.utils.Position;

/**
 * Classe di test che verifica alcune posizione sulla scacchiera e alcuni movimenti
 * 
 * @author Edoardo Tavella
 *
 */
public class PositionsTest {

	@Test
	public void testPiecesPosition() {
		Board board = new Board();
		
		Assert.assertTrue(board.getPedina(new Position(0,0)).getName().equals(Name.ROOK)
				&& board.getPedina(new Position(0,0)).getColore().equals(Colore.NERO));
		Assert.assertTrue(board.getPedina(new Position(0,1)).getName().equals(Name.KNIGHT)
				&& board.getPedina(new Position(0,1)).getColore().equals(Colore.NERO));
		Assert.assertTrue(board.getPedina(new Position(0,2)).getName().equals(Name.BISHOP)
				&& board.getPedina(new Position(0,2)).getColore().equals(Colore.NERO));
		Assert.assertTrue(board.getPedina(new Position(0,3)).getName().equals(Name.QUEEN)
				&& board.getPedina(new Position(0,3)).getColore().equals(Colore.NERO));
		Assert.assertTrue(board.getPedina(new Position(0,4)).getName().equals(Name.KING)
				&& board.getPedina(new Position(0,4)).getColore().equals(Colore.NERO));
		Assert.assertTrue(board.getPedina(new Position(0,5)).getName().equals(Name.BISHOP)
				&& board.getPedina(new Position(0,5)).getColore().equals(Colore.NERO));
		Assert.assertTrue(board.getPedina(new Position(0,6)).getName().equals(Name.KNIGHT)
				&& board.getPedina(new Position(0,6)).getColore().equals(Colore.NERO));
		Assert.assertTrue(board.getPedina(new Position(0,7)).getName().equals(Name.ROOK)
				&& board.getPedina(new Position(0,7)).getColore().equals(Colore.NERO));
		
		Assert.assertTrue(board.getPedina(new Position(7,0)).getName().equals(Name.ROOK)
				&& board.getPedina(new Position(7,0)).getColore().equals(Colore.BIANCO));
		Assert.assertTrue(board.getPedina(new Position(7,1)).getName().equals(Name.KNIGHT)
				&& board.getPedina(new Position(7,1)).getColore().equals(Colore.BIANCO));
		Assert.assertTrue(board.getPedina(new Position(7,2)).getName().equals(Name.BISHOP)
				&& board.getPedina(new Position(7,2)).getColore().equals(Colore.BIANCO));
		Assert.assertTrue(board.getPedina(new Position(7,3)).getName().equals(Name.QUEEN)
				&& board.getPedina(new Position(7,3)).getColore().equals(Colore.BIANCO));
		Assert.assertTrue(board.getPedina(new Position(7,4)).getName().equals(Name.KING)
				&& board.getPedina(new Position(7,4)).getColore().equals(Colore.BIANCO));
		Assert.assertTrue(board.getPedina(new Position(7,5)).getName().equals(Name.BISHOP)
				&& board.getPedina(new Position(7,5)).getColore().equals(Colore.BIANCO));
		Assert.assertTrue(board.getPedina(new Position(7,6)).getName().equals(Name.KNIGHT)
				&& board.getPedina(new Position(7,6)).getColore().equals(Colore.BIANCO));
		Assert.assertTrue(board.getPedina(new Position(7,7)).getName().equals(Name.ROOK)
				&& board.getPedina(new Position(7,7)).getColore().equals(Colore.BIANCO));
		
		
		Assert.assertTrue(board.getPedina(new Position(3,3))==null);
		Assert.assertTrue(board.getPedina(new Position(5,7))==null);
	}
	
	
	
	@Test
	public void testTurnMoves() {
		Board board = new Board();
		
		Assert.assertFalse(board.move(new Position(1,4), new Position(2,4), null));
		Assert.assertTrue(board.move(new Position(6,5), new Position(5,5), null));
		Assert.assertFalse(board.move(new Position(6,3), new Position(5, 3), null));
		Assert.assertFalse(board.move(new Position(1,2), new Position(5,2), null));
		Assert.assertTrue(board.move(new Position(1,6), new Position(2,6), null));
	}
	
	

	
	@Test
	public void testPawnMoves() {
		Board board = new Board();
		
		int moves[][]=board.getPedina(new Position(6,3)).possibleMoves(new Position(6,3), board.getBoard());
		Assert.assertTrue(moves[5][3]==1);
		Assert.assertTrue(moves[5][4]==0);
	}
}
