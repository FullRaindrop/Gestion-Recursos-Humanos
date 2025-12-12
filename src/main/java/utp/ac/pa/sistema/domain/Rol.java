package utp.ac.pa.sistema.domain;

import java.util.List;

public class Rol {
    private String nombreRol;
    private List<String> permisos;

    public Rol(String nombreRol, List<String> permisos) {
        this.nombreRol = nombreRol;
        this.permisos = permisos;
    }

    public boolean tienePermiso(String accion) {
        return permisos != null && permisos.contains(accion);
    }

    public String getNombreRol() { return nombreRol; }
    public void setNombreRol(String nombreRol) { this.nombreRol = nombreRol; }
    public List<String> getPermisos() { return permisos; }
    public void setPermisos(List<String> permisos) { this.permisos = permisos; }
}
