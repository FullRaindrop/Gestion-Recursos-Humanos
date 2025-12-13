package utp.ac.pa.sistema.ui;

import utp.ac.pa.sistema.utils.IOUtils;

public class MenuVacaciones {

    IOUtils io = new IOUtils();

    public void menu() {
        while (true) {
            System.out.println("\n--- VACACIONES ---");
            System.out.println("1) Solicitud vacaciones");
            System.out.println("2) Registrar ausencia");
            System.out.println("3) Volver");

            int op = io.leerEntero("Seleccione", 1, 3);

            switch (op) {
                case 1 -> System.out.println(" Solicitud creada.");
                case 2 -> System.out.println(" Ausencia registrada.");
                case 3 -> { return; }
            }
        }
    }
}
