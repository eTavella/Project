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
		Board scacchiera = new Board();
		
		Assert.assertTrue(scacchiera.getPedina(new Position(0,5)).getName().equals(Name.BISHOP)
				&& scacchiera.getPedina(new Position(0,6)).getColore().equals(Colore.NERO));
		
		Assert.assertTrue(scacchiera.getPedina(new Position(7,3)).getName().equals(Name.QUEEN)
				&& scacchiera.getPedina(new Position(7,0)).getColore().equals(Colore.BIANCO));
		
		Assert.assertTrue(scacchiera.getPedina(new Position(3,3))==null);
	}
	
	
	
	@Test
	public void testMove() {
		Board scacchiera = new Board();
		
		Assert.assertFalse(scacchiera.move(new Position(1,4), new Position(2,4), null));
		Assert.assertTrue(scacchiera.move(new Position(6,5), new Position(5,5), null));
		Assert.assertFalse(scacchiera.move(new Position(1,2), new Position(5,2), null));
		Assert.assertTrue(scacchiera.move(new Position(1,6), new Position(2,6), null));
	}
	
	

}
