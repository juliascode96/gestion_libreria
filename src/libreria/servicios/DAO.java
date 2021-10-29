package libreria.servicios;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;

public class DAO {

    EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU2").createEntityManager();

    public void guardarLibro(Libro l) {
        em.getTransaction().begin();
        em.persist(l);
        em.getTransaction().commit();
    }

    public void guardarAutor(Autor a) {
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
    }

    public void guardarEditorial(Editorial e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    public void editarLibro(Libro l) {
        em.getTransaction().begin();
        em.merge(l);
        em.getTransaction().commit();
    }

    public void editarAutor(Autor a) {
        em.getTransaction().begin();
        em.merge(a);
        em.getTransaction().commit();
    }

    public void editarEditorial(Editorial e) {
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
    }

    public Libro buscarLibro(Long isbn) {
        Libro l = em.find(Libro.class, isbn);
        return l;
    }

    public Autor buscarAutor(Integer id) {
        Autor a = em.find(Autor.class, id);
        return a;
    }

    public Editorial buscarEditorial(Integer id) {
        Editorial e = em.find(Editorial.class, id);
        return e;
    }

    public void borrarLibro(Libro l) {
        em.getTransaction().begin();
        em.remove(l);
        em.getTransaction().commit();
    }

    public void borrarAutor(Autor a) {
        em.getTransaction().begin();
        em.remove(a);
        em.getTransaction().commit();
    }

    public void borrarEditorial(Editorial e) {
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
    }

    public void altaBajaLibro(Libro l, boolean estado) {
        l = em.find(Libro.class, l.getIsbn());
        l.setAlta(estado);

        em.getTransaction().begin();
        em.merge(l);
        em.getTransaction().commit();
    }

    public void altaBajaAutor(Autor a, boolean estado) {
        a = em.find(Autor.class, a.getId());
        a.setAlta(estado);

        em.getTransaction().begin();
        em.merge(a);
        em.getTransaction().commit();
    }

    public void altaBajaEditorial(Editorial e, boolean estado) {
        e = em.find(Editorial.class, e.getId());
        e.setAlta(estado);

        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
    }

    public List<Libro> queryLibro(String consulta, String var) {
        List<Libro> libros = em.createQuery(consulta).setParameter("nombre", var).getResultList();
        return libros;
    }

//    Query q =  em.createQuery("SELECT p FROM Parents p WHERE p.login = :login");
//       q.setParameter("login", login);
//       q.setMaxResults(1);
//       Parents p = (Parents) q.getSingleResult();
    public List<Autor> queryAutor(String consulta, String nombre) {
        Query q = em.createQuery(consulta);
        q.setParameter("nombre", nombre);
        List<Autor> autores = q.getResultList();
        return autores;
    }

    public List<Editorial> queryEditorial(String consulta, String nombre) {
        Query q = em.createQuery(consulta);
        q.setParameter("nombre", nombre);
        List<Editorial> editoriales = q.getResultList();
        return editoriales;
    }

    public Autor queryAutorS(String consulta, String nombre) {
        Autor a = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre = :nombre").setParameter("nombre", nombre).getSingleResult();
        return a;
    }

    public Editorial queryEditorialS(String consulta, String nombre) {
        Editorial e = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.nombre = :nombre").setParameter("nombre", nombre).getSingleResult();
        return e;
    }

}
