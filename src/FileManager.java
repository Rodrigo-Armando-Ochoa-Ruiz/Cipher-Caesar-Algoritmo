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


    public static String read(String inputPath){
        Path srcPath = Paths.get(inputPath);

        int sizeBuffer = 1024*1024*500;
        //Definición de canales de entrada y salida de datos
        try (FileChannel inputChannel=FileChannel.open(srcPath, StandardOpenOption.READ)){
            //if (inputChannel.size()>Integer.MAX_VALUE)
            //  throw new
            ByteBuffer byteBufferRead =ByteBuffer.allocate(sizeBuffer); //Definir Buffer de lectura con tamaño de información a procesar

            inputChannel.read(byteBufferRead);
            byteBufferRead.flip();//Preparar Buffer de lectura para ser leído

            byte [] bufferBytesRead=new byte[byteBufferRead.remaining()];//Definir arreglo del tamaño del buffer de lectura
            byteBufferRead.get(bufferBytesRead);//Guardar los datos del buffer de lectura en el arreglo
            System.out.println("Lectura realizada con éxito");
            return new String(bufferBytesRead,StandardCharsets.UTF_8);

        }catch (IOException e) {
            System.out.println(e.getMessage()+"\n"+e.getCause()+"\n"+ Arrays.toString(e.getStackTrace()));
        }
        System.out.println("Fallo en el proceso de lectura");
        return null;
    }

    public static void write(String outputPath,String toWrite){
        Path destPath = Paths.get(outputPath);

        int sizeBuffer = 1024;
        //Definición de canales de entrada y salida de datos
        try (FileChannel outputChannel=FileChannel.open(destPath, StandardOpenOption.WRITE)){
            ByteBuffer byteBufferWrite; //Definir buffer de escritura
            //Convertir el texto cifrado a bytes para su escritura
            byteBufferWrite =ByteBuffer.wrap(toWrite.getBytes(StandardCharsets.UTF_8));

            //Escribir en el archivo de salida todos los bytes del texto cifrado
            while (byteBufferWrite.hasRemaining()) {
                outputChannel.write(byteBufferWrite);
            }
            System.out.println("Escritura realizada con éxito");
        }catch (IOException e) {
            System.out.println(e.getMessage()+"\n"+e.getCause()+"\n"+ Arrays.toString(e.getStackTrace()));
        }
    }
}
