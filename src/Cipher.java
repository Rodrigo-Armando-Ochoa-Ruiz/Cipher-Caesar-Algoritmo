public class Cipher {
    private static final char [] ALPHABET={'a','b','c','d','e','f','g','h','i',//9
                                            'j','k','l','m','n','o','p', 'q','r',//9
                                            's','t','u','v','w','x','y','z',//8 T=26
                                            '.', ',', '"', ':', '!', '?', ' ','\n',
                                            'á','é','í','ó','ú','ñ',
                                            '(',')'};//7
    private static final char [] WIREDALPHABET={1040,1041,1042,1043,1044,1045,1046,1047,1048,
                                                1049,1050,1051,1052,1053,1054,1055,1056,1057,
                                                1058,1059,1060,1061,1062,1063,1064,1065,
                                                '.', ',', '"', ':', '!', '?', ' ','\n',
                                                'á','é','í','ó','ú','ñ',
                                                '(',')'};
    private static Cipher instance;

    private Cipher() {
    }

    public static Cipher getInstance(){
        if (instance==null){
            instance=new Cipher();
        }
        return instance;
    }

    public static String encrypt(String text, int key){
        StringBuilder cipherText=new StringBuilder();
        char [] toCipher=text.toLowerCase().toCharArray();
        int newPosition;
        for (char c : toCipher) {
            for (int j = 0; j < ALPHABET.length; j++) {
                if (c > 96 && c < 123 && c == ALPHABET[j]) {
                    newPosition =(j + key) % 26;
                    cipherText.append(WIREDALPHABET[newPosition]);
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

    public static String decrypt(String text, int key){
        StringBuilder cipherText=new StringBuilder();
        char [] toCipher=text.toCharArray();
        int newPosition;
        for (char c : toCipher) {
            for (int j = 0; j < WIREDALPHABET.length; j++) {
                if (c > 1039 && c < 1066 && c == WIREDALPHABET[j]) {
                    newPosition =(j+key>=0)?(j + key) % 26:26+(j+key);
                    cipherText.append(ALPHABET[newPosition]);
                    break;
                }
                if (c == WIREDALPHABET[j]) {
                    cipherText.append(WIREDALPHABET[j]);
                    break;
                }
            }
        }
        return cipherText.toString();
    }
}
