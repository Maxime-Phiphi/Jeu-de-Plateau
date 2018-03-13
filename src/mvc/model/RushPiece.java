package mvc.model;

public class RushPiece {

    private String id;
    private String type;
    private String[] tabPiece;
    private int x;
    private int y;

    public RushPiece(String type, String id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
        if (type=="C"){
            String[] tabPiece = {id, id};
        }
        else {
            String[] tabPiece = {id, id, id};
        }
    }

}

