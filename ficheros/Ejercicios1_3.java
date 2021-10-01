package ficheros;

import interfaces.InterfazEjercicios1_3;

import java.io.*;
import java.nio.file.*;
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
    public void escribefrases(List<String> cadenas, Path ruta) {
		try(BufferedWriter bw=Files.newBufferedWriter(Paths.get(ruta.toString()))){
            for (int i = 0; i < cadenas.size(); i++) {
                bw.write(cadenas.get(i));
                bw.newLine();            }


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
