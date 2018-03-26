package mvc.blockus;

import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import mvc.blockus.modele.BlockusGrille;
import mvc.blockus.modele.BlockusPiece;
import mvc.blockus.modele.PieceO;
import mvc.libInterpreteurExpr.Piece;
import mvc.libInterpreteurExpr.Utils;
import mvc.libInterpreteurExpr.VueControleur;

import java.util.ArrayList;

public class BlockusVueControleur extends VueControleur {

    private ArrayList<Integer> colors = new ArrayList<>();
    private int nbPieceRouge;
    private int nbPieceBleue;
    private int nbPieceVerte;
    private int nbPieceJaune;
    private String couleur;
    private int nbMaxPiece;
    boolean error;

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
        nbPieceRouge = 1;
        nbPieceBleue = 1;
        nbPieceVerte = 1;
        nbPieceJaune = 1;
        nbMaxPiece = 3;
        error = false;
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


            try {
                if (((BlockusGrille) g).collision(coordX, coordY, (BlockusPiece) piece)) {// Si on clique pas sur une piece
                    for (Piece p : g.getListPiece()) {
                        if (((BlockusGrille) g).isAllowed((BlockusPiece) piece, (BlockusPiece) p) && !((BlockusGrille) g).isForbidden((BlockusPiece) piece, (BlockusPiece) p)) {
                            error = false;
                            ((BlockusGrille) g).addPiece(coordX, coordY, piece);
                            paintGrille(column, row, gPane);
                            switch (colors.get(0)) {
                                case 100:
                                    nbPieceRouge++;
                                    break;
                                case 1:
                                    nbPieceBleue++;
                                    break;
                                case 2:
                                    nbPieceVerte++;
                                    break;
                                case 3:
                                    nbPieceJaune++;
                                    break;
                            }
                            if (nbPieceRouge == nbMaxPiece) {
                                finPartie();
                            }
                            if (nbPieceBleue == nbMaxPiece) {
                                finPartie();
                            }
                            if (nbPieceVerte == nbMaxPiece) {
                                finPartie();
                            }
                            if (nbPieceJaune == nbMaxPiece) {
                                finPartie();
                            }
                            colors.remove(0);
                            System.out.println(nbPieceRouge);
                            colors.add(currentColor);
                            return;
                        }
                        else {
                            error = true;
                        }


                    }

                }
                else{
                    error = true;
                }

                if (error){
                    String content = "Tu ne peux pas poser ta piece ici";
                    Utils.showDialog("Attention", "Mouvement interdit", content, false);
                }

            }
            catch (Exception e){
                String content = "Tu ne peux pas poser ta piece ici";
                Utils.showDialog("Attention", "Mouvement interdit", content, false);
                return;
            }
        });


        stage.setTitle("Blockus");
        stage.show();
    }

    @Override
    public void finPartie() {
        switch(colors.get(0)) {
            case 100 :
                couleur = "rouge";
                break;
            case 1 :
                couleur = "bleu";
                break;
            case 2 :
                couleur = "vert";
                break;
            case 3 :
                couleur = "jaune";
                break;
        }
        String content = "Tu as pose toutes tes pieces sur la tablier";
        Utils.showDialog("Bravo","Le joueur " + couleur + " a gagne la partie",content,true);
    }


}
