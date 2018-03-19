package mvc.rushHour.modele;

import mvc.libInterpreteurExpr.Piece;

public class RushPiece extends Piece{

    private String type;
    private char sens;


    public RushPiece(String type, int id, int y, int x, char sens) {

        this.type = type;
        setId(id);
        setX(x);
        setY(y);
        this.sens = sens;
//        if (type=="V"){
//            int[] tabPiece = {id, id};
//        }
//        else {
//            int[] tabPiece = {id, id, id};
//        }
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

    public void avancer(int n, int c){

        if (this.getSens() =='V'){
            int ecartV = c-this.getX();
            this.setX(this.getX()+n-ecartV);
        }
        else{
            int ecartH = c - this.getY();
            this.setY(this.getY()+n-ecartH);
        }
    }

    public void reculer(int n){
        if (this.getSens() =='V'){
            this.setX(this.getX()-n);
        }
        else{
            this.setY(this.getY()- n);
        }
    }
    // Getters Setters


    public String getType() {
        return type;
    }

    public char getSens() {
        return sens;
    }
}

