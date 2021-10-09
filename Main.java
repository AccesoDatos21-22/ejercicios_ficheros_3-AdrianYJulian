import dao.PokemonDAOImp;
import eu.iamgio.pokedex.pokemon.Pokemon;
import eu.iamgio.pokedex.pokemon.Stat;
import ficheros.Ejercicios1_3;

import java.util.Scanner;

public class Main {

	private static Pokemon tempPokemon;
	public static void main(String[] args) {
		PokemonDAOImp pk=new PokemonDAOImp(50);
		Scanner scanner = new Scanner(System.in);
		Ejercicios1_3 ejercicios1_3 = new Ejercicios1_3();
		//Ejercicio1
		for (int i = 1; i <= 100 ; i++) {
			tempPokemon = Pokemon.fromId(i);
			pk.escribirPokemon("test",tempPokemon.getName(), tempPokemon.getStat(Stat.Type.HP).getBaseStat(),tempPokemon.getStat(Stat.Type.ATTACK).getBaseStat(),tempPokemon.getStat(Stat.Type.DEFENSE).getBaseStat(),tempPokemon.getStat(Stat.Type.SPECIAL_ATTACK).getBaseStat(),tempPokemon.getStat(Stat.Type.SPECIAL_DEFENSE).getBaseStat(),tempPokemon.getStat(Stat.Type.SPEED).getBaseStat());
		}
		//Ejercicio2
		pk.imprimirPokemon("test.csv");
		//Ejercicio3
		ejercicios1_3.escribefrases(ejercicios1_3.getFrases(scanner),ejercicios1_3.getNombre(scanner));
		//Ejercicio4
		ejercicios1_3.escribefrasesOutputStream(ejercicios1_3.getFrases(scanner),ejercicios1_3.getNombre(scanner));
		//Ejercicio5
		ejercicios1_3.escribefrasesBufferedWriter(ejercicios1_3.getFrases(scanner),ejercicios1_3.getNombre(scanner));
		//Ejercicio6
		ejercicios1_3.escribefrasesconScanner(scanner,ejercicios1_3.getNombre(scanner));
		//Ejercicio8
		ejercicios1_3.leerFrases(ejercicios1_3.getNombre(scanner));
		//Ejercicio9
		//Ejercicio10
		//Ejercicio11
		//Ejercicio12
	}

}
