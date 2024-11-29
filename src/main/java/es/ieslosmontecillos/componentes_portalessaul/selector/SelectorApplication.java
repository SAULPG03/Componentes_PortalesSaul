package es.ieslosmontecillos.componentes_portalessaul.selector;

import es.ieslosmontecillos.componentes_portalessaul.SelectorDeslizamiento;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SelectorApplication extends Application {
    ArrayList<String>items=new ArrayList<String>();

    @Override
    public void start(Stage stage) throws IOException {
        String[]numeros={"uno","dos","tres","cuatro","cinco","seis","siete","ocho","nueve","diez"};
        items.addAll(List.of(numeros));
        BorderPane borderPane = new BorderPane();
        VBox vbox = new VBox();
        Label label = new Label();

        borderPane.setCenter(vbox);
        borderPane.setBottom(label);
        vbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(borderPane, 320, 240);
        SelectorDeslizamiento selec1 = new SelectorDeslizamiento();
        selec1.setItems(items);
        SelectorDeslizamiento selec2 = new SelectorDeslizamiento();
        selec2.setItems(items);

        selec1.setOnAction(event -> {
            label.setText("Pulsando selector de arriba");
            label.setTextFill(Paint.valueOf("red"));
        });
        selec2.setOnAction(event -> {
            label.setText("Pulsando selector de abajo");
            label.setTextFill(Paint.valueOf("green"));
        });
        Text text = new Text();

        stage.setTitle("Hello!");
        stage.setScene(scene);
        text.setText("Selectores");

        vbox.getChildren().addAll(text,selec1, selec2);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}