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

public class RushHour extends Application {



	int x = 1;

	private Rectangle[][] tabRect = new Rectangle[8][8];
	private Grille g;
	private int xDepart; 
	private int xArrivee; 
	private int yDepart; 
	private int yArrivee; 


    @Override
    public void start(Stage primaryStage) {
        // initialisation du modèle que l'on souhaite utiliser
        int column = 8;
        int row = 8;
        g = new Grille(column,row);



        // gestion du placement (permet de palcer le champ Text affichage en haut, et GridPane gPane au centre)
        // Faudra le changer pour avoir la grille au centre et un espace pour afficher les pieces à droite
        BorderPane border = new BorderPane();

        // permet de placer les diffrents boutons dans une grille
        GridPane gPane = new GridPane();


        for (int i = 0;i<8;i++) {
            for(int j = 0; j<8;j++) {

                tabRect[j][i] = new Rectangle(40,40);
                gPane.add(tabRect[j][i], j, i);

            }
        }
        initialiseParking();
        updateColor();
        // un controleur (EventHandler) par bouton écoute et met à jour le champ affichage

        gPane.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
            	
                System.out.println("X: " + (int)event.getX()/40 + " Y: " + (int)event.getY()/40);
                xDepart = (int) (event.getX()/40);
                yDepart = (int) event.getY()/40;
          
                updateColor();
  
                
            }

        });
        gPane.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	
                System.out.println("X: " + (int)event.getX()/40 + " Y: " + (int)event.getY()/40);
                xArrivee = (int) (event.getX()/40);
                yArrivee = (int) event.getY()/40;
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
    
    public void initialiseParking() {
    	for(int i=0;i<8;i++) {
    		tabRect[i][0].setFill(Color.LIGHTGRAY);
    		tabRect[0][i].setFill(Color.LIGHTGRAY);
    		tabRect[i][7].setFill(Color.LIGHTGRAY);
    		tabRect[7][i].setFill(Color.LIGHTGRAY);
    		tabRect[7][3].setFill(Color.BLACK);
    		g.changeCase(2, 3, 6);
    		g.changeCase(3, 3, 6);
    	}
    }
    
    public void updateColor() {
        for(int j=0;j<8;j++) {
            for(int i=0;i<8;i++) {
                switch(g.getCase(i, j)) {
                	case 0:
                		tabRect[i][j].setFill(Color.BLACK);
                		break;
                    case 1:
                        tabRect[i][j].setFill(Color.CYAN);
                        break;
                    case 2: 
                    	tabRect[i][j].setFill(Color.YELLOW);
                    	break;
                    case 3:
                    	tabRect[i][j].setFill(Color.PURPLE);
                    	break;
                    case 4: 
                    	tabRect[i][j].setFill(Color.ORANGE);
                    	break;
                    case 5: 
                    	tabRect[i][j].setFill(Color.BLUE);
                    	break;
                    case 6:
                    	tabRect[i][j].setFill(Color.RED);
                    	break;
                    case 7:
                    	tabRect[i][j].setFill(Color.LIMEGREEN);
                    	break;
                }
            }
        }
    }

}