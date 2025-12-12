package utp.ac.pa.sistema.ui;

import java.util.HashMap;
import java.util.Map;
import utp.ac.pa.sistema.domain.Rol;
import utp.ac.pa.sistema.domain.Usuario;
import utp.ac.pa.sistema.utils.IOUtils;

public class MenuUsuarios {

    private IOUtils io = new IOUtils();

    // almacenamiento simple
    private static Map<String, Usuario> usuarios = new HashMap<>();

    public void menu() {

        int opcion = 0;

        do {
            System.out.println("\n--- USUARIOS ---");
            System.out.println("1) Crear usuario");
            System.out.println("2) Autenticar");
            System.out.println("3) Buscar usuario");
            System.out.println("4) Ver lista");
            System.out.println("5) Volver");
            System.out.print("Seleccione: ");

            opcion = io.leerEntero(" ", 1, 5);

            switch (opcion) {
                case 1 -> crearUsuario();
                case 2 -> autenticar();
                case 3 -> buscar();
                case 4 -> listar();
                case 5 -> System.out.println("Volviendo...");
            }

        } while (opcion != 5);
    }

    private void crearUsuario() {
        System.out.println("\n--- CREAR USUARIO ---");

        String username = io.leerString("Usuario");
        String pass = io.leerString("Contraseña");

        // rol básico
        Rol rol = new Rol("BASICO", java.util.List.of("login"));

        Usuario u = new Usuario(username, pass, rol);
        usuarios.put(username, u);

        System.out.println("Usuario creado: " + username);
    }

    private void autenticar() {
        System.out.println("\n--- AUTENTICAR USUARIO ---");

        String username = io.leerString("Usuario");
        String pass = io.leerString("Contraseña");

        Usuario u = usuarios.get(username);

        if (u == null) {
            System.out.println(" Usuario no encontrado");
            return;
        }

        if (u.autenticar(pass)) {
            System.out.println(" Autenticación exitosa. Bienvenido " + username);
        } else {
            System.out.println(" Contraseña incorrecta");
        }
    }

    private void buscar() {
        String username = io.leerString("Ingrese nombre de usuario");

        Usuario u = usuarios.get(username);

        if (u == null) {
            System.out.println(" Usuario no encontrado");
        } else {
            System.out.println("✔ Usuario encontrado:");
            System.out.println("Usuario: " + u.getNombreUsuario());
            System.out.println("Rol: " + u.getRol().getNombreRol());
        }
    }

    private void listar() {
        System.out.println("\n--- LISTA DE USUARIOS ---");

        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }

        for (Usuario u : usuarios.values()) {
            System.out.println(" - " + u.getNombreUsuario() + "   (Rol: " + u.getRol().getNombreRol() + ")");
        }
    }
}
