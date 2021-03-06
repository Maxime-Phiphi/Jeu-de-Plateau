package mvc.rushHour.modele;

import java.util.Observable;
import mvc.libInterpreteurExpr.*;

public class RushHourGrille extends Grille{
	/**
	 * constructor of grid of rush hour game
	 * @param h : height of the grid
	 * @param l : width of the grid
	 */
	public RushHourGrille(int h, int l) {
		setLargeur(l);
		setHauteur(h);
		setTabCases(new int[h][l]);
		initialiserConfigRushHour();
		initialiserTabCases();
		addInTabCases();
	}

	/**
	 * Initialization of the game
	 */
	private void initialiserConfigRushHour() {
	    getListPiece().add(new RushPiece("V", 1, 0, 0, 'H'));
	    getListPiece().add(new RushPiece("V", 100, 1, 2, 'H'));
	    getListPiece().add(new RushPiece("V", 2, 4, 4, 'H'));
	    getListPiece().add(new RushPiece("V", 3, 0, 4, 'V'));
	    getListPiece().add(new RushPiece("C", 4, 0, 1, 'V'));
	    getListPiece().add(new RushPiece("C", 5, 3, 1, 'V'));
	    getListPiece().add(new RushPiece("C", 6, 5, 0, 'V'));
	    getListPiece().add(new RushPiece("C", 6, 2, 5, 'H'));

        for (Piece p : getListPiece()) {
            p.addObserver(this);
        }
    }

	/**
	 * Add a piece in tabCase
	 */
	public void addInTabCases() {
		for(Piece p : getListPiece()) {
			if(( (RushPiece) p).getSens()=='V') {
				getTabCases()[p.getX()][p.getY()]=p.getId();
                getTabCases()[p.getX()+1][p.getY()]=p.getId();
				if(( (RushPiece) p).getType().equals("C")) {
                    getTabCases()[p.getX()+2][p.getY()]=p.getId();
				}
			}else {
                getTabCases()[p.getX()][p.getY()]=p.getId();
                getTabCases()[p.getX()][p.getY()+1]=p.getId();
				if(( (RushPiece) p).getType().equals("C")) {
                    getTabCases()[p.getX()][p.getY()+2]=p.getId();
				}
            }
        }
	}

	/**
	 * Check if the game is winning
	 * @return boolean
	 */
    public boolean gagnePartie() {
		for(Piece p: getListPiece()) {
			if(p.getId()==100) {
				if(p.getY()==4) {
					return true; 
				}
			}
		}
		return false; 
	}


	/**
	 * function called each time a child notify
	 * @param obs : observable child
	 * @param obj : any
	 */
    @Override
    public void update(Observable obs, Object obj) {
        initialiserTabCases();
        addInTabCases();
    }

}
