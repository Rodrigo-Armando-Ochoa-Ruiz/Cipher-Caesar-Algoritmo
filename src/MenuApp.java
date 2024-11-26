import java.util.Scanner;

/**
 * Clase MainApp.  Esta clase realiza la función de mostrar menús y dirigir el flujo del programa
 */
public class MenuApp {
    private Scanner scanner;

    public MenuApp(){
        this.scanner=new Scanner(System.in);
    }

    /**
     * Método startedMenu. Este método inicia el flujo del programa.
     */
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
                        try{
                            if (authenticateInputData(toEncryptData)){
                                //Si los datos ingresados son válidos lee, encripta y escribe
                                String toEncrypt=FileManager.read(toEncryptData.getInputPath());
                                String encryptText=Cipher.encrypt(toEncrypt,toEncryptData.getKey());
                                FileManager.write(toEncryptData.getOutputPath(),encryptText);
                                createPropertiesFile(toEncryptData);
                                System.out.println(FileManager.read("files/properties.txt"));
                            }
                        }catch (RuntimeException e){
                            System.out.println("Error en la validación de datos, verifique e intente nuevamente");
                            isMenuPrinted=false;
                        }
                        break;

                    case 2:
                        ReaderInputData toDecryptData =new ReaderInputData();
                        try{
                            if (authenticateInputData(toDecryptData)){
                                String toDecrypt=FileManager.read(toDecryptData.getInputPath());
                                String encryptText=Cipher.decrypt(toDecrypt,-toDecryptData.getKey());
                                FileManager.write(toDecryptData.getOutputPath(),encryptText);
                                createPropertiesFile(toDecryptData);
                                System.out.println(FileManager.read("files/properties.txt"));
                            }
                        }catch (RuntimeException e){
                            System.out.println("Error en la validación de datos, verifique e intente nuevamente");
                            isMenuPrinted=false;
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
                        try{
                            String textToDecrypt=FileManager.read(dataBruteForce.getInputPath());
                            int key= bruteForce.getKey(textToDecrypt);
                            if (key!=0){
                                System.out.println("Llave encontrada: "+key);
                                String textDecrypted=Cipher.decrypt(textToDecrypt,-key);
                                FileManager.write(dataBruteForce.getOutputPath(),textDecrypted);
                                System.out.println("Archivo Descifrado con éxito");
                                dataBruteForce.setKey(key);
                                createPropertiesFile(dataBruteForce);
                                System.out.println(FileManager.read("files/properties.txt"));
                            }
                            else
                                System.out.println("Llave no encontrada");
                        } catch (RuntimeException e) {
                            System.out.println("Error en la validación de datos, verifique e intente nuevamente");
                            isMenuPrinted=false;
                        }
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

    /**
     * Método printPrincipalMenu. Este método se encarga de imprimir el menú principal.
     */
    public static void printPrincipalMenu() {
        System.out.println("\n===============================================");
        System.out.println("1. Encriptar");
        System.out.println("2. Desencriptar");
        System.out.println("3. Fuerza Bruta");
        System.out.println("4. Análisis Estadístico");
        System.out.println("Para salir presione cualquier tecla");
        System.out.println("===============================================\n");
    }

    /**
     * MétodoauthenticateInputData. Este método sirve para autenticar que los datos ingresados por el usuario
     * sean correctos.
     * @param readerInputData {@link ReaderInputData}
     * @return Devuelve true si los datos son correctos, de lo contrario devuelve false
     */
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

    /**
     * Método createFileProperties. Este método crea el archivo properties.txt.
     * @param readerInputData {@link ReaderInputData}
     */
    public void createPropertiesFile(ReaderInputData readerInputData){
        FileManager.createFile("files/properties.txt");
        FileManager.write("files/properties.txt",
                "\nArchivo de entrada: "+readerInputData.getInputPath()+
                        "\nKey: "+ readerInputData.getKey()+
                        "\nArchivo de salida: " + readerInputData.getOutputPath());
    }
}
