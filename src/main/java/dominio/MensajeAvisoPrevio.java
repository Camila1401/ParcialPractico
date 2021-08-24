package dominio;

public class MensajeAvisoPrevio extends Mensaje{
    public MensajeAvisoPrevio(){
        cuerpo = "Buenas Dias. Por este medio la biblioteca ScoobyDoo le notifica que faltan 3 dias " +
                " para que se venza el plazo acordado para la devolucion de los libros. " +
                "Un cordial saludo, ScoobyDoo.";

        asunto = "Aviso previo de morosidad";
    }
}
