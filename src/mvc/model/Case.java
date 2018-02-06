package mvc.model;


import javafx.scene.paint.Color;
import javafx.scene.shape.*;



public class Case extends Rectangle{
	
	private final static int LARGEUR = 40;
	private final static int HAUTEUR = 40;
	
	
	public Case(Color c) {
		super(LARGEUR, HAUTEUR, c);
	}
}
