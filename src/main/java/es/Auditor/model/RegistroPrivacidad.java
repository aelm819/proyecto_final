package es.auditor.model;

import java.time.LocalDateTime;

public class RegistroPrivacidad {
    // Atributos
    private int idRegistro;
    private LocalDateTime fechaHora;
    private String detalleDato;
    private NivelSensibilidad nivelSensibilidad;
    private Empresa empresa;

    // Constructor
    public RegistroPrivacidad(int idRegistro, LocalDateTime fechaHora, String detalleDato,
            NivelSensibilidad nivelSensibilidad, Empresa empresa) {
        this.idRegistro = idRegistro;
        this.fechaHora = fechaHora;
        this.detalleDato = detalleDato;
        this.nivelSensibilidad = nivelSensibilidad;
        this.empresa = empresa;
    }
    // Getters y Setters

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getDetalleDato() {
        return detalleDato;
    }

    public void setDetalleDato(String detalleDato) {
        this.detalleDato = detalleDato;
    }

    public NivelSensibilidad getNivelSensibilidad() {
        return nivelSensibilidad;
    }

    public void setNivelSensibilidad(NivelSensibilidad nivelSensibilidad) {
        this.nivelSensibilidad = nivelSensibilidad;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    // Métodos
    @Override
    public String toString() {
        return "RegistroPrivacidad [idRegistro=" + idRegistro + ", fechaHora=" + fechaHora + ", detalleDato="
                + detalleDato + ", nivelSensibilidad=" + nivelSensibilidad + ", empresa=" + empresa + "]";
    }

}
