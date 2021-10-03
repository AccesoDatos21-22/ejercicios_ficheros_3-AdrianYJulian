import ficheros.Ejercicios1_3;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ejercicios1_3 ejercicios1_3 = new Ejercicios1_3();
        ejercicios1_3.leerFrases(ejercicios1_3.getNombre(scanner));
    }
}
