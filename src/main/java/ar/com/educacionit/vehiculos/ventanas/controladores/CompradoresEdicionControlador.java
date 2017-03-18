/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionit.vehiculos.ventanas.controladores;

import ar.com.educacionit.vehiculos.entidades.Comprador;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

/**
 * FXML Controller class
 *
 * @author Rodolfo Durante
 */
public class CompradoresEdicionControlador extends EdicionControlador implements Initializable {
    
    @FXML
    private Button btn_cancel;
    
    @FXML
    private TextField fld_nombre;
    
    @FXML
    private TextField fld_apellido;
    
    @FXML
    private TextField fld_documento;
    
    @FXML
    private TextField fld_presupuesto;
    
    private Comprador comprador;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fld_nombre.setTooltip(new Tooltip("Nombre"));
        fld_apellido.setTooltip(new Tooltip("Apellido"));
        fld_documento.setTooltip(new Tooltip("Documento"));
        fld_presupuesto.setTooltip(new Tooltip("Presupuesto"));
        
    }    

    @FXML
    private void cerrarVentana(ActionEvent event) {
        Stage stage = (Stage) btn_cancel.getScene().getWindow();
        stage.close();
    }

    @Override
    public void setearEntidad(Object entidad) {
    
        Comprador c = (Comprador) entidad;
        this.comprador = c;
        if (c.getId() != null) {
            fld_nombre.setText(String.valueOf(c.getNombre()));
            fld_apellido.setText(String.valueOf(c.getApellido()));
            fld_documento.setText(String.valueOf(c.getNumeroDocumento()));
            fld_presupuesto.setText(String.valueOf(c.getPresupuesto()));
        }
    }
    
    @FXML
    private void btnOkPresionado(ActionEvent event) {
        boolean ok = validarCampos();
        if (ok) {
            this.comprador.setNombre(fld_nombre.getText());
            this.comprador.setApellido(fld_apellido.getText());
            this.comprador.setNumeroDocumento(fld_documento.getText());
            this.comprador.setPresupuesto(Double.valueOf(fld_presupuesto.getText()));
            this.comprador.setModificado();
            cerrarVentana(event);
        }
    }
    
}
