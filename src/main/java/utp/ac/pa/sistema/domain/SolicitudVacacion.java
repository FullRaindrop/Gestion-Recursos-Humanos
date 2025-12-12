package utp.ac.pa.sistema.domain;

import java.time.LocalDate;

public class SolicitudVacacion {
    private String idSolicitud;
    private Empleado empleado;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int diasSolicitados;
    private EstadoSolicitud estado;

    public SolicitudVacacion(String idSolicitud, Empleado empleado, LocalDate fechaInicio, LocalDate fechaFin, int diasSolicitados) {
        this.idSolicitud = idSolicitud;
        this.empleado = empleado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.diasSolicitados = diasSolicitados;
        this.estado = EstadoSolicitud.PENDIENTE;
    }

    public void aprobar() { this.estado = EstadoSolicitud.APROBADA; }
    public void rechazar() { this.estado = EstadoSolicitud.RECHAZADA; }

    // getters / setters
    public String getIdSolicitud() { return idSolicitud; }
    public Empleado getEmpleado() { return empleado; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public int getDiasSolicitados() { return diasSolicitados; }
    public EstadoSolicitud getEstado() { return estado; }
}
