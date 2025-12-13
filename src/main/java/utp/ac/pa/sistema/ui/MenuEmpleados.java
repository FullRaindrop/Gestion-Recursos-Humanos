package utp.ac.pa.sistema.ui;

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
    }

    private void buscar() {
        String id = io.leerString("ID a buscar");
        System.out.println("Empleado no implementado aún: " + id);
    }
}
