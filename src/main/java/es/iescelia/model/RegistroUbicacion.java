package es.iescelia.model;

import java.time.LocalDateTime;

public class RegistroUbicacion extends RegistroPrivacidad {
    // Atributos
    private double latitud;
    private double longitud;

    // Constructor
    public RegistroUbicacion(int idRegistro, LocalDateTime fechaHora, String detalleDato,
            NivelSensibilidad nivelSensibilidad, Empresa empresa) {
        super(idRegistro, fechaHora, detalleDato, nivelSensibilidad, empresa);
        String[] partes = detalleDato.split(",");
        this.latitud = Double.parseDouble(partes[0].replace("Lat:", "").trim());
        this.longitud = Double.parseDouble(partes[1].replace(" Lon:", "").trim());
    }

    // Getters y Setters
    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    // Métodos
    @Override
    public String toString() {
        return "RegistroUbicacion [latitud=" + latitud + ", longitud=" + longitud + "]";
    }

}
