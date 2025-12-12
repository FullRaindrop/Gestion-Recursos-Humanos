package utp.ac.pa.sistema.domain;

public class BalanceVacaciones {
    private Empleado empleado;
    private int año;
    private int diasAcumulados;
    private int diasTomados;

    public BalanceVacaciones(Empleado empleado, int año, int diasAcumulados, int diasTomados) {
        this.empleado = empleado;
        this.año = año;
        this.diasAcumulados = diasAcumulados;
        this.diasTomados = diasTomados;
    }

    public void aprobarVacaciones() {
        // placeholder: marcar aprobado o integrar con SolicitudVacacion
    }

    public int diasDisponibles() {
        return diasAcumulados - diasTomados;
    }

    public void restarDias(int cantidad) {
        this.diasTomados += cantidad;
    }

    // getters
    public Empleado getEmpleado() { return empleado; }
    public int getAño() { return año; }
}

