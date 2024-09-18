import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {

    public static void deleateFile(String filePath){
        Path path = Paths.get(filePath);
        try {
            Files.delete(path);
        } catch (IOException e) {
            System.out.println("Error al eliminar el archivo");
        }
    }

    public static boolean createFile(String filePath){
        Path path = Paths.get(filePath);
        if (!Validator.isFileExists(filePath)){
            try{
                Files.createFile(path);
                System.out.println("Archivo creado exitosamente "+path);
                return true;
            } catch (IOException e) {
                System.out.println("Error al crear el archivo " +path);
            }
        }
        return false;
    }
}
