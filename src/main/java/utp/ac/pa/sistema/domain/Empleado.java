package utp.ac.pa.sistema.domain;

public class Empleado {
    private String idEmpleado;
    private String nombre;
    private String email;
    private Empleado jefe;
    private Departamento departamento;
    private Puesto puesto;
    private Contrato contratoVigente;

    public Empleado(String idEmpleado, String nombre, String email) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.email = email;
    }

    public void asignarDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public void asignarJefe(Empleado jefe) {
        this.jefe = jefe;
    }

    public double getSalarioActual() {
        if (contratoVigente != null) return contratoVigente.getSalarioBase();
        if (puesto != null) return puesto.getSalarioBaseReferencial();
        return 0.0;
    }

    // Getters / Setters
    public String getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(String idEmpleado) { this.idEmpleado = idEmpleado; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Empleado getJefe() { return jefe; }
    public Departamento getDepartamento() { return departamento; }
    public Puesto getPuesto() { return puesto; }
    public void setPuesto(Puesto puesto) { this.puesto = puesto; }
    public Contrato getContratoVigente() { return contratoVigente; }
    public void setContratoVigente(Contrato contratoVigente) { this.contratoVigente = contratoVigente; }

}
