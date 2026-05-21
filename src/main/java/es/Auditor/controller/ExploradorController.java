package es.auditor.controller;

import java.time.LocalDateTime;
import java.util.List;

import es.auditor.dao.*;
import es.auditor.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.*;
import javafx.event.ActionEvent;

public class ExploradorController {
    @FXML
    private TextField txtFiltroEmpresa;
    @FXML
    private TableView<RegistroPrivacidad> tablaRegistros;
    @FXML
    private TableColumn<RegistroPrivacidad, String> colEmpresa;
    @FXML
    private TableColumn<RegistroPrivacidad, Integer> colId;
    @FXML
    private TableColumn<RegistroPrivacidad, String> colTipo;
    @FXML
    private TableColumn<RegistroPrivacidad, LocalDateTime> colFecha;
    @FXML
    private TableColumn<RegistroPrivacidad, String> colDetalle;
    @FXML
    private TableColumn<RegistroPrivacidad, NivelSensibilidad> colSensibilidad;

    DAO<RegistroPrivacidad> registroDAO = new RegistroDAO();

    @FXML
    public void initialize() {
        // colEmpresa.setCellValueFactory(new PropertyValueFactory<>("empresa"));
        colEmpresa.setCellValueFactory(cellData -> {
            // 1. Obtenemos el registro de esa fila
            RegistroPrivacidad registro = cellData.getValue();

            // 2. Comprobamos que tenga una empresa asociada para evitar errores
            if (registro != null && registro.getEmpresa() != null) {
                String nombre = registro.getEmpresa().getNombre();
                return new javafx.beans.property.SimpleStringProperty(nombre);
            } else {
                return new SimpleStringProperty("Desconocida");
            }
        });

        colId.setCellValueFactory(new PropertyValueFactory<>("idRegistro"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fechaHora"));
        colDetalle.setCellValueFactory(new PropertyValueFactory<>("detalleDato"));
        colSensibilidad.setCellValueFactory(new PropertyValueFactory<>("nivelSensibilidad"));
        colTipo.setCellValueFactory(cellData -> {
            RegistroPrivacidad registro = cellData.getValue();

            if (registro instanceof RegistroUbicacion) {
                return new SimpleStringProperty("UBICACIÓN");
            } else if (registro instanceof RegistroActividad) {
                return new SimpleStringProperty("ACTIVIDAD");
            }
            return new SimpleStringProperty("DESCONOCIDO");
        });

        List<RegistroPrivacidad> todosLosRegistros = registroDAO.findAll();

        ObservableList<RegistroPrivacidad> listaObservable = FXCollections.observableArrayList(todosLosRegistros);

        tablaRegistros.setItems(listaObservable);
    }

    @FXML
    public void anadirEvento() {
        System.out.println("¡El botón ha sido pulsado con éxito!");

    }

    public void actualizarSensibilidad() {
        System.out.println("¡El botón ha sido pulsado con éxito!");

    }

    public void borrarRegistro() {
        System.out.println("¡El botón ha sido pulsado con éxito!");

    }
}
