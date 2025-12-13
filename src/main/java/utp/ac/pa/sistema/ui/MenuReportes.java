package utp.ac.pa.sistema.ui;

import utp.ac.pa.sistema.utils.IOUtils;

public class MenuReportes {

    IOUtils io = new IOUtils();

    public void menu() {
        while (true) {
            System.out.println("\n--- REPORTES ---");
            System.out.println("1) Generar reporte");
            System.out.println("2) Exportar PDF");
            System.out.println("3) Volver");

            int op = io.leerEntero("Seleccione", 1, 3);

            switch (op) {
                case 1 -> System.out.println(" Reporte OK.");
                case 2 -> System.out.println(" PDF generado.");
                case 3 -> { return; }
            }
        }
    }
}
