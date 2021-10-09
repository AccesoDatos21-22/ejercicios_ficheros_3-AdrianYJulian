/**
 * AulaDAO.java
 *
 * @author Laura y Carlos
 * @version 1.0
 */

package dao;


import modelo.Alumno;

import java.nio.file.Path;

/**
 *  @descrition AulaDAO
 *    @author Laura y Carlos
 *  @date 18/9/2021
 *  @version 1.0
 *  @license GPLv3
 */
public interface AulaDAO {


    /**
     * Comprueba si el almacén está vacio
     *
     * @return true si está vacio
     */
    boolean estaVacio();

    /**
     * Comprueba si el almacén está lleno
     *
     * @return
     */
    boolean estaLLeno();

    /**
     * Anade un nuevo elemento al almacén si hay sitio
     *
     * @param valor
     *            a anadir al almacén
     */
    void add(Alumno alumno);

    /**
     * Elimina un elemento del almacén si está en el almacen
     *
     * @param valor
     * @return true si elimina el elemento, false en caso contrario
     */
    boolean eliminar(Alumno alumno);

    /**
     * Imprime por pantalla los elementos del almacén
     */
    void informacionAlumnos();

    /**
     * Método que escribe los alumnos en un archivo
     *
     * @param ruta
     */
    void escribeAlumnos(Path ruta);

    /**
     * Método que lee alumnos de un archivo y los muestra por pantalla
     *
     * @param ruta
     */
    void leeAlumnos(Path ruta);

}
