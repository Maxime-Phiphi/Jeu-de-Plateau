package mvc.model;

public abstract class Piece {
	
	protected String nom; 
	protected int[][] tabPiece;
	protected String couleur; 
	protected int centreGrav; 
	
	public Piece(String nom, int[][] tabPiece, String couleur, int centreGrav) {
		this.nom = nom; 
		this.tabPiece = tabPiece;
		this.couleur = couleur;
		this.centreGrav = centreGrav;
		
	}

}
