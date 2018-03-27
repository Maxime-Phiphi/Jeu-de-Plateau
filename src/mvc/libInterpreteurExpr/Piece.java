package mvc.libInterpreteurExpr;

import java.util.Observable;

public abstract class Piece extends Observable {

    /**
     * field id : color of piece
     */
    protected int id;
    /**
     * field x : coordinates x
     */
    protected int x;
    /**
     * fiels y : coordinates y
     */
    protected int y;

    /**
     * Check if the piece is include in these coordinates
     * @param x : coordinate x
     * @param y : coordinate y
     * @return boolean
     */
    public abstract boolean isInclude (int x, int y);

    //Getter Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
