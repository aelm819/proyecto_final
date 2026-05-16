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

        if (partes.length >= 2) {
            try {

                this.latitud = Double.parseDouble(partes[0].replace("Lat:", "").trim());
                this.longitud = Double.parseDouble(partes[1].replace("Lon:", "").replace("Lon :", "").trim());

            } catch (NumberFormatException e) {
                // Plan de emergencia A: Había coma, pero el texto no era un número
                this.latitud = 0.0;
                this.longitud = 0.0;
                System.err.println("Advertencia: Las coordenadas no son numéricas en: " + detalleDato);
            }
        } else {
            // Plan de emergencia B: No había coma en absoluto (formato antiguo)
            this.latitud = 0.0;
            this.longitud = 0.0;
            System.err.println("Advertencia: Formato de ubicación incorrecto en BD: " + detalleDato);
        }
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
