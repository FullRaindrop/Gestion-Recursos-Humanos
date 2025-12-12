package utp.ac.pa.sistema.ui;

import utp.ac.pa.sistema.utils.IOUtils;

public class MenuContratos {

    IOUtils io = new IOUtils();

    public void menu() {

        while (true) {
            System.out.println("\n--- CONTRATOS Y NÓMINA ---");
            System.out.println("1) Crear contrato");
            System.out.println("2) Generar nómina");
            System.out.println("3) Volver");

            int op = io.leerEntero("Seleccione", 1, 3);

            switch (op) {
                case 1 -> crear();
                case 2 -> nomina();
                case 3 -> { return; }
            }
        }
    }

    private void crear() {
        String id = io.leerString("ID contrato");
        io.leerFecha("Fecha inicio");
        io.leerDouble("Salario");
        System.out.println("[DEMO] contrato creado.");
    }

    private void nomina() {
        System.out.println("[DEMO] nómina generada.");
    }
}
