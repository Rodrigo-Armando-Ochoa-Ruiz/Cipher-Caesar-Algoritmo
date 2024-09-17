import java.util.Scanner;
//MainApp realiza la función de mostrar menús y dirigir la secuencia del programa
public class MainApp {
    static MainApp instance=null;
    private MainApp(){

    }
    public static MainApp getInstance(){
        if (instance==null){
            instance=new MainApp();
        }
        return instance;
    }

    public static void selectOption(){
        int option;
        boolean isMenuPrinted=true;
        Scanner scanner =new Scanner(System.in);

        while (isMenuPrinted){
            try {
                MainApp.selectOption();
                option= Integer.parseInt(scanner.nextLine());
                switch (option){
                    case 1, 2:
                        ReaderInputData readerCipherData =new ReaderInputData();
                        if (readerCipherData.isInputPathValid()
                            && readerCipherData.isOutputPathValid()
                            && readerCipherData.isKeyValid()){
                            System.out.println("Datos ingresados correctamente");
                        }
                        int key= readerCipherData.getKey();
                        if (option==2)
                            key=-key;
                        FileProcess.processInfoByBlock(readerCipherData.getInputPath(),
                                                       readerCipherData.getOutputPath(),
                                                       key);
                        break;
                    case 3:break;
                    case 4: break;
                    default:
                        isMenuPrinted=false;
                        break;
                }
            }catch (NumberFormatException e){
                System.out.println("Hasta Luego");
                isMenuPrinted=false;
            }
        principalMenu();
        }

    }
    public static void principalMenu() {
        System.out.println("1. Encriptar");
        System.out.println("2. Desencriptar");
        System.out.println("3. Fuerza Bruta");
        System.out.println("4. Análisis Estadístico");
        System.out.println("Para salir presione cualquier tecla");
    }
}
