package dominio;

public class Multa {
    private int dias;

    Multa(){
        dias = 0;
    }

    public void agregarDia(){
        dias += 5;
    }

    public void sacarDia() {
        if (dias > 0) {
            dias -= 1;
        }
    }

}
