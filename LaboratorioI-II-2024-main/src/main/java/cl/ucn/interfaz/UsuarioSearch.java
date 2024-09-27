import cl.ucn.modelo.Usuario;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public interface UsuarioSearch{

    Usuario buscarUsuario(int rut);
    void mostrarArchivo(Usuario usuario);

}