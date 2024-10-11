    package classes.entrega;

// Classe que representa uma entrega feita por drone, herdando da classe base Entrega.
public class EntregaDrone extends Entrega {

    // Construtor que inicializa a entrega com o nome do entregador e define o símbolo 🚀 para o drone.
    public EntregaDrone(String nomeEntregador) {
            super(nomeEntregador, "🚀"); // Chama o construtor da superclasse Entrega passando o nome do entregador e o símbolo específico para o drone.
    }

    // Metodo que move o drone diretamente para as coordenadas (x, y), calculando a distancia percorrida.
    public void moverDireto(int x, int y) {
        // Obtem a posição atual a partir do último movimento registrado.
        int[] posAtual = {super.movimentos.get(super.movimentos.size() - 1)[0], super.movimentos.get(super.movimentos.size() - 1)[1]};

        // Calcula a distancia euclidiana entre a posição atual e o destino (x, y).
        double distancia = Math.sqrt(Math.pow(x - posAtual[0], 2) + Math.pow(y - posAtual[1], 2));

        // Verifica se as coordenadas de destino estão dentro dos limites do mapa (de 0 a 7).
        if (x >= 0 && x < 8 && y >= 0 && y < 8) {
            // Marca todas as quadras intermediarias ao longo do caminho entre a posição atual e a nova posição.
            marcarMovimento(posAtual[0], posAtual[1], x, y);

            // Adiciona a distancia percorrida ao total da superclasse.
            super.distanciaPercorrida += distancia;

            // Atualiza a posição atual do drone.
            super.posicaoAtual[0] = x;
            super.posicaoAtual[1] = y;
        } else {
            System.out.println("Movimento inválido: Fora dos limites do mapa!");
        }
    }

    // Sobrescreve o metodo imprimirCaminho() da classe Entrega para adicionar uma mensagem específica para o drone.
    @Override
    public void imprimirCaminho() {
        super.imprimirCaminho(); // Chama o metodo da superclasse para imprimir o caminho.
        System.out.println("Entrega realizada por drone.");
    }
}
