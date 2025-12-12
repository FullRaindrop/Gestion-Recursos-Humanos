package utp.ac.pa.sistema.ui;

import utp.ac.pa.sistema.utils.IOUtils;

public class MenuPrincipal {

    IOUtils io = new IOUtils();

    public void iniciar() {

        while (true) {
            System.out.println("\n======================");
            System.out.println(" MENU PRINCIPAL");
            System.out.println("======================");
            System.out.println("1) Gestión de Empleados");
            System.out.println("2) Gestión de Usuarios");
            System.out.println("3) Contratos y Nómina");
            System.out.println("4) Vacaciones y Ausencias");
            System.out.println("5) Reportes");
            System.out.println("6) Salir");

            int op = io.leerEntero("Seleccione", 1, 6);

            switch (op) {
                case 1 -> new MenuEmpleados().menu();
                case 2 -> new MenuUsuarios().menu();
                case 3 -> new MenuContratos().menu();
                case 4 -> new MenuVacaciones().menu();
                case 5 -> new MenuReportes().menu();
                case 6 -> { System.out.println("Fin del sistema."); return; }
            }
        }
    }
}

