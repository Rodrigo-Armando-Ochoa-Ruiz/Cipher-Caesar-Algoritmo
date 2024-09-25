import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class BruteForce {
    private static final int LENGTH=Cipher.getAlphabetLength();

    public String readText(String path){

        Path srcPath = Paths.get(path);
        String toDecipherText;
        ByteBuffer byteBufferRead =ByteBuffer.allocate(1024);

        //Definición de canales de entrada y salida de datos
        try (FileChannel inputChannel=FileChannel.open(srcPath, StandardOpenOption.READ)){
            inputChannel.read(byteBufferRead);
             //Definir Buffer de lectura con tamaño de información a procesar
            byteBufferRead.flip();//Preparar Buffer de lectura para ser leído

            byte [] bufferBytesRead=new byte[byteBufferRead.remaining()];//Definir arreglo del tamaño del buffer de lectura
            byteBufferRead.get(bufferBytesRead);//Guardar los datos del buffer de lectura en el arreglo
            toDecipherText=new String(bufferBytesRead,StandardCharsets.UTF_8);

            return toDecipherText;

        }catch (IOException e) {
            System.out.println(e.getMessage()+"\n"+e.getCause()+"\n"+ Arrays.toString(e.getStackTrace()));
        }
        return null;
    }

    public int getKey(String toDecipherText){

        for (int i = 1; i < LENGTH; i++) {
            char[] charArray=new char[toDecipherText.length()];
            toDecipherText.getChars(0,toDecipherText.length(),charArray,0);
            for (int j = 0; j < charArray.length; j++)
                charArray[j]=(char)(charArray[j]-i);
            for (Dictionary dictionary:Dictionary.values()) {
                if(String.valueOf(charArray).toLowerCase().contains(dictionary.getPalabra())){
                    System.out.println(dictionary.getPalabra());
                    return i;
                }

            }

        }

        return 0;
    }
}
