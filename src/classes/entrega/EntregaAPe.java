package classes.entrega;

// Classe que representa uma entrega realizada a pé, herdando da classe base Entrega.
public class EntregaAPe extends Entrega{

    // Construtor que inicializa o nome do entregador e define o símbolo 🚶 para a entrega a pé.
    public EntregaAPe(String nomeEntregador) {
        super(nomeEntregador, "🚶");
    }

    // Sobrescreve o metodo imprimirCaminho() para incluir uma mensagem adicional para entregas a pé.
    @Override
    public void imprimirCaminho() {
        super.imprimirCaminho();
        System.out.println("Entrega realizada a pé.");
    }
}
