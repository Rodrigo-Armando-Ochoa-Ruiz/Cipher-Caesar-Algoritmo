import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
    public static boolean isValidKey(int key){
        if (key>0&&key<26){
            System.out.println("Clave válida");
            return true;
        }
        System.out.println("Clave inválida, ingrese un número entre 1 y 25");
        return false;
    }

    public static boolean isFileExists(String filePath){
        Path path = Paths.get(filePath);
        return Files.exists(path);
    }
}
