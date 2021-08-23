package dominio;

import java.util.*;

public class ControladorPrestables {

    public Prestable generarPrestable(List<Copia> copias){
        if(copias.size() == 1){
            return new PrestableSimple(copias.get(0));
        } else {
            Paquete paqueteGeneral = new Paquete();

            //aca falta filtrar la lista con los generos q se repiten
            List<Copia> listaFiltrada = new ArrayList<>();

            if(listaFiltrada.size() == 0){
                copias.forEach(copia -> paqueteGeneral.agregarPrestable(new PrestableSimple(copia)));
            } else {
                //aca faltaria ver el tema de crear paquetes por genero, meterle los prestables y ver cuales copias sobran
            }
            return paqueteGeneral;
        }
    }


}
