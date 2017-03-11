/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionit.vehiculos.ventanas.controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author Rodolfo Durante
 */
public class ConfiguracionVentanaController extends ConcesionariaControlador implements Initializable {

    @FXML
    private TextField fld_version;
    @FXML
    private TextField fld_sistema;
    @FXML
    private TextField fld_usuario;
    @FXML
    private TextField fld_java;

    @FXML
    private Button btn_close;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        fld_sistema.setEditable(false);
        fld_sistema.setText(System.getProperty("os.name"));
        fld_version.setEditable(false);
        fld_version.setText(System.getProperty("os.version"));
        fld_usuario.setEditable(false);
        fld_usuario.setText(System.getProperty("user.name"));
        fld_java.setEditable(false);
        fld_java.setText(System.getProperty("java.version"));
    }

    @FXML
    private void cerrarVentana(ActionEvent event) {
        Stage stage = (Stage) btn_close.getScene().getWindow();
        stage.close();
    }
}
