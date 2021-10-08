package ficheros;

import interfaces.InterfazEjercicios1_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Escribe_aqui_tu_nombre
 * @date
 * @license GPLv3
 */
public class Ejercicios1_3 implements InterfazEjercicios1_3 {


    @Override
    public List<String> getFrases(Scanner escaner) {
        String continuar = "";
        List<String> lista = new ArrayList<>();
        System.out.println("Si desea salir introduzca -1");
        while (!continuar.equals("-1")) {
            System.out.println("Introduzca una frase");
            continuar = escaner.nextLine();
            if (!continuar.equals("-1")) {
                lista.add(continuar);
            }
        }
        return lista;
    }

    @Override
    public Path getNombre(Scanner escaner) {
        System.out.println("introduzca el nombre del fichero deseado");
        var nombreFichero = escaner.nextLine();
            if (Paths.get(nombreFichero).toFile().exists()) {
                return Paths.get(nombreFichero);
            } else {
                try {
                    throw new Exception("Error : Introduzca el nombre de un fichero existente");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        return null;
    }

    @Override
    public void escribefrases(List<String> cadenas, Path ruta) {
        try {
            Files.write(ruta, cadenas);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void leerFrases(Path ruta) {
        // TODO Auto-generated method stub

    }


    @Override
    public void escribirFlotante(float numeroDecimal, String ruta) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Float> leerFlotante(String ruta) {
        // TODO Auto-generated method stub
        return null;
    }


}
