package es.iescelia.model;

public class Empresa {
    private int id;
    private String nombre;
    private String sector;

    // Constructors
    public Empresa(int id, String nombre, String sector) {
        this.id = id;
        this.nombre = nombre;
        this.sector = sector;
    }

    // Getters Y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    // Métodos
    @Override
    public String toString() {
        return "Empresa [id=" + id + ", nombre=" + nombre + ", sector=" + sector + "]";
    }

}
