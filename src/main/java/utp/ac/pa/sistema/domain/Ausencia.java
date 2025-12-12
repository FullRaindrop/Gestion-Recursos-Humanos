package utp.ac.pa.sistema.domain;

import java.time.LocalDate;

public class Ausencia {
    private String idAusencia;
    private Empleado empleado;
    private LocalDate fecha;
    private TipoAusencia tipoAusencia;
    private boolean justificada;

    public Ausencia(String idAusencia, Empleado empleado, LocalDate fecha, TipoAusencia tipoAusencia) {
        this.idAusencia = idAusencia;
        this.empleado = empleado;
        this.fecha = fecha;
        this.tipoAusencia = tipoAusencia;
        this.justificada = false;
    }

    public void justificar() { this.justificada = true; }

    // getters
    public String getIdAusencia() { return idAusencia; }
    public Empleado getEmpleado() { return empleado; }
    public LocalDate getFecha() { return fecha; }
    public TipoAusencia getTipoAusencia() { return tipoAusencia; }
    public boolean isJustificada() { return justificada; }
}
