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
		switch(etat) {
		case 1: 
			//if rotation pas possible break
			//else case ++ et rotation
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
