package utp.ac.pa.sistema.domain;

import java.time.LocalDate;

public class Evaluacion {
    private String idEvaluacion;
    private Empleado empleado;
    private double puntaje;
    private String comentarios;
    private LocalDate fecha;

    public Evaluacion(String idEvaluacion, Empleado empleado, double puntaje, String comentarios, LocalDate fecha) {
        this.idEvaluacion = idEvaluacion;
        this.empleado = empleado;
        this.puntaje = puntaje;
        this.comentarios = comentarios;
        this.fecha = fecha;
    }

    // getters / setters
    public String getIdEvaluacion() { return idEvaluacion; }
    public Empleado getEmpleado() { return empleado; }
    public double getPuntaje() { return puntaje; }
    public String getComentarios() { return comentarios; }
    public LocalDate getFecha() { return fecha; }
}

