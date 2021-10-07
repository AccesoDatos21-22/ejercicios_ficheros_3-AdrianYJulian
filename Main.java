import dao.AulaDAOImp;

import modelo.Aula;


import java.awt.*;
import java.nio.file.Path;
import java.time.Clock;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

    	
        AulaDAOImp a=new AulaDAOImp(5);
       
//a.escribeAlumnos(Path.of("test.txt"));
        a.leeAlumnos(Path.of("test.txt"));



        
      
    }
}
