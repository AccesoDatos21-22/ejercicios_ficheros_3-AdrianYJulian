public class prueba {
    public static void main(String[] args) {
        String nombre = "Pokemon{nombre='bulbasaur'";
        nombre = nombre.substring(nombre.lastIndexOf("=") + 2, nombre.lastIndexOf("'"));
        System.out.println(nombre);

    }
}
