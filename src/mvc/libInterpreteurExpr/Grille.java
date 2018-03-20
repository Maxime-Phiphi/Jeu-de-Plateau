package mvc.libInterpreteurExpr;
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



    public  boolean collision (Piece currentpiece, int x, int y, int row, int column){
        int xmax =0;
        int ymax =0;
        int xmin =0;
        int ymin =0;
        // on avance
        for (int i = x; i < row ; i++) {
            do {
                 ymax = i;
            }
            while ( !isOccupied(i,y) || currentpiece.isInclude(x, y));
        }

        for (int j = y; j < column ; j++) {
            do{
                 xmax = j;
            }
            while ( !isOccupied(x, j)|| currentpiece.isInclude(x, y));
        }
        //on recule
        for (int i = x; i >= 0 ; i--) {
            do {
                  ymin = i;
            }
            while ( !isOccupied(i,y) || currentpiece.isInclude(x, y));
        }
        for (int j = y; j >= 0 ; j--) {
            do{
                 xmin = j;
            }
            while ( !isOccupied(x, j)|| currentpiece.isInclude(x, y));
        }
        if (y > ymax || y < ymin){
            return false;
        }
        else if (x > xmax || x < xmin){
            return false;
        }

        return true;
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
