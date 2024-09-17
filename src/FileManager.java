import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class FileManager {
    public String readFile(String filePath){

        return null;
    }

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
                System.out.println("Error al crear el archivo " + path);
            }
        }
        System.out.println("Archivo existente");
        return false;
    }
}
