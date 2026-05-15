package es.iescelia.model;

import java.time.LocalDateTime;

public class RegistroActividad extends RegistroPrivacidad {
    // Atributos
    private String accion; 
    private String objetivo;
    
    // Constructor
    public RegistroActividad(int idRegistro, LocalDateTime fechaHora, String detalleDato,
            NivelSensibilidad nivelSensibilidad, Empresa empresa) {
        super(idRegistro, fechaHora, detalleDato, nivelSensibilidad, empresa);
        String[] partes = detalleDato.split(":");
        this.accion = partes[0].trim();
        this.objetivo = partes[1].trim();
    }

    // G y S
    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    // Métodos
    @Override
    public String toString() {
        return "RegistroActividad [accion=" + accion + ", objetivo=" + objetivo + "]";
    }

    
}
