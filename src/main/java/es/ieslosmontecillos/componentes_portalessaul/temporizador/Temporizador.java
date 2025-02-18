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

/**
 * La clase Temporizador es un componente de JavaFX que muestra un temporizador en pantalla.
 * Cuenta con tres etiquetas para mostrar "Tiempo restante", el tiempo restante actual,
 * y una "s" para indicar segundos.
 */
public class Temporizador extends HBox {
    /**
     * Etiqueta que muestra el texto "Tiempo restante".
     */
    @FXML
    private Label label1 = new Label();

    /**
     * Etiqueta que muestra el tiempo restante actual.
     */
    @FXML
    private Label label_tiempo = new Label();

    /**
     * Etiqueta que muestra el texto "s" para indicar segundos.
     */
    @FXML
    private Label label3 = new Label();

    private int tiempo;
    private Timeline timeline;
    private EventHandler<ActionEvent> onFinCuentaAtras;

    /**
     * Constructor de la clase Temporizador.
     *
     * @param tiempoInicial El tiempo inicial en segundos.
     */
    public Temporizador(int tiempoInicial) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("temporizador.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (label_tiempo == null) {
            throw new IllegalStateException("label_tiempo no está inicializado. Revisa el archivo FXML.");
        }

        this.tiempo = tiempoInicial;
        label_tiempo.setText(String.valueOf(tiempo));

        KeyFrame kf = new KeyFrame(Duration.seconds(1), e -> actualizarTiempo());
        timeline = new Timeline(kf);
        timeline.setCycleCount(Timeline.INDEFINITE);
    }

    /**
     * Inicia la cuenta regresiva del temporizador.
     */
    public void iniciar() {
        timeline.play();
    }

    /**
     * Actualiza el tiempo restante en el temporizador y verifica si ha llegado a cero.
     */
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

    /**
     * Establece el controlador de evento que se ejecutará al finalizar la cuenta regresiva.
     *
     * @param onFinCuentaAtras El controlador de evento.
     */
    public void setOnFinCuentaAtras(EventHandler<ActionEvent> onFinCuentaAtras) {
        this.onFinCuentaAtras = onFinCuentaAtras;
    }

    /**
     * Obtiene el tiempo restante actual.
     *
     * @return El tiempo restante en segundos.
     */
    public int getTiempo() {
        return tiempo;
    }

    /**
     * Establece el tiempo restante y actualiza la etiqueta del tiempo.
     *
     * @param tiempo El nuevo tiempo en segundos.
     */
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
        label_tiempo.setText(String.valueOf(tiempo));
    }
}

