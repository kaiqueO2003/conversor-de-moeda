public class ConversorMoeda {
    private ServiçoTaxaCambio serviçoTaxaCambio;

    public ConversorMoeda(ServiçoTaxaCambio serviçoTaxaCambio) {
        this.serviçoTaxaCambio = serviçoTaxaCambio;
    }

    public double coversor(Moeda de, Moeda para, double quantia) {
        Cambio cambio = serviçoTaxaCambio.getTaxa(de, para);
        if (cambio != null) {
            return quantia * cambio.getTaxa();
        } else {
            System.out.println("Não foi possível obter a taxa de câmbio.");
            return 0.0; 
        }
    }
}


