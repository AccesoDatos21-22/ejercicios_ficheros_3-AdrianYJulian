package ficheros;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.DataInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

class Ejercicios1_3Test {

    private Ejercicios1_3 ejercicios1_3;

    @BeforeEach
    void setUp() {
        ejercicios1_3 = new Ejercicios1_3();
    }

    @Test
    void imprimirFlotante() {
        int test = 1;
        try (DataInputStream dataInputStream = new DataInputStream(Files.newInputStream(Path.of("test.dat")))) {
            while ((test = dataInputStream.available()) > 0) {
            }
            Assumptions.assumeTrue(test == 0, "Lee el fichero hasta el final");
        } catch (IOException e) {
        }

    }

    @Test
    void leerFlotante() {
        try {
            for (int i = 0; i < 9 ; i++) {
                ejercicios1_3.escribirFlotante((float) i, "testjunit");
            }
            Assumptions.assumeTrue(ejercicios1_3.leerFlotante("testjunit").size() == 9, "Comprobamos que lee el numero indicado de floats");
            Files.deleteIfExists(Paths.get("testjunit"));
           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getFrases() {
        Scanner sc = null;
        try {
            List<String> lista = List.of("asdasd", "asdasd", "asdasd", "asdasd", "asdasd", "asdasd", "asdasd", "asdasd", "-1");
            Files.write(Paths.get("testjunit"), lista);
            sc = new Scanner(Paths.get("testjunit").toFile());
            List<String> list = ejercicios1_3.getFrases(sc);
            sc.close();
            Files.deleteIfExists(Paths.get("testjunit"));
            //El fichero tiene 9 lineas predifinidas pero la ultima es -1 para acabar el metodo
            Assumptions.assumeTrue(list.size() == 8, "Comprobacion que agrega correctamente objetos a la lista");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
