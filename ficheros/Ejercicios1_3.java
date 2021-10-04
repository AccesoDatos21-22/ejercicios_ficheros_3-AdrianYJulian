package ficheros;

import interfaces.InterfazEjercicios1_3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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

        return null;
    }

    @Override
    public Path getNombre(Scanner escaner) {

        return null;
    }

    @Override
    public void escribefrases(List<String> cadenas, Path ruta) {


    }

    @Override
    public void leerFrases(Path ruta) {
        // TODO Auto-generated method stub

    }


    @Override
    public void escribirFlotante(float numeroDecimal, String ruta) {
        Path archivoFlotantes = Paths.get(ruta);
        if (!Files.exists(archivoFlotantes)) {
            try {
                Files.createFile(archivoFlotantes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(archivoFlotantes, StandardOpenOption.APPEND)) {
            bufferedWriter.write(String.valueOf(numeroDecimal));
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Float> leerFlotante(String ruta) {
        // TODO Auto-generated method stub
        return null;
    }


}
