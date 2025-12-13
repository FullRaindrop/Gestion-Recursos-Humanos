package utp.ac.pa.sistema.domain;

public class Empleado {

    private String idEmpleado;
    private String nombre;
    private String email;
    private Empleado jefe;
    private String departamento;
    private String puesto;
    private Contrato contratoVigente;

    public Empleado(String idEmpleado, String nombre, String email) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.email = email;
    }

    public void asignarDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void asignarPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSalarioActual() {
        if (contratoVigente != null) return contratoVigente.getSalarioBase();
        return 0.0;
    }

    // Getters / Setters
    public String getIdEmpleado() { return idEmpleado; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public Empleado getJefe() { return jefe; }
    public String getDepartamento() { return departamento; }
    public String getPuesto() { return puesto; }
    public Contrato getContratoVigente() { return contratoVigente; }
    public void setContratoVigente(Contrato contratoVigente) { this.contratoVigente = contratoVigente; }
}
