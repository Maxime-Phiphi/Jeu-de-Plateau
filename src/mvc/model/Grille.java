package mvc.model;

import mvc.Modele;
import javafx.scene.paint.Color;

public class Grille extends Modele{
	
	private int largeur;
	private int hauteur;
	private Case[][] tabCases;  
	
	public Grille(int h, int l) {
		this.largeur = l; 
		this.hauteur = h;
		tabCases = new Case[h][l];
		initialiserTabCases();
	}
	
	public void initialiserTabCases() {
		for(int i=0;i<largeur;i++) {
			for(int j=0;j<hauteur;j++) {
				tabCases[j][i]=new Case(Color.BLACK);
			}
		}
	}
	
	public void updateGrille() {
        setChanged();
        notifyObservers();
	}
	
	public void changeCase(int x, int y, Color c) {
		tabCases[x][y].setFill(c);
		updateGrille();
	}
	
	public Case getCase(int x, int y) {
		return tabCases[x][y];
	}
}
