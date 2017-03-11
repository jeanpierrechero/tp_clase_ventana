package ar.com.educacionit.vehiculos.ventanas.controladores;

import ar.com.educacionit.vehiculos.ventanas.Ventanas;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author Rodolfo Durante
 */
public class VentanaMaestraControlador extends ConcesionariaControlador implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void abrirVentanaAutos(ActionEvent event) {
        super.mainApp.mostrarVentanaInterna(Ventanas.AutosVentana);
    }

    @FXML
    private void abrirVentanaVendedores(ActionEvent event) {
        super.mainApp.mostrarVentanaInterna(Ventanas.VendedoresVentana);
    }

    @FXML
    private void abrirVentanaCompradores(ActionEvent event) {
        super.mainApp.mostrarVentanaInterna(Ventanas.CompradoresVentana);
    }

    @FXML
    private void abrirVentanaConfiguracion(ActionEvent event) {
        super.mainApp.mostrarVentanaInterna(Ventanas.ConfiguracionVentana);
    }
    
    @FXML
    private void salir(ActionEvent event) {
        Platform.exit();
    }

}
