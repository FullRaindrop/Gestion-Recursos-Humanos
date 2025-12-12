package utp.ac.pa.sistema.domain;

import java.util.Objects;

public class Usuario {
    private String nombreUsuario;
    private String contraseña;
    private Rol rol;
    private Empleado empleado; // opcional: usuario vinculado a empleado

    public Usuario(String nombreUsuario, String contraseña, Rol rol) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    public Usuario(String nombreUsuario, String contraseña, Rol rol, Empleado empleado) {
        this(nombreUsuario, contraseña, rol);
        this.empleado = empleado;
    }

    public boolean autenticar(String contraseña) {
        return Objects.equals(this.contraseña, contraseña);
    }

    public void cambiarContraseña(String nueva) {
        this.contraseña = nueva;
    }

    // getters / setters
    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }
    public String getContraseña() { return contraseña; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }
    public Rol getRol() { return rol; }
    public void setRol(Rol rol) { this.rol = rol; }
    public Empleado getEmpleado() { return empleado; }
    public void setEmpleado(Empleado empleado) { this.empleado = empleado; }
}
