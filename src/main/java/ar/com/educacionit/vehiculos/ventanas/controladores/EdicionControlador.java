/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionit.vehiculos.ventanas.controladores;

import ar.com.educacionit.vehiculos.util.CONSTANTES;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Rodolfo Durante
 */
public abstract class EdicionControlador extends ConcesionariaControlador implements Initializable {

    private List<Control> campos;

    public EdicionControlador() {
        this.campos = new ArrayList<>();
    }

    public abstract void setearEntidad(Object entidad);

    protected void agregarCampoNumerico(Control field) {
        agregarCampo(field);
        validacionNumerica(field);
    }

    protected void agregarCampo(Control field) {
        this.campos.add(field);
    }

    protected boolean validarCampos() {
        for (Control campo : campos) {
            if (campo instanceof TextField) {
                TextField c = (TextField) campo;
                if (c.getText().isEmpty()) {
                    validacionFalla(campo);
                    return false;
                }
            }
            if (campo instanceof TextArea) {
                TextArea c = (TextArea) campo;
                if (c.getText().isEmpty()) {
                    validacionFalla(campo);
                    return false;
                }
            }
            if (campo instanceof ComboBox) {
                ComboBox c = (ComboBox) campo;
                if (c.getValue().equals(CONSTANTES.COMBO_SIN_SELECCION.toString())) {
                    validacionFalla(campo);
                    return false;
                }
            }
        }
        return validacionOk();
    }

    private boolean validacionOk() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmacion");
        alert.setHeaderText("Esta a punto de guardar los cambios...");
        alert.setContentText("desea continuar?");
        Optional<ButtonType> result = alert.showAndWait();
        return (result.get() == ButtonType.OK);
    }

    private void validacionFalla(Control control) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Datos incompletos");
        alert.setHeaderText("Por favor complete todos los campos");
        alert.setContentText("El campo " + control.getTooltip().getText() + " no puede estar vacio.");
        alert.showAndWait();
        control.requestFocus();
    }

    private void validacionNumerica(Control control) {
        if (control instanceof TextField) {
            TextField c = (TextField) control;
            c.setPromptText("Solo números");
            c.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(final ObservableValue<? extends String> observable, final String oldValue, final String newValue) {
                    try {
                        Double.parseDouble(newValue);
                    } catch (Exception e) {
                        c.clear();
                    }
                }
            });
        }
    }
}
