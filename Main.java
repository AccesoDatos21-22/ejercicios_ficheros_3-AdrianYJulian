import dao.PokemonDAOImp;

public class Main {
	
	public static void main(String[] args) {
		PokemonDAOImp pk=new PokemonDAOImp(5);
		pk.escribirPokemon("./test.txt","bulva",5,20,15,2,3,120);



	}

}
