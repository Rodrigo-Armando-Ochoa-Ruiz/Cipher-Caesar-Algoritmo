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

    public static String decrypt(String text, int key){
        return encrypt(text,key+ALPHABET.length());
    }

}
