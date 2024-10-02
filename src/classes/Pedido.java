package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pedido {
    private String codigoPedido;
    private List<Produto> produtos;

    public Pedido() {
        this.codigoPedido = gerarCodigoPedido();
        this.produtos = new ArrayList<>();
    }

    private String gerarCodigoPedido() {
        Random random = new Random();
        StringBuilder codigo = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            codigo.append(random.nextInt(10)); // Adiciona dígitos de 0 a 9
        }
        return codigo.toString();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public String getCodigoPedido() {
        return codigoPedido;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void imprimir() {
        System.out.println(" ");
        System.out.println("Código do Pedido: " + codigoPedido);
        System.out.println("Produtos no Pedido:");
        for (Produto produto : produtos) {
            produto.imprimir();
        }
    }
}
