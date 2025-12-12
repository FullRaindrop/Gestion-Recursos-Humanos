package utp.ac.pa.sistema.domain;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private String idDepartamento;
    private String nombre;
    private Empleado jefeDepartamento;
    private List<Empleado> empleados;

    public Departamento(String idDepartamento, String nombre) {
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public void asignarJefe(Empleado jefe) {
        this.jefeDepartamento = jefe;
    }

    public void agregarEmpleado(Empleado e) {
        if (e != null) this.empleados.add(e);
    }

    // getters / setters
    public String getIdDepartamento() { return idDepartamento; }
    public String getNombre() { return nombre; }
    public Empleado getJefeDepartamento() { return jefeDepartamento; }
    public List<Empleado> getEmpleados() { return empleados; }
}
