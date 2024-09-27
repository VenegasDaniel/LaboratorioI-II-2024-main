package cl.ucn.main;

import cl.ucn.modelo.Usuario;
import cl.ucn.interfaz.*;
import jakarta.persistence.*;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("multimediaApp");
        EntityManager em = emf.createEntityManager();

        // Usar la interfaz para el proxy
        UsuarioService usuarioService = new UsuarioProxy(em);

        // Parte 1: Buscar usuario
        int rut = 89830291;
        Usuario usuario = usuarioService.buscarUsuario(rut);

        // Parte 2: Controlar acceso a recursos multimedia
        if (usuario != null) {
            usuarioService.mostrarArchivo(usuario);
        }

        em.close();
    }
}
