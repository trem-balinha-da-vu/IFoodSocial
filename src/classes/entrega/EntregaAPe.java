package classes.entrega;

public class EntregaAPe extends Entrega{
    public EntregaAPe(String nomeEntregador) {
        super(nomeEntregador, "🚶");
    }

    @Override
    public void imprimirCaminho() {
        super.imprimirCaminho();
        System.out.println("Entrega realizada a pé.");
    }
}
