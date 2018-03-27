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

    /**
     * field colors : ArrayList<Integer> of possible colors
     */
    private ArrayList<Integer> colors = new ArrayList<>();
    /**
     * field nbPieceRouge : number of red Piece on the grid
     */
    private int nbPieceRouge;
    /**
     * field nbPieceBleue : number of blue Piece on the grid
     */
    private int nbPieceBleue;
    /**
     * field nbPieceVerte : number of green Piece on the grid
     */
    private int nbPieceVerte;
    /**
     * field nbPieceJaune : number of yellow Piece on the grid
     */
    private int nbPieceJaune;
    /**
     * field couleur : Color
     */
    private String couleur;
    /**
     * field nbMaxPiece : maximum number of piece per color on the grid
     */
    private int nbMaxPiece;
    /**
     * field error : if there is an error with the placement on the grid
     */
    private boolean error;

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
        nbMaxPiece = 21;
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

            if (!((BlockusGrille)g).possibilities ((BlockusPiece)piece, piece.getId())) {
               String content = "Tu ne peux plus poser de pièce";
               Utils.showDialog("Perdu", getCouleur()+ " a perdu :'(", content, true);
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
                            } else {
                                error = true;
                            }


                        }

                    } else {
                        error = true;
                    }

                    if (error) {
                        String content = "Tu ne peux pas poser ta piece ici";
                        Utils.showDialog("Attention", "Mouvement interdit", content, false);
                    }

                } catch (Exception e) {
                    String content = "Tu ne peux pas poser ta piece ici";
                    Utils.showDialog("Attention", "Mouvement interdit", content, false);
                }



        });

        stage.setTitle("Blockus");
        stage.show();
    }

    /**
     * return the color of the piece
     * @return String
     */
    private String getCouleur() {
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
        return couleur;
    }
    @Override
    public void finPartie() {
        getCouleur();
        String content = "Tu as pose toutes tes pieces sur la tablier";
        Utils.showDialog("Bravo","Le joueur " + couleur + " a gagne la partie",content,true);
    }


}
