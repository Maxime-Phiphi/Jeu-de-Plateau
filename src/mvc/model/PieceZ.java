package mvc.model;

public class PieceZ extends Piece{
	
    public PieceZ() {
    	identifiant = 6;
    	int id = identifiant;
  
    	tabPiece = new int[][]{
    		{0,0,0},
    		{id,id,0},
    		{0,id,id}
    		};
    		
    	centreGrav = new int[] {1,1};
    }

	@Override
	public void rotation() {
		int id = this.getIdentifiant();
		switch(etat) {
		case 1: 
	    	tabPiece = new int[][]{
	    		{0,0,id},
	    		{0,id,id},
	    		{0,id,0}
	    		};
	    	etat++;
			//if rotation pas possible break
			//else case ++ et rotation
			break;
		case 2:
	    	tabPiece = new int[][]{
	    		{0,0,0},
	    		{id,id,0},
	    		{0,id,id}
	    		};
	    		etat++;
			break;
		case 3: 
	    	tabPiece = new int[][]{
	    		{0,0,id},
	    		{0,id,id},
	    		{0,id,0}
	    		};
	    	etat++;
			break;
		case 4:
	    	tabPiece = new int[][]{
	    		{0,0,0},
	    		{id,id,0},
	    		{0,id,id}
	    		};
	    		etat=1;
			break;
		}
		
	}
	
	
}
