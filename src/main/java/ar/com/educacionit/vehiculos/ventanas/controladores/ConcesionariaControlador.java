/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionit.vehiculos.ventanas.controladores;

import ar.com.educacionit.vehiculos.aplicacion.APPConcesionaria;
import javafx.scene.control.Alert;

/**
 *
 * @author Rodolfo Durante
 */
public abstract class ConcesionariaControlador {

    protected APPConcesionaria mainApp;

    public void setMainApp(APPConcesionaria runner) {
        this.mainApp = runner;
    }

    public void mostrarMensajeDeError(String error, Exception ex) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(error);
        alert.setContentText("ERROR: " + ex.getMessage());
        alert.showAndWait();
    }
}
