import classes.Categoria;
import classes.Produto;
import classes.Pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    static Scanner ler = new Scanner(System.in).useLocale(Locale.US);
    private static List<Categoria> categoriaList = new ArrayList<>();
    private static List<Produto> produtoList = new ArrayList<>();
    private static List<Pedido> pedidoList = new ArrayList<>();

    public static void main(String[] args) {
        exibirBanner();

        int opcao;
        do {
            menuPrincipal();
            opcao = ler.nextInt();
            ler.nextLine();

            switch (opcao) {
                case 1:
                    Categoria novaCategoria = solicitaDadosCategoria();
                    if (novaCategoria != null) {
                        categoriaList.add(novaCategoria);
                        System.out.println("Categoria adicionada com sucesso!");
                    }
                    break;
                case 2:
                    Produto novoProduto = solicitaDadosProduto();
                    if (novoProduto != null) {
                        produtoList.add(novoProduto);
                        System.out.println(" ");
                        System.out.println("Produto adicionado com sucesso!");
                        System.out.println(" ");
                    }
                    break;
                case 3:
                    finalizarPedido();
                    break;
                case 4:
                    //categoriaList.forEach(Categoria::imprimir);
                    produtoList.forEach(Produto::imprimir);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void exibirBanner() {
        System.out.println();
        System.out.println(" ### #######                        #####                                 ");
        System.out.println("  #  #        ####   ####  #####   #     #  ####   ####  #   ##   #      ");
        System.out.println("  #  #       #    # #    #  #   #  #       #    # #    # #  #  #  #      ");
        System.out.println("  #  #####   #    # #    #  #    #  #####  #    # #      # #    # #      ");
        System.out.println("  #  #       #    # #    #  #    #       # #    # #      # ###### #      ");
        System.out.println("  #  #       #    # #    #  #   #  #     # #    # #    # # #    # #      ");
        System.out.println(" ### #        ####   ####  #####    #####   ####   ####  # #    # ######  ");
        System.out.println();
    }

    private static void menuPrincipal() {
        System.out.println("\n=== Menu Principal ===");
        System.out.println("1 - Criar Categoria");
        System.out.println("2 - Criar Produto");
        System.out.println("3 - Finalizar Pedido");
        System.out.println("4 - Mostrar Cardápio");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static Produto solicitaDadosProduto() {
        Categoria c_produto = null;
        System.out.println("Informe o código do produto: ");
        String codigoProduto = ler.nextLine();
        System.out.println("Informe a descrição do produto: ");
        String descricaoProduto = ler.nextLine();
        System.out.println("Informe o preço do produto: ");
        double preco = ler.nextDouble();
        ler.nextLine();


        System.out.println("Informe o código da categoria: ");
        String codigoCategoria = ler.nextLine();
        for (Categoria categoria : categoriaList) {
            if (categoria.getCodigoCategoria().equals(codigoCategoria)) {
                c_produto = categoria;
                break;
            }
        }

        if (c_produto == null) {
            System.out.println("Categoria não encontrada! Produto não adicionado.");
            return null; // Retorna null se a categoria não for encontrada
        }

        return new Produto(codigoProduto, descricaoProduto, preco, c_produto);
    }

    private static Categoria solicitaDadosCategoria() {
        System.out.println("Informe o código da categoria: ");
        String codigoCategoria = ler.nextLine();
        System.out.println("Informe a descrição da categoria: ");
        String descricaoCategoria = ler.nextLine();
        return new Categoria(codigoCategoria, descricaoCategoria);
    }

    private static void finalizarPedido() {
        Pedido pedido = new Pedido();
        int opcaoProduto;

        do {
            System.out.println(" ");
            System.out.println("Escolha um produto para adicionar ao pedido (0 para finalizar):");
            for (int i = 0; i < produtoList.size(); i++) {
                System.out.println((i + 1) + " - " + produtoList.get(i).getDescricaoProduto());
            }
            System.out.println("0 - Finalizar Pedido");
            System.out.print("Escolha uma opção: ");
            opcaoProduto = ler.nextInt();
            ler.nextLine();

            if (opcaoProduto > 0 && opcaoProduto <= produtoList.size()) {
                pedido.adicionarProduto(produtoList.get(opcaoProduto - 1));
                System.out.println("Produto adicionado ao pedido.");
            } else if (opcaoProduto != 0) {
                System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcaoProduto != 0);

        pedidoList.add(pedido);
        pedido.imprimir();
    }
}
