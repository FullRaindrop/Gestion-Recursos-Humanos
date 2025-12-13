package utp.ac.pa.sistema.ui;

import java.util.ArrayList;
import java.util.List;
import utp.ac.pa.sistema.domain.Contrato;
import utp.ac.pa.sistema.domain.Empleado;
import utp.ac.pa.sistema.domain.Nomina;
import utp.ac.pa.sistema.utils.IOUtils;

public class MenuPrincipal {

    IOUtils io = new IOUtils();
    
    private List<Empleado> empleados = new ArrayList<>();
    private List<Nomina> nominas = new ArrayList<>();
    private List<Contrato> contratos = new ArrayList<>();

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
                case 1 -> new MenuEmpleados(empleados).menu();
                case 2 -> new MenuUsuarios().menu();
                case 3 -> new MenuContratos(empleados, contratos, nominas).menu();
                case 4 -> new MenuVacaciones(empleados).menu();
                case 5 -> new MenuReportes(empleados).menu();
                case 6 -> { System.out.println("Fin del sistema."); return; }
            }
        }
    }
}

