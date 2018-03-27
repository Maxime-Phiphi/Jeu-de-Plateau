package mvc.blockus.modele;

import mvc.libInterpreteurExpr.Piece;

import java.util.ArrayList;

public abstract class BlockusPiece extends Piece{

    /**
     * field tabPiece : table which contain all the piece
     */
    protected int[][] tabPiece;

    /**
     * rotatation of the Piece
     */
    public abstract void rotation();

    /**
     * return the list of coordinate of a Piece
     * @return ArrayList<int []>
     */
    public abstract ArrayList<int[]> listCoords();

    /**
     * return the coordinate of possible neighbors
     * @return ArrayList<int []>
     */
    public abstract ArrayList<int []> neighborsPlaces();

    /**
     * return the coordinate of forbidden places for the Piece
     * @return ArrayList<int []>
     */
    public abstract ArrayList<int []> forbiddenPlaces();



}
