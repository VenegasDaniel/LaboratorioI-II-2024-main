package cl.ucn.proxy;

import cl.ucn.modelo.Usuario;
import cl.ucn.modelo.RecursosMultimedia;
import cl.ucn.util.Util;
import jakarta.persistence.*;

public class UsuarioProxy implements UsuarioSearch{

    private EntityManager em;
    private Util util;

    public UsuarioProxy(EntityManager em) {
        this.em = em;
        this.util = new Util();
    }

    public Usuario buscarUsuario(int rut) {
        // Intentar buscar el usuario en la base de datos
        String jpql = "SELECT u FROM Usuario u WHERE u.rut = :rut";
        TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
        query.setParameter("rut", rut);
        try {
            Usuario usuario = query.getSingleResult();
            System.out.println("Usuario encontrado en la base de datos: " + usuario.getRut());
            return usuario;
        } catch (NoResultException e) {
            System.out.println("Usuario no encontrado en la base de datos, buscando en archivo CSV...");
            return buscarUsuarioEnCsv(rut);
        }
    }

    private Usuario buscarUsuarioEnCsv(int rut) {
        // Buscar el usuario en el archivo CSV
        for (Usuario usuario : util.loadCsv()) {
            if (usuario.getRut() == rut) {
                System.out.println("Usuario encontrado en CSV: " + usuario.getRut());
                return usuario;
            }
        }
        System.out.println("Usuario no encontrado ni en la base de datos ni en el archivo CSV.");
        return null;
    }

    public void mostrarArchivo(Usuario usuario) {
        // Verificar si el usuario tiene permisos y si el archivo es protegido
        RecursosMultimedia recurso = usuario.getRecursosMultimedia();
        if (recurso != null) {
            if (usuario.isTienePermiso()) {
                System.out.println("Permiso válido. Mostrando archivo.");
                recurso.mostrar();
            } else {
                System.out.println("Acceso denegado. El usuario no tiene permisos para ver este archivo.");
            }
        } else {
            System.out.println("El usuario no tiene archivos asignados.");
        }
    }
}
