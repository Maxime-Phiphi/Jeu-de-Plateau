package mvc.blockus;

import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import mvc.blockus.modele.BlockusGrille;
import mvc.blockus.modele.BlockusPiece;
import mvc.blockus.modele.PieceO;
import mvc.libInterpreteurExpr.Piece;
import mvc.libInterpreteurExpr.VueControleur;

import java.util.ArrayList;

public class BlockusVueControleur extends VueControleur {

    ArrayList<Integer> colors = new ArrayList<>();

    @Override
    public void initVars() {
        column = 20;
        row = 20;
        tabRect = new Rectangle[column][row];
        g = new BlockusGrille(row, column);
        colors.add(100);
        colors.add(1);
        colors.add(2);
        colors.add(3);
    }

    @Override
    public void start(Stage stage) {
        super.start(stage);
        initVars();
        paintGrille(column, row, gPane);

        super.gPane.setOnMouseClicked(event-> {
            int coordY = (int) (event.getX() / 40);
            int coordX = (int) event.getY() / 40;
            int currentColor = colors.get(0);
            Piece piece =  new PieceO(coordX, coordY, currentColor);

            if (g.getListPiece().isEmpty()){
                ((BlockusGrille) g).addPiece(coordX, coordY, piece);
                paintGrille(column, row, gPane);
                System.out.println("ajoutée");
            }

            if(((BlockusGrille)g).collision(coordX, coordY, (BlockusPiece)piece)) {// Si on clique pas sur une piece
                for (Piece p: g.getListPiece()) {
                    if (((BlockusGrille) g).isAllowed ((BlockusPiece) piece, (BlockusPiece)p) && !((BlockusGrille)g).isForbidden((BlockusPiece) piece, (BlockusPiece)p)){
                        ((BlockusGrille) g).addPiece(coordX, coordY, piece);
                        paintGrille(column, row, gPane);
                        colors.remove(0);
                        colors.add(currentColor);
                        return;
                    }
                }
            }



        });


        stage.setTitle("Blockus");
        stage.show();
    }


}
