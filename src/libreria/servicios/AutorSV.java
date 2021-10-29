package libreria.servicios;

import libreria.entidades.Autor;
import java.util.Scanner;

public class AutorSV extends DAO {
    Scanner sc = new Scanner(System.in);

    public Autor crearAutor() {
        Autor a = new Autor();
        System.out.println("Por favor ingrese el nombre del autor");
        a.setNombre(sc.nextLine());
        a.setAlta(true);
        guardarAutor(a);
        return a;
    }
    
    public Autor editarAutor() {
        Autor a = buscarAutorNombre();
        System.out.println("Por favor ingrese nuevo nombre");
        String nn = sc.nextLine();
        a.setNombre(nn);
        editarAutor(a);
        return a;
    }
    
    public Autor buscarAutorNombre() {
        System.out.println("Ingrese apellido de autor a buscar");
        String nombre = sc.nextLine();
        Autor a = queryAutorS("SELECT a FROM Autor a WHERE a.nombre IN :nombre", nombre);
        //SELECT u FROM User u WHERE u.name IN :names
        return a;
    }

}
