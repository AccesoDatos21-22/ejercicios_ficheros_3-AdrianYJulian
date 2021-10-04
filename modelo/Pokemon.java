package modelo;

import eu.iamgio.pokedex.pokemon.Stat;

import java.io.Serializable;

//Nombre, nivel, Vida, ataque, defensa, ataqueEspecial, DefensaEspecial y velocidad.
public class Pokemon implements Serializable {
    private String nombre;
    private int nivel, vida, ataque, defensa, ataqueEspecial, defensaEspecial, velocidad;
    eu.iamgio.pokedex.pokemon.Pokemon getPokemon;


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
