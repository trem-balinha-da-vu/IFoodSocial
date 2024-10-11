package classes.entrega;

// Classe que representa uma entrega feita de carro, herdando da classe base Entrega.
public class EntregaCarro extends Entrega{
    private final double consumoMedio; // Consumo médio em litros por quilômetro

    // Construtor que inicializa o nome do entregador e o consumo médio do carro, além de definir o símbolo 🚗.
    public EntregaCarro(String nomeEntregador, double consumoMedio) {
        super(nomeEntregador, "🚗");
        this.consumoMedio = consumoMedio;
    }

    // Metodo para calcular o consumo total de gasolina com base na distância percorrida.
    public double calcularConsumoTotal() {
        return getDistanciaPercorrida() * consumoMedio;// Multiplica a distância total percorrida pelo consumo médio para calcular o total de litros consumidos.
    }

    // Sobrescreve o metodo imprimirCaminho() para adicionar informações sobre o consumo de gasolina.
    @Override
    public void imprimirCaminho() {
        super.imprimirCaminho();// Chama o metodo da superclasse para imprimir o caminho.
        System.out.println("Entrega realizada de carro.");

        // Exibe o consumo total de gasolina, formatado com duas casas decimais.
        System.out.println("Consumo total de gasolina: " + String.format("%.2f", calcularConsumoTotal()) + " litros.");
    }


}
