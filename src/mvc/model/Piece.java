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
	
	public Piece() {
		
	}



	public int[][] getTabPiece() {
		return tabPiece;
	}

	public void setTabPiece(int[][] tabPiece) {
		this.tabPiece = tabPiece;
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public int[] getCentreGrav() {
		return centreGrav;
	}

	public void setCentreGrav(int[] centreGrav) {
		this.centreGrav = centreGrav;
	}

}
