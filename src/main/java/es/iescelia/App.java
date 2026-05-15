package es.iescelia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import es.iescelia.dao.*;
import es.iescelia.model.*;
/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
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
        // launch();
        System.out.println("Iniciando pruebas de DataFootprint Auditor...\n");

        // 1. Instanciar nuestros puentes (DAOs)
        // Usamos la interfaz DAO en la declaración por buenas prácticas (Polimorfismo)
        DAO<Empresa> empresaDAO = new EmpresaDAO();
        DAO<RegistroPrivacidad> registroDAO = new RegistroPrivacidadDAO();

        // ==========================================
        // PRUEBA 1: CREAR Y GUARDAR UNA EMPRESA
        // ==========================================
        System.out.println("--- 1. GUARDANDO EMPRESA ---");
        // Nota: Asumo que tu constructor pide (id, nombre, sector). 
        // Si el ID es autoincremental en MySQL, no hará falta pasarlo aquí.
        Empresa miEmpresa = new Empresa(1, "TechGlobal", "Desarrollo de Software");
        
        empresaDAO.insert(miEmpresa);


        // ==========================================
        // PRUEBA 2: CREAR Y GUARDAR REGISTROS
        // ==========================================
        System.out.println("\n--- 2. GUARDANDO REGISTROS DE AUDITORÍA ---");
        
        // Creamos una Ubicación
        RegistroUbicacion regUbicacion = new RegistroUbicacion(
            101,                            // ID del registro
            LocalDateTime.now(),            // Fecha y hora actual
            "Lat: 40.4168, Lon: -3.7038", // Detalle
            NivelSensibilidad.ALTO,         // Enum de sensibilidad
            miEmpresa                       // Objeto empresa anidado
        );

        // Creamos una Actividad
        RegistroActividad regActividad = new RegistroActividad(
            102,
            LocalDateTime.now(),
            "Accion: Login, Objetivo: Comprar",
            NivelSensibilidad.BAJO,
            miEmpresa
        );

        // Los guardamos usando el mismo método (¡Magia del Polimorfismo!)
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
        }
        
        System.out.println("\n¡Pruebas finalizadas con éxito! ");
    }
    

}