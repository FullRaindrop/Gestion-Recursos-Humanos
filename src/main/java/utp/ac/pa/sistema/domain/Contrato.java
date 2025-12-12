package utp.ac.pa.sistema.domain;

import java.time.LocalDate;

public class Contrato {
    private String idContrato;
    private Empleado empleado;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private TipoContrato tipoContrato;
    private double salarioBase;

    public Contrato(String idContrato, Empleado empleado, LocalDate fechaInicio, LocalDate fechaFin, TipoContrato tipoContrato, double salarioBase) {
        this.idContrato = idContrato;
        this.empleado = empleado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tipoContrato = tipoContrato;
        this.salarioBase = salarioBase;
    }

    public boolean esVigente() {
        LocalDate hoy = LocalDate.now();
        boolean despuesInicio = !hoy.isBefore(fechaInicio);
        boolean antesFin = fechaFin == null || !hoy.isAfter(fechaFin);
        return despuesInicio && antesFin;
    }

    // getters / setters
    public String getIdContrato() { return idContrato; }
    public Empleado getEmpleado() { return empleado; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public TipoContrato getTipoContrato() { return tipoContrato; }
    public double getSalarioBase() { return salarioBase; }
    public void setSalarioBase(double salarioBase) { this.salarioBase = salarioBase; }
}
