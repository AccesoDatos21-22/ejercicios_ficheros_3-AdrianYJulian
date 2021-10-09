package ficheros;

import interfaces.InterfazEjercicios1_3;

import java.io.*;
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

    public void escribefrasesOutputStream(List<String> cadenas, Path ruta) {
        try {
            OutputStream oos = new FileOutputStream(ruta.toFile());
            for (int i = 0; i < cadenas.size(); i++) {
                oos.write(cadenas.get(i).getBytes());
                oos.write("\n".getBytes());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void escribefrasesBufferedWriter(List<String> cadenas, Path ruta) {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(ruta.toString()))) {
            for (int i = 0; i < cadenas.size(); i++) {
                bw.write(cadenas.get(i));
                bw.newLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void escribefrasesconScanner(Scanner scanner, Path ruta) {
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
        try {
            Files.readAllLines(ruta).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*    public void escribirFlotanteBufferedWriter(float numeroDecimal, String ruta) {
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
        }*/

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
            while (dataInputStream.available() > 0) {
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
