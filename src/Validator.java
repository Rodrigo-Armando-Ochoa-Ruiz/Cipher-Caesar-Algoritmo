import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Clase Validator. Se encarga de validar la key y verificar si el path del usuario existe.
 */
public class Validator {
    private static Validator instance;
    private Validator() {
    }

    public static Validator getInstance(){
        if (instance==null){
            instance=new Validator();
        }
        return instance;
    }

    /**
     * Método isValidKey. Valida si la key se encuentra dentro del rango del abecedario.
     * @param key
     * @return true si la key cumple con el rango, de lo contrario false.
     */
    public static boolean isValidKey(int key){
        if (key>0&&key<Cipher.getAlphabetLength()){
            System.out.println("Clave válida");
            return true;
        }
        System.out.println("Clave inválida, ingrese un número entre 1 y "+Cipher.getAlphabetLength());
        return false;
    }

    /**
     * Método isFileExists. Valida si un archivo esxiste de acuerdo con su path.
     * @param filePath
     * @return boolean: true si el archivo existe, de lo contrario false.
     */
    public static boolean isFileExists(String filePath){
        Path path = Paths.get(filePath);
        return Files.exists(path);
    }
}
