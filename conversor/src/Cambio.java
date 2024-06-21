public class Cambio {
    private Moeda de;
    private Moeda para;
    private double taxa;

    public Cambio(Moeda de, Moeda para, double taxa) {
        this.de = de;
        this.para = para;
        this.taxa = taxa;
    }

    public Moeda getDe() {
        return de;  // Retorna o atributo de, não chama recursivamente getDe()
    }

    public Moeda getPara() {
        return para;  // Retorna o atributo para, não chama recursivamente getPara()
    }

    public double getTaxa() {
        return taxa;  // Retorna o atributo taxa, não chama recursivamente getTaxa()
    }
}

