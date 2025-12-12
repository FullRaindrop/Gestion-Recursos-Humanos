package utp.ac.pa.sistema.domain;

import java.util.List;

public class Nomina {
    private String idNomina;
    private Empleado empleado;
    private Contrato contrato;
    private int mes;
    private int año;
    private List<Deduccion> deducciones;

    public Nomina(String idNomina, Empleado empleado, Contrato contrato, int mes, int año, List<Deduccion> deducciones) {
        this.idNomina = idNomina;
        this.empleado = empleado;
        this.contrato = contrato;
        this.mes = mes;
        this.año = año;
        this.deducciones = deducciones;
    }

    public double calcularSalarioBruto() {
        if (contrato == null) return 0.0;
        return contrato.getSalarioBase();
    }

    public double calcularDeducciones() {
        double bruto = calcularSalarioBruto();
        if (deducciones == null) return 0.0;
        double total = 0.0;
        for (Deduccion d : deducciones) total += d.aplicarDeduccion(bruto);
        return total;
    }

    public double calcularSalarioNeto() {
        return calcularSalarioBruto() - calcularDeducciones();
    }

    public String generarRecibo() {
        return "Recibo - Empleado: " + (empleado != null ? empleado.getNombre() : "N/A")
                + " Bruto: " + calcularSalarioBruto()
                + " Neto: " + calcularSalarioNeto();
    }

    // getters
    public String getIdNomina() { return idNomina; }
}
