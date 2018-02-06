package mvc.model;

public class Grille {
	
	private int largeur;
	private int hauteur;
	private Case[][] tabCases;  
	
	public Grille(int h, int l) {
		this.largeur = l; 
		this.hauteur = h;
		tabCases = new Case[h][l];
	}
	
	public void initialiserTabCases() {
		
	}
}
