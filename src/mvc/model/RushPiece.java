package mvc.model;

import java.util.ArrayList;

public class RushPiece {

    private int id;
    private String type;
    private String[] tabPiece;
    private int x;
    private int y;
    private char sens;

    public RushPiece(String type, int id, int y, int x, char sens) {
        this.type = type;
        this.id = id;
        this.x = x;
        this.y = y;
        this.sens = sens;
        if (type=="V"){
            int[] tabPiece = {id, id};
        }
        else {
            int[] tabPiece = {id, id, id};
        }
    }

    public boolean isInclude (int x, int y){
        if (this.sens == 'V'){
            if (this.type == "V") {
                return (this.getX() == x || this.getX() + 1 == x )&& this.getY()==y;
            }
            else {
                return (this.getX() == x || this.getX() + 1 == x || this.getX() +2 == x)&& this.getY()==y;
            }
        }
        else{
            if (this.type == "V") {
                return (this.getY() == y || this.getY() + 1 == y)&& this.getX()==x;
            }
            else {
                return (this.getY() == y || this.getY() + 1 == y || this.getY() +2 == y)&& this.getX()==x;
            }

        }
    }

    public int mostClose (int x, int column, int row){
        int min = 1000;
        int m=x;
        if (this.sens == 'V'){
            for (int i = 0; i <row ; i++) {
                if (isInclude( i, this.getY())){
                    m = Math.abs(x - i);
                }
                if (m < min){
                    min = m;
                }
            }
        return Math.abs(x-min);
        }
        else {
            for (int i = 0; i <column ; i++) {
                if (isInclude( this.getX(), i)){
                    m = x - i;
                }
                if (m < min){
                    min = m;
                }
            }
            return Math.abs(x-min);
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
    public String getType() {
    	return type; 
    }

    public void setId(int id) {
        this.id = id;
    }
}

