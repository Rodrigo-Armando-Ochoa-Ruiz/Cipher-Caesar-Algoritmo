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
                        if (authenticateInputData(toEncryptData)){
                            String toEncrypt=FileManager.read(toEncryptData.getInputPath());
                            String encryptText=Cipher.encrypt(toEncrypt,toEncryptData.getKey());
                            FileManager.write(toEncryptData.getOutputPath(),encryptText);
                        }
                        break;

                    case 2:
                        ReaderInputData toDecryptData =new ReaderInputData();
                        if (authenticateInputData(toDecryptData)){
                            String toDecrypt=FileManager.read(toDecryptData.getInputPath());
                            String encryptText=Cipher.decrypt(toDecrypt,-toDecryptData.getKey());
                            FileManager.write(toDecryptData.getOutputPath(),encryptText);
                        }
                        break;

                    case 3:
                        BruteForce bruteForce=new BruteForce();
                        ReaderInputData dataBruteForce=new ReaderInputData();

                        System.out.println("Ingrese la ruta del archivo a desencriptar");
                        dataBruteForce.setInputPath(scanner.nextLine());

                        System.out.println("Ingrese la ruta del archivo destino");
                        dataBruteForce.setOutputPath(scanner.nextLine());

                        String partOfText=bruteForce.readText(scanner.nextLine());
                        dataBruteForce.setKey(bruteForce.getKey(partOfText));

//                        if (dataBruteForce.getKey()==0)
//                            System.out.println("No se pudo descifrar el archivo");
//                        else
//                            FileManager.processInfoByBlock(dataBruteForce.getInputPath(),
//                                dataBruteForce.getOutputPath(),
//                                -dataBruteForce.getKey());
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
