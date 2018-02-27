package mvc.model;

public abstract class Piece {
	
	protected String nom; 
	protected int[][] tabPiece;
	protected int identifiant;
	protected int centreGrav; 
	
	public Piece(String nom, int[][] tabPiece, int identifiant, int centreGrav) {
		this.nom = nom; 
		this.tabPiece = tabPiece;
		this.identifiant = identifiant;
		this.centreGrav = centreGrav;
		
	}

}
