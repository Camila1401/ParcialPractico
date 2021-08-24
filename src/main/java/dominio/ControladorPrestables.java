package dominio;

import java.util.*;
import java.util.stream.Collectors;

import static dominio.Genero.todos;

public class ControladorPrestables {

    public Prestable generarPrestable(List<Copia> copias){

        Prestado prestado = new Prestado();

        copias.forEach(copia -> copia.modificarEstado(prestado));

        if(copias.size() == 1){
            return new PrestableSimple(copias.get(0));
        } else {
            Paquete paqueteGeneral = new Paquete();
            List<Genero> generos = todos();

            generos.forEach(genero -> {
                List<Copia> sublista = copias.stream()
                        .filter(copia -> copia.matchearGenero(genero))
                        .collect(Collectors.toList());
                if(sublista.size() == 0){ } else {
                    if(sublista.size() == 1){
                        PrestableSimple prestableSimple = new PrestableSimple(sublista.get(0));
                        paqueteGeneral.agregarPrestable(prestableSimple);
                    } else {
                        Paquete paqueteGenero = new Paquete();
                        sublista.forEach(copia -> {
                        PrestableSimple prestableSimple = new PrestableSimple(copia);
                        paqueteGenero.agregarPrestable(prestableSimple);
                        });
                        paqueteGeneral.agregarPrestable(paqueteGenero);
                    }
                }
            });
            return paqueteGeneral;
        }
    }


}
