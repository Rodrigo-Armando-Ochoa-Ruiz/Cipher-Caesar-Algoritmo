/**
 * Clase Cipher. Realiza el cifrado y descifrado César.
 */
public class Cipher {
    private static final String ALPHABET="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz" +
                                         "ÁÉÍÓÚáéíóúÜüÑñ .,:!?();«»-¿¡0123456789";

    private static Cipher instance;

    private Cipher() {
    }

    public static Cipher getInstance(){
        if (instance==null){
            instance=new Cipher();
        }
        return instance;
    }


    public static int getAlphabetLength() {
        return ALPHABET.length();
    }

    /**
     * Método encrypt. Realiza la encriptación.
     * @param text Recibe un texto a encriptar.
     * @param key Recibe la llave de encriptación.
     * @return Texto encriptado.
     */
    public static String encrypt(String text, int key){
        StringBuilder cipherText=new StringBuilder();
        char [] toCipher=text.toCharArray();
        int alphabetLength=ALPHABET.length();
        for (char c : toCipher) {
            int index=ALPHABET.indexOf(c);
            if (index!=-1){
                int newPosition=(index + key) % alphabetLength;
                cipherText.append(ALPHABET.charAt(newPosition));
            }
            else
                cipherText.append(c);
        }
        return cipherText.toString();
    }

    /**
     * Método decrypt. Realiza la desencriptación.
     * @param text Recibe el texto a desencriptar.
     * @param key Recibe la llave de desencriptación.
     * @return El texto desencriptado.
     */
    public static String decrypt(String text, int key){
        return encrypt(text,key+ALPHABET.length());
    }
}
