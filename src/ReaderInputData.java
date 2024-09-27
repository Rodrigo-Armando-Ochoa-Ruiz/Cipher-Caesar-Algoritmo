import java.util.Scanner;

public class ReaderInputData {
    private String inputPath;
    private String outputPath;
    private int key;
    private final Scanner scanner=new Scanner(System.in);
    public ReaderInputData(){

    }

    public void setInputPath(String inputPath) {
        this.inputPath = inputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public boolean isInputPathValid() {
        System.out.println("Ingrese la ruta del archivo fuente");
        String path =scanner.nextLine();
        if (!Validator.isFileExists(path))
            return FileManager.createFile(path);
        this.inputPath= path;
        return true;
    }

    public boolean isOutputPathValid(){
        System.out.println("Ingrese la ruta del archivo destino");
        String path = scanner.nextLine();
        if (Validator.isFileExists(path))
            FileManager.deleateFile(path);
        this.outputPath=path;
        return FileManager.createFile(path);
    }

    public boolean isKeyValid(){
        while (true){
            System.out.println("Ingrese la clave");
            try{
                int key= Integer.parseInt(scanner.nextLine());
                if (Validator.isValidKey(key)){
                    this.key=key;
                    return true;
                }
            }catch (NumberFormatException e){
                System.out.println("Ingrese un número entero");
            }
        }
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