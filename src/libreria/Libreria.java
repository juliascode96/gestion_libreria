package libreria;

import java.util.Scanner;
import libreria.servicios.AutorSV;
import libreria.servicios.EditorialSV;
import libreria.servicios.LibroSV;

public class Libreria {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibroSV l = new LibroSV();
        AutorSV a = new AutorSV();
        EditorialSV e = new EditorialSV();
        int r = 100;
        do {
            System.out.println("Qué desea hacer?");
            System.out.println("1.Agregar un autor \n 2.Agregar editorial \n 3.Agregar libro \n 4.Buscar libro/s \n 0.Salir");
            r = sc.nextInt();
            
            switch(r) {
                case 1:
                 a.crearAutor();
                 break;
                case 2:
                    e.crearEditorial();
                    break;
                case 3:
                    l.crearLibro();
                    break;
                case 4:
                    System.out.println("Cómo desea buscar? \n 1.Por ISBN \n 2.Por titulo \n 3.Por autor \n 4.Por editorial");
                    int s = sc.nextInt();
                    
                    switch(s) {
                        case 1:
                            System.out.println(l.buscarISBN().getTitulo() + ", " + l.buscarLibroTitulo().getEjemplaresRestantes());
                            break;
                        case 2:
                            System.out.println(l.buscarLibroTitulo().getTitulo() + ", " + l.buscarLibroTitulo().getEjemplaresRestantes());
                            break;
                        case 3:
                            System.out.println(l.buscarLibroAutor());
                            break;
                        case 4:
                            System.out.println(l.buscarLibroEditorial());
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
                    

            }
        } while (r!=0);
    }

}
