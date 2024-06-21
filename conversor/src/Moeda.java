public class Moeda {
    private String moeda;

    public Moeda(String moeda) {
        this.moeda = moeda;
    }

    public String getMoeda(){
        return moeda;
    }
    public void setMoeda(String moeda){
        this.moeda= moeda;
    }
    @Override
    public String toString() {
        return moeda;
    }

}
