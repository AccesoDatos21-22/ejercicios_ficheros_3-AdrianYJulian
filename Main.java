import dao.PokemonDAOImp;
import eu.iamgio.pokedex.pokemon.Pokemon;
import eu.iamgio.pokedex.pokemon.Stat;

public class Main {

	private static Pokemon tempPokemon;
	public static void main(String[] args) {
		PokemonDAOImp pk=new PokemonDAOImp(50);
		for (int i = 1; i <= 100 ; i++) {
			tempPokemon = Pokemon.fromId(i);
			pk.escribirPokemon("./test.txt",tempPokemon.getName(), 50,tempPokemon.getStat(Stat.Type.ATTACK).getBaseStat(),tempPokemon.getStat(Stat.Type.DEFENSE).getBaseStat(),tempPokemon.getStat(Stat.Type.SPECIAL_ATTACK).getBaseStat(),tempPokemon.getStat(Stat.Type.SPECIAL_DEFENSE).getBaseStat(),tempPokemon.getStat(Stat.Type.SPEED).getBaseStat());

		}
	}

}
