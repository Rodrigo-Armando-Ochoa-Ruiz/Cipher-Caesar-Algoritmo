public class Validator {
    private static Validator instance;
    private Validator() {
    }

    public static Validator getInstance(){
        if (instance==null){
            instance=new Validator();
        }
        return instance;
    }
    public boolean isValidKey(int key, char [] alphabet){
        return false;
    }

    public boolean isFileExists(String filrPath){

    }
}
