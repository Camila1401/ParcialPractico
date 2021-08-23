package dominio;

import java.util.Arrays;
import java.util.List;

public enum Genero {
    POLICIAL, PARANINIOS, CIENTIFICO, MANGA, FANTASIA;

    public static List<Genero> todos(){
        return Arrays.asList(Genero.values());
    }
}
