package ficheros;

import interfaces.InterfazEjercicios1_3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
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
        try (DataOutputStream dataOutputStream = new DataOutputStream(Files.newOutputStream(archivoFlotantes, StandardOpenOption.APPEND))) {
            dataOutputStream.writeFloat(numeroDecimal);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void imprimirFlotante(String ruta) {
        Path archivoFlotantes = Paths.get(ruta);
        try (DataInputStream dataInputStream = new DataInputStream(Files.newInputStream(archivoFlotantes))) {
            while (dataInputStream.available()>0) {
                System.out.println(dataInputStream.readFloat());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Float> leerFlotante(String ruta) {
        Path archivoFlotantes = Paths.get(ruta);
        List<Float> listaFlotantes = new ArrayList<>();
        try (DataInputStream dataInputStream = new DataInputStream(Files.newInputStream(archivoFlotantes))) {
            while (dataInputStream.available()>0) {
                listaFlotantes.add(dataInputStream.readFloat());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaFlotantes;
    }


}
