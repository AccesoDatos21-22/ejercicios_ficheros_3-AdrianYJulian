package modelo;

import eu.iamgio.pokedex.pokemon.Stat;

import java.io.Serializable;

//Nombre, nivel, Vida, ataque, defensa, ataqueEspecial, DefensaEspecial y velocidad.
public class Pokemon implements Serializable {
    private String nombre;
    private int nivel, vida, ataque, defensa, ataqueEspecial, defensaEspecial, velocidad;
    private eu.iamgio.pokedex.pokemon.Pokemon getPokemon;

    public Pokemon(int id) {
        getPokemon = getPokemon.fromId(id);
        this.nivel = 1;
        this.nombre = getPokemon.getName();
        this.vida = getPokemon.getStat(Stat.Type.HP).getBaseStat();
        this.ataque = getPokemon.getStat(Stat.Type.ATTACK).getBaseStat();
        this.defensa = getPokemon.getStat(Stat.Type.DEFENSE).getBaseStat();
        this.ataqueEspecial = getPokemon.getStat(Stat.Type.SPECIAL_ATTACK).getBaseStat();
        this.defensaEspecial = getPokemon.getStat(Stat.Type.SPECIAL_DEFENSE).getBaseStat();
        this.velocidad = getPokemon.getStat(Stat.Type.SPEED).getBaseStat();
    }

    public Pokemon(String nombre) {
        getPokemon = getPokemon.fromName(nombre);
        this.nivel = 1;
        this.nombre = getPokemon.getName();
        this.vida = getPokemon.getStat(Stat.Type.HP).getBaseStat();
        this.ataque = getPokemon.getStat(Stat.Type.ATTACK).getBaseStat();
        this.defensa = getPokemon.getStat(Stat.Type.DEFENSE).getBaseStat();
        this.ataqueEspecial = getPokemon.getStat(Stat.Type.SPECIAL_ATTACK).getBaseStat();
        this.defensaEspecial = getPokemon.getStat(Stat.Type.SPECIAL_DEFENSE).getBaseStat();
        this.velocidad = getPokemon.getStat(Stat.Type.SPEED).getBaseStat();
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
}
