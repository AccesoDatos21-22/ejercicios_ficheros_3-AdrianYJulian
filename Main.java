import modelo.Pokemon;

public class Main {

    public static void main(String[] args) {
        Pokemon p1 = new Pokemon(2);
        p1.escribirPokemon("test.txt",p1);
        for (int i = 1; i <30 ; i++) {
            p1.escribirPokemon("test.txt",new Pokemon(i));
        }

        p1.leerPokemon("test.txt","saur").forEach(System.out::println);
    }
}
