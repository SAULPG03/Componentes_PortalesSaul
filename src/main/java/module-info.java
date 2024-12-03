module es.ieslosmontecillos.componentes_portalessaul {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ieslosmontecillos.componentes_portalessaul to javafx.fxml;
    exports es.ieslosmontecillos.componentes_portalessaul.selector;
    exports es.ieslosmontecillos.componentes_portalessaul.textfieldsample;
    exports es.ieslosmontecillos.componentes_portalessaul.temporizador;

    opens es.ieslosmontecillos.componentes_portalessaul.selector to javafx.fxml;
    exports es.ieslosmontecillos.componentes_portalessaul;
}