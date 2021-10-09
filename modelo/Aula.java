/**
 * Aula.java
 *
 * @author Laura y Carlos
 * @version 1.0
 */

package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Laura y Carlos
 * @version 1.0
 * @descrition Clase que describe un Aula de Alumnos para los ejercicios
 * @date 18/9/2021
 * @license GPLv3
 */
public class Aula {
    private final List<Alumno> alumnos;
    private final int tamano; //atributo para controlar el número real de elementos que tiene nuestro almacén
    private int tamano1;

    /**
     * Constructor del Almacén con un determinado tamano
     *
     * @param tamano
     */
    public Aula(int tamano) {
        this.tamano = tamano;
        alumnos = new ArrayList<>(tamano);

    }

    /**
     * Comprueba si el almacén está vacio
     *
     * @return true si está vacio
     */
    public boolean estaVacio() {
        return alumnos.isEmpty();
    }

    /**
     * Comprueba si el almacén está lleno
     *
     * @return
     */
    public boolean estaLLeno() {
        return tamano == alumnos.size();
    }

    /**
     * Anade un nuevo elemento al almacén si hay sitio
     *
     * @param valor a anadir al almacén
     */
    public void add(Alumno alumno) {
        if (!this.estaLLeno()) {
            alumnos.add(alumno);
        }
    }

    /**
     * Elimina un elemento del almacén si está en el almacen
     *
     * @param valor
     * @return true si elimina el elemento, false en caso contrario
     */
    public boolean eliminar(Alumno alumno) {
        return alumnos.remove(alumno);

    }


    /**
     * Imprime por pantalla los elementos del almacén
     */
    public void informacionAlumnos() {
        System.out.println("El aula tiene los siguientes alumnos:");
        for (int j = 0; j < alumnos.size(); j++) {
            System.out.println(alumnos.get(j).toString() + " ");
        }
    }
}
