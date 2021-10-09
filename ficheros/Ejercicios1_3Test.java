package ficheros;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.DataInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

class Ejercicios1_3Test {

    private Ejercicios1_3 ejercicios1_3 = new Ejercicios1_3();

    @BeforeEach
    void setUp() {
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
        Assumptions.assumeFalse(ejercicios1_3.leerFlotante("test.dat").getClass() == (List.of(1.123)).getClass(), "Comprobamos que nos traiga una lista de floats");
    }
}