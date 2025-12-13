package utp.ac.pa.sistema.ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import utp.ac.pa.sistema.domain.Ausencia;
import utp.ac.pa.sistema.domain.Empleado;
import utp.ac.pa.sistema.domain.SolicitudVacacion;
import utp.ac.pa.sistema.domain.TipoAusencia;
import utp.ac.pa.sistema.utils.IOUtils;

public class MenuVacaciones {

    private IOUtils io = new IOUtils();

    // listas locales (igual que otros menús)
    private List<Empleado> empleados;
    private List<SolicitudVacacion> solicitudes = new ArrayList<>();
    private List<Ausencia> ausencias = new ArrayList<>();

    public MenuVacaciones(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void menu() {
        while (true) {
            System.out.println("\n--- VACACIONES Y AUSENCIAS ---");
            System.out.println("1) Solicitud vacaciones");
            System.out.println("2) Registrar ausencia");
            System.out.println("3) Volver");

            int op = io.leerEntero("Seleccione", 1, 3);

            switch (op) {
                case 1 -> crearSolicitudVacaciones();
                case 2 -> registrarAusencia();
                case 3 -> { return; }
            }
        }
    }

    // ============================
    // VACACIONES
    // ============================
    private void crearSolicitudVacaciones() {

        String idEmp = io.leerString("ID del empleado");

        Empleado emp = buscarEmpleado(idEmp);
        if (emp == null) {
            System.out.println("Empleado no encontrado");
            return;
        }

        String idSol = io.leerString("ID solicitud");
        LocalDate inicio = io.leerFecha("Fecha inicio");
        LocalDate fin = io.leerFecha("Fecha fin");

        int dias = (int) (fin.toEpochDay() - inicio.toEpochDay()) + 1;

        SolicitudVacacion s = new SolicitudVacacion(
                idSol,
                emp,
                inicio,
                fin,
                dias
        );

        solicitudes.add(s);
        System.out.println("Solicitud de vacaciones creada (PENDIENTE)");
    }

    // ============================
    // AUSENCIAS
    // ============================
    private void registrarAusencia() {

        String idEmp = io.leerString("ID del empleado");

        Empleado emp = buscarEmpleado(idEmp);
        if (emp == null) {
            System.out.println("Empleado no encontrado");
            return;
        }

        String idAus = io.leerString("ID ausencia");
        LocalDate fecha = io.leerFecha("Fecha");

        System.out.println("Tipos de ausencia:");
        System.out.println("1) ENFERMEDAD");
        System.out.println("2) PERSONAL");
        System.out.println("3) MATERNIDAD");
        System.out.println("4) OTRO");

        int opTipo = io.leerEntero("Seleccione", 1, 4);

        TipoAusencia tipoAusencia = switch (opTipo) {
            case 1 -> TipoAusencia.ENFERMEDAD;
            case 2 -> TipoAusencia.PERSONAL;
            case 3 -> TipoAusencia.MATERNIDAD;
            case 4 -> TipoAusencia.OTRO;
            default -> null;
        };


        Ausencia a = new Ausencia(idAus, emp, fecha, tipoAusencia);
        ausencias.add(a);

        System.out.println("Ausencia registrada correctamente");
    }

    // ============================
    // UTIL
    // ============================
    private Empleado buscarEmpleado(String id) {
        for (Empleado e : empleados) {
            if (e.getIdEmpleado().equals(id)) {
                return e;
            }
        }
        return null;
    }
}
