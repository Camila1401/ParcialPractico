package dominio;

import java.util.List;

public class Biblioteca {
    private List<Usuario> usuarios;
    private List<Copia> copias;

    public List<Copia> copiasDisponibles() {
        return (List<Copia>) copias.stream().filter(Copia::puedePrestarse);
    }
}
