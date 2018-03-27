package mvc.blockus.modele;
import mvc.libInterpreteurExpr.Grille;
import mvc.libInterpreteurExpr.Piece;
import java.util.ArrayList;
import java.util.Observable;

public class BlockusGrille extends Grille {

    /**
     * constructor of the grid
     * @param column : number of columns in the grid
     * @param row : nulber of rows in the grid
     */
    public BlockusGrille(int column , int row) {
        setLargeur(column);
        setHauteur(row);
        setTabCases(new int[row][column]);
        initialiserTabCases();
        initialiserConfigBlockus();
    }

    /**
     * add a piece in the grid
     * @param x : coordinate x
     * @param y : coordinate y
     * @param piece : Piece of the game
     */
    public void addPiece(int x, int y, Piece piece) {
        piece.setX(x);
        piece.setY(y);
        getListPiece().add(piece);
        addInTabCases();
    }

    /**
     * check if there isn't another piece there
     * @param x : coordinate x
     * @param y : coordinate y
     * @param piece : Piece
     * @return boolean
     */
    public boolean collision (int x, int y, BlockusPiece piece){
        for (int[] coords : piece.listCoords()) {
            if (!super.collision(coords[0], coords[1])){
                return false;
            }

        }
        return true;
    }

    /**
     * initialization of the configuration of the game
     */
    private void initialiserConfigBlockus() {
        getListPiece().add(new PieceO(0,0,100));
        getListPiece().add(new PieceO(0,getLargeur()-2,1));
        getListPiece().add(new PieceO(getHauteur()-2,getLargeur()-2,2));
        getListPiece().add(new PieceO(getHauteur()-2,0,3));

    }
    


    /**
     * check if the piece can be there
     * @param newPiece : Piece that we want to add
     * @param piece : Piece of reference
     * @return boolean
     */
    public boolean isAllowed (BlockusPiece newPiece, BlockusPiece piece){
        ArrayList<int[]> listNeighbors = piece.neighborsPlaces();
            for (int[] place : listNeighbors) {
                for (int[] coord : newPiece.listCoords()) {
                    if (place[0] == coord[0] && place[1] == coord[1] && newPiece.getId() == piece.getId()) {
                        return true;
                    }
                }
        }
        return false;
    }

    /**
     * check if it's forbidden to put the piece there
     * @param newPiece : Piece we want to add
     * @param piece ! Piece of reference
oo     * @return boolean
     */
    public boolean isForbidden (BlockusPiece newPiece, BlockusPiece piece){
        ArrayList<int[]> listForbidden = piece.forbiddenPlaces();
        for (int [] place : listForbidden) {
            for (int [] coord : newPiece.listCoords()) {
                if (place[0] == coord[0] && place[1] == coord[1]){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean possibilities ( BlockusPiece newPiece, int id){
        for (Piece p : getListPiece()) {
            if (p.getId() == id){
                for (int i = 0; i < tabCases.length ; i++) {
                    for (int j = 0; j <tabCases.length ; j++) {
                        if (isAllowed(newPiece, (BlockusPiece) p)){
                            return true;
                        }
                    }

                }
            }

        }
        return false;
    }

    

    @Override
    public void addInTabCases() {
        for (Piece piece : getListPiece()) {
            for (int i = 0; i < getTabCases().length; i++) {
                for (int j = 0; j < getTabCases().length; j++) {
                    if (piece.isInclude(i, j)){
                        getTabCases()[i][j] = piece.getId();
                    }
                }

            }
        }
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
