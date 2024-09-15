public class Cipher {
    private static final char [] ALPHABET={'a','b','c','d','e','f','g','h','i',
                                            'j','k','l','m','n','o','p', 'q','r',
                                            's','t','u','v','w','x','y','z'};
    private static Cipher instance;

    private Cipher() {
    }

    public static Cipher getInstance(){
        if (instance==null){
            instance=new Cipher();
        }
        return instance;
    }

    public String encrypt(String text, int key){
        return null;
    }

    public String decrypt(String encryptedTex,int key){
        return null;
    }
}
