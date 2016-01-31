package scacchi.core;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import scacchi.pieces.Bishop;
import scacchi.pieces.Knight;
import scacchi.pieces.Queen;
import scacchi.pieces.Rook;
import scacchi.utils.Board;
import scacchi.utils.Colore;
import scacchi.utils.Position;

/**
 * Classe che crea un frame e i pannelli di selezione per la promozione di una pedina
 * 
 * @author Edoardo Tavella
 *
 */
public class PieceFrame extends JFrame {

	private ImageIcon whiteQueen = new ImageIcon(this.getClass().getResource("\\immagini\\whiteQueen.png"));
	private ImageIcon whiteBishop = new ImageIcon(this.getClass().getResource("\\immagini\\whiteBishop.png"));
	private ImageIcon whiteRook = new ImageIcon(this.getClass().getResource("\\immagini\\whiteRook.png"));
	private ImageIcon whiteKnight = new ImageIcon(this.getClass().getResource("\\immagini\\whiteKnight.png"));

	private ImageIcon blackQueen = new ImageIcon(this.getClass().getResource("\\immagini\\blackQueen.png"));
	private ImageIcon blackBishop = new ImageIcon(this.getClass().getResource("\\immagini\\blackBishop.png"));
	private ImageIcon blackRook = new ImageIcon(this.getClass().getResource("\\immagini\\blackRook.png"));
	private ImageIcon blackKnight = new ImageIcon(this.getClass().getResource("\\immagini\\blackKnight.png"));

	private JButton queen = new JButton();
	private JButton bishop = new JButton();
	private JButton rook = new JButton();
	private JButton knight = new JButton();
	private JPanel northPanel = new JPanel();
	private JPanel southPanel = new JPanel();
	private static final long serialVersionUID = 1L;

	/**
	 * Sostituisce il pedone in base alla selezione
	 *  
	 * @param turn
	 * @param board
	 * @param pos
	 * @param boardPanel
	 */
	public PieceFrame(Colore turn, Board board, Position pos,
			BoardPanel boardPanel) {
		super("Promozione pedone");

		queen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				board.setBoard(pos, new Queen(turn));
				boardPanel.repaint();
				dispose();
			}
		});
		bishop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				board.setBoard(pos, new Bishop(turn));
				boardPanel.repaint();
				dispose();
			}
		});
		rook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				board.setBoard(pos, new Rook(turn));
				boardPanel.repaint();
				dispose();
			}
		});
		knight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				board.setBoard(pos, new Knight(turn));
				boardPanel.repaint();
				dispose();
			}
		});

		queen.setName("regina");
		bishop.setName("alfiere");
		rook.setName("torre");
		knight.setName("cavallo");

		southPanel.setLayout(new GridLayout(2, 2));

		JLabel etichetta = new JLabel();
		etichetta.setText("Scegli la pedina");
		etichetta.setFont(new Font("Thaoma", Font.BOLD, 16));

		northPanel.add(etichetta);

		setColore(turn);

		add(northPanel, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}

	/**
	 * Mostra le pedine tra cui scegliere
	 * 
	 * @param colore
	 */
	public void setColore(Colore colore) {

		southPanel.setLayout(new GridLayout(2, 2));
		if (colore.equals(Colore.NERO)) {
			bishop.setIcon(blackBishop);
			knight.setIcon(blackKnight);
			queen.setIcon(blackQueen);
			rook.setIcon(blackRook);
		} else {
			bishop.setIcon(whiteBishop);
			knight.setIcon(whiteKnight);
			queen.setIcon(whiteQueen);
			rook.setIcon(whiteRook);
		}

		southPanel.add(bishop);
		southPanel.add(knight);
		southPanel.add(queen);
		southPanel.add(rook);

		add(southPanel, BorderLayout.SOUTH);
		revalidate();
	}
}