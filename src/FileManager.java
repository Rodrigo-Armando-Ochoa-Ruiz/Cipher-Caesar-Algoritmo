import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Optional;

/**
 * Clase FileManager. Se encarga de administrar los procesos con archivos.
 */
public class FileManager {

    /**
     * Método deleteFile. Elimina un archivo existente.
     * @param filePath Recibe un parámetro con la ruta del archivo a eliminar.
     */
    public static void deleteFile(String filePath){
        Path path = Paths.get(filePath);
        try {
            Files.delete(path);
        } catch (IOException e) {
            System.out.println("Error al eliminar el archivo " + filePath);
        }
    }

    /**
     * Método createFile. Método utilizado para crear un archivo.
     * @param filePath Recibe la ruta del archivo a crear.
     * @return boolean true si el archivo se creó con éxito, de lo contrario regresa false.
     */
    public static boolean createFile(String filePath){
        Path path = Paths.get(filePath);
        if (!Validator.isFileExists(filePath)){
            try{
                Files.createFile(path);
                System.out.println("Archivo creado exitosamente " + path);
                return true;
            } catch (IOException e) {
                System.out.println("Error al crear el archivo " + path);
            }
        }
        return false;
    }

    /**
     * Método read. Lee el texto de un archivo mediante la creación de un canal de lectura.
     * @param inputPath Recibe la ruta del archivo a ser leído.
     * @return Devuelve texto leído desde el archivo.
     */
    public static String read(String inputPath){

        int sizeBuffer = 1024*1024*500;//500MB
        //Definición de canales de entrada y salida de datos
        try (FileChannel inputChannel=FileChannel.open(Paths.get(inputPath), StandardOpenOption.READ)){
            //Lanzar Excepción si el archivo supera los 500MB
            if (inputChannel.size()>sizeBuffer){
                System.out.println("Tamaño de archivo excedido, pruebe con uno de menor tamaño");
                throw new BufferOverflowException();
            }

            //Definir Buffer de lectura con tamaño de información a procesar
            ByteBuffer byteBufferRead =ByteBuffer.allocate(sizeBuffer);

            //Guardar los datos leídos del inputChannel en el bbyteBufferRead
            inputChannel.read(byteBufferRead);
            byteBufferRead.flip();//Preparar Buffer de lectura para ser leído

            byte [] bufferBytesRead=new byte[byteBufferRead.remaining()];//Definir arreglo del tamaño del buffer de lectura
            byteBufferRead.get(bufferBytesRead);//Guardar los datos del buffer de lectura en el arreglo
            System.out.println("Lectura de " + inputPath + " realizada con éxito");
            return new String(bufferBytesRead,StandardCharsets.UTF_8);


        }catch (IOException | NullPointerException e) {
            throw new RuntimeException("Fallo en el proceso de lectura",e.getCause());
        }
    }

    /**
     * Método write. Método que se encarga de escribir un texto dado en un archivo de una ruta dada.
     * @param outputPath Recibe la ruta del archivo al cual escribir el texto.
     * @param toWrite Recibe el texto a escribir en el archivo.
     */
    public static void write(String outputPath,String toWrite){
        Path destPath = Paths.get(outputPath);

        //Definición de canales de entrada y salida de datos
        try (FileChannel outputChannel=FileChannel.open(destPath, StandardOpenOption.WRITE)){
            ByteBuffer byteBufferWrite; //Definir buffer de escritura
            //Convertir el texto cifrado a bytes para su escritura
            byteBufferWrite =ByteBuffer.wrap(toWrite.getBytes(StandardCharsets.UTF_8));

            //Escribir en el archivo de salida todos los bytes del texto cifrado
            while (byteBufferWrite.hasRemaining()) {
                outputChannel.write(byteBufferWrite);
            }
            System.out.println("Escritura de " + outputPath + " realizada con éxito");
        }catch (IOException e) {
            System.out.println(e.getMessage()+"\n"+e.getCause()+"\n"+ Arrays.toString(e.getStackTrace()));
            throw new RuntimeException("Fallo en el proceso de escritura " + outputPath,e.getCause());
        }
    }
}
