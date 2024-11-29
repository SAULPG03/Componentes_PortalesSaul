package es.ieslosmontecillos.componentes_portalessaul.textfieldsample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CampoTextoNumerico extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);

        HBox hbox = new HBox();
        CustomCampoTextoNumerico campoTextoNumerico=new CustomCampoTextoNumerico();
        hbox.getChildren().add(campoTextoNumerico);
        scene.setRoot(hbox);
        stage.show();
    }

}
