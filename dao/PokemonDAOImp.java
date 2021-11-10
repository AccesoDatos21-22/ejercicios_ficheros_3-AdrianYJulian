package dao;

import modelo.Pokemon;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PokemonDAOImp implements PokemonDAO {

    private final List<Pokemon> pokemones;
    private final int numPokemones; // atributo para controlar el numero real de
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
        return this.pokemones.size() == 0;
    }

    @Override
    public boolean estaLLeno() {
        return this.pokemones.size() == this.numPokemones;


    }


    @Override
    public void add(Pokemon pokemon) {
        pokemones.add(pokemon);
    }


    @Override
    public boolean eliminar(Pokemon pokemon) {

        if (this.pokemones.removeIf(pokemon1 -> pokemon1.getNombre().equals(pokemon.getNombre()))) {
            System.out.println("pokemon eliminado");
        }

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
                    if (corte[0].equals(name)) {
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
        try (BufferedReader bw = new BufferedReader(new FileReader(ruta))) {
            String[] split;
            String frase = bw.readLine();
            while (frase != null) {
                split = frase.split(";");
                System.out.print("name: " + split[0] + " level: " + 1 + " HP: " + split[1] + " attack: " + split[2] + " defense: " + split[3] + " Special attack: " + split[4] + " Special defense: " + split[5] + " speed: " + split[6]);
                frase = bw.readLine();
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void escribirPokemon(String ruta, Pokemon pokemon) {
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
                String name = pokemon.getNombre();

                for (String pokemonsExistente : pokemonsExistentes) {
                    String[] corte = pokemonsExistente.split(",");
                    corte[0] = corte[0].substring(corte[0].lastIndexOf("=") + 2, corte[0].lastIndexOf("'"));
                    if (corte[0].equals(name)) {
                        comprobador = true;
                        break;
                    }
                }
                //Comprobamos si el pokemon que se quiere insertar existe en el fichero
                if (!comprobador) {
                    bw.write(String.valueOf(pokemon));
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
    public List<Pokemon> leerPokemon(String ruta) {
        try (BufferedReader bw = new BufferedReader(new FileReader(ruta))) {
            String[] split;
            String frase = bw.readLine();
            while (frase != null) {
                split = frase.split(",");
                for (int i = 0; i < split.length; i++) {
                    if (i == 0) {
                        split[i] = split[i].substring(split[i].lastIndexOf("=") + 2, split[i].lastIndexOf("'"));
                    }
                    split[i] = split[i].replaceAll("\\D", "");
                }
                this.pokemones.add(new Pokemon(split[0], 1, Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]), Integer.parseInt(split[5]), Integer.parseInt(split[6]), Integer.parseInt(split[7])));
                frase = bw.readLine();
            }
            return this.pokemones;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Pokemon> leerPokemon(String ruta, String nombre) {

        List<Pokemon> pokemonList = new ArrayList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(Paths.get(ruta)))) {
            pokemonList.addAll((Collection<? extends Pokemon>) objectInputStream.readObject());
            pokemonList.removeIf(pokemon -> !pokemon.getNombre().toLowerCase().contains(nombre.toLowerCase()));
        } catch (EOFException e) {
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return pokemonList;
    }

    public List<Pokemon> getPokemones() {
        return pokemones;
    }
}
