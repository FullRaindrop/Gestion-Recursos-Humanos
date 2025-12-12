package utp.ac.pa.sistema.utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import javax.swing.*;

public class IOUtils {

    private Scanner sc = new Scanner(System.in);

    // ================================
    // CONSOLA
    // ================================

    public String leerString(String msg) {
        while (true) {
            System.out.print(msg + ": ");
            String txt = sc.nextLine().trim();

            if (!txt.isEmpty()) return txt;
            System.out.println("[ERROR] El texto no puede estar vacío.");
        }
    }

    public int leerEntero(String msg, int min, int max) {
        while (true) {
            try {
                System.out.print(msg + ": ");
                int v = Integer.parseInt(sc.nextLine());
                if (v < min || v > max) {
                    System.out.println("[ERROR] Debe estar entre " + min + " y " + max);
                } else return v;
            } catch (Exception e) {
                System.out.println("[ERROR] Ingrese un número válido.");
            }
        }
    }

    public double leerDouble(String msg) {
        while (true) {
            try {
                System.out.print(msg + ": ");
                double v = Double.parseDouble(sc.nextLine());
                if (v < 0) {
                    System.out.println("[ERROR] No puede ser negativo.");
                } else return v;
            } catch (Exception e) {
                System.out.println("[ERROR] Ingrese un decimal válido.");
            }
        }
    }

    public LocalDate leerFecha(String msg) {
        while (true) {
            try {
                System.out.print(msg + " (YYYY-MM-DD): ");
                return LocalDate.parse(sc.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("[ERROR] Formato inválido.");
            }
        }
    }

    // ================================
    // JOPTIONPANE
    // ================================

    public String leerStringJ(String msg) {
        while (true) {
            String txt = JOptionPane.showInputDialog(null, msg);
            if (txt != null && !txt.trim().isEmpty()) return txt.trim();
            JOptionPane.showMessageDialog(null, "ERROR: no puede estar vacío");
        }
    }

    public int leerEnteroJ(String msg, int min, int max) {
        while (true) {
            try {
                int v = Integer.parseInt(JOptionPane.showInputDialog(msg));
                if (v < min || v > max)
                    JOptionPane.showMessageDialog(null, "Fuera de rango");
                else return v;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR número entero");
            }
        }
    }

    public double leerDoubleJ(String msg) {
        while (true) {
            try {
                double v = Double.parseDouble(JOptionPane.showInputDialog(msg));
                if (v < 0) JOptionPane.showMessageDialog(null, "Debe ser positivo");
                else return v;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR número decimal");
            }
        }
    }

    public LocalDate leerFechaJ(String msg) {
        while (true) {
            try {
                return LocalDate.parse(JOptionPane.showInputDialog(msg + " (YYYY-MM-DD)"));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Fecha inválida");
            }
        }
    }
}
