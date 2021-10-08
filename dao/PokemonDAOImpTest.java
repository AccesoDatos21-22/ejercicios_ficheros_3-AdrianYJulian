package dao;

import eu.iamgio.pokedex.pokemon.Pokemon;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PokemonDAOImpTest {
    private static Pokemon tempPokemon;

    @Test
    public void testImprimirPokemon() {

        try (BufferedReader bw = new BufferedReader(new FileReader("./test.txt"))) {
            String frase = bw.readLine();
            for (int i = 1; i <= 100; i++) {
                String[] split;
                tempPokemon = Pokemon.fromId(i);
                split = frase.split(";");
                assertEquals(tempPokemon.getName(), split[0]);
                frase = bw.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // fail("Not yet implemented");
}
