package mvc.model;

public class PieceO extends Piece{

    public PieceO() {
        identifiant = 2;
        tabPiece = new int[][] {
                {0,0,0,0},
                {0, identifiant, identifiant,0},
                {0, identifiant, identifiant,0},
                {0,0,0,0}
        };
    }

    @Override
    public void rotation() {}
}
