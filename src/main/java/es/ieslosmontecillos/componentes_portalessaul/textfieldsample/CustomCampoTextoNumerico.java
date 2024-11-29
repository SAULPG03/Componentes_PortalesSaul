package es.ieslosmontecillos.componentes_portalessaul.textfieldsample;

import javafx.scene.control.TextField;

public class CustomCampoTextoNumerico extends TextField {
    public CustomCampoTextoNumerico() {
        super();
        // Filtra para que solo se ingresen números
        this.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                setText(oldValue);  // Si no es un número, restaura el valor anterior
            }
        });
    }
}