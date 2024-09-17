import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class FileProcess {
    //Método que procesa información por bloques
    public static void processInfoByBlock(String inputPath, String outputPath, int key){

        Path srcPath = Paths.get(inputPath);
        Path destPath = Paths.get(outputPath);

        //Definición de canales de entrada y salida de datos
        try (FileChannel inputChannel=FileChannel.open(srcPath, StandardOpenOption.READ);
             FileChannel outputChannel=FileChannel.open(destPath, StandardOpenOption.WRITE)){



            ByteBuffer byteBufferRead =ByteBuffer.allocate(1024); //Definir Buffer de lectura con tamaño de información a procesar
            ByteBuffer byteBufferWrite; //Definir buffer de escritura

            //Ciclo que lee todos los bytes através del canal de entrada y los almacena en el buffer de lectura
            while (inputChannel.read(byteBufferRead)>0){
                byteBufferRead.flip();//Preparar Buffer de lectura para ser leído

                byte [] bufferBytesRead=new byte[byteBufferRead.remaining()];//Definir arreglo del tamaño del buffer de lectura
                byteBufferRead.get(bufferBytesRead);//Guardar los datos del buffer de lectura en el arreglo

                //Enviar a Cifrado la clave y la cadena de texto, guardar texto cifrado
                String cipherText =Cipher.cipher(new String(bufferBytesRead,StandardCharsets.UTF_8),key);

                //Convertir el texto cifrado a bytes para su escritura
                byteBufferWrite =ByteBuffer.wrap(cipherText.getBytes(StandardCharsets.UTF_8));

                //Escribir en el archivo de salida todos los bytes del texto cifrado
                while (byteBufferWrite.hasRemaining()) {
                    outputChannel.write(byteBufferWrite);
                }

                byteBufferRead.clear(); //Limpiar el buffer de lectura para leer nuevos datos
            }

        }catch (IOException e) {
            System.out.println(e.getMessage()+"\n"+e.getCause()+"\n"+ Arrays.toString(e.getStackTrace()));
        }
    }
}
