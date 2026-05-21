package es.auditor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
// import java.time.LocalDateTime;
// import java.util.List;

// import es.auditor.dao.*;
// import es.auditor.model.*;
// import es.auditor.util.GestorArchivos;
/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("/es/auditor/view/vista_principal"), 1000, 680);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
        /* 
        System.out.println("Iniciando pruebas de DataFootprint Auditor...\n");

        // 1. Instanciar nuestros puentes (DAOs)
        DAO<Empresa> empresaDAO = new EmpresaDAO();
        DAO<RegistroPrivacidad> registroDAO = new RegistroDAO();

        // ==========================================
        // PRUEBA 1: CREAR Y GUARDAR UNA EMPRESA
        // ==========================================
        System.out.println("--- 1. GUARDANDO EMPRESA ---");
        Empresa miEmpresa = new Empresa("TechGlobal", "Desarrollo de Software");
        
        empresaDAO.insert(miEmpresa);


        // ==========================================
        // PRUEBA 2: CREAR Y GUARDAR REGISTROS
        // ==========================================
        System.out.println("\n--- 2. GUARDANDO REGISTROS DE AUDITORÍA ---");
        
        // Creamos una Ubicación
        RegistroUbicacion regUbicacion = new RegistroUbicacion(
            101,                             
            LocalDateTime.now(),             
            "Lat: 40.4168, Lon: -3.7038",  
            NivelSensibilidad.ALTO,         
            miEmpresa                       
        );

        // Creamos una Actividad
        RegistroActividad regActividad = new RegistroActividad(
            102,
            LocalDateTime.now(),
            "Accion: Login, Objetivo: Sistema",
            NivelSensibilidad.BAJO,
            miEmpresa
        );

        // Los guardamos usando el mismo método  
        registroDAO.insert(regUbicacion);
        registroDAO.insert(regActividad);


        // ==========================================
        // PRUEBA 3: LEER Y MOSTRAR LOS DATOS
        // ==========================================
        System.out.println("\n--- 3. LEYENDO REGISTROS DESDE MYSQL ---");
        
        List<RegistroPrivacidad> todosLosRegistros = registroDAO.findAll();
        
        for (RegistroPrivacidad registro : todosLosRegistros) {
            System.out.println("-> ID Registro: " + registro.getIdRegistro());
            System.out.println("   Detalle: " + registro.getDetalleDato());
            System.out.println("   Sensibilidad: " + registro.getNivelSensibilidad());
            
            // Usamos instanceof de nuevo para imprimir algo específico si queremos
            if (registro instanceof RegistroUbicacion) {
                System.out.println("   [TIPO: Ubicación Detectada]");
            } else if (registro instanceof RegistroActividad) {
                System.out.println("   [TIPO: Actividad Detectada]");
            }
            System.out.println("-----------------------------------");
            
            System.out.println("\n¡Pruebas finalizadas con éxito! ");
        }
        */
        
        
        // GestorArchivos gestor = new GestorArchivos();
        // gestor.importarDatos("src/main/resources/mock_data/google_mock_dataset.csv");
    }
    

}