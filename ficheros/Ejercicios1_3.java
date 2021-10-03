package ficheros;

import interfaces.InterfazEjercicios1_3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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
        return Paths.get(escaner.nextLine());
    }

    @Override
    public void escribefrases(Scanner scanner, Path ruta) {
        String frase = "";
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(ruta.toString()), StandardOpenOption.APPEND)) {
            System.out.println("Si desea salir introduzca -1");
            while (!frase.equals("-1")) {
                System.out.println("Introduzca una frase");
                frase = scanner.nextLine();
                if (!frase.equals("-1")) {
                    bw.write(frase);
                    bw.newLine();
                }
            }

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
