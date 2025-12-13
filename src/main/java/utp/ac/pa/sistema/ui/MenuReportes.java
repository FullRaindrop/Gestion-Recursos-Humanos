package utp.ac.pa.sistema.ui;

import java.util.List;
import utp.ac.pa.sistema.domain.Empleado;
import utp.ac.pa.sistema.utils.IOUtils;

public class MenuReportes {

    private IOUtils io = new IOUtils();
    private List<Empleado> empleados;

    public MenuReportes(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void menu() {

        if (empleados == null || empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }

        while (true) {
            System.out.println("\n--- REPORTES ---");
            System.out.println("1) Listado general de empleados");
            System.out.println("2) Empleados con contrato vigente");
            System.out.println("3) Empleados por departamento");
            System.out.println("4) Empleados por puesto");
            System.out.println("5) Volver");

            int op = io.leerEntero("Seleccione", 1, 5);

            switch (op) {
                case 1 -> reporteGeneral();
                case 2 -> reporteContratoVigente();
                case 3 -> reportePorDepartamento();
                case 4 -> reportePorPuesto();
                case 5 -> { return; }
            }
        }
    }

    // =========================
    // REPORTES
    // =========================

    private void reporteGeneral() {

        System.out.println("\n--- LISTADO GENERAL ---");

        for (Empleado e : empleados) {
            imprimirEmpleado(e);
        }
    }

    private void reporteContratoVigente() {

        System.out.println("\n--- EMPLEADOS CON CONTRATO VIGENTE ---");

        boolean encontrado = false;

        for (Empleado e : empleados) {
            if (e.getContratoVigente() != null) {
                imprimirEmpleado(e);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hay empleados con contrato vigente.");
        }
    }

    private void reportePorDepartamento() {

        String dep = io.leerString("Ingrese el departamento");

        System.out.println("\n--- EMPLEADOS DEL DEPARTAMENTO: " + dep + " ---");

        boolean encontrado = false;

        for (Empleado e : empleados) {
            if (e.getDepartamento() != null &&
                e.getDepartamento().equalsIgnoreCase(dep)) {

                imprimirEmpleado(e);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron empleados en ese departamento.");
        }
    }

    private void reportePorPuesto() {

        String puesto = io.leerString("Ingrese el puesto");

        System.out.println("\n--- EMPLEADOS CON PUESTO: " + puesto + " ---");

        boolean encontrado = false;

        for (Empleado e : empleados) {
            if (e.getPuesto() != null &&
                e.getPuesto().equalsIgnoreCase(puesto)) {

                imprimirEmpleado(e);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron empleados con ese puesto.");
        }
    }

    // =========================
    // UTIL
    // =========================

    private void imprimirEmpleado(Empleado e) {

        System.out.println(
            "ID: " + e.getIdEmpleado()
            + " | Nombre: " + e.getNombre()
            + " | Email: " + e.getEmail()
            + " | Departamento: " +
              (e.getDepartamento() != null ? e.getDepartamento() : "N/A")
            + " | Puesto: " +
              (e.getPuesto() != null ? e.getPuesto() : "N/A")
            + " | Contrato vigente: " +
              (e.getContratoVigente() != null ? "Sí" : "No")
        );
    }
}
