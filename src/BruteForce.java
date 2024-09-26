public class BruteForce {
    private static final int LENGTH=Cipher.getAlphabetLength();

    public int getKey(String toDecipherText){

        for (int i = 1; i < LENGTH; i++) {
            String decryptText=Cipher.decrypt(toDecipherText,-i);
            for (Dictionary d:Dictionary.values())
                if (decryptText.toLowerCase().contains(d.getPalabra())){
                    return i;
                }
        }
        return 0;
    }
}
