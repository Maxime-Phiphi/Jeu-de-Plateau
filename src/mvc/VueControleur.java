
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;


import java.util.Observable;
import java.util.Observer;
import javafx.application.Application;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.effect.Blend;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Shadow;
import javafx.scene.shape.*;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import mvc.model.Grille;

public class VueControleur extends Application {




	private Rectangle[][] tabRect = new Rectangle[10][10];
	private Grille g;

	@Override
	public void start(Stage primaryStage) {
		// initialisation du modèle que l'on souhaite utiliser
		int column = 10;
		int row = 10;
		g = new Grille(column,row);
		


		// gestion du placement (permet de palcer le champ Text affichage en haut, et GridPane gPane au centre)
		// Faudra le changer pour avoir la grille au centre et un espace pour afficher les pieces à droite
		BorderPane border = new BorderPane();

		// permet de placer les diffrents boutons dans une grille
		GridPane gPane = new GridPane();





		for (int i = 0;i<10;i++) {
			for(int j = 0; j<10;j++) {

				tabRect[j][i] = new Rectangle(40,40);
				gPane.add(tabRect[j][i], j, i);

			}
		}
		// un controleur (EventHandler) par bouton écoute et met à jour le champ affichage

		gPane.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				System.out.println("X: " + event.getX() + " Y: " + event.getY());
				int coordX = (int) (event.getX()/40);
				int coordY = (int) event.getY()/40;
				actualiseCase(coordX, coordY, 1);
				updateColor();
			}

		});

		gPane.setGridLinesVisible(true);

		border.setCenter(gPane);

		Scene scene = new Scene(border, Color.LIGHTGREY);

		primaryStage.setTitle("Calc FX");
		primaryStage.setScene(scene);
		primaryStage.show();
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
	
	public void updateColor() {
		for(int j=0;j<10;j++) {
			for(int i=0;i<10;i++) {
				switch(g.getCase(i, j)) {
				case 1: 
					tabRect[i][j].setFill(Color.BURLYWOOD);
					break;
				}
			}
		}
	}

}
