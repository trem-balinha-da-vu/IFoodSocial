package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Classe que representa um pedido contendo um codigo gerado aleatoriamente e uma lista de produtos.
public class Pedido {
    private final String codigoPedido;

    // Lista que armazena os produtos associados ao pedido.
    private List<Produto> produtos;

    // Construtor que instancia um novo pedido, gerando um codigo aleatorio e inicializando a lista de produtos.
    public Pedido() {
        this.codigoPedido = gerarCodigoPedido();
        this.produtos = new ArrayList<>();
    }

    // Metodo privado que gera um codigo de 6 digitos aleatorios para o pedido
    private String gerarCodigoPedido() {
        Random random = new Random();// Objeto para gerar numeros aleatorios.
        StringBuilder codigo = new StringBuilder(); // StringBuilder para construir o codigo.
        for (int i = 0; i < 6; i++) {
            codigo.append(random.nextInt(10)); // Adiciona dígitos de 0 a 9
        }
        return codigo.toString();
    }

    // Metodo para adicionar um produto ao pedido.
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    // Metodo getter para obter o codigo do pedido.
    public String getCodigoPedido() {
        return codigoPedido;
    }

    // Metodo getter para obter a lista de produtos do pedido.
    public List<Produto> getProdutos() {
        return produtos;
    }

    // Metodo que imprime os detalhes do pedido, incluindo o codigo e os produtos.
    public void imprimir() {
        System.out.println(" ");
        System.out.println("Código do Pedido: " + codigoPedido);
        System.out.println("Produtos no Pedido:");
        for (Produto produto : produtos) {
            produto.imprimir();// Chama o metodo imprimir para cada produto na lista.
        }
    }
}
