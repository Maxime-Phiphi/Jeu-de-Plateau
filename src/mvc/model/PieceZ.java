package mvc.model;

public class PieceZ extends Piece{
    public PieceZ() {
    	identifiant = 6;
    	int id = identifiant;
    	etat = 1; 
    	tabPiece = new int[][]{
    		{0,0,0},
    		{id,id,0},
    		{0,id,id}
    		};
    		
    	centreGrav = new int[] {1,1};
    }

	@Override
	public void rotation() {
		
		
	}
}
