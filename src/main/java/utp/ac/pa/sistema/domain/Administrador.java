package utp.ac.pa.sistema.domain;

public class Administrador {
    private String idAdmin;
    private String nombre;

    public Administrador(String idAdmin, String nombre) {
        this.idAdmin = idAdmin;
        this.nombre = nombre;
    }

    public Empleado crearEmpleado(String id, String nombre, String email) {
        return new Empleado(id, nombre, email);
    }

    public Administrador crearAdministrador(String id, String nombre) {
        return new Administrador(id, nombre);
    }

    // getters
    public String getIdAdmin() { return idAdmin; }
    public String getNombre() { return nombre; }
}
