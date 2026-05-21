package es.auditor.controller;

import java.io.*;

import es.auditor.util.GestorArchivos;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;

public class MainController {

    // Nuestro contenedor dinámico (el "lienzo")
    @FXML
    private StackPane areaCentral; 

     
    @FXML
    public void initialize() {
        System.out.println("Interfaz principal cargada correctamente.");
         
    }

    @FXML
    public void abrirExploradorArchivos() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Seleccionar archivo CSV");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos CSV", "*.csv"));

        File archivoSeleccionado = fc.showOpenDialog(null);

        if (archivoSeleccionado != null) {
            String ruta = archivoSeleccionado.getAbsolutePath();
            GestorArchivos ga = new GestorArchivos();
            ga.importarDatos(ruta);
        } 

    }

    @FXML
    public void mostrarDashboard() {
        
    }
    @FXML
    public void mostrarExplorador() {

    }
    @FXML
    public void mostrarMapa() {

    }
    @FXML
    public void generarInforme() {

    }



}
