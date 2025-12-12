package utp.ac.pa.sistema.domain;

public class Puesto {
    private String idPuesto;
    private String nombre;
    private int nivelJerarquico;
    private double salarioBaseReferencial;

    public Puesto(String idPuesto, String nombre, int nivelJerarquico, double salarioBaseReferencial) {
        this.idPuesto = idPuesto;
        this.nombre = nombre;
        this.nivelJerarquico = nivelJerarquico;
        this.salarioBaseReferencial = salarioBaseReferencial;
    }

    // getters / setters
    public String getIdPuesto() { return idPuesto; }
    public String getNombre() { return nombre; }
    public int getNivelJerarquico() { return nivelJerarquico; }
    public double getSalarioBaseReferencial() { return salarioBaseReferencial; }
}
