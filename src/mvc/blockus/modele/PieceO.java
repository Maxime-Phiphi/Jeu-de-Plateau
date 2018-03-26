package mvc.blockus.modele;

import java.util.ArrayList;

public class PieceO extends BlockusPiece{

// x, y sont les coordonnées du coin en haut à gauche

    public PieceO(int x, int y, int id) {
        this.id = id;
        tabPiece = new int[][] {
                {200,0,0,200},
                {0, id, id,0},
                {0, id, id,0},
                {200,0,0,200}
        };
        this.x = x;
        this.y = y;
    }

    @Override
    public void rotation() {}

    @Override
    public ArrayList<int[]> listCoords() {
        ArrayList<int[]> listCoords = new ArrayList<>();
        int [] coord1 = {getX(), getY()};
        int [] coord2 = {getX()+1, getY()};
        int [] coord3 = {getX()+1, getY()+1};
        int [] coord4 = {getX(), getY()+1};
        listCoords.add(coord1);
        listCoords.add(coord2);
        listCoords.add(coord3);
        listCoords.add(coord4);
        return listCoords;
    }

    @Override
    public ArrayList<int[]> neighborsPlaces() {
        ArrayList<int []> listNeighbors = new ArrayList<>();
        int [] neighbor1 = {(getX()-1), (getY()-1)};
        int [] neighbor2 = {(getX()+2), (getY()-1)};
        int [] neighbor3 = {(getX()-1), (getY()+2)};
        int [] neighbor4 = {(getX()+2), (getY()+2)};
        listNeighbors.add(neighbor1);
        listNeighbors.add(neighbor2);
        listNeighbors.add(neighbor3);
        listNeighbors.add(neighbor4);

        return listNeighbors;
    }

    @Override
    public ArrayList<int[]> forbiddenPlaces() {
        ArrayList<int []> listForbidden = new ArrayList<>();
        int [] forbidden1 = {(getX()-1), (getY())};
        int [] forbidden2 = {(getX()-1), (getY()+1)};
        int [] forbidden3 = {(getX()+2), (getY())};
        int [] forbidden4 = {(getX()+2), (getY()+1)};
        int [] forbidden5 = {(getX()), (getY()-1)};
        int [] forbidden6 = {(getX()+1), (getY()-1)};
        int [] forbidden7 = {(getX()), (getY()+2)};
        int [] forbidden8 = {(getX()+1), (getY()+2)};
        listForbidden.add(forbidden1);
        listForbidden.add(forbidden2);
        listForbidden.add(forbidden3);
        listForbidden.add(forbidden4);
        listForbidden.add(forbidden5);
        listForbidden.add(forbidden6);
        listForbidden.add(forbidden7);
        listForbidden.add(forbidden8);

        return listForbidden ;
    }


    @Override
    public boolean isInclude(int x, int y) {
        return (x == this.x && this.y == y) || (x == this.x + 1 && y == this.y) || (y == this.y + 1 && x == this.x) || (x == this.x + 1 && y == this.y + 1);
    }




}
