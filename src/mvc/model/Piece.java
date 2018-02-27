package mvc.model;

public abstract class Piece {
	
	protected int[][] tabPiece;
	protected int identifiant;
	protected int[] centreGrav;
	
	public Piece(int[][] tabPiece, int identifiant, int[] centreGrav) {
		this.tabPiece = tabPiece;
		this.identifiant = identifiant;
		this.centreGrav = centreGrav;
		
	}

	public Piece (){}

	public abstract void rotation();

}
