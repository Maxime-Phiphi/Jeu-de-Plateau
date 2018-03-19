package mvc.model;


import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;


public class Grille extends Observable{

	private int largeur;
	private int hauteur;
	private int[][] tabCases;
	private ArrayList<RushPiece> listPiece = new ArrayList<RushPiece>();

	public Grille(int h, int l) {
		this.largeur = l; 
		this.hauteur = h;
		tabCases = new int[h][l];
		initialiserConfigRushHour();
		initialiserTabCases();
		addPiece();
	}
	
	public void initialiserConfigRushHour() {
		RushPiece v1 = new RushPiece("V", 1, 0, 0, 'H');
		listPiece.add(v1);
		RushPiece vR = new RushPiece("V", 100, 1, 2, 'H');
		listPiece.add(vR);
		RushPiece v2 = new RushPiece("V", 2, 4, 4, 'H');
		listPiece.add(v2);
		RushPiece v3 = new RushPiece("V", 3, 0, 4, 'V');
		listPiece.add(v3);
		RushPiece c4 = new RushPiece("C", 4, 0, 1, 'V');
		listPiece.add(c4);
		RushPiece c5 = new RushPiece("C", 5, 3, 1, 'V');
		listPiece.add(c5);
		RushPiece c6 = new RushPiece("C", 6, 5, 0, 'V');
		listPiece.add(c6);
		RushPiece c7 = new RushPiece("C", 6, 2, 5, 'H');
		listPiece.add(c7);
	}
	
	public void addPiece() {
		for(RushPiece p : listPiece) {
			if(p.getSens()=='V') {
				tabCases[p.getX()][p.getY()]=p.getId();
				tabCases[p.getX()+1][p.getY()]=p.getId();
				if(p.getType()=="C") {
					tabCases[p.getX()+2][p.getY()]=p.getId();
				}
			}else {
				tabCases[p.getX()][p.getY()]=p.getId();
				tabCases[p.getX()][p.getY()+1]=p.getId();
				if(p.getType()=="C") {
					tabCases[p.getX()][p.getY()+2]=p.getId();
				
				
			}
		}
	}
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
	public void avancer(RushPiece piece, int n){

		if (piece.getSens() =='H'){
			int x =piece.getX();
			piece.setX(x+n);
		}
		else{
		    int y = piece.getY();
		    piece.setY(y+n);
        }
	}

    public void reculer(RushPiece piece, int n){
        if (piece.getSens() =='H'){
            int x =piece.getX();
            piece.setX(x-n);
        }
        else{
            int y = piece.getY();
            piece.setY(y-n);
        }
    }

    public RushPiece getPieceAt (int x, int y){

        for (RushPiece piece : listPiece) {
            if (piece.isInclude(x,y)){
                return piece;
            }
        }
       return null;
    }
}
