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
        String[] partes = detalleDato.split(",");
        // this.accion = partes[0].replace("Accion:", "").trim();
        // this.objetivo = partes[1].replace("Objetivo:", "").trim();
        if (partes.length >= 2) {
            this.accion = partes[0].replace("Accion:", "").trim();
            this.objetivo = partes[1].replace("Objetivo:", "").trim();
        } else {
            // Plan de emergencia si la BD devuelve un texto antiguo o mal formateado
            this.accion = detalleDato.trim(); // Guardamos lo que haya en acción
            this.objetivo = "Desconocido"; // Valor por defecto para que no falle
            System.err.println("Advertencia: Formato incorrecto en BD para actividad: " + detalleDato);
        }
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
