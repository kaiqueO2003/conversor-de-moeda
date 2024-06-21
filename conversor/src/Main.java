public class Main {
    public static void main(String[] args){
        ServiçoTaxaCambio serviçoTaxaCambio = new ApiServicoTaxaCambio();
        ConversorMoeda conversor = new ConversorMoeda(serviçoTaxaCambio);
        Menu menu = new Menu(conversor);
        menu.display();
    }
}
