package mvc.model;

public abstract class Piece {
	
<<<<<<< HEAD
	 
	protected int[][] tabPiece;
	protected int identifiant;
	protected int[] centreGrav; 
=======
	protected int[][] tabPiece;
	protected int identifiant;
	protected int[] centreGrav;
>>>>>>> 52bfb841a0c6675ed4302307faab26f4e665901f
	
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

	public Piece (){}

	public abstract void rotation();

}
