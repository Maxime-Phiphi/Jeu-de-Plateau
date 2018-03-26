//package mvc.blockus.modele;
//
//public class PieceS extends Piece{
//
//    public PieceS() {
//    	identifiant = 7;
//    	int id = identifiant;
//
//    	tabPiece = new int[][]{
//    		{0,0,0},
//    		{0,id,id},
//    		{id,id,0}
//    		};
//
//    	centreGrav = new int[] {1,1};
//    }
//
//	@Override
//	public void rotation() {
//		int id = this.getIdentifiant();
//		switch(etat) {
//		case 1:
//	    	tabPiece = new int[][]{
//	    		{0,id,0},
//	    		{0,id,id},
//	    		{0,0,id}
//	    		};
//	    	etat++;
//			//if rotation pas possible break
//			//else case ++ et rotation
//			break;
//		case 2:
//	    	tabPiece = new int[][]{
//	    		{0,0,0},
//	    		{0,id,id},
//	    		{id,id,0}
//	    		};
//	    		etat++;
//			break;
//		case 3:
//	    	tabPiece = new int[][]{
//	    		{0,id,0},
//	    		{0,id,id},
//	    		{0,0,id}
//	    		};
//	    	etat++;
//			break;
//		case 4:
//	    	tabPiece = new int[][]{
//	    		{0,0,0},
//	    		{0,id,id},
//	    		{id,id,0}
//	    		};
//	    		etat=1;
//			break;
//		}
//
//	}
//
//}
