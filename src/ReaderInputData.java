import java.util.Scanner;

public class ReaderInputData {
    private String inputPath;
    private String outputPath;
    private int key;
    private final Scanner scanner=new Scanner(System.in);
    public ReaderInputData(){

    }
    public boolean isInputPathValid() {
        System.out.println("Ingrese la ruta del archivo fuente");
        String path =scanner.nextLine();
        if (!Validator.isFileExists(path))
            FileManager.createFile(path);
        this.inputPath= path;
        return true;
    }

    public boolean isOutputPathValid(){
        System.out.println("Ingrese la ruta del archivo destino");
        String path = scanner.nextLine();
        if (Validator.isFileExists(path))
            FileManager.deleateFile(path);

        FileManager.createFile(path);
        this.outputPath=path;
        return true;
    }

    public boolean isKeyValid(){
        boolean isValidKey =false;
            while (!isValidKey){
                System.out.println("Ingrese la clave");
                try{
                    int key= Integer.parseInt(scanner.nextLine());
                    if (Validator.isValidKey(key)){
                        this.key=key;
                        isValidKey =true;
                    }
                    else
                        System.out.println("Clave no válida");
                }catch (NumberFormatException e){
                    System.out.println("Ingrese un número entero");
                }
            }
            return true;
    }

    public String getInputPath() {
        return inputPath;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public int getKey() {
        return key;
    }
}