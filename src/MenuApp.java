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
                        //Clase ReaderInputData se encarga de leer los datos de entrada
                        ReaderInputData toEncryptData =new ReaderInputData();
                        //La clase authenticateInputData valida los datos ingresados
                        if (authenticateInputData(toEncryptData)){
                            //Si los datos ingresados son válidos lee, encripta y escribe
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
                        //Lectura de datos de entrada
                        BruteForce bruteForce=new BruteForce();
                        ReaderInputData dataBruteForce=new ReaderInputData();

                        System.out.println("Ingrese la ruta del archivo a desencriptar");
                        dataBruteForce.setInputPath(scanner.nextLine());

                        System.out.println("Ingrese la ruta del archivo destino");
                        dataBruteForce.setOutputPath(scanner.nextLine());

                        //Proceso de lectura de archivo, luego obtención de la clave y escritura de archivo
                        String textToDecrypt=FileManager.read(dataBruteForce.getInputPath());
                        int key= bruteForce.getKey(textToDecrypt);
                        if (key!=0){
                            System.out.println("Llave encontrada: "+key);
                            String textDecrypted=Cipher.decrypt(textToDecrypt,-key);
                            FileManager.write(dataBruteForce.getOutputPath(),textDecrypted);
                            System.out.println("Archivo Descifrado con éxito");
                        }
                        else
                            System.out.println("Llave no encontrada");
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
