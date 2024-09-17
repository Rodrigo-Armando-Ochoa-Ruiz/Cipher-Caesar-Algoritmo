public class Cipher {
    private static final char [] ALPHABET={'a','b','c','d','e','f','g','h','i',//9
                                            'j','k','l','m','n','o','p', 'q','r',//9
                                            's','t','u','v','w','x','y','z',//8 T=26
                                            '.', ',', '"', ':', '!', '?', ' ','\n'};//7
    private static Cipher instance;

    private Cipher() {
    }

    public static Cipher getInstance(){
        if (instance==null){
            instance=new Cipher();
        }
        return instance;
    }

    public static String cipher(String text, int key){
        StringBuilder cipherText=new StringBuilder();
        char [] toCipher=text.toLowerCase().toCharArray();
        int newPosition;
        for (char c : toCipher) {
            for (int j = 0; j < ALPHABET.length; j++) {
                if (c > 96 && c < 123 && c == ALPHABET[j]) {
                    newPosition =(j+key>=0)?(j + key) % 26:26+(j+key);
                    cipherText.append(ALPHABET[newPosition]);
                    break;
                }
                if (c == ALPHABET[j]) {
                    cipherText.append(ALPHABET[j]);
                    break;
                }
            }
        }
        return cipherText.toString();
    }
}
