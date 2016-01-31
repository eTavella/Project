package scacchi.core;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

import scacchi.pieces.Piece;
import scacchi.utils.Board;
import scacchi.utils.Colore;
import scacchi.utils.Position;

/**
 * Classe che imposta il pannello della scacchiera
 * 
 * @author Edoardo Tavella
 *
 */
public class BoardPanel extends JComponent {
	
	private Image whiteKing = new ImageIcon(this.getClass().getResource("\\images\\whiteKing.png")).getImage();
	private Image whiteQueen = new ImageIcon(this.getClass().getResource("\\images\\whiteQueen.png")).getImage();
	private Image whiteBishop = new ImageIcon(this.getClass().getResource("\\images\\whiteBishop.png")).getImage();
	private Image whiteRook = new ImageIcon(this.getClass().getResource("\\images\\whiteRook.png")).getImage();
	private Image whiteKnight = new ImageIcon(this.getClass().getResource("\\images\\whiteKnight.png")).getImage();
	private Image whitePawn = new ImageIcon(this.getClass().getResource("\\images\\whitePawn.png")).getImage();
	
	private Image blackKing = new ImageIcon(this.getClass().getResource("\\images\\blackKing.png")).getImage();
	private Image blackQueen = new ImageIcon(this.getClass().getResource("\\images\\blackQueen.png")).getImage();
	private Image blackBishop = new ImageIcon(this.getClass().getResource("\\images\\blackBishop.png")).getImage();
	private Image blackRook = new ImageIcon(this.getClass().getResource("\\images\\blackRook.png")).getImage();
	private Image blackKnight = new ImageIcon(this.getClass().getResource("\\images\\blackKnight.png")).getImage();
	private Image blackPawn = new ImageIcon(this.getClass().getResource("\\images\\blackPawn.png")).getImage();
	
	private Image redTile = new ImageIcon(this.getClass().getResource("\\images\\redSquare.png")).getImage();
	private Image greenTile = new ImageIcon(this.getClass().getResource("\\images\\greenSquare.png")).getImage();

	private Image chessBoard= new ImageIcon(this.getClass().getResource("\\images\\board.png")).getImage();
	
	int high[][];
	boolean highlighted;
	Board board;
	Position oldPos;
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Imposta le caselle da evidenziare
	 * 
	 * @param toHighlight array contenente le caselle da evidenziare
	 * @param highlight true per evidenziare, false per non evidenziare
	 */
	public void setHighlight(int toHighlight[][], boolean highlight){
		this.high=toHighlight;this.highlighted=highlight;
	}
	
	/**
	 * @return array con la posizione delle caselle evidenziate
	 */
	public int[][] getHighlated(){
		return this.high;
	}
	
	/**
	 * Costruttore del pannello scacchiera
	 * 
	 * @param board la scacchiera
	 */
	public BoardPanel(Board board) {
		this.board = board;	
		Dimension dimension=new Dimension(400,400);
		setSize(dimension);
		setPreferredSize(dimension);
		setMaximumSize(dimension);
		setMinimumSize(dimension);
		setLayout(null);
		
	}

	public void paintComponent(Graphics g) {
		g.drawImage(chessBoard, 0, 0, 400, 400, null);
		
		if (highlighted) {

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					switch (high[i][j]) {
					case 1:
						g.drawImage(greenTile, j * 50, i * 50, null);
						break;
					case 2:
						g.drawImage(redTile, j * 50, i * 50, null);
						break;
					default:
					}
				}
			}
		}

// stampo le pedine
		printPieces(g);
	}

	

	/**
	 * metodo che stampa le pedine
	 * 
	 * @param g graphics del pannello
	 */
	private void printPieces(Graphics g) {
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Piece p = board.getPedina(new Position(i, j));
				int x1 = j * 50;
				int y1 = i * 50;

				if (p != null && p.getColore().equals(Colore.BIANCO)) {//
					switch (p.getName()) {
					case KING:
						g.drawImage(whiteKing, x1, y1, null);
						break;
					case QUEEN:
						g.drawImage(whiteQueen, x1, y1, null);
						break;
					case BISHOP:
						g.drawImage(whiteBishop, x1, y1, null);
						break;
					case ROOK:
						g.drawImage(whiteRook, x1, y1, null);
						break;
					case KNIGHT:
						g.drawImage(whiteKnight, x1, y1, null);
						break;
					case PAWN:
						g.drawImage(whitePawn, x1, y1, 50, 50, null);
						break;
					}
				}
				else{
					if (p != null && p.getColore().equals(Colore.NERO)) {
						switch (p.getName()) {
						case KING:
							g.drawImage(blackKing, x1, y1, null);
							break;
						case QUEEN:
							g.drawImage(blackQueen, x1, y1, null);
							break;
						case BISHOP:
							g.drawImage(blackBishop, x1, y1, null);
							break;
						case ROOK:
							g.drawImage(blackRook, x1, y1, null);
							break;
						case KNIGHT:
							g.drawImage(blackKnight, x1, y1, 50, 50, null);
							break;
						case PAWN:
							g.drawImage(blackPawn, x1, y1, 50, 50, null);
							break;
						}
					}
				}
			}
		}

	}

}
