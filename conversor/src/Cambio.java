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
        return de;  
    }

    public Moeda getPara() {
        return para;  
    }

    public double getTaxa() {
        return taxa;  
    }
}

