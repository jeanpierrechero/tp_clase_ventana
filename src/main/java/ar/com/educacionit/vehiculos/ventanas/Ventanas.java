/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionit.vehiculos.ventanas;

/**
 *
 * @author Rodolfo Durante
 */
public enum Ventanas {

    VentanaPrincipal("ar/com/educacionit/vehiculos/presentacion/presentacion/ventanas/VentanaMaestra.fxml", "Administracion de Concesionaria"),
    AutosVentana("ar/com/educacionit/vehiculos/presentacion/presentacion/ventanas/AutosVentana.fxml", "Administracion de Autos"),
    VendedoresVentana("ar/com/educacionit/vehiculos/presentacion/presentacion/ventanas/VendedoresVentana.fxml", "Administracion de Vendedores"),
    CompradoresVentana("ar/com/educacionit/vehiculos/presentacion/presentacion/ventanas/CompradoresVentana.fxml", "Administracion de Compradores"),
    AutosEdicion("ar/com/educacionit/vehiculos/presentacion/presentacion/ventanas/AutosEdicion.fxml", "Edicion de Autos"),
    CompradoresEdicion("ar/com/educacionit/vehiculos/presentacion/presentacion/ventanas/CompradoresEdicion.fxml", "Edicion de Compradores"),
    VendedoresEdicion("ar/com/educacionit/vehiculos/presentacion/presentacion/ventanas/VendedoresEdicion.fxml", "Edicion de Vendedores"),
    ConfiguracionVentana("ar/com/educacionit/vehiculos/presentacion/presentacion/ventanas/ConfiguracionVentana.fxml", "Ventana de configuracion");

    private String path;
    private String title;
    private Boolean isopen;

    public String getPath() {
        return path;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getIsopen() {
        return isopen;
    }

    public void setIsopen(Boolean isopen) {
        this.isopen = isopen;
    }

    
    private Ventanas(String path, String title) {
        this.path = path;
        this.title = title;
        isopen = false;
    }
    
    

}
