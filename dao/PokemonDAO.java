package dao;

import modelo.Pokemon;

import java.util.List;

public interface PokemonDAO {


    /**
     * Comprueba si el almacén está vacio
     *
     * @return true si está vacio
     */
    boolean estaVacio();

    /**
     * Comprueba si el almacén está lleno
     *
     * @return
     */
    boolean estaLLeno();

    /**
     * Anade un nuevo elemento al almacén si hay sitio
     *
     * @param valor a anadir al almacén
     */
    void add(Pokemon pokemon);

    /**
     * Elimina un elemento del almacén si está en el almacen
     *
     * @param valor
     * @return true si elimina el elemento, false en caso contrario
     */
    boolean eliminar(Pokemon pokemon);


    /**
     * escribe en un fichero de texto “csv la información de un pokemon separando
     * los campos por puntos y coma.
     * <p>
     * Nombre;nivel;Vida;ataque;defensa;ataqueEspecial;DefensaEspecial;velocidad
     * En caso de existir el fichero, no se borrará, se seguirán añadiendo pokemons
     * al final.
     *
     * @param ruta fichero de texto
     */
    void escribirPokemon(String ruta, String name, int life, int atack, int defense, int specialAttack, int specialdefense, int speed);


    /**
     * Imprime por pantalla el contenido del fichero csv con los pokemon de la forma:
     * Name: <Nombre>
     * level: <nivel>
     * HP: <Vida>
     * attack: <Vida>
     * defense: <defensa>
     * Special attack: <AtaqueEspecial>
     * Special defense: <DefensaEspecial>
     * speed: <velocidad>
     *
     * @param ruta
     */
    void imprimirPokemon(String ruta);


    /**
     * escribe en un fichero objetos pokemon	 *
     * <p>
     * En caso de existir el fichero, no se borrará, se seguirán añadiendo pokemons
     * al final.
     *
     * @param ruta fichero de texto
     */
    void escribirPokemon(String ruta, Pokemon pokemon);

    /**
     * devuelve una lista de objetos pokemon del fichero.
     *
     * @param ruta
     * @return
     */
    List<Pokemon> leerPokemon(String ruta);

    /**
     * devuelve una lista de objetos pokemon que contengan esa cadena en el nombre.
     *
     * @param ruta
     * @param nombre
     * @return
     */
    List<Pokemon> leerPokemon(String ruta, String nombre);


}
