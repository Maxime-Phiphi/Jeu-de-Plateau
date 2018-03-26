package mvc.blockus.modele;

import mvc.libInterpreteurExpr.Grille;
import mvc.libInterpreteurExpr.Piece;

import java.util.ArrayList;
import java.util.Observable;

public class BlockusGrille extends Grille {

    public BlockusGrille(int column , int row) {
        setLargeur(column);
        setHauteur(row);
        setTabCases(new int[row][column]);
        initialiserTabCases();
        initialiserConfigBlockus();
    }

    public void addPiece(int x, int y, Piece piece) {
        piece.setX(x);
        piece.setY(y);
        getListPiece().add(piece);
        addInTabCases();
    }

    public boolean collision (int x, int y, BlockusPiece piece){
        for (int[] coords : piece.listCoords()) {
            if (!super.collision(coords[0], coords[1])){
                return false;
            }

        }
        return true;
    }

    private void initialiserConfigBlockus() {
        getListPiece().add(new PieceO(0,0,100));
        getListPiece().add(new PieceO(0,getLargeur()-2,1));
        getListPiece().add(new PieceO(getHauteur()-2,getLargeur()-2,2));
        getListPiece().add(new PieceO(getHauteur()-2,0,3));

    }

    public boolean isAllowed (BlockusPiece newPiece, BlockusPiece piece){
        ArrayList<int[]> listNeighbors = piece.neighborsPlaces();
        for (int [] place : listNeighbors) {
            for (int [] coord : newPiece.listCoords()) {
                if (place[0] == coord[0] && place[1] == coord[1] && newPiece.getId() == piece.getId()){
                    return true;
                }
            }
        }
        return false;
    }

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
