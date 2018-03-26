package mvc.libInterpreteurExpr;
import java.util.ArrayList;
import java.util.Observer;

public abstract class Grille implements Observer {
    /**
     * field largeur : width of the grid
     */
    private int largeur;

    /**
     * field hauteur : height of the grid
     */
    private int hauteur;

    /**
     * field tabCases : representation of the pieces on the grid filled by ids
     */
    protected int[][] tabCases;

    /**
     * field listPiece : list of pieces
     */
    private ArrayList<Piece> listPiece = new ArrayList<>();

    /**
     * fill the tabCases with listPiece
     */
    public abstract void addInTabCases();

    /**
     * Check if the target case is empty
     * @param x : coordinate x
     * @param y : coordinate y
     * @return Boolean
     */
    public boolean collision(int x, int y) {
        return tabCases[x][y] == 0;
    }

    /**
     * fill tabCases with zeros
     */
    protected void initialiserTabCases() {
        for(int i=0;i<largeur;i++) {
            for(int j=0;j<hauteur;j++) {
                tabCases[j][i]=0;
            }
        }
    }

    public Piece getPieceAt (int x, int y){

        for (Piece piece : getListPiece()) {
            if (piece.isInclude(x,y)){
                return piece;
            }
        }
        return null;
    }

    //TODO A supprimer !!!
    public void printGrille(){
        for (int i = 0; i < getLargeur() ; i++){
            for (int j = 0; j < getHauteur(); j++) {
                System.out.print(getTabCases()[i][j] + " ");
            }
            System.out.print("\n");
        }
    }



    //getters setters
    public int[][] getTabCases() {
        return tabCases;
    }

    protected void setTabCases(int[][] tabCases) {
        this.tabCases = tabCases;
    }

    protected int getLargeur() {
        return largeur;
    }

    protected void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    protected int getHauteur() {
        return hauteur;
    }

    protected void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public ArrayList<Piece> getListPiece() {
        return listPiece;
    }
}
