import ficheros.Ejercicios1_3;

public class Main {

    public static void main(String[] args) {
        Ejercicios1_3 ejercicios1_3 = new Ejercicios1_3();
        ejercicios1_3.escribirFlotante((float) 1.3123132131232131, "test.dat");
        ejercicios1_3.leerFlotante("test.dat");
    }
}
