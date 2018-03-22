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
        if ( this.sens == 'V'){
            if (this.getX() > x){
                for (int i = x; i < row ; i++) {
                    if(isInclude(i, this.getY())){
                        return i;
                    }
                }
            }
            else {
                for (int i = x; i > 0 ; i--) {
                    if(isInclude(i, this.getY())){
                        return i;
                    }
                }
            }
            return this.getX();
        }
        else {
            if (this.getY() > x){
                for (int i = x; i < column ; i++) {
                    if(isInclude(this.getX(), i)){
                        return i;
                    }
                }
            }
            else {
                for (int i = x; i > 0 ; i--) {
                    if(isInclude(this.getX(), i)){
                        return i;
                    }
                }
            }
            return this.getY();
        }

    }

    public void avancer(){

        if (this.getSens() =='V'){
            this.setX(this.getX()+1);
        }
        else{
            this.setY(this.getY()+1);
        }
    }

    public void reculer(){
        if (this.getSens() =='V'){
            this.setX(this.getX()-1);
        }
        else{
            this.setY(this.getY()- 1);
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

