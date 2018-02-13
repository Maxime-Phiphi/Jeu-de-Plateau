package mvc.model;


import java.util.Observable;



public class Grille extends Observable{
	
	private int largeur;
	private int hauteur;
	private int[][] tabCases;  
	
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
}
