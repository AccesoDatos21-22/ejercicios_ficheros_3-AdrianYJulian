import ficheros.Ejercicios1_3;
import modelo.Pokemon;

public class Main {

    public static void main(String[] args) {
        Pokemon p1 = new Pokemon(2);

//        p1.escribirPokemon("test.txt",p1);
        p1.leerPokemon("test.txt").forEach(System.out::println);
    }
}
