package mvc.model;



public class PieceI extends Piece{

	
	

	public PieceI(){
		identifiant = 1;
		tabPiece = new int[][]{
				{0, 0, 0, 0},
				{0, 0, 0, 0},
				{identifiant, identifiant, identifiant, identifiant},
				{0, 0, 0, 0},
		};
	}

	@Override
	public void rotation() {
		switch(etat){
			case 1 :
				tabPiece = new int[][]{
						{0, 0, getIdentifiant(), 0},
						{0, 0, getIdentifiant(), 0},
						{0, 0, getIdentifiant(), 0},
						{0, 0, getIdentifiant(), 0},
				};
				break;
			case 2 :
				tabPiece = new int[][]{
						{0, 0, 0, 0},
						{0, 0, 0, 0},
						{getIdentifiant(), getIdentifiant(), getIdentifiant(), getIdentifiant()},
						{0, 0, 0, 0},
				};
				break;

		}

	}
}
