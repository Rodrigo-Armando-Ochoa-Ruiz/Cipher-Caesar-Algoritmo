/**
 * Clase BruteForce. Ejecuta búsqueda de llave por fuerza bruta probando todas las llaves posibles hasta encontrar
 * alguna adecuada.
 */

public class BruteForce {
    private static final int LENGTH=Cipher.getAlphabetLength();

    /**
     * Método getKey. Obtiene una llave adecuada.
     * @param toDecipherText Recibe un fragmento de texto para probar las llaves
     * @return 0 si la llave adecuada no se encontró, de otra manera regresa el valor de la llave.
     */
    public int getKey(String toDecipherText){
        //Probar todas las claves posibles para descifrar el texto
        for (int i = 1; i < LENGTH; i++) {
            String decryptText=Cipher.decrypt(toDecipherText,-i);
            //Una vez probada una llave, se compara con el Enum Diccionary que tiene algunas palabras seleccionadas
            for (Dictionary d:Dictionary.values())
                if (decryptText.toLowerCase().contains(d.getPalabra())){
                    return i;//Si el texto descifrado contiene alguna palabra, se regresa la clave
                }
        }
        return 0;//Si no, se regresa 0
    }
}
