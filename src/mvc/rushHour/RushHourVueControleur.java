package mvc.rushHour;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import mvc.libInterpreteurExpr.Utils;
import mvc.rushHour.modele.RushHourGrille;
import mvc.rushHour.modele.RushPiece;

public class RushHourVueControleur extends Application {

    private Rectangle[][] tabRect = new Rectangle[6][6];
    private int column = 6;
    private int row = 6;
    private RushHourGrille g;
    private RushPiece currentPiece = null;
    private int previous;
    private int nbCoups=0;


    @Override
    public void start(Stage primaryStage) {
        // initialisation du modèle que l'on souhaite utiliser
        g = new RushHourGrille(column, row);

        BorderPane border = new BorderPane();
        GridPane gPane = new GridPane();
        paintGrille(column, row, gPane);

        gPane.setOnMouseClicked(event->{
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
                 if(g.gagnePartie()) {
                	finPartie();
                 }
                }
            }
            else { // Si y a une piece la on clique
                RushPiece piece = g.getPieceAt(coordX, coordY);
                previous = piece.getId();
                piece.setId(500);
                paintGrille(column, row, gPane);
                currentPiece = piece;
                currentPiece.setId(previous);
            }

        });

        border.setCenter(gPane);

        Scene scene = new Scene(border, Color.LIGHTGREY);

        primaryStage.setTitle("Calc FX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Color getColor(int id) {
        switch (id) {
            case 100:
                return Color.RED;
            case 1:
                return Color.BLUE;
            case 2:
                return Color.OLIVE;
            case 3:
                return Color.YELLOW;
            case 4:
                return Color.ORANGE;
            case 5:
                return Color.PINK;
            case 6:
                return Color.VIOLET;
            case 500:
                return Color.LIGHTGREEN;
        }
        return null;
    }

    private void paintGrille(int column, int row, GridPane gPane){
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                if (g.getPieceAt(i, j) != null) {
                    Color color = getColor(g.getPieceAt(i, j).getId());
                    tabRect[j][i] = new Rectangle(40, 40, color);
                    tabRect[j][i].setStroke(Color.GRAY);
                } else {
                    tabRect[j][i] = new Rectangle(40, 40);
                    tabRect[j][i].setStroke(Color.GRAY);
                }
                gPane.add(tabRect[j][i], j, i);
            }
        }
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