package mvc.model;


import java.util.Observable;



public class Grille extends Observable{

	private int largeur;
	private int hauteur;
	private int[][] tabCases;  
<<<<<<< HEAD
	boolean err = false;

=======
	
	
>>>>>>> 52bfb841a0c6675ed4302307faab26f4e665901f
	public Grille(int h, int l) {
		this.largeur = l; 
		this.hauteur = h;
		tabCases = new int[h][l];
		initialiserTabCases();
	}

	public void initialiserTabCases() {
		for(int i=0;i<largeur;i++) {
			for(int j=0;j<hauteur;j++) {
				tabCases[j][i]=0;
			}
		}
	}

	public void updateGrille() {
		setChanged();
		notifyObservers();
	}

	public void changeCase(int x, int y, int n) {
		tabCases[x][y]=n;
		updateGrille();
	}

	public int getCase(int x, int y) {
		return tabCases[x][y];
	}

	public boolean getErr() {
		return err;
	}

	public boolean isEmpty(int x, int y) {
		if(tabCases[x][y]!=0) return false; 
		return true; 
	}
	
<<<<<<< HEAD

=======
	
>>>>>>> 52bfb841a0c6675ed4302307faab26f4e665901f
}
