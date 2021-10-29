package libreria.servicios;

import java.util.List;
import java.util.Scanner;
import libreria.entidades.Libro;

public class LibroSV extends DAO {

    AutorSV asv = new AutorSV();
    EditorialSV esv = new EditorialSV();
    Scanner sc = new Scanner(System.in);

    public Libro crearLibro() {
        Libro l = new Libro();
        System.out.println("Ingrese nombre del libro");
        String nombre = sc.nextLine();
        System.out.println("Ingrese año de publicación");
        int anio = sc.nextInt();
        System.out.println("Ingrese cantidad de ejemplares");
        int ejemplares = sc.nextInt();
        System.out.println("Ingrese cantidad de ejemplares que han sido prestados");
        int ejemplaresPrestados = sc.nextInt();

        l.setAlta(true);
        l.setTitulo(nombre);
        l.setAnio(anio);
        l.setEjemplares(ejemplares);
        l.setEjemplaresPrestados(ejemplaresPrestados);
        l.setEjemplaresRestantes(ejemplares - ejemplaresPrestados);

        l.setAutor(asv.buscarAutorNombre());
        l.setEditorial(esv.buscarEditorialNombre());
        guardarLibro(l);
        return l;
    }

    public Libro buscarISBN() {
        System.out.println("Ingrese ISBN del libro a buscar");
        long isbn = sc.nextLong();
        return buscarLibro(isbn);
    }

    public Libro buscarLibroTitulo() {
        System.out.println("Ingrese titulo del libro a buscar");
        String titulo = sc.nextLine();
        Libro l = queryLibro("select l from Libro l where l.titulo = :nombre", titulo).get(0);
        return l;
    }

    public List<Libro> buscarLibroAutor() {
        String autor = asv.buscarAutorNombre().getNombre();
        List<Libro> libros = queryLibro("select l from Libro l where l.autor.nombre = :nombre", autor);
        return libros;
    }

    public List<Libro> buscarLibroEditorial() {
        String editorial = esv.buscarEditorialNombre().getNombre();
        List<Libro> libros = queryLibro("select l from Libro l where l.editorial.nombre = :nombre",editorial);
        return libros;
    }

}
