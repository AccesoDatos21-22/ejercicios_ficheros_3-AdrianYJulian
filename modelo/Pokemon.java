package modelo;

import eu.iamgio.pokedex.pokemon.Stat;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

//Nombre, nivel, Vida, ataque, defensa, ataqueEspecial, DefensaEspecial y velocidad.
public class Pokemon implements Serializable {
    private final List<Pokemon> listaPokemon;
    private String nombre;
    private int nivel, vida, ataque, defensa, ataqueEspecial, defensaEspecial, velocidad;
    public Pokemon(String nombre, int nivel, int vida, int ataque, int defensa, int ataqueEspecial, int defensaEspecial, int velocidad) {
        this.listaPokemon = new ArrayList<>();
        this.nombre = nombre;
        this.nivel = nivel;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.ataqueEspecial = ataqueEspecial;
        this.defensaEspecial = defensaEspecial;
        this.velocidad = velocidad;
    }
    public Pokemon(int id) {
        this.nivel = 1;
        this.nombre = eu.iamgio.pokedex.pokemon.Pokemon.fromId(id).getName();
        this.vida = eu.iamgio.pokedex.pokemon.Pokemon.fromId(id).getStat(Stat.Type.HP).getBaseStat();
        this.ataque = eu.iamgio.pokedex.pokemon.Pokemon.fromId(id).getStat(Stat.Type.ATTACK).getBaseStat();
        this.defensa = eu.iamgio.pokedex.pokemon.Pokemon.fromId(id).getStat(Stat.Type.DEFENSE).getBaseStat();
        this.ataqueEspecial = eu.iamgio.pokedex.pokemon.Pokemon.fromId(id).getStat(Stat.Type.SPECIAL_ATTACK).getBaseStat();
        this.defensaEspecial = eu.iamgio.pokedex.pokemon.Pokemon.fromId(id).getStat(Stat.Type.SPECIAL_DEFENSE).getBaseStat();
        this.velocidad = eu.iamgio.pokedex.pokemon.Pokemon.fromId(id).getStat(Stat.Type.SPEED).getBaseStat();
        this.listaPokemon = new ArrayList<>();
    }

    public Pokemon(String nombre) {
        this.nivel = 1;
        this.nombre = eu.iamgio.pokedex.pokemon.Pokemon.fromName(nombre).getName();
        this.vida = eu.iamgio.pokedex.pokemon.Pokemon.fromName(nombre).getStat(Stat.Type.HP).getBaseStat();
        this.ataque = eu.iamgio.pokedex.pokemon.Pokemon.fromName(nombre).getStat(Stat.Type.ATTACK).getBaseStat();
        this.defensa = eu.iamgio.pokedex.pokemon.Pokemon.fromName(nombre).getStat(Stat.Type.DEFENSE).getBaseStat();
        this.ataqueEspecial = eu.iamgio.pokedex.pokemon.Pokemon.fromName(nombre).getStat(Stat.Type.SPECIAL_ATTACK).getBaseStat();
        this.defensaEspecial = eu.iamgio.pokedex.pokemon.Pokemon.fromName(nombre).getStat(Stat.Type.SPECIAL_DEFENSE).getBaseStat();
        this.velocidad = eu.iamgio.pokedex.pokemon.Pokemon.fromName(nombre).getStat(Stat.Type.SPEED).getBaseStat();
        this.listaPokemon = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pokemon pokemon = (Pokemon) o;

        if (nivel != pokemon.nivel) return false;
        if (vida != pokemon.vida) return false;
        if (ataque != pokemon.ataque) return false;
        if (defensa != pokemon.defensa) return false;
        if (ataqueEspecial != pokemon.ataqueEspecial) return false;
        if (defensaEspecial != pokemon.defensaEspecial) return false;
        if (velocidad != pokemon.velocidad) return false;
        return nombre != null ? nombre.equals(pokemon.nombre) : pokemon.nombre == null;
    }

    @Override
    public int hashCode() {
        int result = nombre != null ? nombre.hashCode() : 0;
        result = 31 * result + nivel;
        result = 31 * result + vida;
        result = 31 * result + ataque;
        result = 31 * result + defensa;
        result = 31 * result + ataqueEspecial;
        result = 31 * result + defensaEspecial;
        result = 31 * result + velocidad;
        return result;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", vida=" + vida +
                ", ataque=" + ataque +
                ", defensa=" + defensa +
                ", ataqueEspecial=" + ataqueEspecial +
                ", defensaEspecial=" + defensaEspecial +
                ", velocidad=" + velocidad +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }



    public void setAtaqueEspecial(int ataqueEspecial) {
        this.ataqueEspecial = ataqueEspecial;
    }

    public int getDefensaEspecial() {
        return defensaEspecial;
    }

    public void setDefensaEspecial(int defensaEspecial) {
        this.defensaEspecial = defensaEspecial;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void escribirPokemon(String ruta, Pokemon pokemon) {
        int cont = 0;
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(ruta)))) {
            this.listaPokemon.add(pokemon);
            Iterator<Pokemon> it = listaPokemon.iterator();
            while (it.hasNext()) {
                if (it.next().equals(pokemon)) {
                    cont++;
                    if (cont > 1) {
                        it.remove();
                    }
                }

            }

            objectOutputStream.writeObject(listaPokemon);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void escribirPokemon(String ruta, List<Pokemon> pokemon) {
        int cont = 0;
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(ruta)))) {
            this.listaPokemon.addAll(pokemon);
            Iterator<Pokemon> it = listaPokemon.iterator();
            while (it.hasNext()) {
                if (it.next().equals(pokemon)) {
                    cont++;
                    if (cont > 1) {
                        it.remove();
                    }
                }

            }

            objectOutputStream.writeObject(listaPokemon);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Pokemon> leerPokemon(String ruta) {
        List<Pokemon> pokemonList = new ArrayList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(Paths.get(ruta)))) {
            pokemonList.addAll((Collection<? extends Pokemon>) objectInputStream.readObject());
        } catch (EOFException e) {
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return pokemonList;

    }

    public List<Pokemon> leerPokemon(String ruta, String nombre) {
        List<Pokemon> pokemonList = new ArrayList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(Paths.get(ruta)))) {
            pokemonList.addAll((Collection<? extends Pokemon>) objectInputStream.readObject());
            pokemonList.removeIf(pokemon -> !pokemon.nombre.toLowerCase().contains(nombre.toLowerCase()));
        } catch (EOFException e) {
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return pokemonList;

    }
}
