import dao.AulaDAOImp;

import modelo.Aula;


import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
    	
    	
        AulaDAOImp a=new AulaDAOImp(5);
       

        a.leeAlumnos(Path.of("test.txt"));
        
      
    }
}
