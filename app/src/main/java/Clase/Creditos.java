package Clase;

public class Creditos {
    private int cre_hipotecarios;
    private int cre_automotriz;

    public Creditos()
    {
        cre_automotriz = 500000;
        cre_hipotecarios = 1000000;
    }
    public int getCre_hipotecarios(){return cre_hipotecarios;}

    public int getCre_automotriz(){return cre_automotriz;}
}
