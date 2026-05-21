package es.auditor.controller;

import java.io.*;

import es.auditor.util.GestorArchivos;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
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
        try {
            // Cambia "tu_archivo.fxml" por el nombre real de tu vista
            // System.out.println("Buscando FXML en: " + getClass().getResource("/es/auditor/view/vista_explorador.fxml"));
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/es/auditor/view/vista_explorador.fxml"));
            Parent node = fxmlLoader.load();
            areaCentral.getChildren().setAll(node);
        } catch (IOException e) {
            e.printStackTrace();
            mostrarAlerta(Alert.AlertType.ERROR, "Error de Sistema",
                    "No se ha podido cargar la pantalla del explorador.");
        }
    }

    @FXML
    public void mostrarMapa() {

    }

    @FXML
    public void generarInforme() {

    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null); // Lo ponemos a null para que el diseño quede más limpio
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

}
