package utp.ac.pa.sistema.ui;

import java.util.ArrayList;
import java.util.List;
import utp.ac.pa.sistema.domain.Empleado;
import utp.ac.pa.sistema.utils.IOUtils;

public class MenuEmpleados {

    IOUtils io = new IOUtils();

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

        Empleado e = new Empleado(id, nom, email);
        System.out.println("Empleado creado: " + e.getNombre());
        empleados.add(e);
    }

    private static List<Empleado> empleados = new ArrayList<>();

    private void buscar() {
    System.out.println("Buscar por ID: ");
    int id = io.leerEntero("ID", 1, 9999);

    for (Empleado e : empleados) {
        if (e.getId() == id) {
            System.out.println("Empleado encontrado:");
            System.out.println("ID: " + e.getId());
            System.out.println("Nombre: " + e.getNombre());
            System.out.println("Email: " + e.getEmail());
            System.out.println("Departamento: " + e.getDepartamento());
            System.out.println("Rol: " + e.getPuesto());
            return;
        }
    }

    System.out.println("[ERROR] No existe un empleado con ese ID.");
    }
}
