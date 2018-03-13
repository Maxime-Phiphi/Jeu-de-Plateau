package mvc.model;


import java.util.Observable;
import java.util.Random;


public class Grille extends Observable{

	private int largeur;
	private int hauteur;
	private int[][] tabCases;  

	public Grille(int h, int l) {
		this.largeur = l; 
		this.hauteur = h;
		tabCases = new int[h][l];
		initialiserTabCases();
	}

	public void initialiserTabCases() {
		for(int i=0;i<largeur;i++) {
			for(int j=0;j<hauteur;j++) {
				tabCases[j][i]=0;
			}
		}
	}

	public void updateGrille() {
		setChanged();
		notifyObservers();
	}

	public void changeCase(int x, int y, int n) {
		tabCases[x][y]=n;
		updateGrille();
	}

	public int getCase(int x, int y) {
		return tabCases[x][y];
	}


	public boolean isEmpty(int x, int y) {
		if(tabCases[x][y]!=0) return false; 
		return true; 
	}

	public Piece generatePiece(){
		Random r = new Random();
		int identifiant = r.nextInt()% (7 + 1);
		switch (identifiant){
			case 1 :
				Piece pieceI = new PieceI();
				return pieceI;
            case 2 :
				Piece pieceO = new PieceO();
				return pieceO;
			case 3 :
				Piece pieceT = new PieceT();
				return pieceT;
			case 4 :
				Piece pieceL = new PieceL();
				return pieceL;
			case 5 :
				Piece pieceJ = new PieceJ();
				return pieceJ;
			case 6 :
				Piece pieceZ = new PieceZ();
				return pieceZ;
			case 7 :
				Piece pieceS = new PieceS();
				return pieceS;
			default:
				return new PieceI();
		}
	}

	public void mouvement(Piece piece) {

	}

}
