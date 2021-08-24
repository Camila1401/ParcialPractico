package dominio;

public class MensajeTiempoAgotado extends Mensaje{

    public MensajeTiempoAgotado(){
        cuerpo = "Buenas Dias. Por este medio la biblioteca ScoobyDoo le notifica que se vencio el plazo " +
                "acordado para la devolucion de los libros. A partir del dia de la fecha se le comenzara a " +
                "acumular una multa de dias en la que no podra retirar libros nuevos." +
                "Un cordial saludo, ScoobyDoo.";

        asunto = "Aviso de morosidad";
    }
}
