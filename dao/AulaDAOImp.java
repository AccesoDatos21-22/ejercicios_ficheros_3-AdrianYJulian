/**
 * AulaDAOImp.java
 *
 * @author Laura y Carlos
 * @version 1.0
 */

package dao;

import modelo.Alumno;
import modelo.Aula;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Laura y Carlos
 * @version 1.0
 * @descrition AulaDAOImp
 * @date 18/9/2021
 * @license GPLv3
 */
public class AulaDAOImp implements AulaDAO {
    private final List<Alumno> alumnos;
    private final int numalumnos; // atributo para controlar el número real de
    // elementos que tiene nuestro almacén

    /**
     * Constructor del Almacén con un determinado tamano
     *
     * @param tamano
     */
    public AulaDAOImp(int tamano) {
        alumnos = new ArrayList<Alumno>(tamano);
        numalumnos = tamano;

    }

    /**
     * Comprueba si el almacén está vacio
     *
     * @return true si está vacio
     */
    public boolean estaVacio() {
        return false;
    }

    /**
     * Comprueba si el almacén está lleno
     *
     * @return
     */
    public boolean estaLLeno() {
        return false;
    }

    /**
     * Anade un nuevo elemento al almacén si hay sitio
     *
     * @param valor a anadir al almacén
     */
    public void add(Alumno alumno) {

    }

    /**
     * Elimina un elemento del almacén si está en el almacen
     *
     * @param valor
     * @return true si elimina el elemento, false en caso contrario
     */
    public boolean eliminar(Alumno alumno) {
        return false;

    }

    /**
     * Imprime por pantalla los elementos del almacén
     */
    public void informacionAlumnos() {

    }

    /**
     * Método que escribe los alumnos en un archivo
     *
     * @param ruta
     */
    public void escribeAlumnos(Path ruta) {
        Scanner sc = new Scanner(System.in);
        try (BufferedWriter bw = Files.newBufferedWriter(ruta)) {

            for (int i = 0; i < 2; i++) {

                System.out.println("Escribe el nombre");
                String nombre = sc.nextLine();
                System.out.println("Escribe el apellido");
                String apellido = sc.nextLine();
                System.out.println("Escribe la direccion y el numero");
                String direccion = sc.nextLine();
                int numero = sc.nextInt();
                System.out.println("Escribe el año de nacimiento");
                int nacimiento = sc.nextInt();
                bw.write(nombre + "\t" + apellido + "\t" + nacimiento + "\t" + direccion + "\t" + numero);
                bw.newLine();
                sc.nextLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        sc.close();
    }

    /**
     * Método que lee alumnos de un archivo y los muestra por pantalla
     *
     * @param ruta
     */
    public void leeAlumnos(Path ruta) {
        String[] split;
        Aula aula1 = new Aula(5);
        try (BufferedReader br = new BufferedReader(new FileReader(new File(ruta.toUri())))) {
            String alumno = br.readLine();
            while (alumno != null) {

                split = alumno.split("\t");
                alumno = br.readLine();
                Alumno temp = new Alumno(split[0], split[1], Integer.parseInt(split[2]), split[3],
                        Integer.parseInt(split[4]));
                System.out.println(temp.toString());
                aula1.add(temp);
            }
            aula1.informacionAlumnos();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leeAlumnosReadAllLines(Path ruta) {
        String[] split;
        Aula aula1 = new Aula(5);
        try {
            List<String> nombre = Files.readAllLines(ruta);
            for (int i = 0; i < nombre.size(); i++) {
                split = nombre.get(i).split("\t");
                Alumno temp = new Alumno(split[0], split[1], Integer.parseInt(split[2]), split[3],
                        Integer.parseInt(split[4]));
                System.out.println(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
