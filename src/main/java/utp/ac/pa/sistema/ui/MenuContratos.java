package utp.ac.pa.sistema.ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import utp.ac.pa.sistema.domain.Contrato;
import utp.ac.pa.sistema.domain.Deduccion;
import utp.ac.pa.sistema.domain.Empleado;
import utp.ac.pa.sistema.domain.Nomina;
import utp.ac.pa.sistema.domain.TipoContrato;
import utp.ac.pa.sistema.domain.TipoDeduccion;
import utp.ac.pa.sistema.utils.IOUtils;

public class MenuContratos {

    private IOUtils io = new IOUtils();

    private List<Empleado> empleados;
    private List<Contrato> contratos;
    private List<Nomina> nominas;

    public MenuContratos(
            List<Empleado> empleados,
            List<Contrato> contratos,
            List<Nomina> nominas
    ) {
        this.empleados = empleados;
        this.contratos = contratos;
        this.nominas = nominas;
    }

    public void menu() {
        while (true) {
            System.out.println("\n--- CONTRATOS Y NÓMINA ---");
            System.out.println("1) Crear contrato");
            System.out.println("2) Generar nómina");
            System.out.println("3) Volver");

            int op = io.leerEntero("Seleccione", 1, 3);

            switch (op) {
                case 1 -> crear();
                case 2 -> generarNomina();
                case 3 -> { return; }
            }
        }
    }

    // =========================
    // CREAR CONTRATO
    // =========================
    private void crear() {

        String idContrato = io.leerString("ID del contrato");
        String idEmp = io.leerString("ID del empleado");

        Empleado emp = buscarEmpleado(idEmp);
        if (emp == null) {
            System.out.println("Empleado no existe");
            return;
        }

        LocalDate fechaInicio = io.leerFecha("Fecha inicio");
        LocalDate fechaFin = io.leerFecha("Fecha fin");

        System.out.println("Tipo de contrato:");
        System.out.println("1) Indefinido");
        System.out.println("2) Temporal");
        System.out.println("3) Por horas");
        System.out.println("4) Prácticas");

        int opTipo = io.leerEntero("Seleccione", 1, 4);

        TipoContrato tipoContrato = switch (opTipo) {
            case 1 -> TipoContrato.INDEFINIDO;
            case 2 -> TipoContrato.TEMPORAL;
            case 3 -> TipoContrato.POR_HORAS;
            case 4 -> TipoContrato.PRACTICAS;
            default -> null;
        };

        if (tipoContrato == null) {
            System.out.println("Tipo inválido");
            return;
        }

        double salarioBase = io.leerDouble("Salario base");

        Contrato c = new Contrato(
                idContrato,
                emp,
                fechaInicio,
                fechaFin,
                tipoContrato,
                salarioBase
        );

        contratos.add(c);
        emp.setContratoVigente(c);
        System.out.println("Contrato creado para: " + emp.getNombre());
    }

    // =========================
    // GENERAR NÓMINA
    // =========================
    private void generarNomina() {

        String idEmp = io.leerString("ID del empleado");

        Contrato contrato = null;
        for (Contrato c : contratos) {
            if (c.getEmpleado().getIdEmpleado().equals(idEmp)) {
                contrato = c;
                break;
            }
        }

        if (contrato == null) {
            System.out.println("No existe contrato para ese empleado");
            return;
        }

        String idNomina = io.leerString("ID de la nómina");
        int mes = io.leerEntero("Mes (1-12)", 1, 12);
        int año = io.leerEntero("Año", 2000, 2100);

        List<Deduccion> deducciones = new ArrayList<>();

        deducciones.add(new Deduccion(TipoDeduccion.SEGURO_SOCIAL, 0, 9.75));
        deducciones.add(new Deduccion(TipoDeduccion.AFP, 0, 7.25));

        if (contrato.getSalarioBase() > 1000) {
            deducciones.add(new Deduccion(TipoDeduccion.ISR, 0, 10));
        }

        Nomina n = new Nomina(
                idNomina,
                contrato.getEmpleado(),
                contrato,
                mes,
                año,
                deducciones
        );

        nominas.add(n);

        System.out.println("Nómina generada correctamente");
        System.out.println(n.generarRecibo());
    }

    // =========================
    // UTIL
    // =========================
    private Empleado buscarEmpleado(String id) {
        for (Empleado e : empleados) {
            if (e.getIdEmpleado().equals(id)) {
                return e;
            }
        }
        return null;
    }
}
