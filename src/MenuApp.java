import java.util.Scanner;
//MainApp realiza la función de mostrar menús y dirigir la secuencia del programa
public class MenuApp {
    private Scanner scanner;

    public MenuApp(){
        this.scanner=new Scanner(System.in);
    }

    public  void startedMenu(){
        int option;
        boolean isMenuPrinted=true;

        while (isMenuPrinted){
            try {
                printPrincipalMenu();
                option= Integer.parseInt(scanner.nextLine());

                switch (option){
                    case 1:
                        ReaderInputData toEncryptData =new ReaderInputData();
                        if (authenticateInputData(toEncryptData))
                            FileProcess.processInfoByBlock(toEncryptData.getInputPath(),
                                                           toEncryptData.getOutputPath(),
                                                           toEncryptData.getKey());
                        break;

                    case 2:
                        ReaderInputData toDecryptData =new ReaderInputData();
                        if (authenticateInputData(toDecryptData))
                            FileProcess.processInfoByBlock(toDecryptData.getInputPath(),
                                                           toDecryptData.getOutputPath(),
                                                          -toDecryptData.getKey());
                        break;

                    case 3:
                        break;
                    case 4:
                        break;
                    default:
                        isMenuPrinted=false;
                        break;
                }
            }catch (NumberFormatException e){
                isMenuPrinted=false;
            }
        }

    }
    public static void printPrincipalMenu() {
        System.out.println("1. Encriptar");
        System.out.println("2. Desencriptar");
        System.out.println("3. Fuerza Bruta");
        System.out.println("4. Análisis Estadístico");
        System.out.println("Para salir presione cualquier tecla");
    }

    public boolean authenticateInputData(ReaderInputData readerInputData){
        if (readerInputData.isInputPathValid() &&
            readerInputData.isOutputPathValid() &&
            readerInputData.isKeyValid()){
            System.out.println("Datos ingresados correctamente");
            return true;
        }
        else{
            System.out.println("Error de archivos");
            return false;
        }

    }
}
