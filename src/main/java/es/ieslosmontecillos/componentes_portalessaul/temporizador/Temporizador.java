package es.ieslosmontecillos.componentes_portalessaul.temporizador;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

import java.io.IOException;

public class Temporizador extends HBox {
    @FXML
    private Label label1=new Label();
    @FXML
    private Label label_tiempo=new Label();
    @FXML
    private Label label3=new Label();

    private int tiempo;
    private Timeline timeline;
    private EventHandler<ActionEvent> onFinCuentaAtras;

    public Temporizador(int tiempoInicial) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("temporizador.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Verifica si los nodos @FXML han sido inicializados correctamente
        if (label_tiempo == null) {
            throw new IllegalStateException("label_tiempo no está inicializado. Revisa el archivo FXML.");
        }

        this.tiempo = tiempoInicial;
        label_tiempo.setText(String.valueOf(tiempo));

        KeyFrame kf = new KeyFrame(Duration.seconds(1), e -> actualizarTiempo());
        timeline = new Timeline(kf);
        timeline.setCycleCount(Timeline.INDEFINITE);
    }

    public void iniciar() {
        timeline.play();
    }

    private void actualizarTiempo() {
        tiempo--;
        label_tiempo.setText(String.valueOf(tiempo));
        if (tiempo <= 0) {
            timeline.stop();
            if (onFinCuentaAtras != null) {
                onFinCuentaAtras.handle(new ActionEvent());
            }
        }
    }

    public void setOnFinCuentaAtras(EventHandler<ActionEvent> onFinCuentaAtras) {
        this.onFinCuentaAtras = onFinCuentaAtras;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
        label_tiempo.setText(String.valueOf(tiempo));
    }
}
