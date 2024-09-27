package cl.ucn.util;


import cl.ucn.modelo.Usuario;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {

    public List<Usuario> loadCsv(){

        String[] values = null;
        List<Usuario> usuarios = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader("externo.csv"));) {
            while ((values = csvReader.readNext()) != null) {

                Usuario usuario = new Usuario();
                usuario.setRut(Integer.valueOf(values[0]));
                usuario.setNombre(values[1]);
                usuario.setTienePermiso(Boolean.valueOf(values[2]));
                usuario.setRecursosMultimedia(null);
                usuarios.add(usuario);
            }
        } catch (FileNotFoundException | CsvValidationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return usuarios;

    }
}
