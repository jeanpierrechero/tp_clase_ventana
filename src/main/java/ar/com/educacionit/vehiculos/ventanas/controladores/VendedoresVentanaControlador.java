package ar.com.educacionit.vehiculos.ventanas.controladores;

import ar.com.educacionit.vehiculos.ventanas.Ventanas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author Rodolfo Durante
 */
public class VendedoresVentanaControlador extends ConcesionariaControlador implements Initializable {

    @FXML
    private Button btn_close;

    @FXML
    private Button btn_new;

    @FXML
    private Button btn_edit;

    @FXML
    private Button btn_delete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btn_edit.setDisable(true);
        btn_delete.setDisable(true);
    }

    @FXML
    private void abrirEdicion(ActionEvent event) {
        Stage stage = (Stage) btn_close.getScene().getWindow();
        super.mainApp.mostrarVentanaModal(Ventanas.VendedoresEdicion, stage, null);
    }

    @FXML
    private void cerrarVentana(ActionEvent event) {
        Stage stage = (Stage) btn_close.getScene().getWindow();
        stage.close();
    }
}
