package utp.ac.pa.sistema.domain;

public class Deduccion {
    private TipoDeduccion tipo;
    private double montoFijo;
    private double porcentaje; // porcentaje sobre salario bruto (ej: 9.0 => 9%)

    public Deduccion(TipoDeduccion tipo, double montoFijo, double porcentaje) {
        this.tipo = tipo;
        this.montoFijo = montoFijo;
        this.porcentaje = porcentaje;
    }

    public double aplicarDeduccion(double salario) {
        double por = salario * (porcentaje / 100.0);
        return montoFijo + por;
    }

    public TipoDeduccion getTipo() { return tipo; }
    public double getMontoFijo() { return montoFijo; }
    public double getPorcentaje() { return porcentaje; }
}
