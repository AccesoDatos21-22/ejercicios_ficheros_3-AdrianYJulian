import dao.AulaDAOImp;
import dao.PokemonDAOImp;
import eu.iamgio.pokedex.pokemon.Pokemon;
import eu.iamgio.pokedex.pokemon.Stat;
import ficheros.Ejercicios1_3;

import java.nio.file.Path;
import java.util.Scanner;

public class Main {

    private static Pokemon tempPokemon;

    public static void main(String[] args) {
        PokemonDAOImp pk = new PokemonDAOImp(50);
        Scanner scanner = new Scanner(System.in);
        Ejercicios1_3 ejercicios1_3 = new Ejercicios1_3();
        AulaDAOImp a = new AulaDAOImp(5);


        //Ejercicio1
        for (int i = 1; i <= 5; i++) {
            tempPokemon = Pokemon.fromId(i);
            pk.escribirPokemon("test", tempPokemon.getName(), tempPokemon.getStat(Stat.Type.HP).getBaseStat(), tempPokemon.getStat(Stat.Type.ATTACK).getBaseStat(), tempPokemon.getStat(Stat.Type.DEFENSE).getBaseStat(), tempPokemon.getStat(Stat.Type.SPECIAL_ATTACK).getBaseStat(), tempPokemon.getStat(Stat.Type.SPECIAL_DEFENSE).getBaseStat(), tempPokemon.getStat(Stat.Type.SPEED).getBaseStat());
            modelo.Pokemon tempmodelo = new modelo.Pokemon(tempPokemon.getId());
            pk.add(tempmodelo);
            pk.escribirPokemon("test2", tempmodelo);
        }
        pk.eliminar(new modelo.Pokemon("bulbasaur", 2, 2, 2, 2, 2, 2, 2));
        //Ejercicio2
        pk.imprimirPokemon("test.csv");
        pk.leerPokemon("test2.csv");
        //Ejercicio3
//        ejercicios1_3.escribefrases(ejercicios1_3.getFrases(scanner), ejercicios1_3.getNombre(scanner));
//        //Ejercicio4
//        ejercicios1_3.escribefrasesOutputStream(ejercicios1_3.getFrases(scanner), ejercicios1_3.getNombre(scanner));
//        //Ejercicio5
//        ejercicios1_3.escribefrasesBufferedWriter(ejercicios1_3.getFrases(scanner), ejercicios1_3.getNombre(scanner));
//        //Ejercicio6
//        ejercicios1_3.escribefrasesconScanner(scanner, ejercicios1_3.getNombre(scanner));
//        //Ejercicio8
//        ejercicios1_3.leerFrases(ejercicios1_3.getNombre(scanner));
//        //Ejercicio9
        ejercicios1_3.escribirFlotante((float) 1.3123132131232131, "test.dat");
        //Ejercicio10
        ejercicios1_3.imprimirFlotante("test.dat");
        //Ejercicio11
        ejercicios1_3.leerFlotante("test.dat");
        //Ejercicio12
        modelo.Pokemon p1 = new modelo.Pokemon(2);
        System.out.println(p1);
        //Ejercicio13
        p1.escribirPokemon("test.txt", p1);
        //Ejercicio14
        p1.leerPokemon("test.txt").forEach(System.out::println);
        //Ejercicio15
        p1.escribirPokemon("test.txt", pk.getPokemones());
        p1.leerPokemon("test.txt", "saur").forEach(System.out::println);
        pk.leerPokemon("test.txt", "saur").forEach(System.out::println);
        //Ejercicio16
        a.escribeAlumnos(Path.of("test.txt"));
//        a.leeAlumnos(Path.of("test.txt"));
        a.informacionAlumnos();
        //Ejercicio17
       // a.leeAlumnosReadAllLines(Path.of("test.txt"));
    }

}
