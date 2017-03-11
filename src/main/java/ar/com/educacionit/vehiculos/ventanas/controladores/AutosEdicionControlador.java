/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionit.vehiculos.ventanas.controladores;

import ar.com.educacionit.base.util.LectorDeArchivos;
import ar.com.educacionit.vehiculos.entidades.Auto;
import ar.com.educacionit.vehiculos.util.CONSTANTES;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author Rodolfo Durante
 */
public class AutosEdicionControlador extends EdicionControlador {

    @FXML
    private TextField fld_alto;
    @FXML
    private TextField fld_largo;
    @FXML
    private TextField fld_ancho;
    @FXML
    private TextField fld_precio;
    @FXML
    private ComboBox<String> cmb_marca;
    @FXML
    private ComboBox<String> cmb_modelo;
    @FXML
    private ComboBox<String> cmb_color;
    @FXML
    private TextArea txt_equipamiento;
    @FXML
    private Button btn_ok;
    @FXML
    private Button btn_cancel;

    private Auto auto;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fld_alto.setTooltip(new Tooltip("Alto"));
        fld_largo.setTooltip(new Tooltip("Largo"));
        fld_ancho.setTooltip(new Tooltip("Ancho"));
        cmb_marca.setTooltip(new Tooltip("Marca"));
        cmb_modelo.setTooltip(new Tooltip("Modelo"));
        cmb_color.setTooltip(new Tooltip("Color"));
        fld_precio.setTooltip(new Tooltip("Precio"));
        txt_equipamiento.setTooltip(new Tooltip("Equipamiento"));

        agregarCampoNumerico(fld_alto);
        agregarCampoNumerico(fld_largo);
        agregarCampoNumerico(fld_ancho);
        agregarCampo(cmb_marca);
        agregarCampo(cmb_modelo);
        agregarCampo(cmb_color);
        agregarCampoNumerico(fld_precio);
        agregarCampo(txt_equipamiento);
        cargarMarcas();
        cargarModelos();
        cargarColores();
    }

    @FXML
    private void btnOkPresionado(ActionEvent event) {
        boolean ok = validarCampos();
        if (ok) {
            this.auto.setAltura(new Integer(fld_alto.getText()));
            this.auto.setAncho(new Integer(fld_ancho.getText()));
            this.auto.setLargo(new Integer(fld_largo.getText()));
            this.auto.setMarca(cmb_marca.getSelectionModel().getSelectedItem());
            this.auto.setModelo(cmb_modelo.getSelectionModel().getSelectedItem());
            this.auto.setColor(cmb_color.getSelectionModel().getSelectedItem());
            this.auto.setPrecio(new Double(fld_precio.getText()));
            this.auto.setEquipamiento(txt_equipamiento.getText());
            this.auto.setModificado();
            cerrarVentana(event);
        }
    }

    @FXML
    private void cerrarVentana(ActionEvent event) {
        Stage stage = (Stage) btn_cancel.getScene().getWindow();
        stage.close();
    }

    private void cargarColores() {
        //  Obtiene la ubicacion del archivo colores.txt
        String ubicacion = CONSTANTES.UBICACION_RECURSOS + "colores.txt";
        try {
            // Obtiene los colores como un vector
            List colores = LectorDeArchivos.obtenerContenidoDeArchivoComoVector(ubicacion);
            Iterator itColores = colores.iterator();
            // Agrega la opcion "Seleccione..."
            cmb_color.getItems().add(CONSTANTES.COMBO_SIN_SELECCION.toString());
            // Carga los colores
            while (itColores.hasNext()) {
                // Obtiene el color
                String c = (String) itColores.next();
                // Agrega el color al combo
                cmb_color.getItems().add(c);
            }
            cmb_color.setValue(CONSTANTES.COMBO_SIN_SELECCION.toString());

        } catch (Exception e) {
            // Muestra el mensaje de error
            mostrarMensajeDeError("Error al cargar las colores!", e);
        }
    }

    private void cargarModelos() {
        // Agrega la opcion "Seleccione..."
        cmb_modelo.getItems().add(CONSTANTES.COMBO_SIN_SELECCION.toString());
        // Carga el combo con los modelos
        for (int i = 1985; i <= 2015; i++) {
            cmb_modelo.getItems().add(String.valueOf(i));
        }
        cmb_modelo.setValue(CONSTANTES.COMBO_SIN_SELECCION.toString());
    }

    private void cargarMarcas() {
        //  Obtiene la ubicacion del archivo marcas.txt
        String ubicacion = CONSTANTES.UBICACION_RECURSOS + "marcas.txt";
        try {
            // Obtiene las marcas como un vector
            List marcas = LectorDeArchivos.obtenerContenidoDeArchivoComoVector(ubicacion);
            Iterator itMarcas = marcas.iterator();
            // Agrega la opcion "Seleccione..."
            cmb_marca.getItems().add(CONSTANTES.COMBO_SIN_SELECCION.toString());
            // Carga las marcas
            while (itMarcas.hasNext()) {
                // Obtiene la marca
                String m = (String) itMarcas.next();
                // Agrega la marca al combo
                cmb_marca.getItems().add(m);
            }
            cmb_marca.setValue(CONSTANTES.COMBO_SIN_SELECCION.toString());
        } catch (Exception e) {
            // Muestra el mensaje de error
            mostrarMensajeDeError("Error al cargar las marcas!", e);
        }
    }

    @Override
    public void setearEntidad(Object entidad) {
        Auto a = (Auto) entidad;
        this.auto = a;
        if (a.getId() != null) {
            fld_alto.setText(String.valueOf(a.getAltura()));
            fld_ancho.setText(String.valueOf(a.getAncho()));
            fld_largo.setText(String.valueOf(a.getLargo()));
            cmb_marca.setValue(a.getMarca());
            cmb_modelo.setValue(a.getModelo());
            cmb_color.setValue(a.getColor());
            fld_precio.setText(String.valueOf(a.getPrecio()));
            txt_equipamiento.setText(a.getEquipamiento());
        }
    }
}
