package mvc.libInterpreteurExpr;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Utils {

    /**
     * generate dialog box
     * @param title : title of the box
     * @param header : header of the box
     * @param content : content of the box
     * @param exit : if you want to exit the game pressing ok
     */
    public static void showDialog(String title, String header, String content, boolean exit){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
                if (exit){
                    Platform.exit();
                }
            }
        });
    }
}
