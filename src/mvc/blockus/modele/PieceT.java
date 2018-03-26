//package mvc.blockus.modele;
//
//public class PieceT extends Piece{
//
//    public PieceT() {
//        identifiant = 3;
//        tabPiece = new int[][]{
//                {0, 0, 0},
//                {identifiant, identifiant, identifiant},
//                {0, identifiant, 0}
//        };
//    }
//
//    @Override
//    public void rotation() {
//        switch(etat) {
//            case 1:
//                tabPiece = new int [][]{
//                        {0, getIdentifiant(), 0},
//                        {getIdentifiant(), getIdentifiant(), 0},
//                        {0, getIdentifiant(), 0}
//                };
//                break;
//            case 2:
//                tabPiece = new int [][]{
//                        {0, getIdentifiant(), 0},
//                        {getIdentifiant(),getIdentifiant(),getIdentifiant()},
//                        {0, 0, 0}
//                };
//                break;
//            case 3:
//                tabPiece = new int [][]{
//                        {0, getIdentifiant(), 0},
//                        {0, getIdentifiant(),getIdentifiant()},
//                        {0, getIdentifiant(), 0}
//                };
//                break;
//            case 4:
//                tabPiece = new int[][]{
//                        {0, 0, 0},
//                        {identifiant, identifiant, identifiant},
//                        {0, identifiant, 0}
//                };
//                break;
//        }
//
//    }
//}
