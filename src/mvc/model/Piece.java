package mvc.model;

public abstract class Piece {
	

	protected int[][] tabPiece;
	protected int identifiant;
	protected int[] centreGrav;
	protected int etat=1;
	protected int x;
	protected int y;

	
	public Piece(int[][] tabPiece, int identifiant, int[] centreGrav, int x, int y) {
		this.tabPiece = tabPiece;
		this.identifiant = identifiant;
		this.centreGrav = centreGrav;
		this.x = x;
		this.y = y;
		
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

	public abstract void rotation();

}
