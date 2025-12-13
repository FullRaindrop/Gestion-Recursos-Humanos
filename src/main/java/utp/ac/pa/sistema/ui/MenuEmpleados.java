package utp.ac.pa.sistema.ui;

import java.util.ArrayList;
import java.util.List;
import utp.ac.pa.sistema.domain.Empleado;
import utp.ac.pa.sistema.utils.IOUtils;


public class MenuEmpleados {

    private List<Empleado> empleados = new ArrayList<>();
    IOUtils io = new IOUtils();

    public MenuEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void menu() {
        while (true) {
            System.out.println("\n--- EMPLEADOS ---");
            System.out.println("1) Crear empleado");
            System.out.println("2) Buscar empleado");
            System.out.println("3) Volver");

            int op = io.leerEntero("Seleccione", 1, 3);

            switch (op) {
                case 1 -> crearEmpleado();
                case 2 -> buscar();
                case 3 -> { return; }
            }
        }
    }

    private void crearEmpleado() {
        String id = io.leerString("ID");
        String nom = io.leerString("Nombre");
        String email = io.leerString("Email");
        String departamento = io.leerString("Departamento");
        String puesto = io.leerString("Puesto");

        Empleado e = new Empleado(id, nom, email);
        e.asignarDepartamento(departamento);
        e.asignarPuesto(puesto);
        empleados.add(e);
        System.out.println("Empleado creado: " + e.getNombre());
    }

    private void buscar() {
        String id = io.leerString("ID a buscar");

        for (Empleado e : empleados) {
            if (e.getIdEmpleado().equals(id)) {
                System.out.println("Empleado encontrado:");
                System.out.println("ID: " + e.getIdEmpleado());
                System.out.println("Nombre: " + e.getNombre());
                System.out.println("Email: " + e.getEmail());
                System.out.println("Departamento: " + e.getDepartamento());
                System.out.println("Puesto: " + e.getPuesto());
                return;
            }
        }

        System.out.println("Empleado NO encontrado");
    }

}
