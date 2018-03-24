package mvc.libInterpreteurExpr;

import java.util.Observable;

public abstract class Piece extends Observable {

    /**
     * field id : color of piece
     */
    private int id;
    /**
     * field x : coordinates x
     */
    private int x;
    /**
     * fiels y : coordinates y
     */
    private int y;

    /**
     * Check if the piece is include in these coordinates
     * @param x : coordinate x
     * @param y : coordinate y
     * @return boolean
     */
    public abstract boolean isInclude (int x, int y);

    /**
     * move the piece forward
     */
    public abstract void avancer();

    /**
     * Move the piece backward
     */
    public abstract void reculer();

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

    protected void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    protected void setY(int y) {
        this.y = y;
    }
}
