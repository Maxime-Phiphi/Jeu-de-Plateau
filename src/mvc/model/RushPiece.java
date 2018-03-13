package mvc.model;

import java.util.ArrayList;

public class RushPiece {

    private int id;
    private String type;
    private String[] tabPiece;
    private int x;
    private int y;
    private char sens;

    public RushPiece(String type, int id, int x, int y, char sens) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.sens = sens;
        if (type=="C"){
            int[] tabPiece = {id, id};
        }
        else {
            int[] tabPiece = {id, id, id};
        }
    }
//Getter Setter

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getSens() {
        return sens;
    }

    public int getId() {
        return id;
    }
}

