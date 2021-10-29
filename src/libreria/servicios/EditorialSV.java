
package libreria.servicios;

import java.util.Scanner;
import libreria.entidades.Editorial;

public class EditorialSV extends DAO{
    
    Scanner sc = new Scanner(System.in);

    public Editorial crearEditorial() {
        Editorial e = new Editorial();
        System.out.println("Por favor ingrese el nombre de la editorial");
        e.setNombre(sc.nextLine());
        e.setAlta(true);
        guardarEditorial(e);
        return e;
    }
    
    public Editorial buscarEditorialNombre() {
        System.out.println("Ingrese nombre de la editorial a buscar");
        String nombre = sc.nextLine();
        Editorial e = queryEditorialS("SELECT e FROM Editorial e WHERE e.nombre IN :nombre", nombre);
        return e;
    }
    
}
