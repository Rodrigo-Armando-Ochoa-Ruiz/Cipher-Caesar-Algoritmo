/**
 * Clase Principal. Desde esta clase se corre el programa.
 * @author Rodrigo Armando Ochoa Ruiz
 * @version 2.0 25/11/2024
 */

public class Main {
    public static void main(String[] args) {
        MenuApp menuApp=new MenuApp();

        //Impresión de Menú en Consola
        System.out.println("===============================================\nBienvenido al Encriptador");
        menuApp.startedMenu();
        System.out.println("Hasta Luego");
    }
}