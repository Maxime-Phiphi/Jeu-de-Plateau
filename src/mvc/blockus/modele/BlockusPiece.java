package mvc.blockus.modele;

import mvc.libInterpreteurExpr.Piece;

import java.util.ArrayList;

public abstract class BlockusPiece extends Piece{

    protected int[][] tabPiece;


    public abstract void rotation();

    public abstract ArrayList<int[]> listCoords();

    public abstract ArrayList<int []> neighborsPlaces();

    public abstract ArrayList<int []> forbiddenPlaces();



}
