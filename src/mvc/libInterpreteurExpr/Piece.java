package mvc.libInterpreteurExpr;

import mvc.rushHour.modele.RushPiece;

import java.util.ArrayList;

public abstract class Piece {

        private int id;
        private ArrayList<Piece> tabPiece;
        private int x;
        private int y;


    public abstract boolean isInclude (int x, int y);

    public abstract void avancer();

    public abstract void reculer();



//Getter Setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Piece> getTabPiece() {
        return tabPiece;
    }

    public void setTabPiece(ArrayList<Piece> tabPiece) {
        this.tabPiece = tabPiece;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
