package dominio;

public class MensajeAvisoPrevio extends Mensaje{
    public MensajeAvisoPrevio(){
        cuerpo = "Buenas Dias. Por este medio la biblioteca ScoobyDoo le notifica que faltan 3 dias " +
                " para que se venza el plazo acordado para la devolucion de los libros. " +
                "A partir del dia del vencimiento se le comenzara a acumular una multa de 5 dias en la " +
                "que no podra retirar libros nuevos, por cada dia de mora. " +
                "Un cordial saludo, ScoobyDoo.";

        asunto = "Aviso previo de morosidad";
    }
}
