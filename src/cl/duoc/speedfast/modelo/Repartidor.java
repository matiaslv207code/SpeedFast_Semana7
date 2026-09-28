package cl.duoc.speedfast.modelo;

public class Repartidor {
    // atributos del repartidor
    private int id;
    private String nombre;

    // constructor vacio
    public Repartidor() {}

    // constructor con parametros sin id
    public Repartidor(String nombre) {
        this.nombre = nombre;
    }

    // constructor completo con id
    public Repartidor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}