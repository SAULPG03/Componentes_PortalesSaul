package es.ieslosmontecillos.componentes_portalessaul.temporizador;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TemporizadorApplication extends Application {
    @Override
    public void start(Stage stage) {
        Temporizador temporizador = new Temporizador(10); // Tiempo inicial: 10 segundos

        temporizador.setOnFinCuentaAtras(event -> {
            System.out.println("¡Tiempo finalizado!");
        });

        Scene scene = new Scene(temporizador, 300, 100);
        stage.setScene(scene);
        stage.setTitle("Temporizador");
        stage.show();

        temporizador.iniciar();
    }

    public static void main(String[] args) {
        launch();
    }
}
