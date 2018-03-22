package mvc.rushHour.modele;


import mvc.rushHour.modele.RushPiece;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;
import mvc.libInterpreteurExpr.*;


public class RushHourGrille extends Grille{

	private int largeur;
	private int hauteur;
	private int[][] tabCases;
	private ArrayList<RushPiece> listPiece = new ArrayList<RushPiece>();

	public RushHourGrille(int h, int l) {
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



    public boolean gagnePartie() {
		for(RushPiece p: listPiece) {
			if(p.getId()==100) {
				if(p.getY()==4) {
					return true; 
				}
			}
		}
		return false; 
	}


	public RushPiece getPieceAt (int x, int y){

        for (RushPiece piece : listPiece) {
            if (piece.isInclude(x,y)){
                return piece;
            }
        }
       return null;
    }

    public boolean collision(int x, int y) {
        return super.collision(x, y, this.getTabCases());
    }

    public int[][] getTabCases() {
        return tabCases;
    }
}
