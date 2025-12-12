package utp.ac.pa.sistema.domain;

import java.time.LocalDate;
import java.util.List;

public class Reporte {
    private String idReporte;
    private String tipo;
    private LocalDate fechaGeneracion;
    private List<Object> datos;

    public Reporte(String idReporte, String tipo, LocalDate fechaGeneracion, List<Object> datos) {
        this.idReporte = idReporte;
        this.tipo = tipo;
        this.fechaGeneracion = fechaGeneracion;
        this.datos = datos;
    }

    public void generarReporte(String tipo) {
        this.tipo = tipo;
        this.fechaGeneracion = LocalDate.now();
        // lógica de filtrado/llenado de datos según el tipo
    }

    public String exportarPDF() {
        // placeholder: en la implementación real retornaría la ruta de archivo
        return "reporte_" + idReporte + ".pdf";
    }

    // getters
    public String getIdReporte() { return idReporte; }
    public String getTipo() { return tipo; }
    public LocalDate getFechaGeneracion() { return fechaGeneracion; }
    public List<Object> getDatos() { return datos; }
}
