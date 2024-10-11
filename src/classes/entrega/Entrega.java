package classes.entrega;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Entrega {
    protected String nomeEntregador;
    protected List<int[]> movimentos; // Lista de movimentos como pares (x, y)
    protected double distanciaPercorrida; // Total da distância percorrida
    protected int[] posicaoAtual = new int[]{0, 0};// Ponto de partida (0, 0)
    protected String simbolo; // Simbolo para diferenciar os tipos de entrega (carro, pe, drone)

    // Construtor que inicializa a entrega com nome do entregador e simbolo
    public Entrega(String nomeEntregador, String simbolo) {
        this.nomeEntregador = nomeEntregador;
        this.movimentos = new ArrayList<>();
        this.distanciaPercorrida = 0.0;
        // O entregador começa na posição (0,0)
        this.movimentos.add(new int[]{0, 0});
        this.simbolo = simbolo;
    }

    // Metodo getter para obter o nome do entregador.
    public String getNomeEntregador() {
        return nomeEntregador;
    }

    // Metodo auxiliar para marcar o movimento de uma posicao inicial para uma final,
    // incluindo as quadras intermediarias
    protected void marcarMovimento(int xInicial, int yInicial, int xFinal, int yFinal) {
        int x = xInicial;
        int y = yInicial;

        // Move gradualmente da posicao inicial para a final, marcando as quadras no caminho
        while (x != xFinal || y != yFinal) {
            // Move o entregador na direção x até atingir xFinal
            if (x < xFinal) x++;// Se x é menor que xFinal, avança para a direita
            else if (x > xFinal) x--;// Se x é maior que xFinal, avança para a esquerda

            // Move o entregador na direção y até atingir yFinal
            if (y < yFinal) y++; // Se y é menor que yFinal, avança para cima
            else if (y > yFinal) y--; // Se y é maior que yFinal, avança para baixo

            // Adiciona a nova posição (x, y) à lista de movimentos
            movimentos.add(new int[]{x, y});
        }
    }

    // Movimenta o entregador para o norte (diminuindo o valor de y)
    public void moverNorte(int quadras) {
        int novaPosicaoY = posicaoAtual[1] - quadras;
        if (novaPosicaoY >= 0) {
            distanciaPercorrida += quadras;
            marcarMovimento(posicaoAtual[0], posicaoAtual[1], posicaoAtual[0], novaPosicaoY);
            posicaoAtual[1] = novaPosicaoY;
        } else {
            System.out.println("Movimento inválido: Fora dos limites do mapa!");
        }
    }

    // Movimenta o entregador para o sul (aumentando o valor de y)
    public void moverSul(int quadras) {
        int novaPosicaoY = posicaoAtual[1] + quadras;
        if (novaPosicaoY < 8) {
            distanciaPercorrida += quadras;
            marcarMovimento(posicaoAtual[0], posicaoAtual[1], posicaoAtual[0], novaPosicaoY);
            posicaoAtual[1] = novaPosicaoY;
        } else {
            System.out.println("Movimento inválido: Fora dos limites do mapa!");
        }
    }

    // Movimenta o entregador para o leste (aumentando o valor de x)
    public void moverLeste(int quadras) {
        int novaPosicaoX = posicaoAtual[0] + quadras;
        if (novaPosicaoX < 8) {
            distanciaPercorrida += quadras;
            marcarMovimento(posicaoAtual[0], posicaoAtual[1], novaPosicaoX, posicaoAtual[1]);
            posicaoAtual[0] = novaPosicaoX;
        } else {
            System.out.println("Movimento inválido: Fora dos limites do mapa!");
        }
    }

    // Movimenta o entregador para o oeste (diminuindo o valor de x)
    public void moverOeste(int quadras) {
        int novaPosicaoX = posicaoAtual[0] - quadras;
        if (novaPosicaoX >= 0) {
            distanciaPercorrida += quadras;
            marcarMovimento(posicaoAtual[0], posicaoAtual[1], novaPosicaoX, posicaoAtual[1]);
            posicaoAtual[0] = novaPosicaoX;
        } else {
            System.out.println("Movimento inválido: Fora dos limites do mapa!");
        }
    }

    // Metodo para imprimir o caminho percorrido
    public void imprimirCaminho() {
        DecimalFormat df = new DecimalFormat("#.00"); // Formato para duas casas decimais
        System.out.println("Caminho percorrido pelo entregador " + nomeEntregador + ":");
        for (int[] posicao : movimentos) {
            System.out.println("Posição: (" + posicao[0] + ", " + posicao[1] + ")");
        }
        System.out.println("Distância total percorrida: " + df.format(distanciaPercorrida) + " quadras.");
    }

    // Metodo que exibe a trajetoria no mapa (8x8)
    public void visualizarMapa() {
        String[][] mapa = new String[8][8]; // Mapa de 8x8 quadras
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                mapa[i][j] = " . "; // Inicializa o mapa com pontos representando quadras vazias
            }
        }

        // Marca as posicoes visitadas com 'X'
        for (int[] posicao : movimentos) {
            mapa[posicao[1]][posicao[0]] = " X ";
        }

        // Marca o ponto final com o simbolo da entrega (carro, pe ou drone)
        mapa[movimentos.get(movimentos.size() - 1)[1]]// Acessa a coordenada y da última posição.
                [movimentos.get(movimentos.size() - 1)[0]]// Acessa a coordenada x da última posição.
                = simbolo;

        // Exibir o mapa
        System.out.println("Mapa da entrega:");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(mapa[i][j] + " "); // Imprime o mapa linha por linha
            }
            System.out.println();
        }
    }

    // Retorna a posição atual (última posição da lista)
    public int[] getPosicaoAtual() {
        return movimentos.get(movimentos.size() - 1);
    }

    // Retorna a distância total percorrida
    public double getDistanciaPercorrida() {
        return distanciaPercorrida;
    }
}