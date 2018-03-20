package mvc.libInterpreteurExpr;

import mvc.rushHour.modele.RushPiece;

import java.util.ArrayList;

public abstract class Grille {
    private int largeur;
    private int hauteur;
    private int[][] tabCases;
    private ArrayList<Piece> listPiece = new ArrayList<>();

    public abstract void addPiece();

    public boolean isOccupied(int x, int y) {
        if (tabCases[x][y] != 0){
            return true;
        }
        else {
            return false;
        }
    }


    public void initialiserTabCases() {
        for(int i=0;i<largeur;i++) {
            for(int j=0;j<hauteur;j++) {
                tabCases[j][i]=0;
            }
        }
    }

//    public void updateGrille() {
//        setChanged();
//        notifyObservers();
//    }
//
//    public void changeCase(int x, int y, int n) {
//        tabCases[x][y]=n;
//        updateGrille();
//    }

    public int getCase(int x, int y) {
        return tabCases[x][y];
    }


    public boolean isEmpty(int x, int y) {
        if(tabCases[x][y]!=0) return false;
        return true;
    }
}
