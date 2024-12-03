package es.ieslosmontecillos.componentes_portalessaul.temporizador;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

public class Temporizador extends HBox {
    @FXML
    Label label1;
    @FXML
    Label label_tiempo;
    @FXML
    Label label3;
    private int tiempo;
    private Timeline timeline;
    private EventHandler<ActionEvent> onFinCuentaAtras;

    public Temporizador(Label label_tiempo, int tiempo_inicial) {
        this.label1.setText( "Tiempo Transcurrido: ");
        this.label3.setText( " s");
        this.label_tiempo = label_tiempo;
        this.tiempo = tiempo_inicial;
        this.label_tiempo.setText(String.valueOf(tiempo));

        KeyFrame kf = new KeyFrame(Duration.seconds(1), e -> actualizar_tiempo());
        timeline = new Timeline(kf);
        timeline.setCycleCount(Timeline.INDEFINITE);

    }

    public void iniciar() {
        timeline.play();
    }

    public void actualizar_tiempo(){
        tiempo--;
        label_tiempo.setText(String.valueOf(tiempo));
        if(tiempo<=0){
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
