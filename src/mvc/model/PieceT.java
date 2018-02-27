package mvc.model;

public class PieceT extends Piece{
    public PieceT() {
        identifiant = 3;
        tabPiece = new int[][]{
                {0, 0, 0},
                {identifiant, identifiant, identifiant},
                {0, identifiant, 0}
        };
    }

    @Override
    public void rotation() {
        switch(etat) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }

    }
}
