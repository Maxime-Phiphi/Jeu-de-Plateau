package mvc.rushHour;

import javafx.scene.shape.*;
import javafx.stage.Stage;
import mvc.libInterpreteurExpr.Utils;
import mvc.libInterpreteurExpr.VueControleur;
import mvc.rushHour.modele.RushHourGrille;
import mvc.rushHour.modele.RushPiece;

public class RushHourVueControleur extends VueControleur{

    private RushPiece currentPiece = null;
    private int previous;
    private int nbCoups=0;


    @Override
    public void initVars() {
        column = 6;
        row =6;
        tabRect = new Rectangle[column][row];
        g = new RushHourGrille(row, column);
    }

    @Override
    public void start(Stage primaryStage) {
        super.start(primaryStage);
        initVars();
        g = new RushHourGrille(column, row);
        paintGrille(column, row, gPane);


        super.gPane.setOnMouseClicked(event->{
            int coordY = (int) (event.getX() / 40);
            int coordX = (int) event.getY() / 40;
            //Si y a pas de piece la ou on clique
            if (g.getPieceAt(coordX, coordY)== null){
                if (currentPiece==null) {
                    Utils.showDialog("Erreur", "Attention, tu as choisi une case vide", "Veuillez choisir une piece",false);
                }
                else{
                 avancer (coordX, coordY, currentPiece);
                 nbCoups++;
                 paintGrille(column, row, gPane);
                 if(((RushHourGrille)g).gagnePartie()) {
                	finPartie();
                 }
                }
            }
            else { // Si y a une piece la on clique
                RushPiece piece = (RushPiece) g.getPieceAt(coordX, coordY);
                previous = piece.getId();
                piece.setId(500);
                paintGrille(column, row, gPane);
                currentPiece = piece;
                currentPiece.setId(previous);
            }

        });

        primaryStage.setTitle("Rush Hour");
        primaryStage.show();
    }


    
    private void finPartie() {
        String content = "Tu as fini la partie en " + nbCoups + " coups.";
        Utils.showDialog("Bravo","Tu as gagne la partie",content,true);
    }

    private void avancer(int x, int y, RushPiece currentPiece){
        if (currentPiece.getSens()=='V'){
            if (currentPiece.getX() > x && y == currentPiece.getY()){
                int n = currentPiece.mostClose(x, column, row);
                for (int i = n; i > x; i--) {
                    if (g.collision(i-1,currentPiece.getY())){
                        currentPiece.reculer();
                    }
                    else {
                        return;
                    }
                }
            }
            else if (currentPiece.getX() < x && y == currentPiece.getY()){
                int n = currentPiece.mostClose(x, column, row);
                for (int i = n; i < x ; i++) {
                    if (g.collision(i+1,currentPiece.getY())){
                        currentPiece.avancer();
                    }
                    else {
                        return;
                    }
                }
            }
            else {
            	nbCoups--;
                Utils.showDialog("Erreur","Attention, ne peux pas deplacer la piece ici","Veuillez choisir une autre case", false);
            }
        }
        else {
            if (currentPiece.getY() > y && x == currentPiece.getX()) {
                int n = currentPiece.mostClose(y, column, row);
                for (int i = n; i > y; i--) {
                    if (g.collision(currentPiece.getX(),i-1)) {
                        currentPiece.reculer();
                    }
                    else {
                        return;
                    }
                }
            }
            else if (currentPiece.getY() < y && x == currentPiece.getX()){
                int n = currentPiece.mostClose(y, column, row);
                for (int i = n; i < y ; i++) {
                    if (g.collision(currentPiece.getX(),i+1)) {
                        currentPiece.avancer();
                    }
                    else {
                        return;
                    }
                }
            }
            else {
            	nbCoups--;
            	Utils.showDialog("Erreur", "Attention, ne peux pas deplacer la piece ici","Veuillez choisir une autre case",false);
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}