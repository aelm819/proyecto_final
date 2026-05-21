package es.auditor.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class MainController {

    // Botones del menú lateral
    @FXML
    private Button btnDashboard;
    
    @FXML
    private Button btnExplorador;
    
    @FXML
    private Button btnMapa;
    
    @FXML
    private Button btnImportar;
    
    @FXML
    private Button btnExportar;

    // Nuestro contenedor dinámico (el "lienzo")
    @FXML
    private StackPane areaCentral; 

     
    @FXML
    public void initialize() {
        System.out.println("Interfaz principal cargada correctamente.");
         
    }
}
