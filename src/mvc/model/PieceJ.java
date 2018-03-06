package mvc.model;

public class PieceJ extends Piece {

    public PieceJ(int[][] tabPiece, int identifiant, int[] centreGrav) {
        super(tabPiece, identifiant, centreGrav);
    }

    public PieceJ(){
        identifiant = 5;
        tabPiece = new int [][]{
                {0, 0, 0},
                {identifiant, identifiant, identifiant},
                {0, 0, identifiant}
        };
    }

    @Override
    public void rotation() {
    switch (etat){
        case 1 :
            tabPiece = new int [][]{
                    {0, getIdentifiant(), 0},
                    {0, getIdentifiant(), 0},
                    {getIdentifiant(), getIdentifiant(), 0}
            };
            break;
        case 2 :
            tabPiece = new int [][]{
                    {getIdentifiant(), 0 , 0},
                    {getIdentifiant(), getIdentifiant(), getIdentifiant()},
                    {0, 0, 0}
            };
            break;
        case 3 :
            tabPiece = new int [][]{
                    {0, getIdentifiant(), getIdentifiant()},
                    {0, getIdentifiant(), 0},
                    {0, getIdentifiant(), 0}
            };
            break;
        case 4 :
            tabPiece = new int [][]{
                    {0, 0, 0},
                    {getIdentifiant(), getIdentifiant(), getIdentifiant()},
                    {0, 0, getIdentifiant()}
            };
            break;
    }
    }

}
