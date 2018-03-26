//package mvc.blockus.modele;
//
//import mvc.libInterpreteurExpr.Piece;
//
//public class PieceZ extends BlockusPiece{
//
//    public PieceZ() {
//    	identifiant = 6;
//    	int id = identifiant;
//
//    	tabPiece = new int[][]{
//    		{0,0,0},
//    		{id,id,0},
//    		{0,id,id}
//    		};
//
//    	centreGrav = new int[] {1,1};
//    }
//
//	public void rotation() {
//		int id = this.getIdentifiant();
//		switch(etat) {
//		case 1:
//	    	tabPiece = new int[][]{
//	    		{0,0,id},
//	    		{0,id,id},
//	    		{0,id,0}
//	    		};
//	    	etat++;
//			//if rotation pas possible break
//			//else case ++ et rotation
//			break;
//		case 2:
//	    	tabPiece = new int[][]{
//	    		{0,0,0},
//	    		{id,id,0},
//	    		{0,id,id}
//	    		};
//	    		etat++;
//			break;
//		case 3:
//	    	tabPiece = new int[][]{
//	    		{0,0,id},
//	    		{0,id,id},
//	    		{0,id,0}
//	    		};
//	    	etat++;
//			break;
//		case 4:
//	    	tabPiece = new int[][]{
//	    		{0,0,0},
//	    		{id,id,0},
//	    		{0,id,id}
//	    		};
//	    		etat=1;
//			break;
//		}
//
//	}
//
//
//    @Override
//    public boolean isInclude(int x, int y) {
//        return false;
//    }
//
//    @Override
//    public void avancer() {
//
//    }
//
//    @Override
//    public void reculer() {
//
//    }
//}
