package mvc;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import mvc.model.Grille;
import mvc.model.RushPiece;

public class VueControleur extends Application {

    private Rectangle[][] tabRect = new Rectangle[6][6];
    private Grille g;
    private RushPiece currentPiece = null;
    private int previous;


    @Override
    public void start(Stage primaryStage) {
        // initialisation du modèle que l'on souhaite utiliser
        int column = 6;
        int row = 6;
        g = new Grille(column, row);

        BorderPane border = new BorderPane();
        GridPane gPane = new GridPane();
        paintGrille(column, row, gPane);



        gPane.setOnMouseClicked(event->{
            System.out.println("X: " + event.getX() / 40 + " Y: " + event.getY() / 40);
            int coordY = (int) (event.getX() / 40);
            int coordX = (int) event.getY() / 40;
            //Si y a une piece la ou on clique
            RushPiece piece = g.getPieceAt(coordX, coordY);
            previous = piece.getId();
            piece.setId(500);
            paintGrille(column, row, gPane);
            currentPiece = piece;
            currentPiece.setId(previous);
            // sinon on fait avancer la piece


//            actualiseCase(coordX, coordY, x);


        });



        border.setCenter(gPane);

        Scene scene = new Scene(border, Color.LIGHTGREY);

        primaryStage.setTitle("Calc FX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Color getColor(int id) {
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
    public void paintGrille(int column, int row, GridPane gPane){
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

    public void avancer (int x, int y, RushPiece currentPiece){
        if (currentPiece.getSens()=='V'){
            if (currentPiece.getX() > x){
                int n = currentPiece.getX()-x;
                g.reculer(currentPiece,n);
            }
            else{
                int n = x - currentPiece.getX();
                g.avancer(currentPiece,n);
            }
        }
        else {
            if (currentPiece.getY() > y) {
                int n = currentPiece.getY()-y;
                g.reculer(currentPiece,n);
            }
            else {
                int n = y - currentPiece.getY();
                g.avancer(currentPiece,n);
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void actualiseCase(int i, int j, int couleur) {
        g.changeCase(i, j, couleur);
    }

//    public void updateColor() {
//        for(int j=0;j<10;j++) {
//            for(int i=0;i<10;i++) {
//                switch(g.getCase(i, j)) {
//                    case 1:
//                        tabRect[i][j].setFill(Color.CYAN);
//                        break;
//                    case 2:
//                    	tabRect[i][j].setFill(Color.YELLOW);
//                    	break;
//                    case 3:
//                    	tabRect[i][j].setFill(Color.PURPLE);
//                    	break;
//                    case 4:
//                    	tabRect[i][j].setFill(Color.ORANGE);
//                    	break;
//                    case 5:
//                    	tabRect[i][j].setFill(Color.BLUE);
//                    	break;
//                    case 6:
//                    	tabRect[i][j].setFill(Color.RED);
//                    	break;
//                    case 7:
//                    	tabRect[i][j].setFill(Color.LIMEGREEN);
//                    	break;
//                }
//            }
//        }
//    }

}