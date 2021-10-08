package dao;

import modelo.Pokemon;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PokemonDAOImp implements PokemonDAO {

    private List<Pokemon> pokemones;
    private int numPokemones; // atributo para controlar el numero real de
    // elementos que tiene nuestro almacen

    /**
     * Constructor del Almacen con un determinado tamano
     *
     * @param tamano
     */
    public PokemonDAOImp(int tamano) {
        pokemones = new ArrayList<Pokemon>(tamano);
        numPokemones = tamano;
    }

    @Override
    public boolean estaVacio() {
        return false;
    }

    @Override
    public boolean estaLLeno() {
        return false;
    }


    @Override
    public void add(Pokemon pokemon) {

    }


    @Override
    public boolean eliminar(Pokemon pokemon) {
        return false;
    }


    @Override
    public void escribirPokemon(String ruta, String name, int life, int atack, int defense, int specialAttack, int specialdefense, int speed) {
        //Accedemos a la ruta definida por el usuario
        File ficheropokemon;
        Path rutaPokemon;
        if (ruta.endsWith(".csv")) {
            ficheropokemon = new File(ruta);
            rutaPokemon = Paths.get(ruta);
        } else {
            ficheropokemon = new File(ruta + ".csv");
            rutaPokemon = Paths.get(ruta + ".csv");
        }


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ficheropokemon, true))) {
            //Comprobamos si el archivo existe
            if (ficheropokemon.exists()) {
                //Leemos el fichero y lo pasamos a una lista
                List<String> pokemonsExistentes = Files.readAllLines(rutaPokemon);
                boolean comprobador = false;
                String pokemon = name + ";" + life + ";" + atack + ";" + defense
                        + ";" + specialAttack + ";" + specialdefense + ";" + speed;

                for (String pokemonsExistente : pokemonsExistentes) {
                    String[] corte = pokemonsExistente.split(";");
                    if (corte[0].contains(name)) {
                        comprobador = true;
                        break;
                    }
                }
                //Comprobamos si el pokemon que se quiere insertar existe en el fichero
                if (!comprobador) {
                    bw.write(pokemon);
                    bw.newLine();
                }
            } else {
                ficheropokemon.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void imprimirPokemon(String ruta) {

    }

    @Override
    public void escribirPokemon(String ruta, Pokemon pokemon) {

    }

    @Override
    public List<Pokemon> leerPokemon(String ruta) {
        return null;
    }

    @Override
    public List<Pokemon> leerPokemon(String ruta, String nombre) {
        return null;
    }
}
