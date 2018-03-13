package mvc.model;

public class RushPiece {

    private String id;
    private String type;
    private String[] tabPiece;

    public RushPiece(String type, String id) {
        this.id = id;
        if (type=="C"){
            String[] tabPiece = {id, id};
        }
        else {
            String[] tabPiece = {id, id, id};
        }
    }

}

