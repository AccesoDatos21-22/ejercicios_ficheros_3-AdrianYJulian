package interfaces;


import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

/**
 * @author Escribe_aqui_tu_nombre
 * @date
 * @license GPLv3
 */
public interface InterfazEjercicios1_3 {

    /**
     * guarda en un fichero dado números en coma flotante
     * si el fichero no existe lo crear
     * si el fichero existe lo añadirá al final.
     *
     * @param numeroDecimal
     * @param ruta
     */
    void escribirFlotante(float numeroDecimal, String ruta);


    /**
     * devuelva una lista de números flotante del fichero creado con
     * escribirFlotante
     *
     * @param ruta ruta del fichero
     * @return lista de números flotante del fichero
     */
    List<Float> leerFlotante(String ruta);

    void imprimirFlotante(String ruta);

    /**
     * Método que solicita un nombre de archivo
     *
     * @return el nombre de archivo si existe, sino finaliza el programa
     */
    Path getNombre(Scanner escaner);

    /**
     * Método que solicita frases al usuario
     *
     * @param escaner
     * @return
     */
    List<String> getFrases(Scanner escaner);


    /**
     * Método que escribe frases a un archivo
     *
     * @param cadenas
     * @param ruta
     */
    void escribefrases(List<String> cadenas, Path ruta);

    /**
     * Método que lee frases de un archivo y las muestra por pantalla
     *
     * @param cadenas
     * @param ruta
     */
    void leerFrases(Path ruta);
}
