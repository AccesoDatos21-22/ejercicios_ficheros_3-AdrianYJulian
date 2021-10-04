import dao.AulaDAOImp;
import ficheros.Ejercicios1_3;
import modelo.Aula;
import modelo.Pokemon;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        AulaDAOImp a=new AulaDAOImp(5);
        Aula aula1=new Aula(5);
        a.leeAlumnos(Path.of("test.txt"));
        aula1.informacionAlumnos();
    }
}
