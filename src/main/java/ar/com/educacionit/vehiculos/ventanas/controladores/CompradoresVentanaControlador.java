package ar.com.educacionit.vehiculos.ventanas.controladores;

import ar.com.educacionit.vehiculos.entidades.Auto;
import ar.com.educacionit.vehiculos.entidades.Comprador;
import ar.com.educacionit.vehiculos.util.AdministradorDeConexiones;
import ar.com.educacionit.vehiculos.ventanas.Ventanas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Rodolfo Durante
 */
public class CompradoresVentanaControlador extends ConcesionariaControlador implements Initializable {

    @FXML
    private Label lbl_nombre_valor, lbl_apellido_valor, lbl_documento_valor, lbl_presupuesto_valor;
    
    @FXML
    private Button btn_close;

    @FXML
    private Button btn_new;

    @FXML
    private Button btn_editar;
    
    @FXML
    private Button btn_borrar;
    
    @FXML
    private Button btn_edit;

    @FXML
    private Button btn_delete;
    
    @FXML
    private TableView<Comprador> tbl_compradores;
    
    @FXML
    private TableColumn<Comprador, String> clmn_nombre;

    @FXML
    private TableColumn<Comprador, String> clmn_documento;
    
    private ObservableList<Comprador> compradoresData = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btn_edit.setDisable(true);
        btn_delete.setDisable(true);
        
        // Initialize the person table with the two columns.
        clmn_nombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        clmn_documento.setCellValueFactory(cellData -> cellData.getValue().documentoProperty());

        // Listener para detectar el cambio de seleccion
        tbl_compradores.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> cargarCompradorSeleccionado(newValue));

        tbl_compradores.setItems(compradoresData);
        llenarTablaDeCompradores();

    }
    
    private void cargarCompradorSeleccionado(Comprador c) {
        if (c != null) {
            this.lbl_nombre_valor.setText(String.valueOf(c.getNombre()));
            this.lbl_apellido_valor.setText(String.valueOf(c.getApellido()));
            this.lbl_documento_valor.setText(String.valueOf(c.getNumeroDocumento()));
            this.lbl_presupuesto_valor.setText(String.valueOf(c.getPresupuesto()));
        } else {
            this.lbl_nombre_valor.setText("");
            this.lbl_apellido_valor.setText("");
            this.lbl_documento_valor.setText("");
            this.lbl_presupuesto_valor.setText("");
        }
        btn_edit.setDisable(false);
        btn_delete.setDisable(false);
    }
    
    private void llenarTablaDeCompradores() {
        try {
            // Obtiene la conexion
            Connection conn = AdministradorDeConexiones.getConnection();
            Comprador.obtenerTodos(conn).forEach(c -> compradoresData.add(c));
        } catch (Exception ex) {
            Logger.getLogger(AutosVentanaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    

    @FXML
    private void abrirEdicion(ActionEvent event) {
        Stage stage = (Stage) btn_close.getScene().getWindow();
        Comprador compradorNuevo = new Comprador();
        super.mainApp.mostrarVentanaModal(Ventanas.CompradoresEdicion, stage, compradorNuevo);
        
        if (compradorNuevo.estaModificado()) {
            try {
                Connection conn = AdministradorDeConexiones.getConnection();
                compradorNuevo.setId(compradorNuevo.insertar(conn));
                conn.close();
                compradoresData.add(compradorNuevo);
                tbl_compradores.getSelectionModel().select(compradorNuevo);
            } catch (Exception ex) {
                // Muestra el mensaje de error
                super.mostrarMensajeDeError("Error al conectarse con la base de datos", ex);
            }
        }
    }

    @FXML
    private void cerrarVentana(ActionEvent event) {
        Stage stage = (Stage) btn_close.getScene().getWindow();
        stage.close();
    }
    
    
}
