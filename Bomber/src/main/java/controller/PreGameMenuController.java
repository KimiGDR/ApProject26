package controller;


import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.util.Objects;

public class PreGameMenuController {
    public TextField name;
    public Label createGame;
    public Button play;
    public TextField friendName;
//    public ImageView blueImage, yellowImage, redImage, greenImage, purpleImage;
//    public Label blueLabel, yellowLabel, redLabel, greenLabel, purpleLabel;



    public void checkName(MouseEvent mouseEvent) {
        if (Objects.equals(name.getText(), "")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING");
            alert.setHeaderText("Empty box!");
            alert.setContentText("You cannot play with nobody!");
            alert.show();
        }
//        else if (Objects.equals(name.getText(), user.nickName)) {
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setTitle("WARNING");
//            alert.setHeaderText("Wrong ID!");
//            alert.setContentText("You cannot play with you!");
//            alert.show();
//        }
        else {
//            factionPage();
//            FactionPage factionPage = new FactionPage();
//            try {
//                factionPage.start(PreGameMenu.stage);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        }
    }

//    public void factionPage() {
//        Node nameToDelete = name;
//        Node createGameToDelete = createGame;
//        Node playToDelete = play;
//        Parent parent = nameToDelete.getParent();
//        ((Pane) parent).getChildren().remove(name);
//        parent = createGameToDelete.getParent();
//        ((Pane) parent).getChildren().remove(createGame);
//        parent = playToDelete.getParent();
//        ((Pane) parent).getChildren().remove(play);
//        Label blueLabel = new Label();
//        blueLabel.setText("Draw a card from your deck whenever you win a round.");
//        System.out.println(blueLabel.getText());
//
//    }

//    public void factionPage() {
////        play.setVisible(false);
//        createGame.setVisible(false);
//        name.setVisible(false);
//        BorderPane.getMargin(play);
//
//        blueImage.setVisible(true);
//        yellowImage.setVisible(true);
//        redImage.setVisible(true);
//        greenImage.setVisible(true);
//        purpleImage.setVisible(true);
//    }

}
