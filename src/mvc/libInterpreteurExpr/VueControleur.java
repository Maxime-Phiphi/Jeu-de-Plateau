package mvc.libInterpreteurExpr;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public abstract class VueControleur extends Application {

    protected Rectangle[][] tabRect;
    protected int column;
    protected int row;
    protected Grille g;
    protected GridPane gPane;


    public abstract void initVars();

    @Override
    public void start(Stage stage) {
        BorderPane border = new BorderPane();
        gPane = new GridPane();

        border.setCenter(gPane);
        Scene scene = new Scene(border, Color.LIGHTGREY);
        stage.setScene(scene);

    }

    protected void paintGrille(int column, int row, GridPane gPane){
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

    public abstract void finPartie();
}
