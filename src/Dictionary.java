/**
 * Dictionary. Enum que contiene palabras clave del español para realizar el proceso de desifrado por fuerza bruta
 * {@link BruteForce}
 */
public enum Dictionary {
    ANTE(" ante "),
    BAJO(" bajo "),
    CABE(" cabe "),
    CON(" con "),
    CONTRA(" contra "),
    DESDE(" desde "),
    DURANTE(" durante "),
    ENTRE(" entre "),
    HACIA(" hacia "),
    HASTA(" hasta "),
    PARA(" para "),
    POR(" por "),
    DEL(" del "),
    DE(" de ");

    private final String palabra;
    Dictionary(String palabra) {
        this.palabra=palabra;
    }

    public String getPalabra() {
        return palabra;
    }
}
